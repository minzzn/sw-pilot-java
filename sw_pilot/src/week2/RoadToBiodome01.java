package week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RoadToBiodome01 {
    public static void main(String[] args){
        if (args.length > 0) {
            try {
                for(String arg : args){
                    int num = Integer.parseInt((arg));
                    if(num < 0 || num > 1000) {
                        System.out.println("입력된 값의 범위가 올바르지 않습니다. 0에서 1000까지의 값을 입력해주세요.");
                        System.exit(0);
                    }
                }

                List<String> input = new ArrayList<>(Arrays.asList(args));
                ArrayList<String> result = new ArrayList<>();
                for(String item : args){
                    if(!result.contains(item))
                        result.add(item);
                }
                // 기존 배열에서 중복 제거한 배열 빼기 - removeAll을 사용할 경우 중복되는 요소까지 싹다 삭제하므로.... 빈배열됨 주의
                // [5, 9, 16, 16, 5, 11, 5, 5, 9, 16, 16, 9, 9] - [5, 9, 16, 11]
                //  = [16, 5, 5, 5, 9, 16, 16, 9, 9]
                for (String itemToRemove : result) {
                    input.remove(itemToRemove);
                }
                // [5, 9, 16, 11] - [16, 5, 5, 5, 9, 16, 16, 9, 9]
                // = [11]
                result.removeAll(input);
                // result.removeAll(input); 메서드 실행 결과 자체는 배열에 변화가 있었는지를 boolean값으로 출력하므로 메서드 실행 후 배열인 result을 출력해야함 주의
                System.out.println(result);


            }
            catch (NumberFormatException e){
                System.out.println("입력된 값이 올바르지 않습니다. 0에서 1000까지의 값을 입력해주세요.");
            }
        }
        else {
            System.out.println("입력된 값이 올바르지 않습니다. 0에서 1000까지의 값을 입력해주세요.");
        }
    }
}