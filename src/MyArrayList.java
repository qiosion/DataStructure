public class MyArrayList<T> { // public : 다른 파일에서 사용 가능
    // <T>, <E> :
    // 어떤 타입이 들어올지 모르겠으나 일단 뭐가 들어오긴 할거니까, 어떠한 타입 Tyle 의 Element 라는 의미로 넣어줌

    // 멤버 변수
    // 1. 자료를 저장할 배열 array
    // 2. 현재 자료의 개수
    private int size;
    private T[] array;
    private int MAX_SIZE;

    // 생성자. 디폴트 값이 public 이지만 여기선 명시적으로 써주겠다
    public MyArrayList() {
        size = 0;
        MAX_SIZE = 3; // 배열의 크기
        array = (T[])new Object[MAX_SIZE];
        // 자바의 모든 객체는 Object를 상속받음. 따라서 Object 배열은 모든 것을 담을 수 있다
        // 그것을 T타입으로 사용하고 싶어서 T로 형변환(캐스팅 casting) 해준 것
    }

    // 메서드 오버로드 overload, 오버로딩 overloading
    // index번째에 요소 삽입하는 add 메서드
    void add(int index, T element) {
        // 예외처리
        // 인덱스 : 마이너스 X. size 보다 크면 안됨
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        // element shift
        for (int i = size-1; i > index; i--) {  // 뒤에서부터 시작해서 index번째까지 for문 돌아야함
            array[i] = array[i-1]; // 하나씩 뒤로 밀었음
        }

        array[index] = element; // 해당 인덱스 자리에 새로운 요소를 삽입
    }

    // 리스트의 크기를 알려주는 메서드 -> 단, 그 값을 외부에서 바꿀 순 없음
    int length() {
        return size;
    }

    // 리스트에 요소 더하기 : add
    void add (T element) { // T타입의 객체를 하나 받을것
        // 배열의 크기 넘어가는 순간 뻥! 하고 터짐(메모리가 터짐?)
        if (size >= MAX_SIZE) {
            // 1. 시스템에 의한 out of bound exception
//            System.out.println("리스트가 가득 차 더이상 넣을 수 없다");
//            return; // void 타입이라 그냥 빠져나와야함

            // 2 내가 out of bound exception
            throw new IndexOutOfBoundsException();
        }
        array[size] = element; // 사이즈가 0에서 시작. 거기에 element를 하나 넣음
        size++; // 그리고나서 사이즈를 1 증가시킴
    }

}
