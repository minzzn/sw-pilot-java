package week3.BiodomeFamily05;

public class WindAmulet extends AcientArtifact{
    public WindAmulet(String name) {
        super(name);
    }

    @Override
    public void describe() {
        System.out.println(getName() + " : 주변 공기의 흐름을 이용해 날씨를 조절함(예. 저기압, 고기압, 강풍 등)");
    }
}
