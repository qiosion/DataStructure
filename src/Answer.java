public class Answer {
    int [] solution1 (String[] shirt_size) {
        int len = shirt_size.length;
        System.out.println("입력 배열의 길이는 " + len + "입니다.");

        int [] result = new int[6];

        //치수 "XS", "S", "M", "L", "XL", "XXL"
        for (int i = 0; i < len; i++) {

            if (shirt_size[i].equals("XS")) {
                result[0]++;
            }
            else if (shirt_size[i].equals("S")) {
                result[1]++;
            }
            else if (shirt_size[i].equals("M")) {
                result[2]++;
            }
            else if (shirt_size[i].equals("L")) {
                result[3]++;
            }
            else if (shirt_size[i].equals("XL")) {
                result[4]++;
            }
            else if (shirt_size[i].equals("XXL")) {
                result[5]++;
            } else {
                System.out.println("잘못된 입력값");
            }

        }
        return result;
    } // sol 1

    int [] solution2 (int[] original) {
        int len = original.length;
        System.out.println("입력 배열의 길이는 " + len + "입니다.");

        int [] result = new int [len];

        for (int i = 0; i < len; i++) {
            result[i] = original[len - i - 1];
        }
        return result;
    } // sol 2

    int solution3 (int n) {
        System.out.println(n + "항 까지의 합을 구합니다.");

        int result = 0;
//        int test = 2;
//        for (int i = 0; i < n; i++ ){
//            test = 2 + (4 * i);
//            result += test;
////            System.out.println(i + " * 4 = " + test + " => " + result);
//        }

        // 등차수열 4n - 2 이용.. 근데 0부터 시작해서 계산에 +2 해줌
        for (int i = 0; i < n; i++) {
            result += (4 * i) + 2;
        }
        return result;
    } // sol 3

    int solution4 (int[] original) {
        int len = original.length;
        System.out.println("입력 배열의 길이는 " + len + "입니다.");

        int result = 0;

        int max = 1; // 가장 작은 값
        int min = len; // 가장 큰 값

        for (int i = 0; i < len; i++) {
            int count = 0; // count 는 i가 걸려있는 for 루프 안에서 유효함
            // for 루프 밖에 count가 있으면 안에서도 또 0으로 초기화해줘야함
            // i==j 의 갯수를 새는거니까! 시작도 전에 누적되면 안되니까 !

            for (int j = 0; j < len; j++){
                if(original[i] == original[j]) {
                    count++;
                }
            }

            if (count > max) {
                max = count;
            }
            if (count < min) {
                min = count;
            }

        }
        System.out.println("가장 많이 등장하는 수는 " + max);
        System.out.println("가장 적게 등장하는 수는 " + min);
        result = max / min;
        return result;
    } // sol 4

    /* int solution4 (int[] original) { // count 배열버전
        int len = original.length;
        System.out.println("입력 배열의 길이는 " + len + "입니다.");

        int result = 0;

        int [] cnt = new int[len];

        for (int i = 0; i < len; i++) {
//            int count = 0;

            for (int j = 0; j < len; j++) {
                if (original[i] == original[j]) {
                    cnt[i]++;
                }
            }
        }
        int min = cnt[0]; // 가장 큰 값
        int max = cnt[0]; // 가장 작은 값

        for (int i = 0; i<cnt.length; i++) {
            if (cnt[i] > max) {
                max = cnt[i];
            }
            if (cnt[i] < min) {
                min = cnt[i];
            }

        }
        System.out.println("가장 많이 등장하는 수는 " + max);
        System.out.println("가장 적게 등장하는 수는 " + min);
        result = max / min;
        return result;
    } // sol 4*/
}
