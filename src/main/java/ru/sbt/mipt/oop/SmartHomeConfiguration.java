package ru.sbt.mipt.oop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.sbt.mipt.oop.Adapters.CCSensorEventAdapter;
import ru.sbt.mipt.oop.Adapters.DoorEventAdapter;
import ru.sbt.mipt.oop.Adapters.LightEventAdapter;
import ru.sbt.mipt.oop.Adapters.SensorEventAdapter;
import ru.sbt.mipt.oop.SensorEvents.SensorEvent;
import ru.sbt.mipt.oop.eventHandlers.*;
import ru.sbt.mipt.oop.eventHandlers.EventHandler;
import ru.sbt.mipt.oop.library.events.SensorEventsManager;
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
                                            Collection<SensorEventAdapter> adapters) {
        SensorEventsManager sensorEventsManager = new SensorEventsManager();
        sensorEventsManager.registerEventHandler(new AlarmDecorator(
                smartHome(), new EventManager(handlers, eventAdapter(adapters))));
        return sensorEventsManager;
    }


    @Bean
    SensorEventAdapter eventAdapter(Collection<SensorEventAdapter> adapters) {
        return new CCSensorEventAdapter(adapters);
    }

    @Bean
    SensorEventAdapter doorEventAdapter() {
        return new DoorEventAdapter();
    }

    @Bean
    SensorEventAdapter lightEventAdapter() {
        return new LightEventAdapter();
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
}