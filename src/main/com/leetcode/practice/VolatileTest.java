package com.leetcode.practice;

public class VolatileTest {
    public static void main(String[] a) throws Exception {
        Flag state = new Flag();
        state.setRun(true);
        Task task = new Task(state);
        Thread t = new Thread(task);
        t.start();

        state.setRun(false);

        Thread.sleep(500);
        long stoppedOn = System.nanoTime();

        // task.stop(); // -----> do this to stop the thread

        System.out.println("Main thread stopped on: " + stoppedOn);

        t.join();
    }
}

class Task implements Runnable {

    public Task(Flag state) {
        this.state = state;
    }

    private Flag state = null;

    private int i = 0;

//	public void stop() {
//		state = ;
//	}

    @Override
    public void run() {
        System.out.println("Starting child run method.");
        while (state.isRun()) {
            i++;
            // System.out.print("");
        }
        System.out.println(i + " Child Thread Stopped on: " + System.nanoTime());
    }
}

class Flag {
    boolean run;

    public boolean isRun() {
        return run;
    }

    public void setRun(boolean run) {
        this.run = run;
    }

}