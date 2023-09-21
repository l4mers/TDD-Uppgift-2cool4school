package tdd.uppgift.cool4school.fordon;

public class Bil {

    boolean on = false;
    Lyse helljus;
    Lyse halvljus;
    Lyse bakljus;
    Lyse varningsblinkers;

    public Bil(Lyse helljus, Lyse halvljus, Lyse bakljus, Lyse varningsblinkers) {
        this.helljus = helljus;
        this.halvljus = halvljus;
        this.bakljus = bakljus;
        this.varningsblinkers = varningsblinkers;
    }
    public Lyse getHelljus(){
        return this.helljus;
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
