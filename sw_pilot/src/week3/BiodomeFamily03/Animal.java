package week3.BiodomeFamily03;

public class Animal extends Organism {
    private String degestion;
    private String feed;

    public Animal(String name, String species, String habitat, String degestion, String feed) {
        super(name, species, habitat);
        this.degestion =  degestion;
        this.feed =  feed;
    }

    @Override
    public void displayInfo() {
        System.out.println(this.getName() + ", " + getSpecies() + ", " + getHabitat() + ", " + degestion + ", " + feed);
    }

}
