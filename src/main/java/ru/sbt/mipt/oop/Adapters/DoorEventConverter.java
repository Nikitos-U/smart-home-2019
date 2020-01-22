package ru.sbt.mipt.oop.Adapters;

import ru.sbt.mipt.oop.SensorEventType;
import ru.sbt.mipt.oop.SensorEvents.NoSecretCodeEvent;
import ru.sbt.mipt.oop.SensorEvents.SensorEvent;
import com.coolcompany.smarthome.events.CCSensorEvent;

public class DoorEventConverter implements SensorEventConverter {

    @Override
    public SensorEvent convert(CCSensorEvent event) {
        if (!event.getEventType().equals("DoorIsOpen") && !event.getEventType().equals("DoorIsClosed")){
            return null;
        } if (event.getEventType().equals("DoorIsOpen")) {
            return new NoSecretCodeEvent(SensorEventType.DOOR_OPEN, event.getObjectId());
        } else {
            return new NoSecretCodeEvent(SensorEventType.DOOR_CLOSED, event.getObjectId());
        }
    }
}
