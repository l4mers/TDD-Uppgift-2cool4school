package tdd.uppgift.cool4school.fordon;

public class Bil {

    Lyse helljus;
    Lyse halvljus;
    Lyse bakljus;

    public Bil(Lyse helljus, Lyse halvljus) {
        this.helljus = helljus;
        this.halvljus = halvljus;
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
}
