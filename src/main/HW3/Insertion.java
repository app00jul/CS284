package main.HW3;

public class Insertion {
    private static int swaps = 0;

    public static void sort(Comparable [] a){
        int lth = a.length;

        for (int i = 0; i != lth; i++){
            for (int j = i; j > 0 && a[j].compareTo(a[j-1]) < 0; j--){
                Comparable swap = a[j];
                a[j] = a[j-1];
                a[j-1] = swap;
                swaps++;
            }
        }
        System.out.println(swaps + " swaps");
    }

    public static int getSwap() {
        return swaps;
    }
}
