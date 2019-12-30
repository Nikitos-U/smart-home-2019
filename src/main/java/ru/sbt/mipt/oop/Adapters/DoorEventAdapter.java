package ru.sbt.mipt.oop.Adapters;

import ru.sbt.mipt.oop.SensorEventType;
import ru.sbt.mipt.oop.SensorEvents.NoSecretCodeEvent;
import ru.sbt.mipt.oop.SensorEvents.SensorEvent;
import ru.sbt.mipt.oop.library.events.CCSensorEvent;

public class DoorEventAdapter implements SensorEventAdapter {

    @Override
    public SensorEvent adaptee(CCSensorEvent event) {
        if (!event.getEventType().equals("DoorIsOpen") && !event.getEventType().equals("DoorIsClosed")){
            return null;
        } if (event.getEventType().equals("DoorIsOpen")) {
            return new NoSecretCodeEvent(SensorEventType.DOOR_OPEN, event.getObjectId());
        } else {
            return new NoSecretCodeEvent(SensorEventType.DOOR_CLOSED, event.getObjectId());
        }
    }
}
