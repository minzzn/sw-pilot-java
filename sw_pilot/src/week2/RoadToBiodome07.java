package week2;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RoadToBiodome07 {

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

    public static Map<String, Integer> calFrequency(String[] arr){
        Map<String, Integer> frequency = new HashMap<>();

        /* 단어 빈도수 체크하기 */
        /* 단어 빈도수 체크하기 */
        for(String word : arr) { // 향상된 for 루프 사용
            // Map에 이미 단어가 있다면 빈도수를 가져와 1 증가시켜 다시 put
            // Map의 compute 메소드를 사용하는 것이 더 간결하고 효율적일 수 있습니다 (Java 8+)
            // frequency.compute(word, (key, count) -> (count == null) ? 1 : count + 1);

            // 기존 로직 유지
            if(frequency.containsKey(word)) {
                frequency.put(word, frequency.get(word) + 1);
            }
            // Map에 단어가 없다면 새로 추가하고 빈도수를 1로 초기화
            else {
                frequency.put(word, 1);
            }
        }
        return frequency;
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            try {
                String[] result = new String[args.length];
                // 1. 단어 빈도수 계산
                Map<String, Integer> frequencyMap = calFrequency(args);

                // 2. 빈도수 정보를 담은 객체(Map.Entry)들의 List 생성
                // Map의 entrySet()을 가져와서 ArrayList로 변환합니다.
                List<Map.Entry<String, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());

                // 3. 정렬 기준 정의 (Comparator 구현)
                // 빈도수 내림차순 -> 빈도수 같으면 문자열 오름차순
                Comparator<Map.Entry<String, Integer>> frequencyComparator = new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                        // 빈도수 비교 (내림차순): entry2의 빈도수와 entry1의 빈도수를 비교
                        // entry2.getValue().compareTo(entry1.getValue()) 결과가
                        //  - 양수이면 entry2의 빈도수가 더 큼 -> entry2가 앞으로 와야 함 -> 순서 바꿀 필요 없음 (결과 양수)
                        //  - 음수이면 entry1의 빈도수가 더 큼 -> entry1이 앞으로 와야 함 -> 순서 바꿔야 함 (결과 음수)
                        //  - 0이면 빈도수가 같음
                        int frequencyComparison = entry2.getValue().compareTo(entry1.getValue());

                        if (frequencyComparison == 0) {
                            // 빈도수가 같을 경우: 문자열 자체를 가나다순 (오름차순)으로 비교
                            // entry1.getKey().compareTo(entry2.getKey()) 결과가
                            //  - 음수이면 entry1이 사전 순으로 빠름 -> entry1이 앞으로 와야 함 -> 순서 바꿔야 함 (결과 음수)
                            //  - 양수이면 entry2가 사전 순으로 빠름 -> entry2가 앞으로 와야 함 -> 순서 바꿀 필요 없음 (결과 양수)
                            //  - 0이면 두 문자열이 같음
                            return entry1.getKey().compareTo(entry2.getKey());
                        } else {
                            // 빈도수가 다르면 빈도수 비교 결과 반환 (내림차순 정렬에 맞게)
                            return frequencyComparison;
                        }
                    }
                };

                // 4. List 정렬 (Comparator 사용)
                // Collections.sort 메서드는 인자로 받은 List와 Comparator를 사용하여 정렬합니다.
                // 이 메서드는 객체 정렬 시 효율적인 정렬 알고리즘(일반적으로 TimSort)을 사용하며,
                // 이 알고리즘은 Comparator를 통해 두 객체를 비교합니다.
                Collections.sort(entryList, frequencyComparator);

                // 5. 정렬 결과 출력
                System.out.println("단어 빈도수 (빈도수 내림차순, 단어 가나다순):");
                for (Map.Entry<String, Integer> entry : entryList) {
                    System.out.println(entry.getKey() + " (" + entry.getValue() + "회)");
                }



            } catch (NumberFormatException e) {
                System.out.println("입력된 값이 올바르지 않습니다. 정수를 입력해주세요.");
            }
        } else {
            System.out.println("입력된 값이 올바르지 않습니다. 2개의 정수 배열을 입력해주세요.");
        }
    }
}