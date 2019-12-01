package ru.sbt.mipt.oop.tests;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.*;
import ru.sbt.mipt.oop.eventHandlers.AlarmEventHandler;
import ru.sbt.mipt.oop.signalisation.Alarm;
import ru.sbt.mipt.oop.signalisation.SignalisationActivated;
import ru.sbt.mipt.oop.signalisation.SignalisationDeactivated;
import ru.sbt.mipt.oop.signalisation.State;



public class SignalisationDeactivatedStateTest {
    private static AlarmEventHandler alarmEventHandler;
    private static SmartHome smartHome;

    @BeforeAll
    static void preparations() {
        smartHome = new SmartHome();
        alarmEventHandler = new AlarmEventHandler();
    }

    @Test
    void testDeactivatingEvent() {
        SensorEvent correctPasswordDeactivation = new SensorEvent(SensorEventType.ALARM_DEACTIVATE, "12", "correct password");
        alarmEventHandler.handle(correctPasswordDeactivation, smartHome);
        Assert.assertTrue(isInstanceOfDeactivated(smartHome.signalisation.getState()));
    }

    @Test
    void testActivatingEvent() {
        SensorEvent activatingEvent = new SensorEvent(SensorEventType.ALARM_ACTIVATE,null,"some password");
        alarmEventHandler.handle(activatingEvent,smartHome);
        Assert.assertTrue(isInstanceOfActivated(smartHome.signalisation.getState()));
    }

    static boolean isInstanceOfActivated(State state) {
        return (state instanceof SignalisationActivated);
    }


    static boolean isInstanceOfDeactivated(State state) {
        return (state instanceof SignalisationDeactivated);
    }
}

