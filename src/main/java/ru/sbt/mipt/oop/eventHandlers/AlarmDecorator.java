package ru.sbt.mipt.oop.eventHandlers;

import ru.sbt.mipt.oop.*;
import ru.sbt.mipt.oop.SensorEvents.SensorEvent;
import ru.sbt.mipt.oop.library.events.CCSensorEvent;
import ru.sbt.mipt.oop.signalisation.*;

public class AlarmDecorator implements ru.sbt.mipt.oop.library.events.EventHandler {
    SmartHome smartHome;
    ru.sbt.mipt.oop.library.events.EventHandler eventHandler;

    public AlarmDecorator(SmartHome smartHome, ru.sbt.mipt.oop.library.events.EventHandler eventHandler) {
        this.smartHome = smartHome;
        this.eventHandler = eventHandler;
    }

    @Override
    public void handleEvent(CCSensorEvent event) {
        SignalisationState state = smartHome.getSignalisation().getState();
        if (state instanceof SignalisationActivated) {
            System.out.println("Got event: " + event);
            if (!(event.getEventType().equals(SensorEventType.ALARM_ACTIVATE.toString())) && !(event.getEventType().equals(SensorEventType.ALARM_DEACTIVATE.toString()))) {
                AlarmMassageSender.send();

            } else if (event.getEventType().equals(SensorEventType.ALARM_DEACTIVATE.toString())) {
                //smartHome.getSignalisation().deactivate(event.getSecretCode());
                eventHandler.handleEvent(event);
            } else {
                //smartHome.getSignalisation().activate(event.getSecretCode());
                eventHandler.handleEvent(event);
            }

        } else if (state instanceof Alarm) {
            if (event.getEventType().equals(SensorEventType.ALARM_DEACTIVATE.toString())) {
                System.out.println("Got event: " + event);
                //smartHome.getSignalisation().deactivate(event.getSecretCode());
                eventHandler.handleEvent(event);
            } else {
                System.out.println("Got event: " + event);
                System.out.println("Alarm state");
                AlarmMassageSender.send();
            }
        } else {
            //EventManager eventManager = new EventManager(smartHome);
            //eventManager.handleEvent(event);
            eventHandler.handleEvent(event);
        }
    }
}
