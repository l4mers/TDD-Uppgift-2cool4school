package tdd.uppgift.cool4school;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.uppgift.cool4school.fordon.Bil;

import static org.junit.jupiter.api.Assertions.*;
class BilTest {

    Bil bil;

    @BeforeEach
    void setUp(){
        bil = new Bil();
    }

    @Test
    void validBil(){
        assertNotNull(bil);
    }
    @Test
    void harLyse(){
        assertNotNull(bil.harLyse());
    }
}
