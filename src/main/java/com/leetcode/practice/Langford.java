public class Langford {
    private static boolean print(int array[], int k, int n) {
        if (k == n + 1) {
            return true;
        }
        for (int i = 0; i < array.length; ++i) {
            if (array[i] == 0 && i + k + 1 < array.length && array[i + k + 1] == 0) {
                array[i] = array[i + k + 1] = k;
                if (print(array, k + 1, n)) {
                    return true;
                }
                array[i] = array[i + k + 1] = 0;
            }
        }
        return false;
    }

    public static void print(int input) {
     // create an int array of size = left shift input no 1 bit.
        int array[] = new int[input << 1];
        boolean ret = print(array, 1, input);
        if (ret) {
            for (int i = 0; i < array.length; ++i) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("Sorry");
        }
    }
    public static void main(String args[]) {
		print(7);
    }
}
