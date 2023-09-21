package tdd.uppgift.cool4school.fordon;

public class Lyse {
    boolean on = false;

    public boolean isOn() {
        return on;
    }
    public void onOff(Battery battery){
        on = !on;
        if(on){
            battery.batteryConsumption(1);
        }
        if(battery.batteryLife == 0){
            on = false;
        }
    }
    public void outOfBattery(){
        on = false;
    }
}
