import java.util.Arrays;

// Quick Sort 퀵정렬 구현
public class QuickSort {
    static void quickSort(int[] a, int begin, int end) {
        if (begin >= end) {
            return; // begin이 end와 같으면 끝낸다. begin이 더 큰 경우는 오류. 예외처리하는 것
        }

        // partitioning 파티셔닝 -> pivot 피봇의 위치 결정
        int pivot = partition(a, begin, end);

        // 피봇의 위치를 기준으로 좌/우를 퀵소트
        quickSort(a, begin, pivot-1);
        quickSort(a, pivot+1, end);

    }

    // 배열 a에서 x와 y의 위치를 바꿈
    static void swap (int [] a, int x, int y) {
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }

    // 파티션 함수 : 피봇의 위치를 결정하여 인덱스를 리턴
    static int partition(int[] a, int begin, int end) {
        int pivot = (begin + end) / 2; // 시작 위치는 가운데
        int L = begin; // 좌->우. 자신보다 크거나 같은 값을 만날 때 까지 이동
        int R = end; // 우->좌. 자신보다 작은 값을 만날 때 까지 이동

        // 피봇과 비교해서 자리를 바꾸면서, L과 R이 만날때까지 돈다. 같아지면 멈춘다
        while (L < R) { // 즉, L이 R을 넘어서면 안되므로 이렇게 조건을 줌
            while ((a[L] < a[pivot]) && (L < R)) {
                L++; // 뒤로 간다
            }
            while ((a[R] >= a[pivot]) && (L < R)) {
                R--; // 앞으로 간다
            }

            // L, R이 만났으면 스왑 swap
            swap(a, L, R);
        }

        // 만났으면 피봇의 위치랑 R이랑 바꾼다.
        // 그리고 R이 있던 자리가 피봇의 자리로 확정된다
        swap(a, pivot, R);
//        System.out.println("피봇은 " + pivot);
        System.out.println(Arrays.toString(a));

        return R; // R이 있던 자리가 피봇이 됨
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();

        int [] data = {69, 10, 30, 2, 16, 8, 31, 22};
        quickSort(data, 0, data.length-1);
    }
}
