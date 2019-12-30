package ru.sbt.mipt.oop.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.sbt.mipt.oop.Door;
import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.SmartHomeConfiguration;
import ru.sbt.mipt.oop.rc.RemoteControl;
import ru.sbt.mipt.oop.signalisation.Alarm;
import ru.sbt.mipt.oop.signalisation.SignalisationActivated;

import static org.junit.jupiter.api.Assertions.*;

class RCTest{

    private SmartHome smartHome;
    private RemoteControl rc;

    @BeforeEach
    void setUp() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SmartHomeConfiguration.class);
        smartHome = context.getBean(SmartHome.class);
        rc = (RemoteControl) context.getBean("remoteControl");
    }

    @Test
    public void testSignalisationActivation() {
        rc.onButtonPressed("A", "1");
        assertTrue(smartHome.getSignalisation().getState() instanceof SignalisationActivated);
    }

    @Test
    public void testCloseHallDoorCommand(){
        rc.onButtonPressed("D","1");
        Door hallDoor = new Door(false, "4","hall");
        assertFalse(hallDoor.isOpen());
    }

    @Test
    public void testHallLightsOnCommand(){
        rc.onButtonPressed("2","1");
        Light hallLight = new Light("7", false,"hall");
        assertFalse(hallLight.isOn());
    }

    @Test
    public void testAlarmActivation() {
        rc.onButtonPressed("1", "1");
        assertTrue(smartHome.getSignalisation().getState() instanceof Alarm);
    }
}