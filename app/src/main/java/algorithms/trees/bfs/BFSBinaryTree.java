package trees.bfs;

import trees.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSBinaryTree {
    public static void main(String[] args) {

        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.left.left = new Node(8);
        root.left.right = new Node(12);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        BFSBinaryTree bfs = new BFSBinaryTree();
        System.out.println(bfs.levelOrder(root));
    }

    public List<List<Integer>> levelOrder(Node root) {

        Queue<Node> queue = new LinkedList<>();

        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;

        queue.offer(root);

        while (!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);

                temp.add(queue.poll().data);

            }
            ans.add(temp);
        }

        return ans;

    }
}