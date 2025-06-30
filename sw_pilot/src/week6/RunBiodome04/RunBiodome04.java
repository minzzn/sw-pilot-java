package week6.RunBiodome04;


import week6.RunBiodome03.FruitStore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunBiodome04 {
    public static void main(String[] args) throws IOException {
        boolean run = true;
        System.out.println("과일 상점에 오신 것을 환영합니다!");
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
                    System.out.println();
                    System.out.print("판매할 수량을 입력하세요: ");
                    System.out.println();
                case 2:
                    System.out.print("재고를 추가할 과일의 이름을 입력하세요: ");
                    System.out.println();
                    System.out.print("추가할 수량을 입력하세요: ");
                    System.out.println();
                    System.out.println(" 재고가 " + "개 추가되었습니다!");
                case 3:

                case 4:
                    System.out.println("모든 데이터가 저장되었습니다. 과일 상점 관리 시스템을 종료합니다!");
                    run = false;
                    break;
            }
        }
    }
}