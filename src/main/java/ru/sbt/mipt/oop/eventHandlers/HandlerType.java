package ru.sbt.mipt.oop.eventHandlers;

import ru.sbt.mipt.oop.eventHandlers.DoorEventHandler;
import ru.sbt.mipt.oop.eventHandlers.EventHandler;
import ru.sbt.mipt.oop.eventHandlers.HallDoorClosedScenario;
import ru.sbt.mipt.oop.eventHandlers.LightEventHandler;

public enum HandlerType {
    LIGHT_EVENT(new LightEventHandler()), DOOR_EVENT(new DoorEventHandler()), HALL_DOOR_CLOSED_SCENARIO(new HallDoorClosedScenario()), ALARM_EVENT(new AlarmEventHandler());

    HandlerType(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    public EventHandler getEventHandler() {
        return eventHandler;
    }

    EventHandler eventHandler;
}