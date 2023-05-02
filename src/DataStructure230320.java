import java.util.Arrays;

public class DataStructure230320 {
    public static void main(String[] args) {
//        // 배열
//        int[] question2 = {10, 20, 30, 50, 3, 60, -3, 10};
//        int sum = 0;
//        double avg = 0;
//
//        // 배열의 원소 모두 더하기
//        for (int i = 0; i < question2.length; i++) {
//            sum += question2[i];
////            sum = sum + question2[i];
//        }
//        // 평균 구하기
//        avg = (double)sum / question2.length;
//        // 소수점이 나와야 하므로 우변의 값중 하나인 sum을 double 형태로 casting 했다
//        System.out.printf("배열의 합 : %d, 평균 : %f\n", sum, avg);

//        // swap
////        int a= 111;
////        int b = 999;
////        int temp;
////
////        temp = a;
////        a = b;
////        b = temp;
////        System.out.printf("a는 %d, b는 %d가 되었다", a, b);
//
//        int[] q4 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int x = 4;
//        int y = 5;
//
//        int temp;
//        temp = q4[x];
//        q4[x] = q4[y];
//        q4[y] = temp;
//        System.out.printf("q4[x] = %d, q4[y] = %d\n", q4[x], q4[y]);
//        System.out.println("q4 주소 " + q4);
//        System.out.println(Arrays.toString(q4));
//        // swap을 이용해서 배열의 최대값, 최소값 구하라
//
//        int[] q5 = {100, 99, 234, -423, 11, 23, -7890 ,123, 234};
//        // 최대값 최소값
//        int max = q5[0];
//        int min = q5[0];
//        // 최대값의 인덱스, 최소값의 인덱스
//        int argmax = 0;
//        int argmin = 0;
//
//        for (int i = 0; i < q5.length; i++) {
//            if (q5[i] > max) {
//                max = q5[i];
//                argmax = i;
//            }
//            if (q5[i] < min) {
//                min = q5[i];
//                argmin = i;
//            }
//        }
//        System.out.printf("최대값 : %d, 최소값 : %d\n", max, min);
//        System.out.printf("최대값 인덱스 : %d, 최소값 인덱스 : %d\n", argmax, argmin);

        // Char 배열
        char[] alphabet = new char[26];
        for (int i = 0; i < alphabet.length; i++) {
            alphabet[i] = (char)('A'+i);
            //'A' = 65이므로 이렇게 적어도 된다. 하지만 헷갈리니까 패스
//            alphabet[i] = char(65 + i);
        }
        System.out.println(Arrays.toString(alphabet)); // 전체 배열 출력

        // 알파벳을 배열에 역순으로 넣어서 출력해보자
        char[] alphabet_reverse = new char[26];
        for (int i = 0; i < alphabet.length; i++) {
            alphabet_reverse[i] = (char)('Z'-i);
        }
        System.out.println(Arrays.toString(alphabet_reverse));

        // 혹은 기존의 알파벳 배열을 역순으로 출력해보자
        System.out.printf("[");
        for (int i = alphabet.length-1; i >= 0; i-- ){
            if (i != 0) {
                System.out.printf("%c, ", alphabet[i]);
            }
            else {
                System.out.printf("%c", alphabet[i]);
            }
        }
        System.out.printf("]\n");
    }
}
