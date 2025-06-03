package week3.BiodomeFamily05;

import week3.BiodomeFamily04.EnergySource;

import java.util.ArrayList;
import java.util.List;

public class Sorcerer{
    private String socererName;

    List<AcientArtifact> acientArtifactList;

    public Sorcerer(String name) {
        this.socererName = name;
        this.acientArtifactList = new ArrayList<>();
        System.out.println( "마법사 '" + name + "'이 생성되었습니다.");
    }

    public String getSocererName() {
        return socererName;
    }
    public void ownAcientArtifact(AcientArtifact acientArtifact){
        acientArtifactList.add(acientArtifact);
        System.out.println( "마법사 '" + getSocererName() + "'이 " + acientArtifact.getName() + "을 소유하게 되었습니다.");
    }

    public void printAbility(AcientArtifact acientArtifact) {
        System.out.println("마법사 '" + getSocererName() + "'이 " + acientArtifact.getName() + "의 능력을 확인합니다.");
        System.out.println();
        acientArtifact.describe();
        System.out.println();
    }

    public void useAcientArtifact(AcientArtifact acientArtifact) {
        System.out.println("마법사 '" + getSocererName() + "'이 " + acientArtifact.getName() + "의 에너지 생성 능력을 사용합니다.");
        for (AcientArtifact source : acientArtifactList) {
            if (acientArtifact.getName() == "태양의 돌" && source instanceof SolarStone) {
                ((SolarStone) source).generateEnergy();
            } else if (acientArtifact.getName() == "바람의 부적" && source instanceof WindAmulet) {
                ((WindAmulet) source).controlWeather();
            } else if (acientArtifact.getName() == "물의 거울" && source instanceof WaterMirror) {
                ((WaterMirror) source).generateEnergy();
                ((WaterMirror) source).controlWeather();
            }
        }

    }
}
