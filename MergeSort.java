class MergeSort {

    int kviks = 0;

    private void kvik() {
        kviks++;
    }

    public int runMergesoft(int[] a, int l, int r) {
        kviks = 0;
        mergeSort(a, l, r);
        return kviks;
    }

    private void mergeSort(int[] a, int l, int r) {
        kvik();
        if (sorted(a, l, r)) return;
        int mid = (l + r) / 2;
        mergeSort(a, l, mid);
        mergeSort(a, mid, r);
        merge(a, l, mid, r);
    }

    private void merge(int[] a, int low, int middle, int high) {
        int[] help = new int[a.length];
        int i, j;

        for (i = low; i <= middle; i++) {
            help[i] = a[i];
        }

        for (j = middle + 1; j <= high; j++) {
            help[high + middle + 1 - j] = a[j];
        }

        i = low;
        j = high;

        for (int k = low; k <= high; k++) {
            if (help[i] <= help[j]) {
                a[k] = help[i];
                i++;
            } else {
                a[k] = help[j];
                j--;
            }
        }
    }

    private boolean sorted(int[] a, int l, int r) {
        for (int i = l; i < r - 1; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
