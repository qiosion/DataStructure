public class DataStructure230313 {
    public static void main(String[] args) {
//        // 실습 1
//        int score = 95;
//        String grade = "";
//        if (score < 60)
//        {
//            grade = "F";
//        }
//        else if (score < 70)
//        {
//            grade = "D";
//        }
//        else if (score < 80)
//        {
//            grade = "C";
//        }
//        else if (score < 90)
//        {
//            grade = "B";
//        }
//        else
//        {
//            grade = "A";
//        }
//        System.out.println("학점은 " + grade + "입니다");

//        // BMI 지수
//        float BMI = 29.9f;
//        if (BMI < 18.5) {
//            if (BMI < 16) {
//                System.out.println("깡마름");
//            } else {
//                if (BMI < 17) {
//                    System.out.println("마름");
//                } else {
//                    System.out.println("저체중");
//                }
//            }
//        } else {
//            if (BMI < 25) {
//                System.out.println("보통 체중");
//            } else {
//                if (BMI < 30) {
//                    System.out.println("비만 위험군");
//                } else {
//                    System.out.println("비만");
//                }
//            }
//        }
        // 구구단
        int[] multiTable = new int[9];
        for (int i = 2; i <= multiTable.length; i++) {
            multiTable[i] = i;
            System.out.println(">>> " + i + "단");
//            System.out.println(multiplicationTable[i]);
            for (int j = 1; j <= multiTable.length; j++){
//                System.out.println("j : " + j);
                System.out.println(i + " * " + j + " = " + multiTable[i] * j);
            }
        }
    }
}