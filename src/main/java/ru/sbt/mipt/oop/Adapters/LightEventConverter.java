package ru.sbt.mipt.oop.Adapters;

import ru.sbt.mipt.oop.SensorEventType;
import ru.sbt.mipt.oop.SensorEvents.NoSecretCodeEvent;
import ru.sbt.mipt.oop.SensorEvents.SensorEvent;
import com.coolcompany.smarthome.events.CCSensorEvent;

public class LightEventConverter implements SensorEventConverter {

    @Override
    public SensorEvent convert(CCSensorEvent event) {
        if (!event.getEventType().equals("LightIsOn") && !event.getEventType().equals("LightIsOff")){
            return null;
        } if (event.getEventType().equals("LightIsOn")) {
            return new NoSecretCodeEvent(SensorEventType.LIGHT_ON, event.getObjectId());
        } else {
            return new NoSecretCodeEvent(SensorEventType.LIGHT_OFF, event.getObjectId());
        }
    }
}
