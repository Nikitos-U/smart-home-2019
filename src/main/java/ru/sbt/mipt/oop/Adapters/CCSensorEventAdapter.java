package ru.sbt.mipt.oop.Adapters;

import ru.sbt.mipt.oop.SensorEvents.SensorEvent;
import ru.sbt.mipt.oop.library.events.CCSensorEvent;
import ru.sbt.mipt.oop.library.events.SensorEventsManager;

import java.util.Collection;

public class CCSensorEventAdapter implements SensorEventAdapter {
    private Collection<SensorEventAdapter> sensorEventAdapters;

    public CCSensorEventAdapter(Collection<SensorEventAdapter> sensorEventAdapters) {
        this.sensorEventAdapters = sensorEventAdapters;
    }


    @Override
    public SensorEvent adaptee(CCSensorEvent event){
        for (SensorEventAdapter sensorEventAdapter : sensorEventAdapters) {
            SensorEvent adaptedEvent = sensorEventAdapter.adaptee(event);
            if (adaptedEvent != null) {
                return adaptedEvent;
            }
        }
        return null;
    }
}
