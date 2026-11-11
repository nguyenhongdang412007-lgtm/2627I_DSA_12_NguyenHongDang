
import java.util.Scanner;

public class IsBinarySearchTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    static boolean checkBST(Node root) {
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    static boolean isBST(Node root, long min, long max) {
        if (root == null) {
            return true;
        }

        if (root.data <= min || root.data >= max) {
            return false;
        }

        return isBST(root.left, min, root.data)
            && isBST(root.right, root.data, max);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Node[] nodes = new Node[n + 1];

        int[] leftIndex = new int[n + 1];
        int[] rightIndex = new int[n + 1];

        
        for (int i = 1; i <= n; i++) {
            int value = sc.nextInt();
            leftIndex[i] = sc.nextInt();
            rightIndex[i] = sc.nextInt();

            nodes[i] = new Node(value);
        }

        for (int i = 1; i <= n; i++) {
            if (leftIndex[i] != -1) {
                nodes[i].left = nodes[leftIndex[i]];
            }

            if (rightIndex[i] != -1) {
                nodes[i].right = nodes[rightIndex[i]];
            }
        }

        Node root = (n == 0) ? null : nodes[1];

        System.out.println(checkBST(root));

        sc.close();
    }
}
