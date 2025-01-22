package msb;

// leetcode china
// https://leetcode.cn/problems/shu-zu-zhong-de-ni-xu-dui-lcof/submissions/594539096/
public class InversePair_2_103 {
    public int reversePairs(int[] record) {
        if (record == null || record.length == 0) {
            return 0;
        }
        return process(record, 0, record.length - 1);
    }

    public int process(int[] record, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = left + (right - left) / 2;

        int numLeft = process(record, left, mid);
        int numRight = process(record, mid + 1, right);
        int merge = merge(record, left, mid, right);
        return numLeft + numRight + merge;
    }

    public int merge(int[] record, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int tempIndex = 0;

        int i = left;
        int j = mid + 1;

        int inversePair = 0;

        while ( i <= mid && j <= right) {
            if (record[j] < record[i]) {
                inversePair += (mid - i + 1);
                temp[tempIndex++] = record[j++];
            } else {
                temp[tempIndex++] = record[i++];
            }
        }

        while (i <= mid) {
            temp[tempIndex++] = record[i++];
        }

        while (j <= right) {
            temp[tempIndex++] = record[j++];
        }

        for (tempIndex = 0; tempIndex < temp.length; tempIndex++) {
            record[left + tempIndex] = temp[tempIndex];
        }

        return inversePair;
    }

    public static void main(String[] args) {
        InversePair_2_103 inversePair = new InversePair_2_103();
        int[] testCase = {9, 7, 5, 4, 6};
        int result = inversePair.reversePairs(testCase);
        System.out.println(result);
    }
}
