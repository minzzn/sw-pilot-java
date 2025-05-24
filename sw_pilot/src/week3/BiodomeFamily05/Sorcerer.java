package week3.BiodomeFamily05;

import java.util.ArrayList;
import java.util.List;

public class Sorcerer{
    private String socererName;

    List<AcientArtifact> acientArtifactList;

    public Sorcerer(String name) {
        this.socererName = name;
        this.acientArtifactList = new ArrayList<>();
    }

//    public void addAcientArtifact(AcientArtifact acientArtifact) {
//        acientArtifactList.add(acientArtifact);
//        System.out.println(acientArtifact.getName() + " 유물이 생성되었습니다.");
//    }

    public String getSocererName() {
        return socererName;
    }
    public void ownAcientArtifact(AcientArtifact acientArtifact){
        acientArtifactList.add(acientArtifact);
        System.out.println( "마법사 '" + getSocererName() + "'이 " + acientArtifact + "을 소유하게 되었습니다.");
    }

    public void printAbility(AcientArtifact acientArtifact) {
        acientArtifact.describe();
    }

    public void useAcientArtifact() {

    }
}
