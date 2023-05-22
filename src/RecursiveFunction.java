//  Recursive Function 재귀함수

public class RecursiveFunction {

    // 팩토리얼 N! = N * (N-1)!
    static int factorial(int n) {
        if (n == 0) return 1;

        return n * factorial(n - 1);
    }

    // 더하기
    static int sum(int n) {
        if (n == 0) return 0;

        return n + sum(n - 1);
    }

    static void hello(int n) {
        if (n == 0)  return; // 종료조건

        hello(n-1);
        System.out.println("Hello, world!" + n);
    }

    public static void main(String[] args) {
//        hello(5);
//        System.out.println(sum(5));

        System.out.println(factorial(5));

    }
}
