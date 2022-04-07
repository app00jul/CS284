package main.HW4;

public class Bubble{
    public static void sort(Comparable [] a){
        int n = a.length;

        for (int i = 0; i != n-1 ; i++){
            for (int j = 0; j < n-i-1; j++){
                if (less_than(a[j+1], a[j])){
                    Comparable temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }

    public static boolean less_than(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }
}
