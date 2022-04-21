package main.HW3;

public class Bubble {
    private static int swaps = 0;

    public static void sort(Comparable [] a){
        int lth = a.length;

        for (int i = 0; i != lth-1 ; i++){
            for (int j = 0; j < lth-i-1; j++){
                if (a[i].compareTo(a[j]) > 0){
                    Comparable temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    swaps++;
                }
            }
        }
        System.out.println(swaps + " swaps");
    }

    public static int getSwap() {
        return swaps;
    }

}

