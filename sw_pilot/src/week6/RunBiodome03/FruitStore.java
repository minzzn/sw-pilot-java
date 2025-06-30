package week6.RunBiodome03;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class FruitStore {
    HashMap<String, Integer> fruitStock;
    HashMap<String, String> fruitSold;
    private static final String FILE_PATH = "./6-3-fruit_data.csv";

    public FruitStore() {
            fruitStock = new HashMap<String, Integer>();
            fruitSold = new HashMap<String, String>();
            this.readData();
    }

    public void sellFruit(String fruitName, int quantity) { // 1. 과일 판매하기(update)
            Integer value = fruitStock.get(fruitName);
            if (value != null) {
                if( value >= quantity ){
                    value = value - quantity;
                    fruitStock.put(fruitName, value);
                    System.out.println(fruitName + " " + quantity + "개가 판매되었습니다!");
                }
                else {
                    System.out.println("판매하려는 수량이 현재 남아있는 재고보다 많습니다.");
                }
            }
            else {
                System.out.println("기존에 존재하지 않는 과일 품목입니다.");
            }
    }

    public void addStock(String fruitName, int quantity) { // 2. 과일 재고 추가하기(update)
        Integer value = fruitStock.get(fruitName);
        if (value != null) {
            value = value + quantity;
            fruitStock.put(fruitName, value);
            System.out.println(fruitName + " 재고가 " + quantity + "개 추가되었습니다!");
        } else {
            System.out.println("기존에 존재하지 않는 과일 품목입니다.");
        }
    }

    public void readStock() { // 3. 모든 과일 재고 조회하기(read)
        System.out.println("모든 과일 재고 조회: ");
        for (Map.Entry<String, Integer> entry : fruitStock.entrySet()) {
            System.out.println(entry.getKey()+ "-" + entry.getValue() + "개");
        }
    }

    public void readData() { // 파일에서 데이터를 읽어오는 메서드
        try (Stream<String> lines = Files.lines(Paths.get(FILE_PATH))) {
            lines.skip(1)
                    .forEach(line -> {
                        String[] data = line.split(",");
                        if (data.length == 3) { // 과일명,재고량,최근 판매 정보 -> 최소 3개 컬럼 필요
                            try {
                                fruitStock.put(data[0].trim(), Integer.valueOf(data[1].trim()));
                                fruitSold.put(data[0].trim(), data[2].trim());
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

    public void saveData() { // 파일에 데이터를 저장하는 메서드
        String header = "FruitName,StockQuantity,SoldInfo";

        // 2. fruitStock 맵의 엔트리들을 스트림으로 변환하고, 각 엔트리를 CSV 라인으로 매핑
        String dataLines = fruitStock.entrySet().stream()
                .map(entry -> {
                    String fruitName = entry.getKey();
                    Integer stockQuantity = entry.getValue();
                    String soldInfo = fruitSold.getOrDefault(fruitName, ""); // fruitSold에 없으면 빈 문자열 반환

                    // CSV 형식의 한 줄 문자열 생성
                    return String.join(",", fruitName, String.valueOf(stockQuantity), soldInfo);
                })
                .collect(Collectors.joining(System.lineSeparator())); // 모든 라인을 줄바꿈으로 연결

        // 3. 헤더와 데이터 라인들을 최종 문자열로 결합
        String finalContent = header + System.lineSeparator() + dataLines;

        // 4. 파일에 저장
        try {
            Path path = Paths.get(FILE_PATH); // (7) 파일 경로 객체 생성
            Files.write(path, finalContent.getBytes()); // (8) 파일에 바이트 배열로 쓰기
            System.out.println("데이터가 " + FILE_PATH + "에 성공적으로 저장되었습니다.");
        } catch (IOException e) { // (9) 파일 쓰기 중 발생할 수 있는 예외 처리
            System.err.println("파일 저장 중 오류가 발생했습니다: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
