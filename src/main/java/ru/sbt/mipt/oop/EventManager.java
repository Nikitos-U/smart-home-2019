package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.SensorEvents.SensorEvent;
import ru.sbt.mipt.oop.eventHandlers.EventHandler;

import java.util.Collection;

public class EventManager implements EventHandler {
    private Collection<EventHandler> eventHandlers;

    public EventManager(Collection<EventHandler> eventHandlers) {
        this.eventHandlers = eventHandlers;
    }

    @Override
    public void handle(SensorEvent event) {

        for (EventHandler eventHandler : eventHandlers) {
            eventHandler.handle(event);
        }
    }

}

