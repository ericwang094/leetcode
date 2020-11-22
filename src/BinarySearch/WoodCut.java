package BinarySearch;

public class WoodCut {
    /**
     * @param L: Given n pieces of wood with length L[i]
     * @param k: An integer
     *           return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
	    if (L == null || L.length == 0) {
		    return 0;
	    }
	    // write your code here
	    int start = 1;
	    int end = 0;
	    for (int i = 0; i < L.length; i++) {
		    end = Math.max(end, L[i]);
	    }

	    while (start + 1 < end) {
		    int mid = start + (end - start) / 2;
		    int numOfCut= numOfCut(L, mid);
		    if (numOfCut >= k) {
			    start = mid;
		    } else {
			    end = mid;
		    }
	    }

	    if (numOfCut(L, end) >= k) {
		    return end;
	    }

	    if (numOfCut(L, start) >= k) {
		    return start;
	    }

	    return 0;

    }

	private int numOfCut (int[] L, int length) {
		int ans = 0;
		if (length == 0) {
			return 0;
		}
		for (int i = 0; i < L.length; i++) {
			ans += L[i] / length;
		}

		return ans;
	}

	public static void main(String[] args) {
		WoodCut wc = new WoodCut();
		wc.woodCut(new int[]{232,124,456}, 7);
	}
}
