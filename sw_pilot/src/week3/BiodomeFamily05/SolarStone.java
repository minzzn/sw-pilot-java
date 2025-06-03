package week3.BiodomeFamily05;

public class SolarStone extends AcientArtifact implements EnergyGenerator{
    public SolarStone(String name) {
        super(name);
    }

    @Override
    public void describe() {
        System.out.println("\""+ getName() + "로 에너지 생성 중! 빛을 받은 시간에 따라 에너지의 양이 달라집니다.\"");
    }

    @Override
    public void generateEnergy() {
        System.out.println(getName() + "을 이용해 빛으로 에너지를 생성했습니다!");
    }
}
