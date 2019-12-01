package ru.sbt.mipt.oop.signalisation;

import ru.sbt.mipt.oop.*;

public class Signalisation implements Actionable {
    private State state;
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

    void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void activate(String secretCode) {
        state.activate(secretCode);
    }

    public void deactivate(String secretCode) {
        state.deactivate(secretCode);
    }

    public void toAlarmState() {
        state.toAlarmState(secretCode);
    }

    boolean secretCodeChecker(String secretCode) {
        return secretCode.equals(this.secretCode);
    }


    @Override
    public void execute(Action action) {
        action.execute(this);
    }
}
