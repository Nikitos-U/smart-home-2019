package ru.sbt.mipt.oop.Adapters;

import ru.sbt.mipt.oop.SensorEvents.SensorEvent;
import com.coolcompany.smarthome.events.CCSensorEvent;

import java.util.Collection;

public class CCSensorEventConverter implements SensorEventAdapter {
    private Collection<SensorEventAdapter> sensorEventAdapters;

    public CCSensorEventConverter(Collection<SensorEventAdapter> sensorEventAdapters) {
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
