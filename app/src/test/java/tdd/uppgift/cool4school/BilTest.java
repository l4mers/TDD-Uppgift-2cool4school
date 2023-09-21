package tdd.uppgift.cool4school;

import org.junit.jupiter.api.Test;
import tdd.uppgift.cool4school.fordon.Bil;

import static org.junit.jupiter.api.Assertions.*;
class BilTest {

    @Test void validBil(){
        Bil bil = new Bil();
        assertNotNull(bil.getBil());
    }
}
