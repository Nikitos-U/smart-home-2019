package ru.sbt.mipt.oop.remoteControlManagment.commands;

import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome;

public class TurnOnHallLightsCommand implements RCCommandInterface {
    private SmartHome smartHome;

    public TurnOnHallLightsCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.execute( o -> {
            if (o instanceof Room && ((Room) o).getName().equals("hall")) {
                ((Room) o).execute(o1 -> {
                    if (o1 instanceof Light) {
                        ((Light) o1).setOn(true);
                    }
                });
                System.out.println("Hall lights were turned on by remote control");
            }
        });
    }
}
