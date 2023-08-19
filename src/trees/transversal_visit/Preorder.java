package trees.transversal_visit;

import java.util.*;

public class Preorder {
    public static List<Integer> preorderRecursive(Node root, List<Integer> output) {
        if (root == null) {
            return output;
        }
        output.add(root.val);

        Collections.reverse(root.children);
        for (Node child : root.children) {
            preorderRecursive(child, output);
        }
        return output;
    }

    public static List<Integer> preorderIterative(Node root) {

        Stack<Node> stack = new Stack<>();
        List<Integer> output = new ArrayList<>();

        if (root == null) {
            return output;
        }

        stack.push(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            output.add(node.val);
            for (Node child:node.children){
                stack.push(child);
            }
        }
        return output;
    }
}
