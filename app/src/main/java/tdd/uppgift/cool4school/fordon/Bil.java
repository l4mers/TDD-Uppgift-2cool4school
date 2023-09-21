package tdd.uppgift.cool4school.fordon;

public class Bil {

    boolean on = false;
    Lyse helljus;
    Lyse halvljus;
    Lyse bakljus;

    public Bil(Lyse helljus, Lyse halvljus, Lyse bakljus) {
        this.helljus = helljus;
        this.halvljus = halvljus;
        this.bakljus = bakljus;
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
    public void start(){
        this.on = true;
    }
}
