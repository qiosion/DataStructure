import java.util.Arrays;

public class Sort {
    // 최소값을 찾는 메서드
    static int findMin (int[] array) {
        int minValue = array[array.length-1];

        // 최소값을 찾는 for문
        for (int value : array) { // array 에 들어있는 값을 value로 줌
            if (value < minValue) {
                minValue = value;
            }
        }

        return minValue;
    }

    // 최소값을 찾아 그 인덱스를 반환하는 메서드
    static int argmin (int[] array, int start) {
        int minValue = array[start];
        int minIndex = start;

        for (int i = start; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    // 최대값을 찾는 메서드
    static int findMax (int[] array) {
        int maxValue = -1;

        // 최대값을 찾는 for문
        for (int value : array) {
            if (value > maxValue) maxValue = value;
        }
        return maxValue;
    }

    // 최대값을 찾아 그 인덱스를 반환하는 메서드
    static int argmax (int[] array, int start) {
        int maxValue = array[start];
        int maxIndex = start;

        for (int i = start; i < array.length; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    // swap 메서드
    static void swap (int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    // 선택정렬 selection sort 메서드 + 오름차순 / 내림차순
    static void select_sort (int[] array, boolean isAscend) {
        int selected_idx = 0;

        for (int i = 0; i < array.length; i++) {
            if (isAscend) { // 오름차순 // isAscend == true
                selected_idx = argmin(array, i);
            } else { // 내림차순 // isAscend == false
                selected_idx = argmax(array, i);
            }
            swap(array, selected_idx, i); // swap
        }
    }

    // 버블정렬 메서드 bubble sort
    static void bubble_sort(int[] array, boolean isAscend) {
        for (int i = array.length-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (isAscend) { // isAscend == true
                    if (array[j] > array[j+1]) {
                        swap(array, j, j+1);
                    }
                } else { // isAscend == false
                    if (array[j] < array[j+1]) {
                        swap(array, j+1, j);
                    }
                }
                System.out.println(Arrays.toString(array));
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {69, 10, 30, 2, 16, 8, 31, 22};
        // 선택정렬 확인
//        System.out.println(Arrays.toString(array));
//        select_sort(array, false);
//        System.out.println(Arrays.toString(array));

        // 버블정렬 확인
        bubble_sort(array, true);
        bubble_sort(array, false);
    }
}
