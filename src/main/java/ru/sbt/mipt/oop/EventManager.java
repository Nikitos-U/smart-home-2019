package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.Adapters.CCSensorEventAdapter;
import ru.sbt.mipt.oop.Adapters.SensorEventAdapter;
import ru.sbt.mipt.oop.SensorEvents.SensorEvent;
import ru.sbt.mipt.oop.eventHandlers.EventHandler;
import ru.sbt.mipt.oop.eventHandlers.HandlerType;
import ru.sbt.mipt.oop.library.events.CCSensorEvent;

import java.util.Collection;

public class EventManager implements ru.sbt.mipt.oop.library.events.EventHandler {
    private SensorEventAdapter adapter;
    private Collection<EventHandler> eventHandlers;

    public EventManager(Collection<EventHandler> eventHandlers, SensorEventAdapter adapter) {
        this.adapter = adapter;
        this.eventHandlers = eventHandlers;
    }

    @Override
    public void handleEvent(CCSensorEvent event) {
        System.out.println("Got event: " + event.getEventType() + " for object:" + event.getObjectId());
        SensorEvent adaptedEvent = adapter.adaptee(event);

        for (EventHandler eventHandler : eventHandlers) {
            eventHandler.handle(adaptedEvent);
        }
    }
}

