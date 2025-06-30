package week6.RunBiodome02;

import java.util.HashMap;

public class EnergyDistributor {
    HashMap<String, Integer> areaEnergy;
    int total;

    public EnergyDistributor() {
        this.total = 50000;
        areaEnergy = new HashMap<String, Integer>();
        areaEnergy.put("테라노바",0);
        areaEnergy.put("루미나베이",0);
        areaEnergy.put("플로우브릿지",0);
    }

    public void readTotalEnergy() {
        System.out.println("→ 전체 남은 에너지: " + total);
    }

    @FunctionalInterface
    interface allotEnergy {
        public abstract void allotEnergy(String a, int b);
    }

    public void allocateEnergy(String area, int energy){
        allotEnergy allocateEnergy = (a, b) -> {
            this.areaEnergy.replace(a, b);
        };
        allocateEnergy.allotEnergy(area, energy);
        this.total = this.total - energy;
        System.out.println("→ " + area + "에 " +  energy + "의 에너지가 할당되었습니다. 남은 전체 에너지: " + this.total);
    }
    public void readAreaEnergy() {
        HashMap<String, Integer> map = this.areaEnergy;
        System.out.println("→ 구역별 에너지 조회");
        map.forEach((key, value) -> {
            System.out.println( key + " - " + value );
        });
    }
}
