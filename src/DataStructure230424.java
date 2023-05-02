import java.util.LinkedList;

class Menu0424 {
    String name;
    int price;

    // 생성자
    Menu0424 () {} // 기본생성자

    Menu0424 (String name, int price) { // 인자 2개를 받는 생성자
        this.name = name;
        this.price = price;
    }
}

public class DataStructure230424 {
    public static void main(String[] args) {
        // menu의 리스트를 만들어보자 ( != 맛집 리스트)
//        LinkedList menu_pan = new LinkedList(); // object를 담을 수 있는 링크드 리스트 생성
        MyLinkedList<Menu0424> menu_pan = new MyLinkedList<>(); // Menu0424를 담을 수 있는 링크드 리스트

        // 기본 생성자일때는 각각을 따로 집어넣어야해서 귀찮음
        Menu0424 m1 = new Menu0424();
        m1.name = "후라이드";
        m1.price = 17000;

        // 인자 2개를 받는 생성자를 사용하여 메뉴를 만들다
        Menu0424 m2 = new Menu0424("양념치킨", 18000);
        Menu0424 m3 = new Menu0424("간장치킨", 18000);
        Menu0424 m4 = new Menu0424("땡초치킨", 18000);

        // 메뉴들을 메뉴판에 넣어주려면 -> add 메서드 사용
        menu_pan.add(m1);
        menu_pan.add(m2);
        menu_pan.add(m3);
        menu_pan.add(1, m4); // 1번자리에 넣고싶다

        menu_pan.remove(0); // 후라이드 삭제
        menu_pan.remove(2); // 후라이드 없는상태에서 2번째 인덱스, 즉 3번째 요소인 땡초치킨을 삭제

        // 메뉴판의 모든 것들을 출력하려면 -> for문
        for (int i = 0; i < menu_pan.size(); i++) {
            Menu0424 temp = menu_pan.get(i);
            System.out.println(temp.name + " : " + temp.price + "원");
        }

        // 맛집 리스트
        MyLinkedList<JMT> matzipList = new MyLinkedList<>();

        JMT matzip1 = new JMT();
        matzip1.addMenu("자장면", 6000);
        matzip1.addMenu("짬뽕", 7000);

        JMT matzip2 = new JMT();
        matzip2.addMenu("삼겹살", 11000);
        matzip2.addMenu("돼지갈비", 12000);

        JMT matzip3 = new JMT();
        matzip3.addMenu("한정식 상차림", 35000);

        matzipList.add(matzip1);
        matzipList.add(matzip2);
        matzipList.add(matzip3);

        for (int i = 0; i < matzipList.size(); i++) {
            matzipList.get(i).showMenu(); // 맛집리스트의 i번째 가게에서 showMenu 메서드를 사용
        }
    }
}


