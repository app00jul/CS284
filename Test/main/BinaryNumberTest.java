package main;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class BinaryNumberTest {
    public BinaryNumber b1 = new BinaryNumber("10011");
    public BinaryNumber b2 = new BinaryNumber("10111");
    public BinaryNumber b3 = new BinaryNumber("101");

    @Test
    void getLength() {
        assertEquals(5,b1.getLength());
    }

    @Test
    void getDigit() {
        assertEquals(1, b1.getDigit(0));
        assertEquals(0, b1.getDigit(1));
        assertEquals(0, b1.getDigit(2));
        assertEquals(1, b1.getDigit(3));
        assertEquals(1, b1.getDigit(4));
    }

    @Test
    void getInnerArray() {
        System.out.println("\nResult for getInnerArray of b1: ");
        int [] result;
        result = b1.getInnerArray();
        for (int i = 0; i != result.length; i++){
            System.out.println(result[i]);
        }
    }

    @Test
    void bwor() {
        System.out.println("\nResult for bwor of b1 and b2: ");
        int [] r1;
        r1 = BinaryNumber.bwor(b1,b2);
        for (int i = 0; i != r1.length; i++){
            System.out.println(r1[i]);
        }
        System.out.println("Result for bwor of b1 and b3: ");
        int [] r2;
        r2 = BinaryNumber.bwor(b1,b2);
        for (int i = 0; i != r2.length; i++){
            System.out.println(r2[i]);
        }
        System.out.println("Result for bwor of b2 and b3: ");
        int [] r3;
        r3 = BinaryNumber.bwor(b1,b2);
        for (int i = 0; i != r3.length; i++){
            System.out.println(r3[i]);
        }
    }

    @Test
    void bwand() {
        System.out.println("\nResult for bwand of b1 and b2: ");
        int[] t1;
        t1 = BinaryNumber.bwand(b1,b2);
        for (int i = 0; i != t1.length; i++){
            System.out.println(t1[i]);
        }
    }

    @Test
    void testToString() {
        assertEquals("10011", b1.toString());
        assertEquals("10111", b2.toString());
        assertEquals("101", b3.toString());
    }

    @Test
    void toDecimal() {
        assertEquals(19,b1.toDecimal());
        assertEquals(23,b2.toDecimal());
        assertEquals(5,b3.toDecimal());
    }

    @Test
    void bitShift() {
        b1.bitShift(-1,2);
        System.out.println("\nResult for bit shift left of b1: ");
        System.out.println(b1);
        b2.bitShift(1,3);
        System.out.println("\nResult for bit shift right of b2: ");
        System.out.println(b2);
    }

    @Test
    void add() {
        b1.add(b2);
        System.out.println("\nResult for add bit of b1 and b2: ");
        System.out.println(b1);
        b2.add(b3);
        System.out.println("\nResult for add bit of b2 and b3: ");
        System.out.println(b2);
    }
}