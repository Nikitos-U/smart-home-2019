package ru.sbt.mipt.oop.eventHandlers;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.SensorEvents.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class LightEventHandler implements EventHandler{
    public LightEventHandler() {
    }

    @Override
    public void handle(SensorEvent event, SmartHome smartHome) {
        Action action;
        if (event.getType() != LIGHT_OFF && event.getType() != LIGHT_ON) {
            action = null;
        } else {
            action = o -> {
                if (!(o instanceof Light)) {
                    return;
                }
                Light light = (Light) o;
                if (light.getId().equals(event.getObjectId())) {
                    if (event.getType() == LIGHT_ON) {
                        light.setOn(true);
                        System.out.println("Light " + light.getId() + " in room " + light.getRoomName() + " was turned on.");
                    } else {
                        light.setOn(false);
                        System.out.println("Light " + light.getId() + " in room " + light.getRoomName() + " was turned off.");
                    }
                }
            };
        }
        if (action != null) {
            smartHome.execute(action);
        }
    }
}
