package ru.sbt.mipt.oop.tests;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.*;
import ru.sbt.mipt.oop.SensorEvents.NoSecretCodeEvent;
import ru.sbt.mipt.oop.SensorEvents.SensorEvent;
import ru.sbt.mipt.oop.eventHandlers.DoorEventHandler;

import java.util.Arrays;
import java.util.Collections;


public class DoorEventHandlerTest {
    private static DoorEventHandler doorEventHandler;
    private static Door someOpenedDoor;
    private static Door someClosedDoor;
    private static SmartHome smartHome;

    @BeforeAll
    static void preparations() {
        smartHome = new SmartHome();
        someClosedDoor = new Door(false, "12", "someRoom");
        someOpenedDoor = new Door(true, "1", "anotherRoom");
        smartHome.addRoom(new Room(Collections.emptyList(), Arrays.asList(someClosedDoor), "someRoom"));
        smartHome.addRoom(new Room(Collections.emptyList(), Arrays.asList(someOpenedDoor), "anotherRoom"));
        doorEventHandler = new DoorEventHandler(smartHome);
    }

    @Test
    void testWhetherClosedDoorOpenAndCloseCorrectly() {
        SensorEvent sensorEvent = new NoSecretCodeEvent(SensorEventType.DOOR_CLOSED, "12");
        SensorEvent sensorEvent1 = new NoSecretCodeEvent(SensorEventType.DOOR_OPEN, "12");
        doorEventHandler.handle(sensorEvent1);
        Assert.assertTrue(someClosedDoor.isOpen());
        doorEventHandler.handle(sensorEvent);
        Assert.assertFalse(someClosedDoor.isOpen());
    }

    @Test
    void testWhetherOpenedDoorCloseAndOpenCorrectly() {
        SensorEvent doorClosed = new NoSecretCodeEvent(SensorEventType.DOOR_CLOSED, "1");
        SensorEvent doorOpened = new NoSecretCodeEvent(SensorEventType.DOOR_OPEN, "1");
        doorEventHandler.handle(doorClosed);
        Assert.assertFalse(someOpenedDoor.isOpen());
        doorEventHandler.handle(doorOpened);
        Assert.assertTrue(someOpenedDoor.isOpen());
    }
}

