package week3.BiodomeFamily04;

import java.util.ArrayList;
import java.util.List;

public class EnergyManager {
    List<EnergySource> energySourceList;

    public EnergyManager() {
        this.energySourceList = new ArrayList<>();
    }
    public void addEnergySource(EnergySource source) {
        energySourceList.add(source);
    }
    public void sumAllEnergy() {
        int nowEnergyAmount = 0;
        for (int i = 0; i < energySourceList.size(); i++) {
            EnergySource energySource = energySourceList.get(i);
            nowEnergyAmount = nowEnergyAmount + energySource.getEnergyAmount();
        }
        System.out.println();
        System.out.println("남은 에너지: " + nowEnergyAmount);
        System.out.println();
    }
}
