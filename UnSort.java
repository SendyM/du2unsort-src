import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class UnSort {

    int kviks;

    public List<Integer> unsort(int n, int k) {
        if (k > 2 * n - 1 || k % 2 == 0 || k < 1) {
            return Collections.singletonList(-1);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        kviks = k + 1;
        return getUnsortedList(list, 0, n);
    }

    List<Integer> getUnsortedList(List<Integer> list, int l, int r) {
        if (r - l < 2) {
            return list;
        }
        kviks -= 2;
        System.out.println("k:" + kviks + " l:" + l + " r:" + r + " ");
        if (kviks < 2) {
            return list;
        }
        int mid = (int) Math.ceil((l + r) / 2.0);
        List<Integer> leftSwap = new ArrayList<>(list.subList(l, mid));
        List<Integer> rightSwap = new ArrayList<>(list.subList(mid, r));
        if (rightSwap.isEmpty()) {
            rightSwap = new ArrayList<>(list.subList(mid, r + 1));
            list.removeAll(list.subList(l, r + 1));
        } else {
            list.removeAll(list.subList(l, r));
        }
        rightSwap.addAll(leftSwap);
        list.addAll(l, rightSwap);
        if((r-l) % 2 != 0){
            list = new ArrayList<>(getUnsortedList(list, l, mid-1));
            list = new ArrayList<>(getUnsortedList(list, mid-1, r));
        }else{
            list = new ArrayList<>(getUnsortedList(list, l, mid));
            list = new ArrayList<>(getUnsortedList(list, mid, r));
        }

        return new ArrayList<>(list);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        List<Integer> result = new UnSort().unsort(n, k);
        for (Integer x : result) {
            System.out.print(x + " ");
        }
    }

}
