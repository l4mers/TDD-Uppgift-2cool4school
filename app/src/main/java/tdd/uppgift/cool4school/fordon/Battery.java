package tdd.uppgift.cool4school.fordon;

public class Battery {
    int batteryLife = 100;

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
}
