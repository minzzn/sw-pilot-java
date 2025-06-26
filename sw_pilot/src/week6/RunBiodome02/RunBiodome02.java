package week6.RunBiodome02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunBiodome02 {
    public static void main(String[] args) throws IOException {
        boolean run = true;
        System.out.println("바이오도메 에너지 관리 시스템에 오신 것을 환영합니다.");
        EnergyDistributor energyDistributor = new EnergyDistributor();

        System.out.println("1. 전체 에너지 조회하기");
        System.out.println("2. 특정 구역 에너지 할당하기");
        System.out.println("3. 구역별 에너지 조회하기");
        System.out.println("4. 종료하기");
        while(run) {
            System.out.print("메뉴를 선택하세요: ");
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            int inputNumber = Integer.parseInt(input.readLine());
            System.out.println();

            switch(inputNumber) {
                case 1:
                    energyDistributor.readTotalEnergy();
                    break;
                case 2:
                    System.out.print("할당하려는 구역 이름을 입력하세요: ");
                    BufferedReader inputArea = new BufferedReader(new InputStreamReader(System.in));
                    String area = inputArea.readLine();
                    System.out.println();
                    System.out.print("할당하려는 에너지량을 입력하세요: ");
                    BufferedReader inputEnergy = new BufferedReader(new InputStreamReader(System.in));
                    int energy = Integer.parseInt(inputArea.readLine());
                    System.out.println();
                    energyDistributor.allocateEnergy(area, energy);
                    break;
                case 3:
                    energyDistributor.readAreaEnergy();
                    break;
                case 4:
                    run = false;
                    System.out.println("→ 바이오도메 에너지 관리 시스템을 종료합니다. 감사합니다.");
                    break;
            }
        }
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    }
}