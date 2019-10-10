package ru.sbt.mipt.oop;

public enum SensorEventType {
    LIGHT_ON {
        @Override
        public EventHandler createHandler(SensorEventType type, String objectId, SmartHome smartHome) {
            return new LightEventHandler(type, objectId, smartHome);
        }
    }, LIGHT_OFF {
        @Override
        public EventHandler createHandler(SensorEventType type, String objectId, SmartHome smartHome) {
            return new LightEventHandler(type, objectId, smartHome);
        }
    }, DOOR_OPEN {
        public EventHandler createHandler(SensorEventType type, String objectId, SmartHome smartHome) {
            return new DoorEventHandler(type, objectId, smartHome);
        }
    }, DOOR_CLOSED {
        public EventHandler createHandler(SensorEventType type, String objectId, SmartHome smartHome) {
            return new DoorEventHandler(type, objectId, smartHome);
        }
    };

    public abstract EventHandler createHandler(SensorEventType type, String objectId, SmartHome smartHome);
}
