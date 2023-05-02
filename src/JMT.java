import java.util.LinkedList;

public class JMT {
    private class Menu { // 메뉴 클래스를 이 JMT 클래스 내에서만 사용가능 (private)
        String name;
        int price;

        Menu(String name, int price) {
            this.name = name;
            this.price = price;
        }
    }

    // member 변수
    String name; // 가게이름
    int star; // 별점
    String address; // 주소
    private MyLinkedList<Menu> menus = new MyLinkedList<>(); // Menu 클래스를 타입으로 리스트로 묶은 것

    // 메뉴 추가할 수 있는 함수 (인터페이스)
    void addMenu (String name, int price) {
        Menu menu = new Menu(name, price);
        menus.add(menu); // menus 리스트에 이것들을 추가해라
    }

    // 맛집 JMT의 메뉴를 출력해주는 함수
    void showMenu() {
        // menus에 가지고있는 모든 메뉴를 보여줌
        for (int i = 0; i < menus.size(); i++) { // Menu
            Menu tmp = menus.get(i); // i번째 메뉴를 담아서 임시 메뉴에 담아서
            System.out.println(tmp.name + " : " + tmp.price + "원"); // 메뉴 이름과 가격을 출력
        }
    }
}
