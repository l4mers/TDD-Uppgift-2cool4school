package tdd.uppgift.cool4school.fordon;

public class Battery {
    int batteryLife = 100;
    int batteryLifeMax = 100;
    int safetyBattery = 10;
    int safetyBatteryMax = 10;

    Bil bil;

    public Battery(Bil bil) {
        this.bil = bil;
    }

    public void batteryConsumption(int consumption){
        batteryLife -= consumption;
        if(batteryLife <= 0){
            batteryLife = 0;
            bil.getLights().forEach(Lyse::outOfBattery);
        }
    }
    public void safetyLight(){
        bil.varningsblinkers.on = true;
        safetyBattery--;
        if(safetyBattery <= 0){
            bil.varningsblinkers.on = false;
            safetyBattery = 0;
        }
    }
    public void recharge(){
        safetyBattery = safetyBatteryMax;
        batteryLife = batteryLifeMax;
    }
}
