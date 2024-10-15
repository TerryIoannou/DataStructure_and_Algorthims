package data_structures;

public class BinaryTree<T extends Comparable<T>> {
    private Node<T> root;

    public BinaryTree() {
        this.root = null;
    }

    public void add(T data) {
        root = addRecursive(root, data);
    }

    private Node<T> addRecursive(Node<T> node, T data) {
        if (node == null) {
            return new Node<>(data);
        }

        if (data.compareTo(node.data) < 0) {
            node.left = addRecursive(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = addRecursive(node.right, data);
        }

        return node;
    }

    public boolean contains(T data) {
        return containsRecursive(root, data);
    }

    private boolean containsRecursive(Node<T> node, T data) {
        if (node == null) {
            return false;
        }

        if (data.equals(node.data)) {
            return true;
        }

        return data.compareTo(node.data) < 0
                ? containsRecursive(node.left, data)
                : containsRecursive(node.right, data);
    }

    // Binary search method corrected
    public boolean binarySearch(T data) {
        return binarySearchRecursive(root, data);
    }

    private boolean binarySearchRecursive(Node<T> node, T data) {
        if (node == null) {
            return false;
        }

        if (data.equals(node.data)) {
            return true;
        }

        if (data.compareTo(node.data) < 0) {
            return binarySearchRecursive(node.left, data);
        } else {
            return binarySearchRecursive(node.right, data);
        }
    }

    // Clear the binary tree
    public void clear() {
        root = null;
    }

    private static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;

        Node(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
}
