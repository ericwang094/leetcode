package DivideConquer;

import TwoPointers.ListNode;
import leetcode.BFS.TreeNode;

import java.util.*;

public class Test {
    /**
     * @param root: the given BST
     * @param target: the given target
     * @param k: the given k
     * @return: k values in the BST that are closest to the target
     */
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Stack<TreeNode> preStack = new Stack<>();
        Stack<TreeNode> nextStack = new Stack<>();

        while (root != null) {
            if (root.val < target) {
                preStack.add(root);
                root = root.right;
            } else {
                nextStack.add(root);
                root = root.left;
            }
        }

        List<Integer> result = new ArrayList<>();
        while (result.size() < k ) {
            double distN = nextStack.isEmpty() ? Double.MAX_VALUE : Math.abs(nextStack.peek().val - target);
            double distP = preStack.isEmpty() ? Double.MAX_VALUE : Math.abs(target - preStack.peek().val);

            if (distN < distP) {
                result.add(nextStack.peek().val);
                goNext(nextStack);
            } else {
                result.add(0, preStack.peek().val);
                goPrev(preStack);
            }
        }

        return result;
    }

    private void goNext(Stack<TreeNode> stack) {
        TreeNode node = stack.pop().right;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    private void goPrev(Stack<TreeNode> stack) {
        TreeNode node = stack.pop().left;
        while (node != null) {
            stack.push(node);
            node = node.right;
        }
    }

    /**
     * @param root: A Tree
     * @return: Postorder in ArrayList which contains node values.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.add(root);
            root = root.left;
        }

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node.right != null) {
                node = node.right;
                while (node != null) {
                    stack.add(node);
                    node = node.left;
                }
            } else {
                node = stack.pop();
                result.add(node.val);

                while (!stack.isEmpty() && stack.peek().right != null) {
                    node = stack.pop();
                    result.add(node.val);
                }
            }
        }
        return result;
    }

    /**
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // write your code here
        int start = 0;
        int end = s.length() - 1;
        char[] array = s.toCharArray();
        while (start < end) {
            while (start < end && !Character.isLetterOrDigit(array[start])) {
                start++;
            }

            while (start < end && !Character.isLetterOrDigit(array[end])) {
                end--;
            }

            if (Character.toLowerCase(array[start]) != Character.toLowerCase(array[end])) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }


    /**
     * @param s: a string
     * @return boolean: whether you can make s a palindrome by deleting at most one character
     */
    public boolean validPalindrome(String s) {
        boolean hasDeleted = false;
        int start = 0;
        int end = s.length() - 1;
        char[] array = s.toCharArray();
        while (start < end) {
            if (array[start] != array[end]) {
                if (hasDeleted) {
                    return false;
                } else {
                    hasDeleted = true;
                    if (start + 1 < s.length() && array[start + 1] == array[end]) {
                        start++;
                    } else if (end - 1 >= 0 && array[end - 1] == array[start]) {
                        end--;
                    } else {
                        return false;
                    }
                }
            } else {
                start++;
                end--;
            }
        }

        return true;
    }

    /**
     * @param nums: an array of integer
     * @param target: An integer
     * @return: An integer
     */
    public int twoSum6(int[] nums, int target) {
        int result = 0;
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum == target) {
                result++;
                start++;
                end--;
                if (start < end && start + 1 < nums.length && end - 1 >= 0
                        && nums[start + 1] == nums[start]
                        && nums[end - 1] == nums[end]) {
                    start++;
                    end--;
                }

            } else if (sum < target) {
                start++;
            } else {
                end--;
            }
        }

        return result;
    }

    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 1; i++) {
            int target = -numbers[i];

            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            int start = i + 1;
            int end = numbers.length - 1;
            while (start < end) {
                int sum = numbers[start] + numbers[end];
                if (sum == target) {
                    List<Integer> tempList = new ArrayList<>();

                    tempList.add(numbers[i]);
                    tempList.add(numbers[start]);
                    tempList.add(numbers[end]);
                    result.add(tempList);

                    while (start < end && start + 1< numbers.length
                        && numbers[start] == numbers[start + 1]) {
                        start++;
                    }

                    while (start < end && end - 1 >= 0
                            && numbers[end] == numbers[end - 1]) {
                        end--;
                    }

                    start++;
                    end--;
                } else if (sum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        return result;
    }

    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int[] S) {
        // write your code here
        int result = 0;
        Arrays.sort(S);

        for (int i = 0; i < S.length - 1; i++) {
            int start = 0;
            int end = i - 1;
            while (start < end) {
                if (S[start] +  S[end] > S[i]) {
                    result += (start - end);
                    end--;
                }else {
                    start++;
                }
            }
        }
        return result;
    }

	/**
	 * @param nums: an array of integer
	 * @param target: an integer
	 * @return: an integer
	 */
	public int twoSum5(int[] nums, int target) {
		Arrays.sort(nums);
		int result = 0;

		int start = 0;
		int end = nums.length - 1;
		while (start < end) {
			if (nums[start] + nums[end] <= target) {
				result += (end - start);
				start++;
			} else {
				end--;
			}
		}

		return result;
	}

	/**
	 * @param nums: an array of integer
	 * @param target: An integer
	 * @return: an integer
	 */
	public int twoSum2(int[] nums, int target) {
		int result = 0;
		// write your code here
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 1; i++) {
			int start = i + 1;
			while (start < nums.length) {
				int sum = nums[i] + nums[start];
				if (sum > target) {
					result += (nums.length - start);
					break;
				}
				start++;
			}
		}
		return result;
	}

    /**
     * @param nums: an array of Integer
     * @param target: an integer
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum7(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(i) + 1, i + 1};
            } else {
                int sum = target + nums[i];
                int diff = nums[i] - target;
                map.put(sum, i);
                map.put(diff, i);
            }
        }

        return new int[]{};
    }

    /*
     * @param A: An integer array.
     * @return: nothing
     */
    public void rerange(int[] A) {
        int countPositive = 0;

        int positiveIndex = 0;
        int pos = 1;
        int neg = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                swap(A, positiveIndex, i);
                countPositive++;
                positiveIndex++;
            }
        }

        if (countPositive > A.length / 2) {
            pos = 0;
            neg = 1;

            int left = 0;
            int right = A.length - 1;
            while (left < right) {
                swap(A, left, right);
                left++;
                right--;
            }
        }

        while (pos < A.length && neg < A.length) {
            while (pos < A.length && A[pos] > 0) {
                pos += 2;
            }

            while (neg < A.length && A[neg] < 0) {
                neg += 2;
            }

            if (neg >= A.length || pos >= A.length) {
                break;
            }

            swap(A, pos, neg);
        }
    }

	public void sortLetters(char[] chars) {
		int start = 0;
		int end = chars.length - 1;
		while (start < end) {
			while (start < end
					&& Character.isLowerCase(chars[start])) {
				start++;
			}

			while (start <end && Character.isUpperCase(chars[end])) {
				end--;
			}

			if (start < end) {
				char temp = chars[start];
				chars[start] = chars[end];
				chars[end] = temp;
			}
		}
	}

    private void swap(int[] A, int l, int r) {
        int temp = A[l];
        A[l] = A[r];
        A[r] = temp;
    }

	/**
	 * @param nums: A list of integer which is 0, 1 or 2
	 * @return: nothing
	 */
	public void sortColors(int[] nums) {
		// write your code here
		int start = 0;
		int index = 0;
		int end = nums.length - 1;

		while (index < end) {
			if (nums[index] == 0) {
				nums[index] = nums[start];
				nums[start] = 0;
				index++;
				start++;
			} else if (nums[index] == 1) {
				index++;
			} else {
				nums[index] = nums[end];
				nums[end] = 2;
				end--;
			}
		}
	}

	/**
	 * @param head: the head of linked list.
	 * @return: a middle node of the linked list
	 */
	public ListNode middleNode(ListNode head) {
		if (head == null) {
			return null;
		}
		// write your code here
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		return slow;
	}

	public void moveZeroes(int[] nums) {
		// write your code here
		int i = 0;
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] != 0) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				i++;
			}
		}
	}

	public int deduplication(int[] nums) {
		// write your code here
		Arrays.sort(nums);
		int i = 0;
		for (int j = 0; j < nums.length; j++) {
			if (nums[i] != nums[j]) {
				i++;
				nums[i] = nums[j];


			}
		}
		return i;
	}

	/*
	 * @param : a string to be split
	 * @return: all possible split string array
	 */
	public List<List<String>> splitString(String s) {
		List<List<String>> result = new ArrayList<>();
		splitStringHelper(s, 0, new ArrayList<>(), result);
		return result;
	}

	private void splitStringHelper(String s, int index, List<String> current, List<List<String>> result) {
		if (index == s.length()) {
			result.add(new ArrayList<>(current));
		} else {
			current.add(s.substring(index, index + 1));
			splitStringHelper(s, index + 1, current, result);
			current.remove(current.size() - 1);

			if (index < s.length() - 1) {
				current.add(s.substring(index, index + 2));
				splitStringHelper(s, index + 2, current, result);
				current.remove(current.size() - 1);
			}
		}
	}

	/**
	 * @param digits: A digital string
	 * @return: all posible letter combinations
	 */
	public List<String> letterCombinations(String digits) {
		Map<Character, Character[]> map = new HashMap<Character, Character[]>();
		map.put('2', new Character[]{'a', 'b', 'c'});
		map.put('3', new Character[]{'d', 'e', 'f'});
		map.put('4', new Character[]{'g', 'h', 'i'});
		map.put('5', new Character[]{'j', 'k', 'l'});
		map.put('6', new Character[]{'m', 'n', 'o'});
		map.put('7', new Character[]{'p', 'q', 'r', 's'});
		map.put('8', new Character[]{'t', 'u', 'v'});
		map.put('9', new Character[]{'w', 'x', 'y', 'z'});

		List<String> result = new ArrayList<>();
		if (digits.equals("")) {
			return result;
		}

		letterCombinationsHelper(digits, "", result, map);
		return result;
	}

	private void letterCombinationsHelper(String digits, String tempResult, List<String> result, Map<Character, Character[]> map) {
		if (tempResult.length() == digits.length()) {
			result.add(tempResult);
		} else {
			char currentChar = digits.charAt(tempResult.length());
			Character[] allPossibleChar = map.get(currentChar);
			for (int i = 0; i < allPossibleChar.length; i++) {
				tempResult += allPossibleChar[i];
				letterCombinationsHelper(digits, tempResult, result, map);
				tempResult = tempResult.substring(0, tempResult.length() - 1);
			}
		}
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		// write your code here
		List<List<Integer>> result = new ArrayList<>();
		if (candidates.length == 0) {
			return result;
		}
		combinationSumHelper(candidates, result, new ArrayList<>(), target, 0);
		return result;
	}

	private void combinationSumHelper(int[] candidates, List<List<Integer>> result, List<Integer> tempList, int target, int index) {
		if (target == 0) {
			result.add(new ArrayList<>(tempList));
		} else {
			for (int i = index; i < candidates.length; i++) {
				if (i > 0 && candidates[i] == candidates[i - 1]) {
					continue;
				}
				tempList.add(candidates[i]);
				combinationSumHelper(candidates, result, tempList, target - candidates[i], index + 1);
				tempList.remove(tempList.size() - 1);
			}
		}
	}

	/*
	 * @param n: The number of queens
	 * @return: All distinct solutions
	 */
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> result = new ArrayList<>();
		List<Integer> tempResult = new ArrayList<>();
		nQueenHelper(n, result, tempResult);
		return result;
	}

	private void nQueenHelper(int n, List<List<String>> result, List<Integer> tempResult) {
		if (tempResult.size() == n) {
			List<String> solution = convertIntegerToStringList(n, tempResult);
			result.add(solution);
		} else {
			for (int i = 0; i < n; i++) {
				if (!isValidPlacement(tempResult, i)) {
					continue;
				}
				tempResult.add(i);
				nQueenHelper(n, result, tempResult);
				tempResult.remove(tempResult.size() - 1);
			}
		}
	}

	private boolean isValidPlacement(List<Integer> tempResult, int place) {
		for (int i = 0; i < tempResult.size(); i++) {
			int diff = Math.abs(tempResult.get(i) - place);
			if (diff == 0 || diff == tempResult.size() - i) {
				return false;
			}
		}

		return true;
	}

	private List<String> convertIntegerToStringList (int n, List<Integer> tempResult) {
		List<String> result = new ArrayList<>();
		for (int i = 0; i < tempResult.size(); i++) {
			int currentNum = tempResult.get(i);
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < n; j++) {
				if (j == currentNum) {
					sb.append("Q");
				} else {
					sb.append(".");
				}
			}
			result.add(sb.toString());
		}

		return result;
	}

	/**
	 * @param nums: A set of numbers
	 * @return: A list of lists
	 */
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> tempResult = new ArrayList<>();
		if (nums.length == 0) {
			return result;
		}

		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			subsetHelper(nums, result, tempResult, i, 0);
		}
		return result;
	}

	private void subsetHelper(int[] nums, List<List<Integer>> result, List<Integer> tempResult, int size, int index) {
		if (tempResult.size() == size) {
			result.add(new ArrayList<>(tempResult));
		} else {
			for (int i = index; i < nums.length; i++) {
				tempResult.add(nums[i]);
				subsetHelper(nums, result, tempResult, size, i + 1);
				tempResult.remove(tempResult.size() - 1);
			}
		}
	}

	/**
	 * @param n: An integer
	 * @param nums: An array
	 * @return: the Kth largest element
	 */
	public int kthLargestElement(int n, int[] nums) {
		if (nums == null) {
			return -1;
		}

		return quickSort(nums, 0, nums.length - 1, n - 1);
	}

	private int quickSort(int[] nums, int start, int end, int k) {
		if (start >= end) {
			return nums[k];
		}

		int left = start, right = end;
		int mean = nums[(left + right) / 2];

		while (left <= right) {
			while (nums[left] <= nums[mean]) {
				left++;
			}

			while (nums[right] >= nums[mean]) {
				right++;
			}

			if (left <= right) {
				int temp = nums[left];
				nums[left] = nums[right];
				nums[right] = temp;

				left++;
				right--;
			}
		}

		if (k <= right) {
			return quickSort(nums, start, right, k);
		} if (k >= left) {
			return quickSort(nums, left, end, k);
		}

		return nums[k];

	}

	/**
	 * @param nums: a list of integers.
	 * @param k: length of window.
	 * @return: the sum of the element inside the window at each moving.
	 */
	public int[] winSum(int[] nums, int k) {
		List<Integer> list = new ArrayList<>();
		if (nums == null || nums.length == 0 || nums.length < k) {
			return new int[]{};
		}

		int start = 0;
		int end = start + k - 1;
		int firstSum = 0;
		for (int i = 0; i <= end; i++) {
			firstSum += nums[i];
		}
		list.add(firstSum);
		start++;
		end++;

		while (end < nums.length) {
			int newSum = firstSum - nums[start-1] + nums[end];
			firstSum = newSum;
			list.add(newSum);
			start++;
			end++;
		}

		int[] result = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}

		return result;
	}

	public boolean wordPatternMatch(String pattern, String str) {
		Map<Character, String> map = new HashMap<>();
		Set<String> set = new HashSet<>();
		return wordPatternMatchHelper(pattern, str, map, set);
	}

	private boolean wordPatternMatchHelper(String pattern, String str, Map<Character, String> map, Set<String> set) {
		if (pattern.length() == 0) {
			return str.length() == 0;
		}
		char currentChar = pattern.charAt(0);
		if (map.containsKey(currentChar)) {
			String matchStr = map.get(currentChar);
			if (matchStr.equals(str.substring(0, matchStr.length()))) {
				pattern = pattern.substring(1);
				str = str.substring(matchStr.length());
				return wordPatternMatchHelper(pattern, str, map, set);
			}
		}
		for (int i = 1; i < str.length(); i++) {
			String matchStr = str.substring(0, i);
			if (set.contains(matchStr)) {
				continue;
			}
			map.put(currentChar, matchStr);
			set.add(matchStr);
			if (wordPatternMatchHelper(pattern, str, map, set)) {
				return true;
			}
			map.remove(currentChar);
			set.remove(matchStr);
		}
		return false;
	}

	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
		Map<String, Integer> distance = new HashMap<String, Integer>();
		Map<String, List<String>> parentToNextWord = new HashMap<>();
		dict.add(start);
		dict.add(end);

		bfs(start, end, dict, distance, parentToNextWord);
		List<List<String>> result = new ArrayList<>();
		dfs(start, end, distance, parentToNextWord, new ArrayList<>(), result);

		return result;
	}

	private void bfs(String start, String end, Set<String> dict, Map<String, Integer> distance,
	                 Map<String, List<String>> parentToNextWord) {
		distance.put(start, 0);

		for (String word : dict) {
			parentToNextWord.put(word, new ArrayList<>());
		}

		Queue<String> queue = new LinkedList<>();
		queue.add(start);

		while (!queue.isEmpty()) {
			String word = queue.poll();
			List<String> nextWords = findNextWords(word, dict);
			for (String nextWord : nextWords) {
				parentToNextWord.get(word).add(nextWord);
				if (!distance.containsKey(nextWord)) {
					distance.put(nextWord, distance.get(word) + 1);
					queue.add(nextWord);
				}
			}
		}
	}

	private void dfs(String start, String end, Map<String, Integer> distance,
	                 Map<String, List<String>> parentToNextWord, List<String> tempResult, List<List<String>> result) {
		tempResult.add(start);
		if (start.equals(end)) {
			result.add(new ArrayList<>(tempResult));
		} else {
			List<String> nextWords = parentToNextWord.get(start);
			for (String nextWord : nextWords) {
				if (distance.get(start) + 1 == distance.get(nextWord)) {
					dfs(nextWord, end, distance, parentToNextWord, tempResult, result);
				}
			}
		}
		tempResult.remove(tempResult.size() - 1);
	}

	private List<String> findNextWords(String word, Set<String> dict) {
		List<String> result = new ArrayList<>();
		for (int i = 0; i < word.length(); i++) {
			for (char j = 'a'; j <= 'z'; j++) {
				char[] wordArray = word.toCharArray();
				if (wordArray[i] == j) {
					continue;
				}
				wordArray[i] = j;
				String newWord = new String(wordArray);
				if (dict.contains(newWord)) {
					result.add(newWord);
				}
			}
		}

		return result;
	}

	public List<Integer> closestKValues2(TreeNode root, double target, int k) {
		// write your code here
		Stack<TreeNode> nextStack = new Stack<>();
		Stack<TreeNode> prevStack = new Stack<>();

		TreeNode temp = root;
		while (temp != null) {
			nextStack.add(temp);
			temp = temp.left;
		}

		temp = root;
		while (temp != null) {
			prevStack.add(temp);
			temp = temp.right;
		}

		while (!nextStack.isEmpty() && nextStack.peek().val < target) {
			moveNextNode(nextStack);
		}

		while (!prevStack.isEmpty() && prevStack.peek().val >= target) {
			movePrevNode(prevStack);
		}

		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			if (!nextStack.isEmpty() && !prevStack.isEmpty()) {
				TreeNode nextNode = nextStack.peek();
				TreeNode prevNode = prevStack.peek();
				if (Math.abs(target - nextNode.val) < Math.abs(target-prevNode.val)) {
					result.add(nextNode.val);
					moveNextNode(nextStack);
				} else {
					result.add(prevNode.val);
					movePrevNode(prevStack);
				}
			} else if (!nextStack.isEmpty()) {
				result.add(nextStack.peek().val);
				moveNextNode(nextStack);
			} else {
				result.add(prevStack.peek().val);
				movePrevNode(prevStack);
			}
		}
		return result;
	}

	private void movePrevNode(Stack<TreeNode> stack) {
		TreeNode cur = stack.pop();
		cur = cur.left;
		while (cur != null) {
			stack.add(cur);
			cur = cur.right;
		}
	}

	private void moveNextNode(Stack<TreeNode> stack) {
		TreeNode cur = stack.pop();
		cur = cur.right;
		while (cur != null) {
			stack.add(cur);
			cur = cur.left;
		}
	}

	public List<Integer> closestKValues3(TreeNode root, double target, int k) {
		// write your code here
		Stack<TreeNode> inOrderStack = new Stack<>();
		Stack<TreeNode> reverseInOrderStack = new Stack<>();

		while (root != null) {
			if (root.val < target) {
				reverseInOrderStack.add(root);
				root = root.right;

			} else {
				inOrderStack.add(root);
				root = root.left;

			}
		}

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			double inOrderNextDiff = inOrderStack.isEmpty() ? Integer.MAX_VALUE : inOrderStack.peek().val - target;
			double reverseInOrderDiff = reverseInOrderStack.isEmpty() ? Integer.MAX_VALUE : target - reverseInOrderStack.peek().val;

			if (inOrderNextDiff < reverseInOrderDiff) {
				list.add(inOrderStack.peek().val);
				moveToBigger(inOrderStack);
			} else {
				list.add(reverseInOrderStack.peek().val);
				moveToSmaller(reverseInOrderStack);
			}
		}

		return list;

	}

	private void moveToBigger(Stack<TreeNode> stack) {
		TreeNode node = stack.pop();
		node = node.right;
		while (node != null) {
			stack.add(node);
			node = node.left;
		}
	}

	private void moveToSmaller(Stack<TreeNode> stack) {
		TreeNode node = stack.pop();
		node = node.left;

		while (node != null) {
			stack.add(node);
			node = node.right;
		}

	}
	public List<String> binaryTreePaths(TreeNode root) {
		// write your code here
		List<String> result = new ArrayList<>();
		if (root == null) {
			return result;
		}

		dfs(root, result, root.val + "");
		return result;
	}

	public int kthSmallest(TreeNode root, int k) {
		Map<TreeNode, Integer> nodeToCount = new HashMap<>();
		countNode(root, nodeToCount);

		return quickSelectTree(root, k, nodeToCount);
	}

	private int countNode (TreeNode node, Map<TreeNode, Integer> nodeToCount) {
		if (node == null) {
			return 0;
		}

		int left = countNode(node.left, nodeToCount);
		int right = countNode(node.right, nodeToCount);

		nodeToCount.put(node, left + right + 1);
		return left + right + 1;
	}

	private int quickSelectTree(TreeNode node, int k, Map<TreeNode, Integer> nodeToCount) {
		if (nodeToCount.get(node) + 1 == k) {
			return node.val;
		}

		int numOfLeftNode = node.left == null ? 0 : nodeToCount.get(node.left);
		if (numOfLeftNode >= k) {
			return quickSelectTree(node.left, k, nodeToCount);
		}

		return quickSelectTree(node.right, k - numOfLeftNode - 1, nodeToCount);
	}

	private void dfs(TreeNode root, List<String> result, String temp) {
		if (root.left != null && root.right != null) {
			result.add(temp);
		} else {
			if (root.left != null) {
				dfs(root.left, result, temp + root.left.val);
			}

			if (root.right != null) {
				dfs(root.right, result, temp + root.right.val);
			}
		}
	}

	public static void main(String[] args) {
		Test t = new Test();
		TreeNode input = new TreeNode(2);
		input.left = new TreeNode(1);
		input.right = new TreeNode(3);

//		input.left = new TreeNode(4);
//		input.left.right = new TreeNode(5);

//		t.closestKValues2(input, 3.714286, 3);
//		TreeNode input = new TreeNode(2147483647);
//		t.closestKValues3(input, 0.0, 1);
		t.kthSmallest(input, 1);
	}
}
