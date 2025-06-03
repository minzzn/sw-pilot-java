package week3.BiodomeFamily05;

public class BiodomeFamily05 {
    public static void main(String[] args) {
        Sorcerer sorcerer = new Sorcerer("아리엘");
        SolarStone solarStone = new SolarStone("태양의 돌");
        WindAmulet windAmulet = new WindAmulet("바람의 부적");
        WaterMirror waterMirror = new WaterMirror("물의 거울");
        System.out.println();

        sorcerer.ownAcientArtifact(solarStone);
        sorcerer.ownAcientArtifact(windAmulet);
        sorcerer.ownAcientArtifact(waterMirror);
        System.out.println();

        sorcerer.printAbility(solarStone);

        sorcerer.useAcientArtifact(waterMirror);

    }
}