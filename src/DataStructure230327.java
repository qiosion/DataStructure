import java.util.Arrays;

public class DataStructure230327 {
    public static void main(String[] args) {
//        // 이중배열
//        int row = 2, col = 3;
//        int [][] arr_2 = new int[row][col];
//
//        arr_2[0][0] = 11; // 각 인덱스에 접근하여 assign
//        arr_2[0][1] = 12;
//        arr_2[0][2] = 13;
//
//        System.out.println(Arrays.toString(arr_2[0]));
//        // 0번째 행만 출력
//        System.out.println(Arrays.toString(arr_2[1])); // 초기값 없으면 0
//
//        System.out.println("arr_2의 길이 : " + arr_2.length + " : 행의 길이"); // arr_2의 길이(행)는 2
//
//        for (int i = 0; i < row; i++) { // 행을 기준으로 함
//            for (int j = 0; j < col; j++) { // 열
//                System.out.printf("[%d]", arr_2[i][j]);
//            }
//            System.out.println(""); // 엔터
//        }

//        // 구구단
//        for (int i = 2; i < 10; i++) {
//            System.out.println(">>> " + i + "단");
//
//            for (int j = 1; j < 10; j++) {
//                System.out.printf("%d * %d = %d\n", i, j, i*j);
//            }
//        }

//        // 구구단 계산결과를 배열에 저장하기
//        int [][] gugudan = new int[10][10]; // 0단 ~ 9단
////        gugudan[i][j] = i * j ;
//        for (int i = 0; i < gugudan.length; i ++) {
//            System.out.println(">>> " + i + "단");
//            for (int j = 0; j < gugudan[0].length; j++) {
//                gugudan[i][j] = i * j;
//                System.out.printf("%d * %d = %d\n", i, j, gugudan[i][j]);
//            }
////            System.out.println(Arrays.toString(gugudan[i]));
//        }

//        // 열거타입
//        enum Week {
//            MON, TUE, WED, THU, FRI, SAT, SUN
//        }
//        Week today = Week.MON;
//
//        if (today == Week.MON) { // enum을 썼으면 Integer 처럼 쓸수있어서 "" 안써줘도 됨
////            System.out.printf("MON의 값은 %s 입니다.", Week.valueOf("MON"));
//            System.out.println("피곤해요.. 😴");
//        } else if (today == Week.TUE) {
//            System.out.println("화가 나요 !!! 🤬🤬");
//        } else if (today == Week.WED) {
//            System.out.println("밥이 맛있어요 ❤");
//        } else if (today == Week.THU) {
//            System.out.println("하..");
//        } else if (today == Week.FRI) {
//            System.out.println("하루만 버티자~~");
//        } else {
//            System.out.println("휴일입니다 ");
//        }

//        // switch - case 문 : if - else 문을 깔끔히 작성가능
//        switch (today) {
//            case MON:
////                System.out.println("피곤해요.. 😴");
////                break;
//            case TUE:
////                System.out.println("화가 나요 !!! 🤬🤬");
////                break;
//            case WED:
////            System.out.println("밥이 맛있어요 ❤");
////                break;
//            case THU:
////                System.out.println("하..");
////                break;
//            case FRI:
//                System.out.println("평일이 실허요..😢");
//                break;
//            default:
//                System.out.println("휴일입니다");
//                break;
//        }

        // 함수 function
        DataStructure230327 obj = new DataStructure230327();

//        func1(); // 이때 func1 함수는 static 이어야함
        obj.func1(); // DS230327 클래스의 함수 func1이 호출되었습니다

        // 다른 클래스의 함수에 접근하려면?
        // 새로운 클래스 객체를 만들어야한다
        Test230327 test = new Test230327();
        test.func1();

        func2(); // DS230327 클래스의 함수 func2입니다
        System.out.println(func2());
        // DS230327 클래스의 함수 func2입니다
        // 9999

        int a = func3(9, 1);
        System.out.println("func3의 결과값 a = " + a);
        // func3의 결과값 a = 10

        String x = obj.func_hello();
        System.out.println(x);

        System.out.println(obj.add(3, 6));
        // 아규먼트엔 상수와 변수 모두 들어갈수 있다
    }
    String func_hello() {
        return "Hello, world!";
    }

    int add (int a, int b) {
        return a + b;
    }

    // 인자값이 있는 함수
    static int func3(int a, int b) {
        return a + b;
    }
    
    // 리턴값이 있는 함수
    static int func2() {
        System.out.println("DS230327 클래스의 함수 func2입니다");
        return 9999;
    }

    // 리턴값이 없는 함수 -> void
    void func1() {
        System.out.println("DS230327 클래스의 함수 func1이 호출되었습니다");
    }
}
