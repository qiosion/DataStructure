import java.util.Arrays;

public class SelectionSort {
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

    // 정렬 sort 메서드 + 오름차순 / 내림차순
    static void select_sort (int[] array, boolean isAscend) {
        int selected_idx = 0;

        for (int i = 0; i < array.length; i++) {
            if (isAscend == true) { // 오름차순
                selected_idx = argmin(array, i);
            } else { // 내림차순
                selected_idx = argmax(array, i);
            }
            swap(array, selected_idx, i); // swap
        }
    }

    public static void main(String[] args) {
        int[] array = {69, 10, 30, 2, 16, 8, 31, 22};
        System.out.println(Arrays.toString(array));
        select_sort(array, false);
        System.out.println(Arrays.toString(array));
    }
}
