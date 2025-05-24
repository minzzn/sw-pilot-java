package week3.BiodomeFamily04;

public class SolarPower extends EnergySource{
    public SolarPower(String sourceName, int energyAmount) {
        super(sourceName, energyAmount);
    }
    @Override
    public void produceEnergy(int amount) {
        int sum = getEnergyAmount() + ( amount * 10 );
        setEnergyAmount(sum);
        System.out.println(getSourceName() + " 에너지를 " + ( amount * 10 ) + " 생산했습니다.");
    }
}
