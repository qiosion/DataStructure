import java.util.LinkedList;

public class MyTree<T> {
    private class Node {
        T data;
        Node left;
        Node right;

        // Node 의 생성자
        Node (T data) { // 데이터가 없는 노드는 노드가 아니다
            this.data = data;
            left = null;
            right = null;
        }
    }

    // 트리의 필수 구성요소
    private Node root; // 루트노드
    private int n_node; // number of node 즉 크기 size

    // MyTree의 생성자
    MyTree() {
        root = null;
        n_node = 0;
    }

    // insert 메서드 구현
    void insert (T data) {
        // T라는 데이터를 바로 만들어 줄 수 없음. Node 안에 넣어주는 형태로 구현해야 함
        Node insertNode = new Node(data);

        // root 가 없을 경우 (비었을 경우)
        if (root == null) { // MyTree 기본생성자는 root=null, n_node=0 이다
            root = insertNode;
        }

        // 트리가 포화상태일 경우. 즉, n_node = 2^n -1
        else if ((n_node & (n_node + 1)) == 0) { // 괄호 주의
            System.out.println("=== 포화상태 Full Binary Tree ===");
            // 왼쪽으로 내려가서, 자식이 없는 노드를 만나면 거기에 달아준다
            Node curNode = root; // 루트노드에서 시작
            while (curNode.left != null) { // 현재 노드의 left가 null이 아닌동안 계속해서 내려간다
                curNode = curNode.left; // 현재노드의 왼쪽노드를 새로운 현재노드로 바꿔준다
            }
            curNode.left = insertNode;
        }

        // 일반적인 경우
        else {
            // 큐 q 를 하나 만들어서 루트를 넣고 시작함
            LinkedList<Node> q = new LinkedList<>(); // Node 를 집어넣는 큐를 만드는 것이니 <Node> 써야함
            q.add(root);

            // 큐가 빌 때까지 다음을 반복한다 (BFS)
            while (q.isEmpty() == false) { // q가 비지 않았을 경우. 즉 empty가 false일 경우
                // 루트가 있으니까 빼고 시작한다
                Node curNode = q.poll();

                // 먼저, 왼쪽 자식이 있는지 확인한다. 없으면 새 노드를 단다
                if (curNode.left == null) {
                    curNode.left = insertNode;
                    break; // while 루프를 끊어줘야한다 ! 반드시 break 해줘야함
                }
                // 오른쪽 자식도 본다
                else if (curNode.right == null) {
                    curNode.right = insertNode;
                    break;
                }
                // 왼/오 모두 자식노드가 있다면? 즉 꽉 차있는 경우엔
                // 자식 둘을 큐에 넣는다
                else {
                    q.add(curNode.left); // 반드시 왼쪽 자식부터 넣는다
                    q.add(curNode.right);
                }
            }
        }
        // 하나를 추가했으니까 노드 개수를 증가시킨다
        n_node++;
    }

    // 트리의 traversal 구현
    // 전위 순회
    void preOrder() {
        System.out.println(">>> pre-order");
        preOrder(root);// 호출
        // private void preOrder(Node startNode) 에 root 를 넣어서 돌린것
        System.out.println();
    }

    // 오버로딩 Overloading
    private void preOrder(Node startNode) {
        if (startNode != null) { // 시작 노드가 null이 아니라면
            // 루트 - 좌 - 우
            System.out.print(startNode.data.toString() + "\t");
            // 좌-우 노드 넣어줌
            preOrder(startNode.left);
            preOrder(startNode.right);
        }
    }

    // 중위 순회
    void inOrder() {
        System.out.println(">>> in-order");
        inOrder(root); // 호출
        System.out.println();
    }

    // 오버로딩
    private void inOrder(Node startNode) {
        if (startNode != null) { // 시작 노드가 null이 아니라면
            // 좌 - 루트 - 우
            preOrder(startNode.left);
            System.out.print(startNode.data.toString() + "\t");
            preOrder(startNode.right);
        }
    }

    // 후위 순회
    void postOrder() {
        System.out.println(">>> post-order");
        postOrder(root); // 호출
        System.out.println();
    }

    // 오버로딩
    private void postOrder(Node startNode) {
        if (startNode != null) { // 시작 노드가 null이 아니라면
            // 좌 - 우 - 루트
            preOrder(startNode.left);
            preOrder(startNode.right);
            System.out.print(startNode.data.toString() + "\t");
        }
    }
}
