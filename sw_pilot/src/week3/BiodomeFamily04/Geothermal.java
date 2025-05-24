package week3.BiodomeFamily04;

public class Geothermal extends  EnergySource{
    public Geothermal(String sourceName, int energyAmount) {
        super(sourceName, energyAmount);
    }
    @Override
    public void produceEnergy(int amount) {
        int sum = getEnergyAmount() + ( amount * 5 + 20 );
        setEnergyAmount(sum);
        System.out.println(getSourceName() + " 에너지를 " + ( amount * 5 + 20 ) + " 생산했습니다.");
    }
}
