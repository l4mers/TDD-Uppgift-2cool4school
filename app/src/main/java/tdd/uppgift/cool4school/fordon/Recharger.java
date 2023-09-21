package tdd.uppgift.cool4school.fordon;

public class Recharger {
    Bil bil;

    public Bil getBil() {
        return bil;
    }

    public String setBil(Bil bil) {
        this.bil = bil;
        return "Batteri procent " + bil.getBatteryLife() +
                "\nFörväntad laddtid: " + (100 - bil.getBatteryLife()) / 10 + " minuter" ;
    }

    public String recharge(){
        int startingPoint = bil.getBatteryLife();
        bil.getBattery().recharge();
        return "Kostnad " + (100 - startingPoint) * 10 + " Kr";
    }
}
