public class DriveArrayQueue {
    public static void main(String[] args) {
        ArrayQueue<String> q = new ArrayQueue<>();

        if (q.isEmpty()) {
            System.out.println("큐가 비어있습니다");
        }

        q.push("가");
        q.push("나");
        q.push("다");
        q.push("라");
        q.push("마"); // Queue is Full. 여기서부터 못들어감. 큐 배열 사이즈가 5라도 front를 비워두니까 !

        System.out.println(q.peek()); // 가
        System.out.println(q.pop()); // 가
        System.out.println(q.pop()); // 나
        System.out.println(q.pop()); // 다
        q.delete(); // 라가 반환되진 않았지만 삭제됨
        System.out.println(q.pop()); // Queue is Empty. null
    }
}
