package DivideConquer;

import java.util.ArrayList;
import java.util.HashSet;

public class LowestCommonAncestorII {
    /*
     * @param root: The root of the tree
     * @param A: node in the tree
     * @param B: node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
        HashSet<ParentTreeNode> pathA = pathToRoot(root, A);
        ParentTreeNode result = B;
        while (B.parent != null) {
            if (pathA.contains(B)) {
                return B;
            }
            B = B.parent;
        }
        return B;
    }

    private HashSet<ParentTreeNode> pathToRoot (ParentTreeNode root, ParentTreeNode node) {
        HashSet<ParentTreeNode> result = new HashSet<ParentTreeNode>();
        if (node != null) {
            result.add(node);
        }
        while (node.parent != null) {
            result.add(node.parent);
            node = node.parent;
        }
        return result;
    }
}

class ParentTreeNode {
    public ParentTreeNode parent, left, right;
}
