import java.util.*;

class UnSort2 {

    int kviks;

    int[] fail = {-1};

    public int[] unsort(int n, int k) {
        if (k > 2 * n - 1 || k % 2 == 0 || k < 1) {
            return fail;
        }
        int[] list = new int[n];
        for (int i = 1; i <= n; i++) {
            list[i - 1] = i;
        }
        kviks = k + 1;
        return getUnsortedList(list, 0, n);
    }

    int[] getUnsortedList(int[] list, int l, int r) {
        if (r - l < 2) {
            return list;
        }
        kviks -= 2;
        //System.out.println("k:" + kviks + " l:" + l + " r:" + r + " " + list);
        if (kviks < 2) {
            return list;
        }
        int mid = (int) Math.ceil((l + r) / 2.0);
        // swap list[0..min) with list[min,r)
        if (mid > l && r > mid) {
            System.out.println("Swapping " + l + "," + mid + "," + r);
            // make a copy of the first section before overwriting it
            int[] copy = Arrays.copyOfRange(list, l, mid);
            // overwrite the first section with the second section
            System.out.println("arraycopy: src=" + mid + ", dst=" + l + ", len=" + (r - mid));
            System.arraycopy(list, mid, list, l, r - mid);
            // copy the original content of the first section to the second section
            System.out.println("arraycopy: src=0, dst=" + (l + r - mid) + ", len=" + copy.length);
            System.arraycopy(copy, 0, list, l + r - mid, copy.length);
        }

        if ((r - l) % 2 != 0) {
            getUnsortedList(list, l, mid - 1);
            getUnsortedList(list, mid - 1, r);
        } else {
            getUnsortedList(list, l, mid);
            getUnsortedList(list, mid, r);
        }

        return list;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] result = new UnSort2().unsort(n, k);
        for (int x : result) {
            System.out.print(x + " ");
        }
    }

}
