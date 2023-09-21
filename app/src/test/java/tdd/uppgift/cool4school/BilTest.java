package tdd.uppgift.cool4school;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.uppgift.cool4school.fordon.Bil;
import tdd.uppgift.cool4school.fordon.Gear;
import tdd.uppgift.cool4school.fordon.Lyse;
import tdd.uppgift.cool4school.fordon.Recharger;

import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;
class BilTest {

    Bil bil;
    Recharger recharger;

    @BeforeEach
    void setUp(){
        bil = new Bil(new Lyse(),
                new Lyse(),
                new Lyse(),
                new Lyse());
        recharger = new Recharger();

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
        assertTrue(bil.getHalvljus().isOn());
        bil.lightOnOf(bil.getHalvljus());
        assertFalse(bil.getHalvljus().isOn());
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
        int batteryLifeAfterStart = bil.getBatteryLife();
        assertEquals(bil.getBatteryLife(), batteryLifeAfterStart);
        bil.gasa();
        assertTrue(bil.getBatteryLife() < batteryLifeAfterStart);
    }
    @Test
    void drainBatteryOnLight(){
        bil.start();
        int batteryLifeAfterStart = bil.getBatteryLife();
        assertEquals(bil.getBatteryLife(), batteryLifeAfterStart);
        bil.lightOnOf(bil.getHelljus());
        assertTrue(bil.getBatteryLife() < batteryLifeAfterStart);
    }
    @Test
    void emptyBattery(){
        bil.start();
        for (int i = 0; i < 20; i++) {
            bil.gasa();
        }
        assertEquals(bil.getHastighet(), 180);
        bil.bromsa();
        bil.bromsa();
        bil.bromsa();
        assertNotEquals(180, bil.getHastighet());
        int hastighetWhenBatteryEmpty = bil.getHastighet();
        bil.gasa();
        bil.gasa();
        assertEquals(bil.getHastighet(), hastighetWhenBatteryEmpty);
    }
    @Test
    void noBatteryNoLight(){
        bil.start();
        for (int i = 0; i < 50; i++) {
            bil.gasa();
        }
        bil.getLights().forEach(light ->{
            assertFalse(light.isOn());
        });
    }
    @Test
    void batteryForVarningsblinkers(){
        bil.start();
        for (int i = 0; i < 50; i++) {
            bil.gasa();
        }
        assertEquals(0, bil.getBatteryLife());
        bil.varningsblinkersOnOff();
        assertTrue(bil.getVarningsblinkers().isOn());
    }
    @Test
    void rechargeBattery(){
        bil.start();
        for (int i = 0; i < 50; i++) {
            bil.gasa();
        }
        assertEquals(0, bil.getBatteryLife());
        for (int i = 0; i < 11; i++) {
            bil.varningsblinkersOnOff();
        }
        assertEquals(bil.getBatteryLife(), 0);
        assertEquals(bil.getEmergencyBatteryLife(), 0);
        bil.getBattery().recharge();
        assertEquals(bil.getBatteryLife(), 100);
        assertEquals(bil.getEmergencyBatteryLife(), 10);
    }

    @Test
    void rechargerRecharge(){
        bil.start();
        for (int i = 0; i < 50; i++) {
            bil.gasa();
        }
        assertEquals(0, bil.getBatteryLife());
        for (int i = 0; i < 11; i++) {
            bil.varningsblinkersOnOff();
        }
        assertEquals(bil.getBatteryLife(), 0);
        assertEquals(bil.getEmergencyBatteryLife(), 0);
        recharger.setBil(bil);
        recharger.recharge();
        assertEquals(bil.getBatteryLife(), 100);
        assertEquals(bil.getEmergencyBatteryLife(), 10);
    }
    @Test
    void connectCarToCharger(){
        assertNull(recharger.getBil());
        recharger.setBil(bil);
        assertNotNull(bil);
    }
    @Test
    void rechargeCost(){
        bil.start();
        for (int i = 0; i < 50; i++) {
            bil.gasa();
        }
        assertEquals(0, bil.getBatteryLife());
        for (int i = 0; i < 11; i++) {
            bil.varningsblinkersOnOff();
        }
        recharger.setBil(bil);
        assertEquals(bil.getBatteryLife(), 0);
        assertEquals(bil.getEmergencyBatteryLife(), 0);
        assertEquals(recharger.recharge(), "Kostnad " + 1000 + " Kr");
    }

    @Test
    void rechargeIterations(){
        bil.start();
        for (int i = 0; i < 50; i++) {
            bil.gasa();
        }
        assertEquals(0, bil.getBatteryLife());
        for (int i = 0; i < 11; i++) {
            bil.varningsblinkersOnOff();
        }
        assertEquals(recharger.setBil(bil), "Batteri procent " + 0 +
                "\nFörväntad laddtid: " + 10 + " minuter");
    }
}
