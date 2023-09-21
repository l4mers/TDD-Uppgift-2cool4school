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
        bil = new Bil(new Lyse());
    }

    @Test
    void validBil(){
        assertNotNull(bil);
    }
    @Test
    void harLyse(){
        assertNotNull(bil.getLyse());
    }
    @Test
    void onOffLyse(){
        bil.lightOnOff();
        assertTrue(bil.isLightOn());
        bil.lightOnOff();
        assertFalse(bil.isLightOn());
    }
    
}
