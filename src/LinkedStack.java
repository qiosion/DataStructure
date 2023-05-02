public class LinkedStack<T> {
    private class Node {
        T data;
        Node next;

        // 생성자
        Node (T data) {
            this.data = data;
            this.next = null;
        }
    } // end of class Node

    private Node top;
    private int size; // 강의자료엔 없음

    // 생성자
    LinkedStack() {
        top = null;
        size = 0;
    }

    // isEmpty 메서드
    boolean isEmpty() {
        if (top == null) return true;
        else return false;
    }

    // push 메서드
    void push(T item) {
        Node pushNode = new Node(item);
        pushNode.next = top; // 새로만든 것의 next가 top 이어야 함 ..... 진짜 이핵 ㅏ안된다...
        top = pushNode; // top은 방금 들어온 애가 됨.
        size++; // 링크드 리스트는 사이즈가 없음
    }

    // pop 메서드
    T pop() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return null;
        }
        // 왜 바로 return 해주면 안되냐? 링크를 바꿔줘야 하기 때문 !
        T returnValue = top.data;
        top = top.next; // top의 next가 오히려 이전값이 되는거네.. 넘 헷갈린다
        size--;

        return returnValue;
    }

    int size() {
        return this.size;
    }

    // peek 메서드
    T peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return null;
        }
        return top.data;
    }

    // delete 메서드
    void delete() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
        }
        else {
            top = top.next;
            size--;
        }
    }
} // end of class LinkedStack
