package BinarySearch;

public class FindInBigArray {
    /*
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return: An integer which is the first index of target.
     */
//    public int searchBigSortedArray(ArrayReader reader, int target) {
//        int index = 0;
//        while (reader.get(index) < target) {
//            index = index * 2 + 1;
//        }
//
//        int start = 0;
//        while (start + 1< index) {
//            int mid = start + (index - start) / 2;
//            if (reader.get(mid) == target) {
//                index = mid;
//            } else if (reader.get(mid) < target) {
//                start = mid;
//            } else {
//                index = mid;
//            }
//        }
//
//        if (reader.get(start) == target) {
//            return start;
//        }
//        if (reader.get(index) == target) {
//            return index;
//        }
//        return -1;
//    }
}

// public class ArrayReader {
//     public int get(int index) {
//          // return the number on given index,
//          // return 2147483647 if the index is invalid.
//     }
// };


