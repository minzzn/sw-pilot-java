package week3.BiodomeFamily03;

public class Plant extends Organism {
    private String flowering;
    private boolean fruit;

    public Plant(String name, String species, String habitat, String flowering, boolean fruit) {
        super(name, species, habitat);
        this.flowering = flowering;
        this.fruit = fruit;
    }

    @Override
    public void displayInfo() {
        String isFruit = (fruit) ? "있음" : "없음";
        System.out.println(getName() + ", " + getSpecies() + ", " + getHabitat() + ", " + flowering + "월, 열매 " + isFruit);
    }
}
