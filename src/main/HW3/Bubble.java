package main.HW3;

public class Bubble {
    private static int swaps = 0;

    public static void sort(Comparable [] a){
        int lth = a.length;

        for (int i = 0; i != lth-1 ; i++){
            for (int j = 0; j < lth-i-1; j++){
                if (less_than(a[j+1], a[j])){
                    Comparable temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    swaps++;
                }
            }
        }
        System.out.println(swaps + " swaps");
    }

    public static boolean less_than(Comparable p, Comparable q){
        return p.compareTo(q) < 0;
    }

    public int getSwaps(){
        return this.swaps;
    }
}

