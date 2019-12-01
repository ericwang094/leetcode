package leetcode.BFS;

import java.util.*;

public class LintCodeAlienDictionary {
    public String alienOrder(String[] words) {
		Map<Character, AlienDictionary> mapCharToAlienObj = new HashMap<>();
		// create node
		for(String word : words) {
			char[] charArray = word.toCharArray();
			for (int i = 0; i < charArray.length; i++) {
				char c = charArray[i];
				AlienDictionary ad;
				if (!mapCharToAlienObj.containsKey(c)) {
					ad = new AlienDictionary(c, 0, new HashSet<>());
					mapCharToAlienObj.put(c, ad);
				}
			}
		}

		// create edges
	    for (int i = 0; i < words.length - 1; i++) {
			int index = 0;
			while (index < words[i].length() && index < words[i + 1].length()) {
				if (words[i].charAt(index) != words[i + 1].charAt(index)) {
					mapCharToAlienObj.get(words[i + 1].charAt(index)).degree++;
					AlienDictionary currentC = mapCharToAlienObj.get(words[i].charAt(index));
					currentC.preRequest.add(words[i + 1].charAt(index));
					break;
				}
				index++;
			}
	    }


		PriorityQueue<Character> queue = new PriorityQueue<>();
		for (Map.Entry<Character, AlienDictionary> entry : mapCharToAlienObj.entrySet()) {
			if (entry.getValue().degree == 0) {
				queue.add(entry.getKey());
			}
		}

	    StringBuilder sb = new StringBuilder();
		while (!queue.isEmpty()) {

			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Character c = queue.poll();

				Set<Character> preRequestSet = mapCharToAlienObj.get(c).preRequest;
				for (Character ch : preRequestSet) {
					AlienDictionary correspondingAD = mapCharToAlienObj.get(ch);
					correspondingAD.degree--;

					if (correspondingAD.degree == 0) {
						queue.add(correspondingAD.c);
					}
				}
				sb.append(c);
			}
		}

		String result = sb.toString();

		boolean mapEmpty = true;
	    for (Map.Entry<Character, AlienDictionary> entry : mapCharToAlienObj.entrySet()) {
		    if (entry.getValue().degree > 0) {
			    mapEmpty = false;
			    break;
		    }
	    }

	    if (mapEmpty) {
	    	return result;
	    } else {
	    	return "";
	    }
    }

	public static void main(String[] args) {
		LintCodeAlienDictionary ad = new LintCodeAlienDictionary();
		System.out.println(ad.alienOrder(new String[] {"wrt","wrf","er","ett","rftt"}));

	}

}

class AlienDictionary {
    char c;
    int degree;
    Set<Character> preRequest;

    public AlienDictionary(char c, int degree, Set<Character> preRequest) {
        this.c = c;
        this.degree = degree;
        this.preRequest = preRequest;
    }
}