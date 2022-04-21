package main.HW3;

public class Shuffling {
    private static int swaps = 0;

    public static void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void shuffle(Comparable[] a) {
        int lth = a.length;
        for (int i = 0; i != lth; i++) {
            int rand = (int) (Math.random()* (i+1));

            swap(a,i,rand);
            swaps ++;
        }
        System.out.println(swaps + " swaps");
    }

    public static int getSwap() {
        return swaps;
    }
}