package BinarySearch;

public class FastPower {
    /**
     * @param a: A 32bit integer
     * @param b: A 32bit integer
     * @param n: A 32bit integer
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {
        long ans = 1, temp = a;
        while (n != 0) {
            if (n % 2 == 1) {
                ans = (ans * temp) % b;
            }
            temp = (temp * temp) % b;
            n /= 2;
        }
        return (int) ans % b;
    }
}
