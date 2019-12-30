package ru.sbt.mipt.oop.tests;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.*;
import ru.sbt.mipt.oop.SensorEvents.AlarmSensorEvent;
import ru.sbt.mipt.oop.SensorEvents.SensorEvent;
import ru.sbt.mipt.oop.eventHandlers.AlarmEventHandler;
import ru.sbt.mipt.oop.signalisation.SignalisationActivated;
import ru.sbt.mipt.oop.signalisation.SignalisationDeactivated;
import ru.sbt.mipt.oop.signalisation.SignalisationState;



public class SignalisationDeactivatedSignalisationStateTest {
    private static AlarmEventHandler alarmEventHandler;
    private static SmartHome smartHome;

    @BeforeAll
    static void preparations() {
        smartHome = new SmartHome();
        alarmEventHandler = new AlarmEventHandler(smartHome);
    }

    @Test
    void testActivatingEvent() {
        SensorEvent activatingEvent = new AlarmSensorEvent(SensorEventType.ALARM_ACTIVATE,null,"some password");
        alarmEventHandler.handle(activatingEvent);
        Assert.assertTrue(isInstanceOfActivated(smartHome.getSignalisation().getState()));
    }

    @Test
    void testDeactivatingEvent() {
        SensorEvent correctPasswordDeactivation = new AlarmSensorEvent(SensorEventType.ALARM_DEACTIVATE, "12", "some password");
        alarmEventHandler.handle(correctPasswordDeactivation);
        System.out.println(smartHome.getSignalisation().getState().toString());
        Assert.assertTrue(isInstanceOfDeactivated(smartHome.getSignalisation().getState()));
    }

    static boolean isInstanceOfActivated(SignalisationState state) {
        return (state instanceof SignalisationActivated);
    }


    static boolean isInstanceOfDeactivated(SignalisationState state) {
        return (state instanceof SignalisationDeactivated);
    }
}

