package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.SensorEvents.AlarmSensorEvent;
import ru.sbt.mipt.oop.SensorEvents.NoSecretCodeEvent;
import ru.sbt.mipt.oop.SensorEvents.SensorEvent;

public class FakeSensorEventsGenerator {
    static SensorEvent getNextSensorEvent() {
        // pretend like we're getting the events from physical world, but here we're going to just generate some random events
        if (Math.random() < 0.05) {
            return null; // null means end of event stream;
        } else if (Math.random() < 0.35) {
            String objectId = "" + ((int) (10 * Math.random()));
            return new NoSecretCodeEvent((Math.random() < 0.5) ? SensorEventType.LIGHT_OFF : SensorEventType.LIGHT_ON, objectId);
        } else if (Math.random() < 0.7) {
            String objectId = "" + ((int) (10 * Math.random()));
            return new NoSecretCodeEvent((Math.random() < 0.5) ? SensorEventType.DOOR_CLOSED : SensorEventType.DOOR_OPEN, objectId);
        } else {
            String secretCode = (Math.random() < 0.5) ? "rightPassword" : "wrongPassword";
            return  new AlarmSensorEvent(((Math.random() < 0.5) ? SensorEventType.ALARM_ACTIVATE : SensorEventType.ALARM_DEACTIVATE),null ,secretCode);
        }
    }
}
