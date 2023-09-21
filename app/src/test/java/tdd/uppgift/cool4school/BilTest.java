package tdd.uppgift.cool4school;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.uppgift.cool4school.fordon.Bil;
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
}
