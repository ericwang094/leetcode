package msb;

import java.util.PriorityQueue;

// 已知一个几乎有序的数组，几乎有序是指，如果把数组排好顺序，每个元素移动的距离不超过k，并且
// k对于数组来说比较小。请选择一个适合的排序算法
public class KSortedArray_3_120 {
    public void sortArrDistanceLessK(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;

        for (; index < Math.min(arr.length, k); index++) {
            heap.add(arr[index]);
        }
        int i = 0;
        for (; index < arr.length; index++) {
            heap.add(arr[index]);
            arr[i++] = heap.poll();
        }

        while (!heap.isEmpty()) {
            arr[i++] = heap.poll();
        }
    }

    public static void main(String[] args) {
        KSortedArray_3_120 sol = new KSortedArray_3_120();
        int[] test = {6, 5, 3, 2,8,10, 9};
        sol.sortArrDistanceLessK(test, 3);

        for (int num : test) {
            System.out.println(num);
        }
    }
}
