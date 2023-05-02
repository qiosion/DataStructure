public class DriveAS {
    public static void main(String[] args) {

        ArrayStack<String> stack = new ArrayStack<>(5);
        System.out.println("isEmpty : " + stack.isEmpty()); // true
        System.out.println("isFull : " + stack.isFull()); // false
        stack.push("구");
        System.out.println("isEmpty : " + stack.isEmpty()); // false
        stack.push("보");
        stack.push("람");
        System.out.println("스택 사이즈 : " + stack.size()); // 3
        stack.push("김");
        stack.push("나");
        stack.push("은"); // 예외처리 -> Stack is Full
        System.out.println(stack.peek()); // 맨 마지막 (나) 반환
        stack.pop(); // 맨 마지막 (나) 삭제
        stack.pop(); // 맨 마지막 (김) 삭제
        System.out.println(stack.pop()); // 맨 마지막 (람) 반환 후 삭제
        System.out.println(stack.peek()); // 맨 마지막 (보) 반환
        stack.push("집어넣기");
        System.out.println(stack.peek()); // 집어넣기
        stack.delete(); // 맨 마지막 (집어넣기) 삭제
        System.out.println(stack.peek()); // 보
    }
}


