package ru.sbt.mipt.oop;

public enum HandlerType {
    LIGHT_EVENT(new LightEventHandler()), DOOR_EVENT(new DoorEventHandler()), HALL_DOOR_CLOSED_SCENARIO(new HallDoorClosedScenario());

    HandlerType(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    public EventHandler getEventHandler() {
        return eventHandler;
    }

    EventHandler eventHandler;
}