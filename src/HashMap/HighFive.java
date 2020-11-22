package HashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

public class HighFive {
	/**
	 * @param results a list of <student_id, score>
	 * @return find the average of 5 highest scores for each person
	 * Map<Integer, Double> (student_id, average_score)
	 */
	public Map<Integer, Double> highFive(Record[] results) {
		Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
		for (int i = 0; i < results.length; i++) {
			Record currentRecord = results[i];
			if (!map.containsKey(currentRecord.id)) {
				map.put(currentRecord.id, new PriorityQueue<>());
			}
			PriorityQueue<Integer> currentQueue = map.get(currentRecord.id);
			currentQueue.add(currentRecord.score);
			if (currentQueue.size() > 5) {
				currentQueue.poll();
			}
		}

		Map<Integer, Double> result = new HashMap<Integer, Double>();
		for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
			int recordId = entry.getKey();
			PriorityQueue<Integer> pq = entry.getValue();
			int sum = 0;
			while (!pq.isEmpty()) {
				sum += pq.poll();
			}
			result.put(recordId, (double) sum / 5);
		}

		return result;
	}

	private class Record {
		public int id, score;
		public Record(int id, int score) {
			this.id = id;
			this.score = score;
		}
	}
}
