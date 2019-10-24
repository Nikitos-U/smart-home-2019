package ru.sbt.mipt.oop.signalisation;
import ru.sbt.mipt.oop.*;

abstract class State {
    protected final Signalisation signalisation;
    public State(Signalisation signalisation) {
        this.signalisation = signalisation;
    }

    abstract void activate(String secretCode);
    abstract void deactivate();
    abstract void toAlarmState();


}
