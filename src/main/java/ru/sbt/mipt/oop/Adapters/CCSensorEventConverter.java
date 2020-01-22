package ru.sbt.mipt.oop.Adapters;

import ru.sbt.mipt.oop.SensorEvents.SensorEvent;
import com.coolcompany.smarthome.events.CCSensorEvent;

import java.util.Collection;

public class CCSensorEventConverter implements SensorEventConverter {
    private Collection<SensorEventConverter> sensorEventConverters;

    public CCSensorEventConverter(Collection<SensorEventConverter> sensorEventConverters) {
        this.sensorEventConverters = sensorEventConverters;
    }


    @Override
    public SensorEvent convert(CCSensorEvent event){
        for (SensorEventConverter sensorEventConverter : sensorEventConverters) {
            SensorEvent adaptedEvent = sensorEventConverter.convert(event);
            if (adaptedEvent != null) {
                return adaptedEvent;
            }
        }
        return null;
    }
}
