package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.Collection;

public class SmartHome implements Actionable {
    Collection<Room> rooms;

    public SmartHome() {
        rooms = new ArrayList<>();
    }

    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Collection<Room> getRooms() {
        return rooms;
    }

    @Override
    public void execute(SensorEvent event) {
        for (Room room : rooms) {
            room.execute(event);
            if (event.getObjectId().equals("hall")) {
                for (ScenarioTypes value : ScenarioTypes.values()) {
                    Scenarios scenario = value.getScenario();
                    scenario.run(smartHome, room);
                }
            }
        }
    }
}
