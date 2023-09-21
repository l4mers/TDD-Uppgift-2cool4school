package tdd.uppgift.cool4school.fordon;

public class Bil {

    int hastighet = 0;
    int maxHastighet = 180;
    boolean on = false;
    Lyse helljus;
    Lyse halvljus;
    Lyse bakljus;
    Lyse varningsblinkers;
    Gear gear;

    public Bil(Lyse helljus, Lyse halvljus, Lyse bakljus, Lyse varningsblinkers) {
        this.helljus = helljus;
        this.halvljus = halvljus;
        this.bakljus = bakljus;
        this.varningsblinkers = varningsblinkers;
        gear = Gear.DRIVE;
    }

    public void shiftGear(){
        if(gear == Gear.DRIVE){
            gear = Gear.REVERSE;
        } else{
            gear = Gear.DRIVE;
        }
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
        hastighet =- 10;
        if(hastighet < 0){
            hastighet = 0;
        }
    }

    public void gasa(){
        if(on) {
            hastighet += 10;
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
            light.onOff();
        }
    }

    public void varningsblinkersOnOff(){
        varningsblinkers.onOff();
    }

    public boolean isLightOn(Lyse light){
        return light.isOn();
    }

    public void start(){
        this.on = true;
        halvljus.on = true;
        bakljus.on = true;
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
}
