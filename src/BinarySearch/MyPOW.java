package BinarySearch;

import java.sql.SQLOutput;

public class MyPOW {

    public double myPow(double x, int n) {
        boolean isNegative = false;
        if (n < 0) {
            isNegative = true;
            n = -(n + 1);
            x = 1 / x;
        }

        double result = 1;
        double temp = x;
        while (n != 0) {
            if (n % 2 == 1) {
                result *= temp;
            }
            temp *= temp;
            n /= 2;
        }
        if (isNegative) {
            result *= x;
        }
        return result;
    }

    public static void main(String[] args) {
        MyPOW test = new MyPOW();
        System.out.println(test.myPow(2.0, -3));
    }
}
