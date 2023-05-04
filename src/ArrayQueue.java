public class ArrayQueue <T> {
    // 멤버 변수
    private int front; // 맨 앞
    private int rear; // 맨 뒤
    private int queueSize; // array로 할 거라서 사이즈가 필요함
    private T[] queue; // T타입의 배열

    // 생성자
    ArrayQueue () {
        front = 0;
        rear = 0;
        queueSize = 5;
        // Object를 T타입으로 만들기 위해 캐스팅 해줌
        queue = (T[]) new Object[queueSize];
    }

    // isEmpty 메서드 : queue가 비어있는지 여부
    boolean isEmpty() {
        return (front == rear); // (front == rear) 는 조건식. 그 비교값이 true인지 false 인지의 결과값을 리턴하라는 뜻
//        if (front == rear) {
//            return true;
//        } else {
//            return false;
//        }
    }

    // isFull 메서드
    boolean isFull() {
        return (((rear + 1) % queueSize) == front);
//        if (((rear + 1) % queueSize) == front) {
//            return true;
//        } else {
//            return false;
//        }
    }

    void push(T item) {
        if (isFull()) {
            System.out.println("Queue is Full");
        } else {
            rear = (rear + 1) % queueSize;
            queue[rear] = item; // 추가한 데이터를 큐의 rear에 넣는다
        }
    }

    T pop() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return null;
        } else {
            front = (front + 1) % queueSize;
            return queue[front]; // 이건 삭제는 X
            // 확실하게 삭제하는건 아래 방법이지만 굳이 안이래도 된다. 인덱스가 안보이면 사용할 일이 없다
//            T reternVal = queue[front];
//            return reternVal;
        }
    }

    T peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return null;
        } else {
            return queue[(front + 1) % queueSize];
        }
    }

    void delete() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
        } else {
            front = (front + 1) % queueSize;
        }
    }
}
