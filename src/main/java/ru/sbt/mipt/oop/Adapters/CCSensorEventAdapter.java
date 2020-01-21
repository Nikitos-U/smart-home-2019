package ru.sbt.mipt.oop.Adapters;

import ru.sbt.mipt.oop.EventManager;
import ru.sbt.mipt.oop.SensorEvents.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.eventHandlers.AlarmDecorator;
import com.coolcompany.smarthome.events.CCSensorEvent;
import com.coolcompany.smarthome.events.EventHandler;

import java.util.Collection;

public class CCSensorEventAdapter implements EventHandler {
    private SensorEventAdapter adapter;
    private SmartHome smartHome;
    private Collection<ru.sbt.mipt.oop.eventHandlers.EventHandler> eventHandlers;

    public CCSensorEventAdapter(SensorEventAdapter adapter, SmartHome smartHome, Collection<ru.sbt.mipt.oop.eventHandlers.EventHandler> eventHandlers) {
        this.adapter = adapter;
        this.smartHome = smartHome;
        this.eventHandlers = eventHandlers;
    }

    @Override
    public void handleEvent(CCSensorEvent event) {
        System.out.println("Got event: " + event.getEventType() + " for object:" + event.getObjectId());
        SensorEvent adaptedEvent = adapter.adaptee(event);
        AlarmDecorator alarmDecorator = new AlarmDecorator(smartHome,new EventManager(eventHandlers));
        alarmDecorator.handle(adaptedEvent);
    }
}
