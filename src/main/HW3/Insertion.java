package main.HW3;

public class Insertion {
    private static int swaps = 0;

    public static void sort(Comparable [] a){
        int lth = a.length;
        for (int i = 0; i != lth; i++){
            for (int j = i; j > 0; j--){
                if (a[i].compareTo(a[j]) > 0){
                    exchange(a,j,j-1);
                    swaps++;
                } else{
                    break;
                }
            }
        }
        System.out.println(swaps + "swaps");
    }

    public static void exchange(Comparable [] a, int i, int j){
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public int getSwaps(){
        return this.swaps;
    }
}
