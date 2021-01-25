import java.util.Scanner;

public class BSTVerify {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Node root = insertValue(null, 2);
        root = insertValue(root, 3);
        root = insertValue(root, 5);

        Node falseRoot = new Node(5);
        falseRoot.left = new Node(8);
        falseRoot.right = new Node(1);

        System.out.println("True BST: " + checkBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE));
        System.out.println("False BST: " + checkBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE));
    }

    static boolean checkBST(Node root, int max, int min) {
        if (root == null)
            return true;
        if (root.data < min || root.data > max)
            return false;
        else
            return (checkBST(root.left, root.data - 1, min) && checkBST(root.right, max, root.data + 1));
    }

    static Node insertValue(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (root.data > value)
            root.left = insertValue(root.left, value);
        else if (root.data < value)
            root.right = insertValue(root.right, value);
        return root;
    }
}
