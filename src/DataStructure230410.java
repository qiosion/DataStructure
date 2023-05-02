import java.util.ArrayList;

// 성별
enum Gender0410 { MALE, FEMALE };

// 부모 : 사람
class Person0410 {
    String name;
    int age;
    Gender0410 gender;
} // end of Person

// Person을 상속하는 클래스
class Employee0410 extends Person0410 {
    int salary;

    // 생성자 : 리턴타입 X. 함수 이름이 클래스명과 같다
    // Alt + Insert -> Constructor : 되긴 하는데 부모클래스꺼 상속은 자동으로 안되네
    Employee0410(String name, int age, Gender0410 gender, int salary) {
        this.name = name; // 이 클래스 this의 멤버변수 name 에 로컬변수인 name 값을 넣어준다
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }

    void doWork() {
        System.out.println(name + "은/는 일을 합니다");
    }
} // end of Employee

class Boss0410 extends Person0410 {
    // Boss 클래스 외부에서는 Employee의 리스트를 건드릴 수 없음
    private ArrayList<Employee0410> employee0410s = new ArrayList<>(); // 보스가 가진 직원의 리스트

    // 직원 고용
    void hire(Employee0410 e) {
        employee0410s.add(e);
    }

    // 보스의 일 : 직원들이 일하게 시키는 것
    void doWork() { // 보스의 do Work 와 직원들의 do Work 메서드는 서로 연관X 그냥 이름만 같다
        for (Employee0410 e : employee0410s) { // 리스트 에 있는 모든 요소에 대한 반복 (배열 안됨!)
            // employee0410s 리스트에 있는 타입 Employee0410에 대해 라는 뜻!
            e.doWork(); // Employee 리스트에 있는 모든 녀석들아 일을 해라
        }
        // 원래 쓰던 대로 for문을 쓰자면 이렇다
        for (int i = 0; i < employee0410s.size(); i++) { // 모든 리스트는 size라는 메서드를 가짐. 따라서 배열의 length가 X
            // Employee0410 temp = employee0410s.get(i); // employee0410s 리스트에서 i번째 원소를 get. 리턴타입은 Employee0410이 됨
            // temp.doWork(); // temp로 접근할 수 있음. 근데 보통은 변수로 안두고 바로 쓰면
            employee0410s.get(i).doWork();
        }
    }
} // end of Boss

// Employee를 상속하는 클래스
class Prof0410 extends Employee0410 {
    // 생성자 없으면 에러
    Prof0410(String name, int age, Gender0410 gender, int salary) {
        super(name, age, gender, salary); // 부모클래스 상속
    }

    // method overriding 메서드 오버라이딩 : 상속 받은 메서드의 내용만 변경 하는 것 : 재정의
    void doWork() {
        System.out.println("교수 " + name + "은/는 가르칩니다.");
    }
} // end of professor

class Student0410 extends Employee0410 {
    Student0410(String name, int age, Gender0410 gender, int salary) {
        super(name, age, gender, salary); // 부모클래스 상속
    }
    
    // method overriding 메서드 오버라이딩 : 상속 받은 메서드의 내용만 변경 하는 것 : 재정의
    void doWork() {
        System.out.println("학생 " + name + "은/는 공부합니다");
    }
} // end of student

public class DataStructure230410 {
    public static void main(String[] args) {
        // int 타입의 리스트를 만들겠다
        ArrayList<Integer> aList = new ArrayList<Integer>();

        Boss0410 b = new Boss0410();
        Employee0410 e = new Employee0410("홍길동", 200, Gender0410.MALE, 500);
//        b.employee0410s.add(e); // private이라 add 메서드를 통해서 접근 불가능하다
        // Boss 클래스 안의 hire 메서드를 이용해야 함
        b.hire(e); // 고용

        Prof0410 p = new Prof0410("강현우", 45, Gender0410.MALE, 100);
        // 교수를 Employee로 넘겼으니, 교수가 가진 고유속성(학위, ..) 들은 사라짐 -> 추상화
        b.hire(p); // 고용

        Student0410 s = new Student0410("김권아", 23, Gender0410.FEMALE, 80);
        b.hire(s); // 고용

        b.doWork(); // 일시킴

        MyArrayList<Employee0410> myList = new MyArrayList(); // 클래스가 존재한다면, 내용물이 없더라도 가능
        myList.add(p);
        myList.add(p);
        myList.add(p);
        myList.add(p); // 4개째에서 에러나는걸 예외처리

        System.out.println(myList.length());

        for (int i = 0; i < myList.length(); i++ ) {

        }
    }
}
