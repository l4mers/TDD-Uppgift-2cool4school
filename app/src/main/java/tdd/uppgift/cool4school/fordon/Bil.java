package tdd.uppgift.cool4school.fordon;

import java.util.List;

public class Bil {
    Battery battery;
    int hastighet = 0;
    int maxHastighet = 180;
    boolean on = false;
    Lyse helljus;
    Lyse halvljus;
    Lyse bakljus;
    Lyse varningsblinkers;
    Lyse bromsljus;
    Gear gear;

    public Bil(Lyse helljus, Lyse halvljus, Lyse bakljus, Lyse varningsblinkers) {
        this.helljus = helljus;
        this.halvljus = halvljus;
        this.bakljus = bakljus;
        this.varningsblinkers = varningsblinkers;
        this.bromsljus = new Lyse();
        gear = Gear.DRIVE;
        battery = new Battery(this);
    }

    public Battery getBattery() {
        return battery;
    }

    public int getBatteryLife(){
        return battery.batteryLife;
    }

    public void shiftGear(){
        if(gear == Gear.DRIVE){
            gear = Gear.REVERSE;
        } else{
            gear = Gear.DRIVE;
        }
    }

    public Lyse getBromsljus() {
        return bromsljus;
    }

    public Gear getGear() {
        return gear;
    }

    public void setGear(Gear gear) {
        this.gear = gear;
    }

    public Lyse getHelljus(){
        return this.helljus;
    }

    public void bromsa(){
        bromsljus.onOff(battery);
        hastighet -= 10;
        if(hastighet < 0){
            hastighet = 0;
        }
    }

    public void gasa(){
        bromsljus.onOff(battery);
        if(on) {
            if(getBatteryLife() > 0){
                battery.batteryConsumption(5);
                hastighet += 10;
            }
        }
        if(hastighet > maxHastighet){
            hastighet = maxHastighet;
        }
    }

    public int getHastighet() {
        return hastighet;
    }

    public Lyse getBakljus() {
        return bakljus;
    }

    public Lyse getHalvljus() {
        return halvljus;
    }

    public boolean isOn(){
        return this.on;
    }

    public Lyse getVarningsblinkers() {
        return varningsblinkers;
    }

    public void lightOnOf(Lyse light){
        if(this.on){
            light.onOff(battery);
        }
    }

    public void varningsblinkersOnOff(){
        varningsblinkers.onOff(battery);
    }

    public boolean isLightOn(Lyse light){
        return light.isOn();
    }

    public void start(){
        this.on = true;
        halvljus.onOff(battery);
        bakljus.onOff(battery);
    }
    public void off(){
        this.on = false;
        lightsOff();
    }

    private void lightsOff() {
        halvljus.on = false;
        helljus.on = false;
        bakljus.on = false;
    }

    public List<Lyse> getLights() {
        return List.of(helljus, halvljus, bakljus, bromsljus);
    }
}
