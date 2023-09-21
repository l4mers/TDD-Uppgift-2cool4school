package tdd.uppgift.cool4school;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.uppgift.cool4school.fordon.Bil;
import tdd.uppgift.cool4school.fordon.Gear;
import tdd.uppgift.cool4school.fordon.Lyse;

import static org.junit.jupiter.api.Assertions.*;
class BilTest {

    Bil bil;

    @BeforeEach
    void setUp(){
        bil = new Bil(new Lyse(),
                new Lyse(),
                new Lyse(),
                new Lyse());
    }

    @Test
    void validBil(){
        assertNotNull(bil);
    }
    @Test
    void harLyse(){
        assertNotNull(bil.getHelljus());
    }
    @Test
    void onOffLyse(){
        bil.start();
        bil.lightOnOf(bil.getHelljus());
        assertTrue(bil.getHelljus().isOn());
        bil.lightOnOf(bil.getHelljus());
        assertFalse(bil.getHelljus().isOn());
    }
    @Test
    void harHelOchHalvLjus(){
        assertNotNull(bil.getHelljus());
        assertNotNull(bil.getHalvljus());
    }
    @Test
    void harBackLyse(){
        assertNotNull(bil.getBakljus());
    }

    @Test
    void startCar(){
        bil.start();
        assertTrue(bil.isOn());
    }

    @Test
    void stopCarAndLight(){
        bil.start();
        bil.off();
        assertFalse(bil.isOn());
        assertFalse(bil.getBakljus().isOn());
        assertFalse(bil.getHelljus().isOn());
        assertFalse(bil.getHalvljus().isOn());
    }
    @Test
    void checkVarningsblinkers(){
        bil.off();
        bil.varningsblinkersOnOff();
        assertTrue(bil.getVarningsblinkers().isOn());
    }
    @Test
    void checkHastighet(){
        bil.start();
        int hastighet = bil.getHastighet();
        bil.gasa();
        assertTrue(bil.getHastighet() > hastighet);
        assertEquals(bil.getHastighet(), 10);
    }
    @Test
    void maxFart(){
        bil.start();
        for (int i = 0; i < 20; i++) {
            bil.gasa();
        }
        assertEquals(bil.getHastighet(), 180);
    }
    @Test
    void bromsa(){
        bil.start();
        for (int i = 0; i < 20; i++) {
            bil.gasa();
        }
        assertEquals(bil.getHastighet(), 180);
        for (int i = 0; i < 20; i++) {
            bil.bromsa();
        }
        assertEquals(bil.getHastighet(), 0);
    }
    @Test
    void hasGear(){
        assertEquals(bil.getGear(), Gear.DRIVE);
        bil.shiftGear();
        assertEquals(bil.getGear(), Gear.REVERSE);
    }
    @Test
    void breakAndLight(){
        bil.start();
        bil.gasa();
        bil.gasa();
        assertFalse(bil.isLightOn(bil.getBromsljus()));
        bil.bromsa();
        assertTrue(bil.isLightOn(bil.getBromsljus()));
    }
    @Test
    void HastighetReverse(){
        bil.start();
        bil.shiftGear();
        assertEquals(bil.getGear(), Gear.REVERSE);
        bil.gasa();
        assertEquals(bil.getHastighet(), 10);
        bil.bromsa();
        bil.bromsa();
        assertEquals(bil.getHastighet(), 0);
    }
    @Test
    void hasBattery(){
        assertNotNull(bil.getBattery());
    }
    @Test
    void drainBattery(){
        bil.start();
        assertEquals(bil.getBatteryLife(), 100);
        bil.gasa();
        assertTrue(bil.getBatteryLife() < 100);
    }
}
