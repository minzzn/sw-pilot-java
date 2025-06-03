package week3.BiodomeFamily05;

public class WindAmulet extends AcientArtifact implements WeatherController{
    public WindAmulet(String name) {
        super(name);
    }

    @Override
    public void describe() {
        System.out.println("\""+ getName() + "로 에너지 생성 중! 주변 공기의 흐름에 따라 에너지의 양이 달라집니다.\"");
    }

    @Override
    public void controlWeather() {
        System.out.println(getName() + "을 이용해 날씨를 조절합니다! 저기압, 고기압, 강풍 등을 일으킵니다.");
    }
}
