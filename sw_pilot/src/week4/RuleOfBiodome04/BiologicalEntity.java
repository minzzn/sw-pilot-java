package week4.RuleOfBiodome04;

public class BiologicalEntity<T> {
    String name;
    T species;

    BiologicalEntity(String name, T species) {
        this.name = name;
        this.species = species;
    }

    public String getName() {
        return name;
    }
    public T getSpecies() {
        return species;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecies(T species) {
        this.species = species;
    }
}
