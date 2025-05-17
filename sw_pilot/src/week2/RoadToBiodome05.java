package week2;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RoadToBiodome05 {

    public static int[] quickSort(int[] arr) {
        quickSort(arr, 0, arr.length-1);
        return arr;
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end)
            return;
        int pivot = start;
        int low = start + 1;
        int high = end;


        while (low <= high) {
            while (low <=end && arr[low] <= arr[pivot])
                low++;
            while (high > start && arr [high] >= arr[pivot])
                high--;
            if (low > high)
                swap(arr, high, pivot);
            else
                swap(arr, low, high);
        }
        quickSort(arr, start, high-1);
        quickSort(arr, high + 1, end);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        if (args.length == 2) {
            try {

                // 문자열 배열을 정수 배열로 변환
                int[] arr1 = Stream.of(args[0].split(" ")).mapToInt(Integer::parseInt).toArray();
                int[] arr2 = Stream.of(args[1].split(" ")).mapToInt(Integer::parseInt).toArray();

                for (int i : arr1) {
                    if (i < 0 || i > 100) {
                        System.out.println("입력된 값이 범위를 벗어났습니다. 0~100 사이의 정수를 입력해주세요.");
                        System.exit(0);
                    }
                }
                for (int i : arr2) {
                    if (i < 0 || i > 100) {
                        System.out.println("입력된 값이 범위를 벗어났습니다. 0~100 사이의 정수를 입력해주세요.");
                        System.exit(0);
                    }
                }
                // 두 배열 합치기
                int[] arr = IntStream.concat(IntStream.of(arr1),
                        IntStream.of(arr2)).toArray();

                int[] sorted_arr = quickSort(arr);
                System.out.println(Arrays.toString(sorted_arr));

            } catch (NumberFormatException e) {
                System.out.println("입력된 값이 올바르지 않습니다. 정수를 입력해주세요.");
            }
        } else {
            System.out.println("입력된 값이 올바르지 않습니다. 2개의 정수 배열을 입력해주세요.");
        }
    }
}