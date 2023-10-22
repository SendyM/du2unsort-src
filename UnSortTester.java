import java.util.Random;
import java.util.List;

public class UnSortTester {

    private final static int MAX_N = 10;
    private final static int MAX_K = 2 * MAX_N;
    private final static Random rn = new Random();


    private static int randomInt(int minr, int maxr) {
        return rn.nextInt(maxr - minr + 1) + minr;
    }

    public static void main(String[] args) {

        UnSort unsort = new UnSort();
        MergeSort mergesort = new MergeSort();


        // v cykle generujeme n a k - nahodne
        for (int i = 1; i < 1000000; i++) {
            int n = randomInt(1, MAX_N);
            int k = randomInt(1, MAX_K);

            List<Integer> list = unsort.unsort(n, k);

            System.out.println("n=" + n + ", k=" + k + ", list=" + list);

            if (list.size() > 1 || list.get(0) != -1) {
                int[] a = list.stream().mapToInt(Integer::intValue).toArray();
                int kviks = mergesort.runMergesoft(a, 0, n - 1);
                System.out.println("   kviks=" + kviks);
                if (kviks != k) {
                    System.out.println("!!! Oops: k=" + k + " != kviks=" + kviks);
                    return;
                }
            }
        }

    }
}
