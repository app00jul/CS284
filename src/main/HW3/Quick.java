package main.HW3;

import java.util.Random;

public class Quick {
    private static int swaps = 0;

    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
        System.out.println(swaps + " swaps");
    }

    private static void sort(Comparable[] a, int low, int high) {
        if (low < high) {
            int j = partition(a, low, high);
            sort(a, low, j - 1);
            sort(a, j + 1, high);
        }
    }

    private static int partition(Comparable[] a, int low, int high) {
        Comparable pivot = a[high];
        int i = (low -1);
        for (int j = low; j != high; j++){
            if (a[j].compareTo(pivot) < 0){
                i++;
                exchange(a,i,j);
                swaps++;
            }
        }
        exchange(a,i+1,high);
        swaps++;

        return (i+1);
    }

    public static void exchange(Comparable [] a, int i, int j){
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static int getSwap() {
        return swaps;
    }

}
