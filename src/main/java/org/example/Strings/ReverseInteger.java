package org.example.Strings;
//32-bit integers are a specific type of integer that can be stored in 32 bits (4 bytes) of memory.
//The range of values that a 32-bit integer can represent is determined by the number of bits used to store the value
//32 bits can represent 2^32 different values, which is roughly 4.3 billion values.
//Half of these values are positive and half are negative, so the range of values that a 32-bit integer can represent is from -2147483648 to 2147483647.
public class ReverseInteger {

    public int reverse(int x) {
        String stringInt = String.valueOf(x);
        StringBuilder stringReverseInt = new StringBuilder(stringInt).reverse();
        char lastChar = stringReverseInt.charAt(stringReverseInt.length() - 1);

        //after string is reversed if the last character is a negative symbol
        if (lastChar == '-') {
            //remove the negative symbol from the string
            stringReverseInt = stringReverseInt.deleteCharAt(stringReverseInt.length() - 1);
            //insert the negative symbol to front of the string
            stringReverseInt = stringReverseInt.insert(0,'-');
        }

        try {
            Integer reversedInt = Integer.parseInt(stringReverseInt.toString());
            //32 bit 2^32 = 4294967296; 4294967296 / 2 = -2147483648, 0, 2147483647
            //if (reversedInt) is less than -2147483648 or greater than 214748364
            if (reversedInt < -2147483648 || reversedInt > 2147483647) {
                return 0;
            }
            return reversedInt;
        } catch (NumberFormatException e) {
            return 0;
        }

    }
}


