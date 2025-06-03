package week3.BiodomeFamily05;

public class WaterMirror extends AcientArtifact implements EnergyGenerator, WeatherController{
    public WaterMirror(String name) {
        super(name);
    }

    @Override
    public void describe() {
        System.out.println("\""+ getName() + "로 에너지 생성 중! 습도에 따라 에너지의 양이 달라집니다.\"");
    }

    @Override
    public void generateEnergy() {
        System.out.println(getName() + "을 이용해 수증기로 에너지를 생성했습니다!");
    }

    @Override
    public void controlWeather() {
        System.out.println(getName() + "을 이용해 날씨를 조절합니다! 비나 눈을 내립니다.");
    }
}
