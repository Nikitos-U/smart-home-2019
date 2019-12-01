package ru.sbt.mipt.oop.signalisation;

import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SensorEventType;

public class SignalisationDeactivated implements State {
    private  Signalisation signalisation;

    public SignalisationDeactivated(Signalisation signalisation) {
        this.signalisation = signalisation;
    }

    @Override
    public void activate(String someCode) {
        signalisation.setSecretCode(someCode);
        signalisation.setState(new SignalisationActivated(signalisation));
        System.out.println("Signalisation activated");
    }

    @Override
    public void deactivate(String secretCode) {
        System.out.println("Signalisation already deactivated");
    }

    @Override
    public void toAlarmState(String secretCode) {
        signalisation.setState(new Alarm(signalisation));
    }

}
