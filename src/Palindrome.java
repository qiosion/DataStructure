// 회문 Palindrome
public class Palindrome {
    static boolean isPalindrome(String s) {
        // s의 길이가 짝수일때 0, 홀수일때 1이면 끝. 여기까지 왔으면 참으로 판단
        if (s.length() <= 1) return true;

        System.out.println(s);

        // 맨 앞과 맨 뒤가 같으면, 둘을 잘라내고 재귀 호출
        if (s.charAt(0) == s.charAt(s.length()-1)) {
            return isPalindrome(s.substring(1, s.length()-1));
        }
        // 맨 앞과 맨 뒤가 다르면 실패 false
        else {
            return false;
        }
    }

    public static void main(String[] args) {
/*
        // substring : 잘라내기
        String s = "Hello, world";
        // 문자열.substring(인덱스 이상, 미만)
        System.out.println(s.substring(0, s.length()-1));
*/
//        System.out.println("Hello 은 회문인가? " + isPalindrome("Hello"));
//        System.out.println("level 은 회문인가? " + isPalindrome("level"));
        System.out.println("소주만병만주소 은 회문인가? " + isPalindrome("소주만병만주소"));
    }
}
