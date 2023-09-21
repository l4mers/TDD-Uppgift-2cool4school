package tdd.uppgift.cool4school.fordon;

public class Battery {
    int batteryLife = 100;

    public void batteryConsumption(int consumption){
        this.batteryLife =- consumption;
        if(batteryLife < 0){
            batteryLife = 0;
        }
    }
}
