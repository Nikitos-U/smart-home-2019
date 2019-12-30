package ru.sbt.mipt.oop.signalisation;

import ru.sbt.mipt.oop.SensorEvents.SensorEvent;

public class Alarm implements SignalisationState {
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
    public void deactivate(SensorEvent event) {
        if (signalisation.secretCodeChecker(event.getSecretCode())) {
            signalisation.setState(new SignalisationDeactivated(signalisation));
            System.out.println("Right password signalisation deactivated");
        } else {
            System.out.println("Alarm activated, tikay s sela");
        }
    }

    @Override
    public void toAlarmState() {
        System.out.println("Alarm activated, tikay s sela");
    }

}
