package main.HW3;

public class Firstnames implements Comparable<Firstnames> {
    private String name;

    public Firstnames() {
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

        StringBuilder s = new StringBuilder();
        int length = ((int) (Math.random() * (8-3+1))+3);

        s.append((char) ((int) (Math.random() * (90-65+1)) + 65));

        for (int i = 0; i != length; i++){
            s.append((char) ((int) (Math.random() * (122-97+1)) + 97));
        }
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
