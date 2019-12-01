package ru.sbt.mipt.oop.eventHandlers;

import ru.sbt.mipt.oop.*;
import ru.sbt.mipt.oop.signalisation.*;

public class AlarmDecorator implements EventHandler {
    @Override
    public void handle(SensorEvent event, SmartHome smartHome) {
        State state = smartHome.signalisation.getState();
        if (state instanceof SignalisationActivated) {
            System.out.println("Got event: " + event);
            if (!(event.getType().equals(SensorEventType.ALARM_ACTIVATE)) && !(event.getType().equals(SensorEventType.ALARM_DEACTIVATE))) {
                AlarmMassageSender.send();
                smartHome.signalisation.toAlarmState();
            } else if (event.getType().equals(SensorEventType.ALARM_DEACTIVATE)) {
                smartHome.signalisation.deactivate(event.getSecretCode());
            } else {
                smartHome.signalisation.activate(event.getSecretCode());
            }

        } else if (state instanceof Alarm) {
            if (event.getType().equals(SensorEventType.ALARM_DEACTIVATE)) {
                System.out.println("Got event: " + event);
                smartHome.signalisation.deactivate(event.getSecretCode());
                System.out.println("Alarm deactivated");
            } else {
                System.out.println("Got event: " + event);
                System.out.println("Alarm state");
                AlarmMassageSender.send();
            }
        } else {
            EventManager.processEvent(event, smartHome);
        }
    }
}
