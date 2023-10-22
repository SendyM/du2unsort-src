// Java program for Merge Sort


import java.util.Arrays;

class MergeSort {

    int kviks;

    private void kvik() {
        kviks += 1;
    }

    private void merge(int[] arr, int l, int m, int r) {
        // Find sizes of two subarrays to be merged

        int n1 = m - l;
        int n2 = r - m;
        //System.out.println("merge: arr=" + Arrays.toString(arr) + ", l=" + l + ", m=" + m + ", r=" + r + ", n1=" + n1 + ", n2=" + n2);

        // Create temp arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temp arrays
        System.arraycopy(arr, l, L, 0, n1);
        System.arraycopy(arr, m, R, 0, n2);

        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    private void sort(int[] arr, int l, int r) {
        //System.out.println("sort: arr=" + Arrays.toString(arr) + ", l=" + l + ", r=" + r);
        kvik();
        if (sorted(arr, l, r)) return;
        int m = (l + r) / 2; // l + (r - l) / 2;
        sort(arr, l, m);
        sort(arr, m, r);
        merge(arr, l, m, r);
    }

    private boolean sorted(int[] arr, int l, int r) {
        //System.out.print("  is arr=" + Arrays.toString(arr) + ", l=" + l + ", r=" + r + " sorted? ");
        if (l < r - 1) {
            for (int i = l; i < r - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    //System.out.println("NO");
                    return false;
                }
            }
        }
        //System.out.println("YES");
        return true;
    }

    public int mergesort(int[] arr, int l, int r) {
        kviks = 0;
        sort(arr, l, r);
        return kviks;
    }

    static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 2};

        System.out.print("Input: ");
        printArray(arr);

        MergeSort ob = new MergeSort();
        int kviks = ob.mergesort(arr, 0, arr.length);

        System.out.print("Output (kviks=" + kviks + "): ");
        printArray(arr);
    }
}
