package ru.sbt.mipt.oop;

interface EventHandler {
    void run(SensorEventType type, String objectId, SmartHome smartHome);
}