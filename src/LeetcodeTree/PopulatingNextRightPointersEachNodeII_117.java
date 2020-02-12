package LeetcodeTree;
// https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/discuss/37828/O(1)-space-O(n)-complexity-Iterative-Solution
public class PopulatingNextRightPointersEachNodeII_117 {
	public PopulatingNextRightPointersEachNode_116.Node connect(PopulatingNextRightPointersEachNode_116.Node root) {
		PopulatingNextRightPointersEachNode_116.Node result = root;

		PopulatingNextRightPointersEachNode_116.Node head = root;
		PopulatingNextRightPointersEachNode_116.Node prev = null;
		PopulatingNextRightPointersEachNode_116.Node curr = null;

		while (head != null) {
			prev = null;
			curr = head;
			head = null;

			while (curr != null) {
				if (curr.left != null) {
					if (prev != null) {
						prev.next = curr.left;
					} else {
						head = curr.left;
					}
					prev = prev.left;
				}

				if (curr.right != null) {
					if (prev != null) {
						prev.next = curr.right;
					} else {
						head = curr.right;
					}

					prev = curr.right;
				}

				curr = curr.next;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		PopulatingNextRightPointersEachNode_116.Node root = new PopulatingNextRightPointersEachNode_116.Node(3);
		root.left = new PopulatingNextRightPointersEachNode_116.Node(9);
		root.right = new PopulatingNextRightPointersEachNode_116.Node(20);

//		root.left.left = new PopulatingNextRightPointersEachNode_116.Node(4);
//		root.left.right = new PopulatingNextRightPointersEachNode_116.Node(5);

		root.right.left = new PopulatingNextRightPointersEachNode_116.Node(15);
		root.right.right = new PopulatingNextRightPointersEachNode_116.Node(17);

		PopulatingNextRightPointersEachNodeII_117 test = new PopulatingNextRightPointersEachNodeII_117();
		test.connect(root);
	}
}
