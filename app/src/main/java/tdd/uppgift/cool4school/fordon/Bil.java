package tdd.uppgift.cool4school.fordon;

public class Bil {

    Lyse lyse;

    public Bil(Lyse lyse) {
        this.lyse = lyse;
    }
    public boolean isLightOn() {
        return this.lyse.on;
    }

    public void lightOnOff(){
        lyse.on = !lyse.on;
    }

    public void setLyse(Lyse lyse){
        this.lyse = lyse;
    }
    public Lyse getLyse(){
        return this.lyse;
    }
}
