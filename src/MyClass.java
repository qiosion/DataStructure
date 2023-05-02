public class MyClass {
    public static void main(String[] args) {
        Answer ans = new Answer();

        // 1번
        String[] param1 = {"XL", "XXL", "S", "XS"};
        int[] result_1 = ans.solution1(param1);

        System.out.print("[");
        for (int i = 0; i < result_1.length; i++) {
            System.out.print(result_1[i] + ", ");
        }
        System.out.println("]");

        // 2번
        int [] param2 = {1, 4, 2, 3, -9999};
        int [] result_2 = ans.solution2(param2);

        System.out.print("[");
        for (int i = 0; i < result_2.length; i++) {
            System.out.print(result_2[i] + ", ");
        }
        System.out.println("]");

        // 3번
        int param3 = 5;
        int result_3 = ans.solution3(param3);

        System.out.println(param3 + "항 까지의 합은 " + result_3 + "입니다.");

        // 4번
//        int[] param4 = {1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2};
        int[] param4 = {1,2,3,3,1,3,3,2,3,2}; // 1 2개 2 3개 3 5개
        int result_4 = ans.solution4(param4);

        System.out.println("가장 작은 원소와 가장 큰 원소는 " + result_4 + "배 차이 입니다.");
    }
}
