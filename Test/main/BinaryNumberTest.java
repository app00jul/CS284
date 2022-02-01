package main;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        System.out.println(b1);
        System.out.println(b1.getInnerArray());
    }

    @Test
    void bwor() {
        System.out.println(BinaryNumber.bwor(b1,b2));
    }

    @Test
    void bwand() {
    }

    @Test
    void testToString() {
    }

    @Test
    void toDecimal() {
    }

    @Test
    void bitShift() {
    }

    @Test
    void add() {
    }



}