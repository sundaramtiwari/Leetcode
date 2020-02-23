import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MultiThreadAbc {

	/** Configure number of threads counting number series */
	private static final int NUM_OF_THREADS = 5;
	private static final int MAX_VALUE = 54;

	private final int noOfThreads;
	private final MyCount counter;
	private final CyclicBarrier barrier;
	private final Thread[] threads;

	public MultiThreadAbc(int noOfThreads, int maxCounterValue) {
		this.noOfThreads = noOfThreads;
		counter = new MyCount(noOfThreads, maxCounterValue);
		barrier = new CyclicBarrier(noOfThreads + 1);
		threads = new Thread[noOfThreads];

		for (int index = 0; index < noOfThreads; index++) {
			threads[index] = new Thread(new MyThread(barrier, counter, index));
		}
	}

	public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
		MultiThreadAbc main = new MultiThreadAbc(NUM_OF_THREADS, MAX_VALUE);
		main.runInSingleJvm();
	}

	private void runInSingleJvm() throws BrokenBarrierException, InterruptedException {
		for (int i = 0; i < noOfThreads; i++) {
			threads[i].start();
		}

		Thread.sleep(1500);
		System.out.println("MAIN: GREEN Signal to counting threads!");
		barrier.await();

		for (int i = 0; i < noOfThreads; i++) {
			threads[i].join();
		}
	}
}

class MyThread implements Runnable {

	private MyCount counter;
	private int threadId;
	private CyclicBarrier barrier;

	public MyThread(CyclicBarrier barrier, MyCount counter, int threadId) {
		this.counter = counter;
		this.threadId = threadId;
		this.barrier = barrier;
	}

	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + ": Waiting for GREEN Signal from MAIN...");
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
		while (!(counter.isMaxValueReached() || counter.maxCharReached())) {
			counter.printSeries(threadId);
		}
		// signal all threads
		counter.signalAll(threadId);
	}

}

class MyCount {
	private int value = 0;
	private int numOfThreads;
	private int maxVal;
	private int charCounter = 0;
	private int charThread;
	private char ch = 'a';
	private final Lock lock = new ReentrantLock(true);
	private final Condition intCondition = lock.newCondition();
	private final Condition beforeChar = lock.newCondition();
	private final Condition afterChar = lock.newCondition();

	public void printSeries(int threadId) {
		try {
			lock.lockInterruptibly();
			if (threadId == charThread) {
				if (this.isMyTurn(threadId)) {
					System.out.println(Thread.currentThread().getName() + ": " + this.incrementAndGetChar());
					charCounter = 0;
					beforeChar.signalAll();
				} else {
					afterChar.await();
				}
			} else {
				if (!(this.isMyTurn(threadId) || this.isMaxValueReached())) {
					intCondition.await();
				} else if (charCounter == charThread) {
					beforeChar.await();
				} else if (this.isMaxValueReached()) {
					intCondition.signalAll();
				} else {
					System.out.println(Thread.currentThread().getName() + ": " + this.incrementAndGetValue());
					// Thread.sleep(500);
					++this.charCounter;
					if (charCounter == charThread) {
						afterChar.signalAll();
						beforeChar.await();
					}
					intCondition.signalAll();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void signalAll(int threadId) {
		try {
			lock.lockInterruptibly();
			intCondition.signalAll();
			afterChar.signalAll();
			beforeChar.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public boolean maxCharReached() {
		return this.ch > 'z';
	}

	public synchronized boolean isMyTurn(int threadId) {
		if (threadId == charThread) {
			if (this.charCounter == charThread) {
				return true;
			} else
				return false;
		} else {
			return value % (numOfThreads - 1) == threadId;
		}
	}

	public synchronized int incrementAndGetValue() {
		return ++this.value;
	}

	public synchronized char incrementAndGetChar() {
		return this.ch++;
	}

	public int getValue() {
		return this.value;
	}

	public boolean isMaxValueReached() {
		return this.value >= this.maxVal ? true : false;
	}

	public MyCount(int numOfThreads, int maxVal) {
		this.numOfThreads = numOfThreads;
		this.maxVal = maxVal;
		this.charThread = numOfThreads - 1;
	}
}