package week2;

import java.util.Arrays;
import java.text.DecimalFormat;

public class RoadToBiodome04 {
    public static int[] selection_sort(int[] arr) {
        selection_sort(arr, arr.length);
        return arr;
    }
    private static void selection_sort(int [] arr, int size) {
        for (int i = 0; i < size -1; i++){
            int min_index = i;
            for(int j = i+1 ; j < size ; j++){
                if(arr[j] < arr[min_index]){
                    min_index = j;
                }
            }
            swap(arr, min_index, i);
        }
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    // 평균값(medium) 계산
    public static double calMedium(int[] arr, int size) {
        double medium = 0;
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum = sum + arr[i];
        }
        medium = (double) sum / size;

        return medium;
    }
    // 중앙값(median) 계산
    public static double calMedian(int[] arr, int size){
        double median = 0;
        if( size % 2 == 0){
            median = (double) (arr[size/2-1] + arr[size/2]) / 2;
        }
        else{
            median = arr[size/2];
        }
        return median;
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            try {
                for (String arg : args) {
                    int num = Integer.parseInt((arg));
                    if (num < 0 || num > 1000) {
                        System.out.println("입력된 값의 범위가 올바르지 않습니다. 0에서 1000까지의 값을 입력해주세요.");
                        System.exit(0);
                    }
                }

                /* int[] arr = new int[args.length];
                for(int i=0; i<args.length; i++){
                    arr[i] = Integer.parseInt(args[i]);
                } 아래 코드와 같은 의미이다 */

                // 문자열 배열을 정수 배열로 변환
                int[] arr = Arrays.stream(args)
                        .mapToInt(Integer::parseInt)
                        .toArray();

                // 선택 정렬
                int[] sorted_arr = selection_sort(arr);
                System.out.println(Arrays.toString(sorted_arr));

                DecimalFormat df = new DecimalFormat("#.##");
                System.out.print("평균값:" + df.format(calMedium(sorted_arr, sorted_arr.length)));
                System.out.print(", 중앙값:" + df.format(calMedian(sorted_arr, sorted_arr.length)));

            } catch (NumberFormatException e) {
                System.out.println("입력된 값이 올바르지 않습니다. 정수를 입력해주세요.");
            }
        } else {
            System.out.println("입력된 값이 올바르지 않습니다. 정수를 입력해주세요.");
        }
    }
}