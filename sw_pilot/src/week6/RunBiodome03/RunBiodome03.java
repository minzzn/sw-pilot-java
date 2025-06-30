package week6.RunBiodome03;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunBiodome03 {
    public static void main(String[] args) throws IOException {
        boolean run = true;

        System.out.println("과일 상점에 오신 것을 환영합니다!");
        FruitStore fruitStore = new FruitStore();

        System.out.println("1. 과일 판매하기");
        System.out.println("2. 과일 재고 추가하기");
        System.out.println("3. 모든 과일 재고 조회하기");
        System.out.println("4. 종료하기");

        while (run) {
            System.out.print("메뉴를 선택하세요: ");
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            int inputNumber = Integer.parseInt(input.readLine());
            switch (inputNumber) {
                case 1:
                    System.out.print("판매할 과일의 이름을 입력하세요: ");
                    BufferedReader inputFruitname = new BufferedReader(new InputStreamReader(System.in));
                    String fruitName = inputFruitname.readLine();
                    System.out.println();
                    System.out.print("판매할 수량을 입력하세요: ");
                    BufferedReader inputSell = new BufferedReader(new InputStreamReader(System.in));
                    int sellQuantity = Integer.parseInt(inputSell.readLine());
                    System.out.println();
                    fruitStore.sellFruit(fruitName, sellQuantity);
                    break;

                case 2:
                    System.out.print("재고를 추가할 과일의 이름을 입력하세요: ");
                    BufferedReader inputFruitname2 = new BufferedReader(new InputStreamReader(System.in));
                    String fruitName2 = inputFruitname2.readLine();
                    System.out.println();
                    System.out.print("추가할 수량을 입력하세요: ");
                    BufferedReader inputAdd = new BufferedReader(new InputStreamReader(System.in));
                    int addQuantity = Integer.parseInt(inputAdd.readLine());
                    System.out.println();
                    fruitStore.addStock(fruitName2, addQuantity);
                    break;
                case 3:
                    fruitStore.readStock();
                    break;
                case 4:
                    fruitStore.saveData();
                    run = false;
                    System.out.println("모든 데이터가 저장되었습니다. 과일 상점 관리 시스템을 종료합니다!");
                    break;
            }
        }
    }
}