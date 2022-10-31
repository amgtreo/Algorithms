package algorithms.trees.dfs;
import algorithms.trees.Node;

import java.util.ArrayList;
import java.util.List;


class LeftViewOfTree {

    int maxLevel = 0;

    void leftView(Node root, int level, List<Integer> result) {
        if (root == null) return;

        if (maxLevel < level) {
            result.add(root.data);
            maxLevel = level;
        }

        leftView(root.left, level + 1, result);
        leftView(root.right, level + 1, result);
    }
}

class DFSPreOrder {
    void search(Node root, List<Integer> results) {
        if (root == null) return;
        results.add(root.data);
        search(root.left, results);
        search(root.right, results);
    }
}

class DFSInOrder {

    public void search(Node root, List<Integer> results) {
        if (root == null) return;
        search(root.left, results);
        results.add(root.data);
        search(root.right, results);
    }
}

class DFSPostOrder {
    public void search(Node root, List<Integer> results) {
        if (root == null) return;
        search(root.left, results);
        search(root.right, results);
        results.add(root.data);
    }
}

class DFSPreOrderDeepCopy{
    public Node copy(Node root){
        if(root == null) return null;
        Node clone = new Node(root.data);
        clone.left = copy(root.left);
        clone.right = copy(root.right);
        return clone;
    }
}

public class DSFBinaryTree {

    private static void printPreOrder(Node root){
        if(root== null) return;
        System.out.print((char) root.data + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    public static void main(String[] args) {

        System.out.println("\nLeft View Binary Tree - Numbers");
          /*
            3  --- Level 1
           / \
          9   20  --- Level 2
             /  \
            15   7  --- Level 3
         */

        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        List<Integer> result = new ArrayList<>();
        LeftViewOfTree leftViewOfTree = new LeftViewOfTree();
        leftViewOfTree.leftView(root, 1, result);

        for (Integer nodeValue : result) {
            System.out.print(nodeValue + " ");
        }


        System.out.println("\nLeft View Binary Tree - Chars");
        /*
                     F  ---- Level 1
                  /    \
                B       G  ---- Level 2
              /  \       \
            A     D       I ---- Level 3
                /  \     /
               C    E   H ---- Level 4
         */

        Node rootNode = new Node('F');
        rootNode.left = new Node('B');
        rootNode.right = new Node('G');
        rootNode.left.left = new Node('A');
        rootNode.left.right = new Node('D');
        rootNode.right.right = new Node('I');
        rootNode.left.right.left = new Node('C');
        rootNode.left.right.right = new Node('E');
        rootNode.right.right.left = new Node('H');

        List<Integer> results = new ArrayList<>();
        LeftViewOfTree test = new LeftViewOfTree();
        test.leftView(rootNode, 1, results);

        for (Integer integer : results) {
            System.out.print((char) integer.intValue() + " ");
        }

        System.out.println("\nDFS Pre-order Traversal");

        List<Integer> preOrderResults = new ArrayList<>();
        DFSPreOrder preOrder = new DFSPreOrder();
        preOrder.search(rootNode, preOrderResults);
        for (Integer integer : preOrderResults) {
            System.out.print((char) integer.intValue() + " ");
        }

        System.out.println("\nDFS In-order Traversal");
        List<Integer> inOrderResults = new ArrayList<>();
        DFSInOrder inOrder = new DFSInOrder();
        inOrder.search(rootNode, inOrderResults);
        for (Integer integer : inOrderResults) {
            System.out.print((char) integer.intValue() + " ");
        }

        System.out.println("\nDFS Post-order Traversal");
        List<Integer> postOrderResults = new ArrayList<>();
        DFSPostOrder postOrder = new DFSPostOrder();
        postOrder.search(rootNode, postOrderResults);
        for (Integer integer : postOrderResults) {
            System.out.print((char) integer.intValue() + " ");
        }

        System.out.println("\nDFS Pre-order Clone");
        DFSPreOrderDeepCopy deepCopy = new DFSPreOrderDeepCopy();
        Node clone = deepCopy.copy(rootNode);
        printPreOrder(clone);
    }
}
