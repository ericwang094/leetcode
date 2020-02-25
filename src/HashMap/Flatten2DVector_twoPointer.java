package HashMap;

import java.util.List;

public class Flatten2DVector_twoPointer {
	private int row, col;
	private List<List<Integer>> list;

	public Flatten2DVector_twoPointer(List<List<Integer>> vec2d) {
		this.list = vec2d;
		this.row = 0;
		this.col = 0;
	}

	public Integer next() {
		if (hasNext()) {
			return list.get(row).get(col);
		}
		return null;
	}

	public boolean hasNext() {
		while (row < list.size() && col == list.get(row).size()) {
			row++;
			col = 0;
		}
		return row < list.size();
	}

	public void remove() {
	}
}
