package ru.sbt.mipt.oop.tests;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.*;
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
        doorEventHandler = new DoorEventHandler();
    }

    @Test
    void testWhetherClosedDoorOpenAndCloseCorrectly() {
        SensorEvent sensorEvent = new SensorEvent(SensorEventType.DOOR_CLOSED, "12",null);
        SensorEvent sensorEvent1 = new SensorEvent(SensorEventType.DOOR_OPEN, "12",null);
        doorEventHandler.handle(sensorEvent1, smartHome);
        Assert.assertTrue(someClosedDoor.isOpen());
        doorEventHandler.handle(sensorEvent, smartHome);
        Assert.assertFalse(someClosedDoor.isOpen());
    }

    @Test
    void testWhetherOpenedDoorCloseAndOpenCorrectly() {
        SensorEvent doorClosed = new SensorEvent(SensorEventType.DOOR_CLOSED, "1",null);
        SensorEvent doorOpened = new SensorEvent(SensorEventType.DOOR_OPEN, "1",null);
        doorEventHandler.handle(doorClosed, smartHome);
        Assert.assertFalse(someOpenedDoor.isOpen());
        doorEventHandler.handle(doorOpened, smartHome);
        Assert.assertTrue(someOpenedDoor.isOpen());
    }
}

