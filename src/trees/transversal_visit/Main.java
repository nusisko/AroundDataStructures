package trees.transversal_visit;

import java.util.List;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);

        node1.children.add(node2);
        node1.children.add(node3);
        node1.children.add(node4);

        node3.children.add(node8);
        node3.children.add(node5);

        node5.children.add(node6);

        node4.children.add(node7);

        node7.children.add(node9);
        node7.children.add(node10);

        Node.printTree(node1, "", true);

        //#### RECURSIVE ####
        long start0 = System.nanoTime();
        int times = 1000000;
        for (int i = 0; i < times ; i++) {
            Preorder.preorderRecursive(node1, new ArrayList<>());
        }
        long end0 = System.nanoTime();
        List<Integer> resRecursive = Preorder.preorderRecursive(node1, new ArrayList<>());
        System.out.printf("Recursive preorder at %d times\nResult: %s \nTime: %d ns", times, resRecursive,(end0 - start0) / times);


        //#### ITERATIVE ####
        long start = System.nanoTime();
        for (int i = 0; i < times ; i++) {
            Preorder.preorderIterative(node1);
        }
        long end = System.nanoTime();
        List<Integer> rIterative = Preorder.preorderIterative(node1);
        System.out.printf("Recursive preorder at %d times\nResult: %s \nTime: %d ns", times, rIterative,(end - start) / times);

    }
}
