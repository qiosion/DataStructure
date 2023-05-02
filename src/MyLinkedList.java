public class MyLinkedList<T> {
    private class Node {
        T data; // 데이터를 저장하는 부분
        Node next; // 다음에 어디로 이어질지 알려주는 링크

        // 생성자
        Node (T data) {
            this.data = data;
            this.next = null;
        }
    } // end of Node

    private Node head; // 제일 첫번째 노드. 처음엔 null임. 이 head가 그 다음을 next로 가리림
    private int size; // 리스트 안에 몇 개의 원소가 들어있는지 저장

    // 생성자
    MyLinkedList() { // 연결 리스트에서는 모든 원소들이 link에 의해서 연결되므로 제일 앞의 원소를 가지고 있어야 한다
        head = null;
        size = 0;
    }

    // 원소 추가
    void add (T element) {
        // 왜 new 해줘야함? add 할 때, 데이터를 주는데 node는 없다(메모리공간에 없음)
        Node insertNode = new Node(element);

        // list가 비어있다면
        if (head == null) { // head가 비어있다면
            head = insertNode; // 제일 처음 만든 노드가 head가 됨
        } else { // 제일 마지막의 링크(next)만 널 null. 그럼 거기에 추가할 데이터를 연결해주는것이 목표
            Node tmp = head; // shallow copy. 주소만 복사됨

            while (tmp.next != null) {
                tmp = tmp.next; // next 는 노드 타입. 노드의 주소를 가짐.
            } // 지금 tmp는 맨 마지막 노드까지 왔음

            tmp.next = insertNode; // 새로운 노드를 만들어서 element의 값을 next에 담는다
        }
        size++; // 사이즈에 1 더한다
    }

    // 원소를 추가하되, index 번째에 추가하겠다 // 오버로드 overload
    void add(int index, T element) {
        Node insertNode = new Node(element);

        if (index == 0) {
            // 얘의 next가 기존의 head가 되고, 얘가 head 가 되어야함
            insertNode.next = head;
            head = insertNode;
        } else {
            // index 번째의 바로 앞까지 가야지 걔의 next에 얘가 연결될것
            // index - 1 을 찾고싶다
            Node temp = head;
            for (int i = 0; i < (index - 1); i++) {
                temp = temp.next;
            }
            insertNode.next = temp.next; // 추가하고싶은 것의 next가 index-1 찾은것의 next ?????????
            temp.next = insertNode;
        }
        size++; // 사이즈 1 추가
    }

    // 현재 리스트에 몇개가 들어있는지 알려준다
    int size() {
        return this.size;
    }

    // i번째 요소를 사용할 수 있게 해보자. 우리가 가진 데이터는 T타입이므로 리턴타입 T
    T get(int index) {
        // head 부터 next next next 해서 i번째를 찾아야함
        // index는 메뉴의 개수(size)보다 크면 안되므로 예외처리를 해줌
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    // 삭제 remove
    T remove(int index) {

        T element = get(index); // index 번째 요소를 가져옴

        if (index == 0) { // 0번을 지운다 -> head를 지운다
            head = head.next; // head값에 head.next를 넣으면 끝
        }  else {
            // index 번째를 지우기
            Node temp = head;

            // index - 1 번을 찾아간다
            for (int i = 0; i < (index - 1); i++) {
                temp = temp.next;
            }

            // 2번을 지우고싶으면 1번까지 찾아간다. 1의 next는 2였는데, 이제 2의 next인 3이 된다
            temp.next = temp.next.next;
        }

        size--;
        return element;
    }
}
