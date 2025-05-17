package week2;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RoadToBiodome06 {
    // 평균값(medium) 계산
    public static double calMedium(int[] arr1, int[] arr2, int n, int m) {
        double medium = 0;
        int size = n+m;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + arr1[i];
        }
        for (int i = 0; i < m; i++) {
            sum = sum + arr2[i];
        }
        medium = (double) sum / size;

        return medium;
    }
    // 중앙값(median) 계산
    public static double calMedian(int[] arr1, int[] arr2, int n, int m){
        double median = 0;
        int size = n+m;
        int index = 0, index1 = 0, index2 = 0;

        int[] merge = new int[arr1.length + arr2.length];

        while (index1 < n && index2 < m) {
            if (arr1[index1] < arr2[index2]) {
                merge[index++] = arr1[index1++];
            } else {
                merge[index++] = arr2[index2++];
            }

        }
        if ( index1 == n ) {
            while (index2 < m) {
                merge[index++] = arr2[index2++];
            }
        }

        if( index2  == m) {
            while (index1 < n) {
                merge[index++] = arr1[index1++];
            }
        }

        if (merge.length % 2 == 0) {
            median = (double) (merge[merge.length / 2 - 1] + merge[merge.length / 2]) / 2.0;
        } else {
            median = (double) merge[merge.length / 2];
        }
        return median;

    }

    public static void main(String[] args) {
        if (args.length == 2) {
            try {

                // 문자열 배열을 정수 배열로 변환
                int[] arr1 = Stream.of(args[0].split(" ")).mapToInt(Integer::parseInt).toArray();
                int[] arr2 = Stream.of(args[1].split(" ")).mapToInt(Integer::parseInt).toArray();

                Arrays.sort(arr1);
                Arrays.sort(arr2);

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
                int n = arr1.length;
                int m = arr2.length;

                System.out.printf("Mean:%.1f", calMedium(arr1, arr2, n, m));
                System.out.printf(", Median:%.1f", calMedian(arr1, arr2, n, m));



            } catch (NumberFormatException e) {
                System.out.println("입력된 값이 올바르지 않습니다. 정수를 입력해주세요.");
            }
        } else {
            System.out.println("입력된 값이 올바르지 않습니다. 2개의 정수 배열을 입력해주세요.");
        }
    }
}