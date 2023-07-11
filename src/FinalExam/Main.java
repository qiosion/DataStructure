package FinalExam;

public class Main {
//    public static boolean subTreeCheck(Node x, Node y) {
//        if (x == null && y == null) {
//            return true;
//        }
//        return (x != null && y != null) && (x.data == y.data) &&
//                subTreeCheck(x.left, y.left) &&
//                subTreeCheck(x.right, y.right);
//    }

    static boolean isSameTree(SimpleTree t1, SimpleTree t2) {
        boolean result = false;

        // t1과 t2를 비교하여, 트리의 구조와 저장된 값이 같으면 true를 반환
        // 두 트리가 모두 비었을 경우 true
        if (t1.root == null && t2.root == null) {
            return true;
        }

        // 하나의 트리만 비어있을 경우 false
        if (t1.root == null || t2.root == null) {
            return false;
        }

        // 현재 노드의 값이 다른 경우 false
        if (t1.root.data != t2.root.data) {
            return false;
        }

        // 왼쪽 서브트리와 오른쪽 서브트리를 비교
        // 재귀함수
//        return subTreeCheck(t1.root.left, t2.root.left) &&
//                subTreeCheck(t1.root.right, t2.root.right);

//        // 재귀함수
        boolean leftSub = isSameTree(new SimpleTree(t1.root.left), new SimpleTree(t2.root.left));
        boolean rightSub = isSameTree(new SimpleTree(t1.root.right), new SimpleTree(t2.root.right));

        return leftSub && rightSub;
    }

    public static void main(String[] args) {
        Node<String> node1 = new Node<>("A"); // 루트노드
        Node<String> node2 = new Node<>("B");
        Node<String> node3 = new Node<>("C");
        Node<String> node4 = new Node<>("B");
        Node<String> node5 = new Node<>("C");
        Node<String> node6 = new Node<>("A"); // 루트노드

        SimpleTree tree1 = new SimpleTree();
        tree1.root = node1;
        tree1.root.left = node2;
        tree1.root.right = node3;

        SimpleTree tree2 = new SimpleTree();
        tree2.root = node6;
        tree2.root.left = node4;
        tree2.root.right = node5;

        System.out.println(isSameTree(tree1, tree2));
    }
}
