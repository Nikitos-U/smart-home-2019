package ru.sbt.mipt.oop.signalisation;

import ru.sbt.mipt.oop.*;
import ru.sbt.mipt.oop.SensorEvents.SensorEvent;

public class Signalisation implements Actionable {
    private SignalisationState state;
    private String secretCode = "";

    public Signalisation() {
        this.state = new SignalisationDeactivated(this);
        this.secretCode = "";
    }

    public String getSecretCode() {
        return secretCode;
    }

    void setSecretCode(String secretCode) {
        this.secretCode = secretCode;
    }

    void setState(SignalisationState state) {
        this.state = state;
    }

    public SignalisationState getState() {
        return state;
    }

    public void activate(String secretCode) {
        state.activate(secretCode);
    }

    public void deactivate(SensorEvent event) {
        state.deactivate(event);
    }

    public void toAlarmState() {
        state.toAlarmState();
    }

    boolean secretCodeChecker(String secretCode) {
        return secretCode.equals(this.secretCode);
    }


    @Override
    public void execute(Action action) {
        action.execute(this);
    }
}
