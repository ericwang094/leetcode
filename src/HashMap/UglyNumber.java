package HashMap;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;

public class UglyNumber {
    /**
     * @param n: An integer
     * @return: return a  integer as description.
     */
    public int nthUglyNumber(int n) {
        Queue<Long> priorityQueue = new PriorityQueue<>();
        HashSet<Long> inQ = new HashSet<Long>();

        Long[] primes = {2L, 3L, 5L};

        for (int i = 0; i < primes.length; i++) {
            priorityQueue.add(primes[i]);
            inQ.add(primes[i]);
        }

        Long number = 1L;
        for (int i = 1; i < n; i++) {
            number = priorityQueue.poll();
            for (int j = 0; j < 3; j++) {
                Long value = primes[j] * number;
                if (!inQ.contains(value)) {
                    priorityQueue.add(value);
                    inQ.add(value);
                }
            }
        }
        return number.intValue();
    }
}
