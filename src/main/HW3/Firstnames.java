package main.HW3;

public class Firstnames implements Comparable<Firstnames> {
    private String name;

    public Firstnames() {
        StringBuilder s = new StringBuilder();
////        the first character of a name should be uppercase.
////        'A' = 65
////        'Z' = 90
////        A random character between A and Z
////            (char) ((int) (Math.random() * (90-65+1)) + 65)
////
////            append the generated uppercase character to the string (F)
////            append several lowercase characters (e.g., 5) to the string to get a name (Fieszs)
////              'a' = 97
////              'z' = 122
//
    }

    public String toString() {
        return this.name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Firstnames that) {
        return this.getName().compareTo(that.getName());
    }
}
