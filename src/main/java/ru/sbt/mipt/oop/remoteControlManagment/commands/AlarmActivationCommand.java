package ru.sbt.mipt.oop.remoteControlManagment.commands;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.signalisation.Signalisation;

public class AlarmActivationCommand implements RCCommandInterface {
    private SmartHome smartHome;
    public AlarmActivationCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.execute(o -> {
            if (o instanceof Signalisation){
                ((Signalisation) o).toAlarmState();
                System.out.println("NU VSE ALARM OT RC POEHAL");
            }
        });
    }
}
