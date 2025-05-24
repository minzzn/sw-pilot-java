package week3.BiodomeFamily03;

public class BiodomeFamily03 {
    public static void main(String[] args) {
        LifeNest lifeNest = new LifeNest();

        Animal penguin = new Animal("펭귄","동물","남극", "육식","물고기");
        Animal koala = new Animal("코알라","동물","호주", "초식", "유칼립투스");
        Plant cactus = new Plant("선인장","식물","사막", "11", true);
        Plant peppermint = new Plant("페퍼민트","식물","정원", "7", false);

        lifeNest.addOrganism(penguin);
        lifeNest.addOrganism(koala);
        lifeNest.addOrganism(cactus);
        lifeNest.addOrganism(peppermint);

        lifeNest.printOrganismList();

        lifeNest.removeOrganism(koala);
        lifeNest.removeOrganism(cactus);

        lifeNest.printOrganismList();
    }
}