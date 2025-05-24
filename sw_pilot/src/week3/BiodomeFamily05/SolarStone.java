package week3.BiodomeFamily05;

public class SolarStone extends AcientArtifact{
    public SolarStone(String name) {
        super(name);
    }

    @Override
    public void describe() {
        System.out.println(getName() + " : 빛을 받아 에너지 생성(예. 빛을 받은 시간에 영향을 받음)");
    }
}
