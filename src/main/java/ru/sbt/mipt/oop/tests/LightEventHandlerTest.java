package ru.sbt.mipt.oop.tests;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.*;

import java.util.Arrays;
import java.util.Collections;

public class LightEventHandlerTest {

    private static LightEventHandler lightEventHandler;
    private static Light someTurnedOnLight;
    private static Light someTurnedOffLight;
    private static SmartHome smartHome;

    @BeforeAll
    static void preparations() {
        smartHome = new SmartHome();
        someTurnedOffLight = new Light("12", false, "someRoom");
        someTurnedOnLight = new Light("1", true, "anotherRoom");
        smartHome.addRoom(new Room(Arrays.asList(someTurnedOffLight), Collections.emptyList(), "someRoom"));
        smartHome.addRoom(new Room(Arrays.asList(someTurnedOnLight), Collections.emptyList(), "anotherRoom"));
        lightEventHandler = new LightEventHandler();
    }

    @Test
    void testWhetherTurnedOffLightGetsOnAndOff() {
        SensorEvent lightTurnOff = new SensorEvent(SensorEventType.LIGHT_OFF, "12");
        SensorEvent lightTurnOn = new SensorEvent(SensorEventType.LIGHT_ON, "12");
        lightEventHandler.handle(lightTurnOn, smartHome);
        Assert.assertTrue(someTurnedOffLight.isOn());
        lightEventHandler.handle(lightTurnOff, smartHome);
        Assert.assertFalse(someTurnedOffLight.isOn());
    }

    @Test
    void testWhetherTurnedOnLightGetOffAndOn() {
        SensorEvent lightTurnOff = new SensorEvent(SensorEventType.LIGHT_OFF, "1");
        SensorEvent lightTurnOn = new SensorEvent(SensorEventType.LIGHT_ON, "1");
        lightEventHandler.handle(lightTurnOff, smartHome);
        Assert.assertFalse(someTurnedOnLight.isOn());
        lightEventHandler.handle(lightTurnOn, smartHome);
        Assert.assertTrue(someTurnedOnLight.isOn());
    }
}

