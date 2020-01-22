package ru.sbt.mipt.oop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.sbt.mipt.oop.Adapters.*;
import ru.sbt.mipt.oop.eventHandlers.*;
import ru.sbt.mipt.oop.eventHandlers.EventHandler;
import com.coolcompany.smarthome.events.SensorEventsManager;
import ru.sbt.mipt.oop.remoteControlManagment.RCConfiguration;


import java.util.Collection;

@Configuration
@Import(RCConfiguration.class)
public class SmartHomeConfiguration {

    @Bean
    ReadHomeState reader() {
        return new ReadHomeStateFromFile("output.js");
    }

    @Bean
    SmartHome smartHome() {
        return reader().readCondition();
    }

    @Bean
    SensorEventsManager sensorEventsManager(Collection<EventHandler> handlers,
                                            SensorEventConverter eventAdapter) {
        SensorEventsManager sensorEventsManager = new SensorEventsManager();
        sensorEventsManager.registerEventHandler(new CCSensorEventAdapter(eventAdapter, alarmDecorator(handlers)));
        return sensorEventsManager;
    }


    @Bean
    SensorEventConverter eventAdapter(Collection<SensorEventConverter> adapters) {
        return new CCSensorEventConverter(adapters);
    }

    @Bean
    SensorEventConverter doorEventAdapter() {
        return new DoorEventConverter();
    }

    @Bean
    SensorEventConverter lightEventAdapter() {
        return new LightEventConverter();
    }

    @Bean
    EventHandler alarmHandler() {
        return new AlarmEventHandler(smartHome());
    }

    @Bean
    EventHandler lightHandler() {
        return new LightEventHandler(smartHome());
    }

    @Bean
    EventHandler doorHandler() {
        return new DoorEventHandler(smartHome());
    }

    @Bean
    EventHandler hallDoorHandler() {
        return new HallDoorClosedScenario(smartHome());
    }

    @Bean
    AlarmDecorator alarmDecorator(Collection<EventHandler> eventHandlers){
        return new AlarmDecorator(smartHome(), new EventManager(eventHandlers));
    }
}