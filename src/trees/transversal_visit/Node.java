package trees.transversal_visit;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Node {
    public int val;
    public List<Node> children;

    public Node() {}
    public Node(int _val) {
        val = _val;
        children = new LinkedList<>();
    }
    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

    public static void printTree(Node node, String prefix, boolean isTail) {
        if (node == null) {
            return;
        }

        System.out.println(prefix + (isTail ? "└── " : "├── ") + node.val);

        if (node.children != null) {
            Collections.reverse(node.children);
            int numChildren = node.children.size();
            for (int i = 0; i < numChildren - 1; i++) {

                printTree(node.children.get(i), prefix + (isTail ? "    " : "│   "), false);
            }
            if (numChildren > 0) {
                printTree(node.children.get(numChildren - 1), prefix + (isTail ? "    " : "│   "), true);
            }
        }
    }

}
