package zuochenyun;


public class BinaryPrint {
    // print a int value, 32 bits
    public static void printBinary(int a) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((a & ( 1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int a = 78;
        System.out.println(a);
        printBinary(a);
        System.out.println("===a===");
        // 78
        //00000000000000000000000001001110

        int b = -6;
        System.out.println(b);
        printBinary(b);
        System.out.println("===b===");
        //-6
        //11111111111111111111111111111010

        int c = 0b1001110; // we can omit leading zeros, binary start with ob, 32bits this is actually equal to 0000..1001110
        System.out.println(c);
        printBinary(c);
        System.out.println("===c===");

        //78
        //00000000000000000000000001001110

        int d = 0x4e; // 01001110
        System.out.println(d);
        printBinary(d);
        System.out.println("===d===");
        //78
        //00000000000000000000000001001110

        // get its negative
        System.out.println(a);
        printBinary(a);
        printBinary(~a);

        int e = ~a + 1;
        System.out.println(e);
        printBinary(e);
        System.out.println("===e===");

        // The only thing we can't get opposite value is Integer.MIN_VALUE, think of 4 bits,
        // the smallest value is -8, the biggest positive is 7, there is no opposite value of -8

        // bitwise operator
        int g = 0b0001010;
        int h = 0b0001100;
        printBinary(g | h); // 0001110
        printBinary(g & h); // 0001000
        printBinary(g ^ h); // 0000110
        System.out.println("===g,h===");

        int i = 0b0011010;
        printBinary(i);
        printBinary(i << 1);
        printBinary(i << 2);
        printBinary(i << 3);
        System.out.println("===i << ===");
        // for non-negative, >> and equals to >>>
        printBinary(i);
        printBinary(i >> 2);
        printBinary(i >>> 2);
        System.out.println("=== i >> >>> ===");

        int j = 0b1110000;
        printBinary(j);
        printBinary(j >> 2);
        printBinary(j >>> 2);
    }
}
