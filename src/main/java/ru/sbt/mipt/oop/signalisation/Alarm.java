package ru.sbt.mipt.oop.signalisation;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.Actionable;
import ru.sbt.mipt.oop.SensorEvent;

public class Alarm implements State {
    public Signalisation signalisation;

    public Alarm(Signalisation signalisation) {
        this.signalisation = signalisation;
    }

    @Override
    public void activate(String someCode) {
        if (signalisation.secretCodeChecker(someCode)) {
            signalisation.setState(new SignalisationActivated(signalisation));
        } else {
            System.out.println("Alarm activated, tikay s sela");
        }
    }


    @Override
    public void deactivate(String someCode) {
        if (signalisation.secretCodeChecker(someCode)) {
            signalisation.setState(new SignalisationDeactivated(signalisation));
        } else {
            System.out.println("Alarm activated, tikay s sela");
        }
    }

    @Override
    public void toAlarmState(String secretCode) {
        System.out.println("Alarm activated, tikay s sela");
    }

}
