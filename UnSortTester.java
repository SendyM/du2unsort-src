import java.util.Arrays;
import java.util.Random;

public class UnSortTester {

    private final static int MAX_N = 20;
    private final static Random rn = new Random();


    private static int randomInt(int minr, int maxr) {
        return rn.nextInt(maxr - minr + 1) + minr;
    }

    public static void main(String[] args) {

        UnSort2 unsort = new UnSort2();
        MergeSort mergesort = new MergeSort();


        // v cykle generujeme n a k - nahodne
        for (int i = 1; i < 1000000; i++) {
            int n = randomInt(1, MAX_N);
            int k = 2 * randomInt(1, MAX_N) + 1;

            int[] list = unsort.unsort(n, k);

            System.out.println("i: " + i + "  n=" + n + ", k=" + k + ", list=" + Arrays.toString(list));

            if (list[0] != -1) {
                int kviks = mergesort.mergesort(list, 0, n);
                if (kviks != k) {
                    System.out.println("!!! Oops: k=" + k + ", kviks=" + kviks);
                    return;
                }
            }
        }

    }
}
