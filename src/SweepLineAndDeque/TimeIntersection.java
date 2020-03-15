package SweepLineAndDeque;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TimeIntersection {
	/**
	 * @param seqA: the list of intervals
	 * @param seqB: the list of intervals
	 * @return: the time periods
	 */
	public List<Interval> timeIntersection(List<Interval> seqA, List<Interval> seqB) {
		// Write your code here
		List<Interval> result = new ArrayList<>();
		if (seqA.size() == 0 || seqB.size() == 0) {
			return result;
		}

		List<Event> list = new ArrayList<>();
		for (Interval i : seqA) {
			list.add(new Event(i.start, Event.START));
			list.add(new Event(i.end, Event.END));
		}

		for (Interval i : seqB) {
			list.add(new Event(i.start, Event.START));
			list.add(new Event(i.end, Event.END));
		}

		Collections.sort(list, new Comparator<Event>() {
			@Override
			public int compare(Event e1, Event e2) {
				if (e1.time == e2.time) {
					return e1.status - e2.status;
				}
				return e1.time - e2.time;
			}
		});

		int count = 0;
		int start = -1;
		for (Event e : list) {
			if (e.status == Event.START) {
				count++;
			} else {
				count--;
			}

			if (count >= 2) {
				start = e.time;
			}
			if (count == 1 && start != -1) {
				result.add(new Interval(start, e.time));
				start = -1;
			}
		}

		return result;
	}

	private class Event {
		public static final int START = 0;
		public static final int END = 1;

		private int time;
		private int status;
		public Event(int time, int status) {
			this.time = time;
			this.status = status;
		}
	}

	private static class Interval {
		int start, end;
		Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) {
		Interval i1 = new Interval(1, 2);
		Interval i2 = new Interval(5, 100);

		Interval i3 = new Interval(1, 6);

		List<Interval> l1 = new ArrayList<>();
		List<Interval> l2 = new ArrayList<>();

		l1.add(i1);
		l1.add(i2);

		l2.add(i3);

		TimeIntersection ti = new TimeIntersection();
		ti.timeIntersection(l1, l2);
	}
}
