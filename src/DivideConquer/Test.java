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

    public static void main(String[] args) {
        Test test = new Test();
//        TreeNode input = new TreeNode(4);
//        input.left = new TreeNode(3);
//
//        input.right = new TreeNode(7);
//        input.right.left = new TreeNode(5);
//        input.right.right = new TreeNode(6);

//        TreeNode input = new TreeNode(2);
//        input.left = new TreeNode(1);
//        input.right = new TreeNode(2);
//
//        boolean result = test.isValidBST2(input);
//        if (result) {
//            System.out.println("true");
//        } else {
//            System.out.println("false");
//        }
        int[] input = new int[]{1,3,1,4,4,2};
        test.deduplication(input);

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
}
