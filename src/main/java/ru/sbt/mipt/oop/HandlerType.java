package ru.sbt.mipt.oop;

public enum HandlerType {
    LIGHT_EVENT(new LightEventHandler()), DOOR_EVENT(new DoorEventHandler());

    HandlerType(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    public EventHandler getEventHandler() {
        return eventHandler;
    }

    EventHandler eventHandler;
}
