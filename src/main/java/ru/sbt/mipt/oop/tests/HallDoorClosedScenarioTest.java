package ru.sbt.mipt.oop.tests;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.*;

import java.util.Arrays;
import java.util.Collections;

class HallDoorClosedScenarioTest {

    private static Door openedHallDoor;
    private static EventHandler doorEventHandler;
    private static EventHandler hallDoorClosedScenario;
    private static Light hallLight;
    private static Light anotherRoomLight;
    private static SmartHome smartHome;

    @BeforeAll
    static void setUp() {
        smartHome = new SmartHome();
        openedHallDoor = new Door(true, "1", "hall");
        hallLight = new Light( "2", true,"hall");
        anotherRoomLight = new Light( "3", true,"anotherRoom");
        smartHome.addRoom(new Room(Arrays.asList(hallLight), Arrays.asList(openedHallDoor), "hall"));
        smartHome.addRoom(new Room(Arrays.asList(anotherRoomLight),  Collections.emptyList(), "anotherRoom"));
        doorEventHandler = new DoorEventHandler();
        hallDoorClosedScenario = new HallDoorClosedScenario();
    }

    @Test
    void closeHallDoorAndTurnOffLights() {
        SensorEvent closeHallDoorEvent = new SensorEvent(SensorEventType.DOOR_CLOSED, "1");
        doorEventHandler.handle(closeHallDoorEvent,smartHome);
        hallDoorClosedScenario.handle(closeHallDoorEvent,smartHome);
        Assert.assertFalse(hallLight.isOn());
        Assert.assertFalse(anotherRoomLight.isOn());
        Assert.assertFalse(openedHallDoor.isOpen());
    }
}