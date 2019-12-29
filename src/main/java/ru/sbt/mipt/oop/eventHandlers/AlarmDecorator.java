package ru.sbt.mipt.oop.eventHandlers;

import ru.sbt.mipt.oop.*;
import ru.sbt.mipt.oop.SensorEvents.SensorEvent;
import ru.sbt.mipt.oop.signalisation.*;

public class AlarmDecorator implements EventHandler {
    @Override
    public void handle(SensorEvent event, SmartHome smartHome) {
        SignalisationState state = smartHome.getSignalisation().getState();
        if (state instanceof SignalisationActivated) {
            System.out.println("Got event: " + event);
            if (!(event.getType().equals(SensorEventType.ALARM_ACTIVATE)) && !(event.getType().equals(SensorEventType.ALARM_DEACTIVATE))) {
                AlarmMassageSender.send();
                smartHome.getSignalisation().toAlarmState();
            } else if (event.getType().equals(SensorEventType.ALARM_DEACTIVATE)) {
                smartHome.getSignalisation().deactivate(event.getSecretCode());
            } else {
                smartHome.getSignalisation().activate(event.getSecretCode());
            }

        } else if (state instanceof Alarm) {
            if (event.getType().equals(SensorEventType.ALARM_DEACTIVATE)) {
                System.out.println("Got event: " + event);
                smartHome.getSignalisation().deactivate(event.getSecretCode());
            } else {
                System.out.println("Got event: " + event);
                System.out.println("Alarm state");
                AlarmMassageSender.send();
            }
        } else {
            EventManager eventManager = new EventManager();
            eventManager.handle(event,smartHome);
        }
    }
}
