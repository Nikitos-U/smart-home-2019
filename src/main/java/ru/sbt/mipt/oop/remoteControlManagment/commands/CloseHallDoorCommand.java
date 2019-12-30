package ru.sbt.mipt.oop.remoteControlManagment.commands;

import ru.sbt.mipt.oop.Door;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome;

public class CloseHallDoorCommand implements RCCommandInterface {
    private SmartHome smartHome;

    public CloseHallDoorCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.execute( o -> {
            if (o instanceof Room && ((Room) o).getName().equals("hall")) {
                ((Room) o).execute(o1 -> {
                    if (o1 instanceof Door) {
                        ((Door) o1).setOpen(false);
                        System.out.println("Hall door was closed by remote control");
                    }
                });
            }
        });
    }
}
