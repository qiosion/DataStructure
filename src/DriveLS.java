public class DriveLS {
    public static void main(String[] args) {

        LinkedStack<String> stack = new LinkedStack<>();
        System.out.println("isEmpty : " + stack.isEmpty()); // true

        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");
        stack.push("6"); // 링크드 스택은 크기가 정해져 있지 않으므로 Stack 이 Full이 될 일이 없다
        System.out.println("isEmpty : " + stack.isEmpty()); // false
        System.out.println("사이즈 : " + stack.size()); // 6

        System.out.println(stack.pop()); // 맨 마지막 (6) 반환 후 삭제
        System.out.println(stack.pop()); // 맨 마지막 (5) 반환 후 삭제
        System.out.println("사이즈 : " + stack.size()); // 4
        System.out.println(stack.peek()); // 맨 마지막 (4) 반환
        System.out.println(stack.peek()); // 맨 마지막 (4) 반환
        System.out.println("사이즈 : " + stack.size()); // 4

        stack.delete(); // 맨 마지막 (4) 삭제
        stack.delete(); // 맨 마지막 (3) 삭제
        stack.delete(); // 맨 마지막 (2) 삭제
        System.out.println("사이즈 : " + stack.size()); // 1
        System.out.println(stack.pop()); // 맨 마지막 (1) 반환 후 삭제
        System.out.println(stack.isEmpty()); // true
    }
}
