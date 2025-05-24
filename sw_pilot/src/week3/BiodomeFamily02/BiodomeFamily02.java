package week3.BiodomeFamily02;

public class BiodomeFamily02 {
    public static void main(String[] args) {
        LifeNest lifeNest = new LifeNest();

        Organism penguin = new Organism("펭귄","동물","남극");
        Organism koala = new Organism("코알라","동물","호주");
        Organism cactus = new Organism("선인장","식물","사막");
        Organism peppermint = new Organism("페퍼민트","식물","정원");

        lifeNest.addOrganism(penguin);
        lifeNest.addOrganism(koala);
        lifeNest.addOrganism(cactus);
        lifeNest.addOrganism(peppermint);

        lifeNest.printOrganismList();
        System.out.println();

        lifeNest.deleteOrganism(koala);
        lifeNest.deleteOrganism(cactus);

//        penguin.setHabitat("해변"); // 궁금한 점
        lifeNest.changeHabitat(penguin,"해변");

        lifeNest.printOrganismList();
    }
}