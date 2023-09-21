package tdd.uppgift.cool4school.fordon;

public class Recharger {
    Bil bil;

    public Bil getBil() {
        return bil;
    }

    public void setBil(Bil bil) {
        this.bil = bil;
    }

    public void recharge(){
        bil.getBattery().recharge();
    }
}
