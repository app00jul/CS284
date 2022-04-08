package main.HW4;

import java.util.Random;

public class Quick {
    public static void shuffling(Comparable [] a){
        Random rn = new Random();
        int lth = a.length;

        for (int i = lth; i > 0; i --){
            int j = rn.nextInt(i+1);
            exchange(a,i,j);
        }
    }

    public static void sort(Comparable[] a) {
        Quick.shuffling(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int low, int high) {
        if (high <= low) return;
        int j = partition(a, low, high);
        sort(a, low, j-1);
        sort(a, j+1, high);
    }

    private static int partition(Comparable[] a, int low, int high) {
        int i = low;
        int j = high + 1;
        Comparable v = a[low];
        while (true) {

            // find item on lo to swap
            while (less_than(a[++i], v)) {
                if (i == high) break;
            }

            // find item on hi to swap
            while (less_than(v, a[--j])) {
                if (j == low) break;      // redundant since a[lo] acts as sentinel
            }

            // check if pointers cross
            if (i >= j) break;

            exchange(a, i, j);
        }

        exchange(a, low, j);

        return j;
    }

    public static Comparable select(Comparable[] a, int k) {
        if (k < 0 || k >= a.length) {
            throw new IllegalArgumentException("index is not between 0 and " + a.length + ": " + k);
        }
        Quick.shuffling(a);
        int low = 0;
        int high = a.length - 1;
        while (high > low) {
            int i = partition(a, low, high);

            if (i > k) {
                high = i - 1;
            } else if (i < k) {
                low = i + 1;
            } else {
                return a[i];
            }
        }
        return a[low];
    }

    public static void exchange(Comparable [] a, int i, int j){
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static boolean less_than(Comparable p, Comparable q){
        return p.compareTo(q) < 0;
    }
}
