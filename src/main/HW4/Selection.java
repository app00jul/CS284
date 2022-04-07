package main.HW4;

public class Selection{
    public static void sort(Comparable [] a){
        int N = a.length;
        for (int i = 0; i != N; i++){
            int min = i;
            for (int j = i+1; j != N; j++){
                if (less_than(a[j], a[min])){
                    min = j;
                }
            exchange(a,i,min);
            }
        }
    }

    public static void exchange(Comparable [] a, int i, int j){
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static boolean less_than(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }
}
