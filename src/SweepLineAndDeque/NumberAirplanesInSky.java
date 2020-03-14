package SweepLineAndDeque;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NumberAirplanesInSky {
	/**
	 * @param airplanes: An interval array
	 * @return: Count of airplanes are in the sky.
	 */
	public int countOfAirplanes(List<Interval> airplanes) {
		List<EventPoint> list = new ArrayList<>();
		// write your code here
		for (Interval interval : airplanes) {
			EventPoint e1 = new EventPoint(interval.start, 1);
			EventPoint e2 = new EventPoint(interval.end, 0);

			list.add(e1);
			list.add(e2);
		}

		Comparator<EventPoint> comparator = new Comparator<EventPoint>() {
			@Override
			public int compare(EventPoint o1, EventPoint o2) {
				if (o1.time == o2.time) {
					return o1.eventId - o2.eventId;
				} else {
					return o1.time - o2.time;
				}
			}
		};

		Collections.sort(list, comparator);
		int max = 0;
		int num = 0;
		for (EventPoint event : list) {
			if (event.eventId == 1) {
				num++;
			} else {
				num--;
			}
			max = Math.max(max, num);
		}
		return max;
	}

	private class EventPoint {
		int time;
		int eventId;
		public EventPoint(int time, int eventId) {
			this.time = time;
			this.eventId = eventId;
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

		NumberAirplanesInSky nps = new NumberAirplanesInSky();
		List<Interval> list = new ArrayList<>();
		list.add(new Interval(1,2));
		list.add(new Interval(2,3));
		list.add(new Interval(3,4));

		nps.countOfAirplanes(list);
	}
}
