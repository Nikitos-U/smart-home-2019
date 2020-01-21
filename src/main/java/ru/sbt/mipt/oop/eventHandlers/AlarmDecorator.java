package ru.sbt.mipt.oop.eventHandlers;

import ru.sbt.mipt.oop.*;
import ru.sbt.mipt.oop.SensorEvents.SensorEvent;
import ru.sbt.mipt.oop.signalisation.*;

public class AlarmDecorator implements EventHandler {
    SmartHome smartHome;
    EventHandler eventHandler;

    public AlarmDecorator(SmartHome smartHome, EventHandler eventHandler) {
        this.smartHome = smartHome;
        this.eventHandler = eventHandler;
    }

    @Override
    public void handle(SensorEvent event) {
        SignalisationState state = smartHome.getSignalisation().getState();
        if (state instanceof SignalisationActivated) {
            System.out.println("Got event: " + event);
            if (!(event.getType().equals(SensorEventType.ALARM_ACTIVATE.toString())) && !(event.getType().equals(SensorEventType.ALARM_DEACTIVATE.toString()))) {
                AlarmMassageSender.send();

            } else if (event.getType().equals(SensorEventType.ALARM_DEACTIVATE.toString())) {
                //smartHome.getSignalisation().deactivate(event.getSecretCode());
                eventHandler.handle(event);
            } else {
                //smartHome.getSignalisation().activate(event.getSecretCode());
                eventHandler.handle(event);
            }

        } else if (state instanceof Alarm) {
            if (event.getType().equals(SensorEventType.ALARM_DEACTIVATE.toString())) {
                System.out.println("Got event: " + event);
                //smartHome.getSignalisation().deactivate(event.getSecretCode());
                eventHandler.handle(event);
            } else {
                System.out.println("Got event: " + event);
                System.out.println("Alarm state");
                AlarmMassageSender.send();
            }
        } else {
            //EventManager eventManager = new EventManager(smartHome);
            //eventManager.handleEvent(event);
            eventHandler.handle(event);
        }
    }
}
