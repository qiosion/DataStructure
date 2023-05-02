import java.util.ArrayList;

public class DataStructure230420 {
    public static void main(String[] args) {
        JMT matzip1 = new JMT();

        matzip1.name = "도란도란";
        matzip1.address = "한국폴리텍";
        matzip1.star = 5;

//        Menu m1 = new Menu("짜장면", 6000);
//        matzip1.menus.add(m1);

        matzip1.addMenu("짜장면", 6000);
        matzip1.addMenu("짬뽕", 7000);
        matzip1.addMenu("볶음밥", 7000);

        matzip1.showMenu();

        MyLinkedList<JMT> matzipList = new MyLinkedList<>();

        System.out.println(matzipList.size()); // 0

        JMT matzip2 = new JMT();
        matzip2.addMenu("test", 10);

        matzipList.add(matzip1);
        System.out.println(matzipList.size()); // 1

        matzipList.add(matzip2);

        JMT  temp = matzipList.get(0); // 맛집리스트의 첫번째, 즉 도란도란을 가져옴
        temp.showMenu(); // 그 도란도란의 메뉴를 보여줘
    }
}