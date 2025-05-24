package week3.BiodomeFamily04;

public class EnergySource {
    private final String sourceName;
    private int energyAmount;

    public EnergySource(String sourceName, int energyAmount){
        this.sourceName =  sourceName;
        this.energyAmount = energyAmount;
    }

    public String getSourceName() {
        return sourceName;
    }

    public int getEnergyAmount() {
        return energyAmount;
    }

    public void setEnergyAmount(int energyAmount) {
        this.energyAmount = energyAmount;
    }

    public void useEnergy(int amount) {
        this.energyAmount =  energyAmount - amount;
        System.out.println(getSourceName() + " 에너지를 " + amount + " 사용했습니다.");
    }

    public void produceEnergy(int amount) {
        int sum = energyAmount + amount;
        setEnergyAmount(sum);
        System.out.println(getSourceName() + " 에너지를 " + amount + " 생산했습니다.");
    }
}
