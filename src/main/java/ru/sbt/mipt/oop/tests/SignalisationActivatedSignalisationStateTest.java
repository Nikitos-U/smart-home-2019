package ru.sbt.mipt.oop.tests;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.*;
import ru.sbt.mipt.oop.SensorEvents.AlarmSensorEvent;
import ru.sbt.mipt.oop.SensorEvents.SensorEvent;
import ru.sbt.mipt.oop.eventHandlers.AlarmEventHandler;
import ru.sbt.mipt.oop.signalisation.Alarm;
import ru.sbt.mipt.oop.signalisation.SignalisationDeactivated;
import ru.sbt.mipt.oop.signalisation.SignalisationState;



public class SignalisationActivatedSignalisationStateTest {
    private static AlarmEventHandler alarmEventHandler;
    private static SmartHome smartHome;

    @BeforeAll
    static void preparations() {
        smartHome = new SmartHome();
        SensorEvent activationEvent = new AlarmSensorEvent(SensorEventType.ALARM_ACTIVATE, null, "correct password");
        smartHome.getSignalisation().activate(activationEvent.getSecretCode());
        alarmEventHandler = new AlarmEventHandler(smartHome);
    }

    @Test
    void testDeactivatedEventCorrectPassword() {
        SensorEvent correctPasswordDeactivation = new AlarmSensorEvent(SensorEventType.ALARM_DEACTIVATE, "12", "correct password");
        alarmEventHandler.handle(correctPasswordDeactivation);
        Assert.assertTrue(isInstanceOfDeactivated(smartHome.getSignalisation().getState()));
    }

    @Test
    void testDeactivatingEventWrongPassword() {
        SensorEvent wrongPasswordDeactivation = new AlarmSensorEvent(SensorEventType.ALARM_DEACTIVATE,null,"wrong password");
        alarmEventHandler.handle(wrongPasswordDeactivation);
        Assert.assertTrue(isInstanceOfAlarm(smartHome.getSignalisation().getState()));
    }

    static boolean isInstanceOfAlarm(SignalisationState state) {
        return (state instanceof Alarm);
    }


    static boolean isInstanceOfDeactivated(SignalisationState state) {
        return (state instanceof SignalisationDeactivated);
    }
}

