package ru.sbt.mipt.oop.tests;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.*;
import ru.sbt.mipt.oop.SensorEvents.NoSecretCodeEvent;
import ru.sbt.mipt.oop.SensorEvents.SensorEvent;
import ru.sbt.mipt.oop.eventHandlers.LightEventHandler;

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
        lightEventHandler = new LightEventHandler(smartHome);
    }

    @Test
    void testWhetherTurnedOffLightGetsOnAndOff() {
        SensorEvent lightTurnOff = new NoSecretCodeEvent(SensorEventType.LIGHT_OFF, "12");
        SensorEvent lightTurnOn = new NoSecretCodeEvent(SensorEventType.LIGHT_ON, "12");
        lightEventHandler.handle(lightTurnOn);
        Assert.assertTrue(someTurnedOffLight.isOn());
        lightEventHandler.handle(lightTurnOff);
        Assert.assertFalse(someTurnedOffLight.isOn());
    }

    @Test
    void testWhetherTurnedOnLightGetOffAndOn() {
        SensorEvent lightTurnOff = new NoSecretCodeEvent(SensorEventType.LIGHT_OFF, "1");
        SensorEvent lightTurnOn = new NoSecretCodeEvent(SensorEventType.LIGHT_ON, "1");
        lightEventHandler.handle(lightTurnOff);
        Assert.assertFalse(someTurnedOnLight.isOn());
        lightEventHandler.handle(lightTurnOn);
        Assert.assertTrue(someTurnedOnLight.isOn());
    }
}

