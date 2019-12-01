package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.signalisation.Signalisation;
import ru.sbt.mipt.oop.signalisation.SignalisationActivated;
import ru.sbt.mipt.oop.signalisation.SignalisationDeactivated;

import java.util.ArrayList;
import java.util.Collection;

public class SmartHome implements Actionable {
    Collection<Room> rooms;

    public SmartHome() {
        rooms = new ArrayList<>();
        this.signalisation = new Signalisation();
    }

    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
        this.signalisation = new Signalisation();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Collection<Room> getRooms() {
        return rooms;
    }

    public Signalisation signalisation;

    @Override
    public void execute(Action action) {
        action.execute(this);
        signalisation.execute(action);
        for (Actionable room : rooms) {
            room.execute(action);
        }
    }

}
