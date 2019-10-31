package TwoPointers;

public class SortColorsII {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        rainbowsort(colors, 0, colors.length - 1, 1, k);
    }

    private void rainbowsort(int[] colors, int start, int end, int lowerBound, int upperBound) {
        if (start >= end) {
            return;
        }

        if (lowerBound == upperBound) {
            return;
        }

        int colorMid = (lowerBound + upperBound) / 2;
        int left = start, right = end;

        while (left <= right) {
            while (left <= right && colors[left] <= colorMid) {
                left++;
            }

            while (left <= right && colors[right] > colorMid) {
                right--;
            }

            if (left <= right) {
                int temp = colors[left];
                colors[left] = colors[right];
                colors[right] = temp;

                left++;
                right--;
            }
        }

        rainbowsort(colors, start, right, lowerBound, colorMid);
        rainbowsort(colors, left, end, colorMid + 1, upperBound);
    }
}
