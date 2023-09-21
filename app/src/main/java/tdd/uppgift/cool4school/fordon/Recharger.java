package tdd.uppgift.cool4school.fordon;

public class Recharger {
    Bil bil;

    public Recharger(Bil bil) {
        this.bil = bil;
    }

    public void recharge(){
        bil.getBattery().recharge();
    }
}
