package FinalExam;

class Node<T> {
    T data;
    Node<T> left;
    Node<T> right;

    Node (T data) {
        this.data = data;
        left = null;
        right = null;
    }

    Node(Node<T> node) {
        this.data = node.data;
        if (node.left != null) {
            this.left = new Node<>(node.left);
        }
        if (node.right != null) {
            this.right = new Node<>(node.right);
        }
    }
}

public class SimpleTree<T> {
    Node<T> root; // root node

    // 기본 생성자
    SimpleTree() {
        root = null;
    }
    SimpleTree(Node<T> root) {
        this.root = root;
    }

}
