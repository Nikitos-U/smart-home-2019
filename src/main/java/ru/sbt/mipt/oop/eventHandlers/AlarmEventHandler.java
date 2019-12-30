package ru.sbt.mipt.oop.eventHandlers;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.SensorEvents.SensorEvent;
import ru.sbt.mipt.oop.SensorEventType;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.signalisation.Signalisation;


import static ru.sbt.mipt.oop.SensorEventType.*;

public class AlarmEventHandler implements EventHandler {
    private SmartHome smartHome;

    public AlarmEventHandler() {
    }

    public AlarmEventHandler(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void handle(SensorEvent event) {
        Action action;
        if (event == null){
            return;
        }
        if (event.getType() != ALARM_ACTIVATE && event.getType() != SensorEventType.ALARM_DEACTIVATE) {
            action = null;
        } else {
            action = o -> {
                if (!(o instanceof Signalisation)) {
                    return;
                }
                Signalisation signalisation = (Signalisation) o;
                if (event.getType().equals(ALARM_ACTIVATE)) {
                    signalisation.activate(event.getSecretCode());
                } else {
                    signalisation.deactivate(event);
                }
            };
        }
        if (action != null) {
            smartHome.execute(action);
        }
    }
}
