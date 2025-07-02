package week6.RunBiodome04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunBiodome04 {
    public static void main(String[] args) throws IOException {
        boolean run = true;

        System.out.println("과일 상점에 오신 것을 환영합니다!");
        FruitStore fruitStore = new FruitStore();

        System.out.println("1. 모든 과일 재고 조회하기");
        System.out.println("2. 가장 많이 팔린 과일 조회하기");
        System.out.println("3. 총 판매 과일 수 조회하기");
        System.out.println("4. 과일별 평균 판매 개수 조회하기");
        System.out.println("5. 종료하기");

        while (run) {
            System.out.print("메뉴를 선택하세요: ");
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            int inputNumber = Integer.parseInt(input.readLine());
            switch (inputNumber) {
                case 1:
                    fruitStore.readStock();
                    System.out.println();
                    break;
                case 2:
                    fruitStore.soldMax();
                    System.out.println();
                    break;
                case 3:
                    fruitStore.soldStock();
                    System.out.println();
                    break;
                case 4:
                    fruitStore.soldAvg();
                    System.out.println();
                    break;
                case 5:
                    run = false;
                    System.out.println("과일 상점 관리 시스템을 종료합니다!");
                    break;
                default:
                    System.out.println("존재하지 않는 메뉴입니다. 1번에서 5번을 선택해주세요.");
            }
        }
    }
}