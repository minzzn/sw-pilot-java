package week3.BiodomeFamily05;

public class AcientArtifact {
    private final String name;

    public AcientArtifact(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void describe(){
        System.out.println(getName() + " : 고유 특성과 능력");
    }
}
