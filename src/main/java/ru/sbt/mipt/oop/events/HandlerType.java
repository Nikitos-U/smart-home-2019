package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.events.DoorEventHandler;

public enum HandlerType {
    LightEvent(new LightEventHandler()), DoorEvent(new DoorEventHandler());

    HandlerType(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    public EventHandler getEventHandler() {
        return eventHandler;
    }

    EventHandler eventHandler;
}
