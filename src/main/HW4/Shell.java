package main.HW4;

public class Shell{
    public static void sort(Comparable[] a) {
        int lth = a.length;

        int s = 1;
        while (s < lth/3) {
            s = 3 * s + 1;
        }
        while (s >= 1) {
            for (int i = s; i < lth; i++) {
                for (int j = i; j >= s && less_than(a[j], a[j-s]); j -= s) {
                    exchange(a, j, j-s);
                }
            }
            s /= 3;
        }
    }

    public static void exchange(Comparable [] a, int m, int n){
        Comparable swap = a[m];
        a[m] = a[n];
        a[n] = swap;
    }

    public static boolean less_than(Comparable p, Comparable q){
        return p.compareTo(q) < 0;
    }
}
