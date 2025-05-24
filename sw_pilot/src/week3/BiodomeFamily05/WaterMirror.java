package week3.BiodomeFamily05;

public class WaterMirror extends AcientArtifact{
    public WaterMirror(String name) {
        super(name);
    }

    @Override
    public void describe() {
        System.out.println(getName() + " : 수증기를 모아 에너지를 생성하고, 날씨를 조절함(예. 습도에 영향을 받으며, 비와 눈을 내림)");
    }
}
