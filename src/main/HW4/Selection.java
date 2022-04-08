package main.HW4;

public class Selection {
    public static void sort(Comparable [] a){
        int lth = a.length;

        for (int i = 0; i != lth; i++){
            int min = i;
            for (int j = i+1; j != lth; j++){
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

    public static boolean less_than(Comparable p, Comparable q){
        return p.compareTo(q) < 0;
    }
}
