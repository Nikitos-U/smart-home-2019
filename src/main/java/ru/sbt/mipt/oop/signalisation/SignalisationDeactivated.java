package ru.sbt.mipt.oop.signalisation;

import ru.sbt.mipt.oop.SensorEvents.SensorEvent;

public class SignalisationDeactivated implements SignalisationState {
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
    public void deactivate(SensorEvent event) {
        System.out.println("Signalisation already deactivated");
    }

    @Override
    public void toAlarmState() {
        signalisation.setState(new Alarm(signalisation));
    }

}
