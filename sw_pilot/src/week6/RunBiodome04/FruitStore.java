package week6.RunBiodome04;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class FruitStore {
    Map<String, Integer> fruitStock;
    Map<String, Map<String, Integer>> fruitSold;
    private static final String FILE_PATH = "./6-4-fruit_data_total.csv";

    public FruitStore() {
        fruitStock = new HashMap<String, Integer>();
        fruitSold = new HashMap<String, Map<String, Integer>>();
        this.readData();
    }

    public void readStock() { // 1. 모든 과일 재고 조회하기(read)
        System.out.println("모든 과일의 재고량: ");
        for (Map.Entry<String, Integer> entry : fruitStock.entrySet()) {
            System.out.println(entry.getKey()+ "-" + entry.getValue() + "개");
        }
    }

    public void soldMax() { // 2. 최대 판매 과일 조회 메서드(read)
        Map<String, Integer> totalSoldPer = fruitSold.entrySet().stream()
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                entry -> entry.getValue().values().stream()
                                        .mapToInt(Integer::intValue)
                                        .sum()
                        ));
        Optional<Map.Entry<String, Integer>> maxSold = totalSoldPer.entrySet().stream()
                    .max(Map.Entry.comparingByValue());
        if (maxSold.isPresent()) {
            System.out.println("가장 많이 팔린 과일: " + maxSold.get().getKey()+ " - 총 " + maxSold.get().getValue() + "개 판매됨");
        } else {
            //
        }
    }

    public void soldStock() { // 3. 판매된 모든 과일 수 조회 메서드
        int totalSold = fruitSold.values().stream()
                    .mapToInt(stringIntegerMap -> stringIntegerMap.values().stream()
                            .mapToInt(Integer::intValue)
                            .sum())
                    .sum();
        System.out.println("판매된 모든 과일: 총" + totalSold + "개 판매됨");
    }

    public void soldAvg() { // 4. 과일별 평균 판매 개수 조회 메서드
        Map<String,Double> avgSold = fruitSold.entrySet().stream()
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                entry ->  {
                                    OptionalDouble average = entry.getValue().values().stream()
                                            .mapToInt(Integer::intValue)
                                            .average();
                                    return average.orElse(0.0);
                                }
                        ));
        System.out.println("과일별 평균 판매 개수: ");
        if (avgSold.isEmpty()){
            System.out.println("판매된 과일 데이터가 없습니다.");
        }
        avgSold.forEach((fruitName, avg) -> {
            System.out.println( fruitName + " - 평균" + String.format("%.2f", avg) + "개");
        });
    }
    public void readData() { // 파일에서 데이터를 읽어오는 메서드
        try (Stream<String> lines = Files.lines(Paths.get(FILE_PATH))) {
            lines.skip(1)
                    .forEach(line -> {
                        String[] data = line.split(","); // "," 를 기준으로 문자열을 분리하기 위한 작업
                        if (data.length >= 2) { // 과일명,재고량,최근 판매 정보 -> 최소 3개 컬럼 필요
                            try {
                                fruitStock.put(data[0].trim(), Integer.valueOf(data[1].trim()));
                                Map<String, Integer> soldData = new HashMap<>();
                                if (data.length > 2) {
                                    soldData = Arrays.stream(data, 2, data.length)
                                            .map(String::trim)
                                            .map(saleRecord -> saleRecord.split(":"))
                                            .filter(saleParts -> saleParts.length == 2)
                                            .collect(Collectors.toMap(saleParts -> saleParts[0].trim(),
                                                    saleParts -> {
                                                                try{
                                                                    return Integer.parseInt(saleParts[1].trim());
                                                                } catch (NumberFormatException e) {
                                                                    return 0;
                                                                }
                                                            }
                                            ));
                                }
                                fruitSold.put(data[0], soldData);

                            } catch (NumberFormatException e) {
                                // 숫자로 변환할 수 없는 값이 있을 경우
                                System.err.println("경고: '" + line + "' 라인의 재고량(두 번째 컬럼)이 유효한 숫자가 아닙니다. 이 라인은 건너뜁니다. 오류: " + e.getMessage());
                            }
                        } else {
                            // 컬럼 개수가 부족할 경우
                            System.err.println("경고: '" + line + "' 라인이 유효한 형식이 아닙니다 (컬럼 부족). 이 라인은 건너뜁니다.");
                        }
                    });

    } catch (IOException e) {
            System.err.println("파일을 읽는 도중 오류가 발생했습니다: " + e.getMessage());
            // throw new RuntimeException(e); // 예외를 던지는 대신 오류 메시지를 출력하고 프로그램이 계속되도록 할 수 있습니다.
        } catch (NumberFormatException e) {
            System.err.println("파일 데이터 형식 오류: 숫자로 변환할 수 없는 값이 있습니다. " + e.getMessage());
        }
    }
}
