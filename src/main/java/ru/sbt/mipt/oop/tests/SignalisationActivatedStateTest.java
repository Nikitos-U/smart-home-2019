package ru.sbt.mipt.oop.tests;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.*;
import ru.sbt.mipt.oop.eventHandlers.AlarmEventHandler;
import ru.sbt.mipt.oop.signalisation.Alarm;
import ru.sbt.mipt.oop.signalisation.SignalisationDeactivated;
import ru.sbt.mipt.oop.signalisation.State;



public class SignalisationActivatedStateTest {
    private static AlarmEventHandler alarmEventHandler;
    private static SmartHome smartHome;

    @BeforeAll
    static void preparations() {
        smartHome = new SmartHome();
        SensorEvent activationEvent = new SensorEvent(SensorEventType.ALARM_ACTIVATE, null, "correct password");
        smartHome.signalisation.activate(activationEvent.getSecretCode());
        alarmEventHandler = new AlarmEventHandler();
    }

    @Test
    void testDeactivatedEventCorrectPassword() {
        SensorEvent correctPasswordDeactivation = new SensorEvent(SensorEventType.ALARM_DEACTIVATE, "12", "correct password");
        alarmEventHandler.handle(correctPasswordDeactivation, smartHome);
        Assert.assertTrue(isInstanceOfDeactivated(smartHome.signalisation.getState()));
    }

    @Test
    void testDeactivatingEventWrongPassword() {
        SensorEvent wrongPasswordDeactivation = new SensorEvent(SensorEventType.ALARM_DEACTIVATE,null,"wrong password");
        alarmEventHandler.handle(wrongPasswordDeactivation,smartHome);
        Assert.assertTrue(isInstanceOfAlarm(smartHome.signalisation.getState()));
    }

    static boolean isInstanceOfAlarm(State state) {
        return (state instanceof Alarm);
    }


    static boolean isInstanceOfDeactivated(State state) {
        return (state instanceof SignalisationDeactivated);
    }
}

