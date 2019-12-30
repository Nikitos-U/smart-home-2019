package ru.sbt.mipt.oop.remoteControlManagment.commands;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.signalisation.Signalisation;

public class SignalisationActivationCommand implements RCCommandInterface {
    private SmartHome smartHome;

    public SignalisationActivationCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.execute(o -> {
            if (o instanceof Signalisation){
                ((Signalisation) o).activate("Some secret code");
                System.out.println("Signalisation was activated using rc");
            }
        });
    }
}
