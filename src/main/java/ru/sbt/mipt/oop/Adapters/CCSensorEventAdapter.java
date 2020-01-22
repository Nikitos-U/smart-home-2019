package ru.sbt.mipt.oop.Adapters;

import ru.sbt.mipt.oop.EventManager;
import ru.sbt.mipt.oop.SensorEvents.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.eventHandlers.AlarmDecorator;
import com.coolcompany.smarthome.events.CCSensorEvent;
import com.coolcompany.smarthome.events.EventHandler;

import java.util.Collection;

public class CCSensorEventAdapter implements EventHandler {
    private SensorEventConverter converter;
    private ru.sbt.mipt.oop.eventHandlers.EventHandler alarmDecorator;

    public CCSensorEventAdapter(SensorEventConverter converter, ru.sbt.mipt.oop.eventHandlers.EventHandler alarmDecorator) {
        this.converter = converter;
        this.alarmDecorator = alarmDecorator;
    }

    @Override
    public void handleEvent(CCSensorEvent event) {
        System.out.println("Got event: " + event.getEventType() + " for object:" + event.getObjectId());
        SensorEvent adaptedEvent = converter.convert(event);
        //AlarmDecorator alarmDecorator = new AlarmDecorator(smartHome, new EventManager(eventHandlers));
        alarmDecorator.handle(adaptedEvent);
    }
}
