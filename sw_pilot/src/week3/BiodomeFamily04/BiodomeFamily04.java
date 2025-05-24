package week3.BiodomeFamily04;

public class BiodomeFamily04 {
    public static void main(String[] args) {
        EnergyManager energyManager =  new EnergyManager();

        SolarPower solarPower =  new SolarPower("태양광", 0);
        WindForce windForce = new WindForce("풍력", 0);
        Geothermal geothermal = new Geothermal("지열", 0);

        energyManager.addEnergySource(solarPower);
        energyManager.addEnergySource(windForce);
        energyManager.addEnergySource(geothermal);
        System.out.println();

        solarPower.produceEnergy(5);
        windForce.produceEnergy(12);
        geothermal.produceEnergy(4);
        System.out.println();

        solarPower.useEnergy(30);
        windForce.useEnergy(30);
        geothermal.useEnergy(30);

        energyManager.sumAllEnergy();
    }
}