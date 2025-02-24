package msb;

public class TowerOfHanoi_9_53 {
    public static void hanoi(int n) {
        if (n > 0) {
            func(n, "left", "right", "mid");
        }
    }

    public static void func(int i, String start, String end, String mid) {
        if (i == 0) {
            System.out.println("Move 1 from " + start + " to " + end);
        } else {
            func(i - 1, start, mid, end);
            System.out.println("Move " + i + " from " + start + " to " + end);
            func(i - 1, mid, end, start);
        }
    }
}
