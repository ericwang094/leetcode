package SweepLineAndDeque;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MeetingRooms {
	/**
	 * @param intervals: an array of meeting time intervals
	 * @return: the minimum number of conference rooms required
	 */
	public int minMeetingRooms(List<Interval> intervals) {
		// Write your code here
		PriorityQueue<Event> pq = new PriorityQueue<>(new Comparator<Event>() {
			@Override
			public int compare(Event e1, Event e2) {
				if (e1.time == e2.time) {
					return e1.status - e2.status;
				}
				return e1.time - e2.time;
			}
		});

		for (Interval i : intervals) {
			pq.add(new Event(i.start, Event.START));
			pq.add(new Event(i.end, Event.END));
		}

		int result = 0;
		int current = 0;

		while (!pq.isEmpty()) {
			Event event = pq.poll();
			if (event.status == Event.END) {
				current--;
			} else {
				current++;
			}
			result = Math.max(result, current);
		}

		return result;
	}

	private class Event {
		public static final int START = 1;
		public static final int END = 0;

		private int time;
		private int status;
		public Event(int time, int status) {
			this.time = time;
			this.status = status;
		}
	}

	private class Interval {
		int start, end;
		Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
}
