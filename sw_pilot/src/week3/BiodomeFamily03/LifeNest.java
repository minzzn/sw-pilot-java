package week3.BiodomeFamily03;

import java.util.ArrayList;
import java.util.List;

public class LifeNest {

    List<Organism> organismList;

    public LifeNest() {
        this.organismList =  new ArrayList<>();
    }

    public void addOrganism(Organism organism) {
        organismList.add(organism);
        System.out.println("[LifeNest] "+organism.getName()+"이 추가되었습니다.");
    }
    public void removeOrganism(Organism organism) {
        organismList.remove(organism);
        System.out.println("[LifeNest] "+organism.getName()+"이 삭제되었습니다.");
    }
    public void changeHabitat(Organism organism, String habitat) {
        organism.setHabitat(habitat);
        System.out.println("[LifeNest] "+ organism.getName() +" 서식지가 변경되었습니다.");
    }
    public void printOrganismList() {
        System.out.println();
        System.out.println("전체 동식물 목록 출력:");
        for (int i = 0; i < organismList.size(); i++) {
            Organism organism = organismList.get(i);
            System.out.print((i + 1) + ". ");
            organism.displayInfo();
        }
        System.out.println();
    }
}
