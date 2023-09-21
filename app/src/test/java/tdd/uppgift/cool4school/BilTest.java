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
        bil.getHelljus().onOff();
        assertTrue(bil.getHelljus().isOn());
        bil.getHelljus().onOff();
        assertFalse(bil.getHelljus().isOn());
    }
    @Test
    void harHelOchHalvLjus(){
        assertNotNull(bil.getHelljus());
        assertNotNull(bil.getHalvljus());
    }
   
}
