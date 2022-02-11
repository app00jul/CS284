/**
 * Name: Julian Noeske
 * Pledge: I pledge my honor that I have abided by the Stevens Honor System.
 */

package main;

public class BinaryNumber {
    private int[] data;
    private int length;

    public BinaryNumber(int length){
        if (length < 0 || length == 0) { //check if the length is not more than 0.
            throw new ArithmeticException("The binary number's length must be more than 0."); //gives an error if True.
        }
        int[] data = new int[length];
        this.length = length;
        this.data = data;
    }

    public BinaryNumber(String str){
        int binary_length = str.length();
        int[] binary = new int[binary_length];
        for (int i = 0; i != binary_length; i++){ //add a value according to the length of binary.
            char index = str.charAt(i);
            int value = Character.getNumericValue(index);
            if (value != 0 && value != 1){
                throw new ArithmeticException("Binary value can only be 0 or 1");
            }
            else if (binary_length == 0 && binary_length < 0){
                throw new ArithmeticException("Binary length must be more than zero");
            }
            binary[i] = value; // if the value is valid, import it to the binary list.
        }
        this.length = binary_length; //update the binary length.
        this.data = binary; //update the current binary into the array/list.
    }

    public int getLength(){
        return this.data.length; //get the length of the binary number.
    }

    public int getDigit(int index){
        try{
            return this.data[index];
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("The index is out of bound.");
            return -1;
        }
    }

    public int[] getInnerArray(){
        return data; //get the list that represents the binary number.
    }

    public static int[] bwor(BinaryNumber bn1, BinaryNumber bn2){
        if (bn1.getLength() != bn2.getLength()){ //check if both binary has the same length.
            return new int[0]; //if False, return an empty array.
        }
        int[] result = new int[bn1.getLength()]; //create a new array, this array will be the final answer.
        for (int i = 0; i != bn1.getLength(); i ++){
            if (bn1.getDigit(i) == 0 && bn2.getDigit(i) == 0){ //check if both values are 0.
                result[i] = 0; //if true, add 0 to the array.
            }
            else{
                result[i] = 1; //if false, add 1 to the array.
            }
        }
        return result; //return the result.
    }

    public static int[] bwand(BinaryNumber bn1, BinaryNumber bn2){
        if (bn1.getLength() != bn2.getLength()){ //check if both binary has the same length.
            return new int[0]; //if False, return an empty array.
        }
        int[] bwand = new int[bn1.getLength()]; //create a new array, this array will be the final answer.
        for (int i = 0; i != bn1.getLength(); i ++){
            if (bn1.getDigit(i) == 1 && bn2.getDigit(i) == 1){ //check if both values are 1.
                bwand[i] = 1; //if true, add 1 into the array.
            }
            else{
                bwand[i] = 0; //if false, add 0 into the array
            }
        }
        return bwand; //return the result.
    }

    public String toString(){
        String string_value = new String(); //make an empty string.
        for (int i = 0; i != this.getLength(); i++){
            string_value += this.getDigit(i); //add each digit into the string.
        }
        return string_value; //return the result.
    }

    public int toDecimal(){
        int decimal_value = 0; //set the new decimal value to be 0.
        for (int i = 0; i != this.getLength(); i++){
            decimal_value += this.getDigit(i)*Math.pow(2,this.getLength()-i-1); //f(x) = list[i]*(2^length()-i-1)
        }
        return decimal_value;
    }

    public void bitShift(int direction, int amount){
        if (amount < 0 || amount == 0) { //check if the amount is zero or negative.
            throw new ArithmeticException("The shift amount must be a positive number."); //if true, raise an error.
        }

        int left_shift = this.getLength() + amount;
        int right_shift = this.getLength() - amount;

        if (direction == -1){ //if the binary shift left.
            int[] left_result = new int[left_shift];
            for (int i = 0; i != this.getLength(); i++){
                left_result[i] = this.getDigit(i); //move the binary into a new array.
            }
            for (int i = this.getLength(); i != left_shift; i++){
                left_result[i] = 0; //add zero to th
            }
            this.data = left_result;
        }
        else if (direction == 1){ // if the binary shift right.
            int[] right_result = new int[right_shift];
            for (int i = 0; i != right_shift; i++){
                right_result[i] = this.getDigit(i); //shift right
            }
            this.data = right_result;
        }
        else{ //if the direction was neither -1 nor 1.
            throw new ArithmeticException("The direction must be either 1 (right shift) or -1 (left shift)."); //if true, raise an error.
        }
    }

    private void prepend(int amount){
        int new_array = this.getLength() + amount;
        int[] result = new int[new_array];

        for (int i = amount; i < new_array; i++) {
            result[i] = this.getDigit(i - amount);
        }
        this.data = result;
        this.length += amount;
    }

    public void add(BinaryNumber aBinaryNumber){
        if (this.length > aBinaryNumber.length){
            int length = this.length - aBinaryNumber.length;
            aBinaryNumber.prepend(length);
        }
        else if (this.length < aBinaryNumber.length){
            int length = aBinaryNumber.length - this.length;
            this.prepend(length);
        }
        int[] addition_result = new int[this.length]; //make the result into its own array.
        int carry = 0; //add a carry.
        for (int i = this.length - 1; i > -1; i--) {
            int raw_sum = this.data[i] + aBinaryNumber.getDigit(i) + carry;
            if (raw_sum == 0) { //if the sum is 0.
                addition_result[i] = 0; //if true, no addition result and carry.
                carry = 0;
            }
            else if (raw_sum == 1) {  //if the sum is 1.
                addition_result[i] = 1; //if true, make the output 1.
                carry = 0;
            }
            else if (raw_sum == 2) { //if the sum is 2, which is not binary.
                addition_result[i] = 0; //make answer 1 and carry 1.
                carry = 1;
            }
            else if (raw_sum == 3) { //if the sum is 3.
                addition_result[i] = 1;
                carry = 1; //make result 1 and carry 1.
            }
        }

        this.data = addition_result;
        this.length = addition_result.length;

        if (carry == 1){
            this.prepend(1);
            this.data[0] = 1;
            this.length += 1;
        }
    }
}
