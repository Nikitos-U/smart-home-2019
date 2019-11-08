package ru.sbt.mipt.oop.signalisation;

public class SignalisationDeactivated extends State {
    public SignalisationDeactivated(Signalisation signalisation) {
        super(signalisation);
    }

    @Override
    void activate(String secretCode) {

    }

    @Override
    void deactivate() {

    }

    @Override
    void toAlarmState() {

    }
}
