public class ArrayStack<T> {
    // 멤버 변수
    private int top;
    private int size;
    private T[] stack; // T타입의 배열. 몇개인지는 모름

    // 생성자
    ArrayStack(int size) {
        top = -1; // 비었음. 공백
        this.size = size; // 전체 스택의 크기. 맥시멈 사이즈
        stack = (T[])new Object[size]; // 오브젝트 타입이 바로 T 타입이 될 수 없으므로 캐스팅해준다
    }

    // isEmpty 메서드
    boolean isEmpty() {
        if (top == -1) return true;
        else return false;
    }
    // isFull 메서드 : top이 size -1 과 같아지면 Full
    boolean isFull() {
        if (top == size -1) return true;
        else return false;
    }

    // push 메서드
    void push(T item) {
        if (isFull()) {
            System.out.println("Stack is Full");
        }
        else {
            top++; // stack이 비어있을 때 top은 -1이므로 1을 더해주고 시작해야함 ?
            stack[top] = item;
//            stack[++top] = item; 으로도 표현 가능. 단, ++의 위치가 중요하다 !!!!
        }
    }

    // pop 메서드
    T pop() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return null;
        }
        return stack[top--]; // 스택의 마지막 인덱스(top)를 -1해준다
    }

    // size
    int size() {
        return this.top +1; // top 은 인덱스니까 +1 해줌
    }

    // peek 메서드
    T peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return null;
        }
        return stack[top];
    }

    // delete 메서드
    void delete() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
        }
        else {
            stack[top--] = null;
            // 아래와 같이 쓸 수도 있음
            // stack[top] = null;
            // top--;
        }
    }
}
