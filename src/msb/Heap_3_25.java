package msb;

public class Heap_3_25 {

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i); // o(logN)
        }

        // This also can make the array to be heap
//        for (int i = arr.length - 1; i > 0; i--) {
//            heapify(arr, i , arr.length);
//        }

        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize); // o(logN)
            swap(arr, 0, --heapSize); // o(1)
        }
    }
    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void heapify(int[] arr, int index, int heapSize) {
        // this is used to remove the value in the array and make the rest of array still heap
        // index means the position that we want to do heapify
        // this function only make the value after index follows heap

        int left = 2 * index + 1;
        while (left < heapSize) {
            // for left and right child, choose the one that is larger
            int largerChild;
            if (left + 1 >= heapSize) {
                largerChild = left;
            } else if (arr[left] > arr[left + 1]) {
                largerChild = left;
            } else {
                largerChild = left + 1;
            }
             // can use this logic but a bit tricky to understand
//            int largerChild = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1: left;
            // compare the larger child with the parent node
            int largerIndex = arr[index] > arr[largerChild] ? index : largerChild;

            if (largerIndex == index) {
                return;
            }

            swap(arr, largerIndex, index);
            index = largerIndex;
            left = 2 * index + 1;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,2,3,1 };

        Heap_3_25.heapSort(arr);

        for (int num : arr) {
            System.out.println(num);
        }

        int[] testArr = {1, 2, 3, 4};
        int index = 0;
        int index1 = 1;
        int num1 = testArr[index] > testArr[index1] ? index : index1; //1
        int num2 = testArr[index1] > testArr[index] ? index1 : index; // 1

        System.out.println("num1 = " + num1 + ", num2 = " + num2);
    }
}
