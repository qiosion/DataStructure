public class DriveTree {
    public static void main(String[] args) {
        MyTree<String> tree = new MyTree<>();

        tree.insert("-");
        tree.insert("*");
        tree.insert("/");
        tree.insert("A");
        tree.insert("B");
        tree.insert("C");
        tree.insert("D");

        tree.preOrder();
        tree.inOrder();
        tree.postOrder();

        /*
        2의 N 제곱수 판별법 : and 연산

        int a = 4; // 0100
        int b = 5; // 0101
        int c = 3; // 0011
        System.out.println(a & b); // 4
        System.out.println(a & c); // 0
        */
    }
}
