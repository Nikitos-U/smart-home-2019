package ru.sbt.mipt.oop.remoteControlManagment.commands;

import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.SmartHome;

public class AllLightsCommand implements RCCommandInterface {
    private SmartHome smartHome;
    private boolean lightSwitch;

    public AllLightsCommand(SmartHome smartHome, boolean lightSwitch) {
        this.smartHome = smartHome;
        this.lightSwitch = lightSwitch;
    }

    @Override
    public void execute() {
        smartHome.execute(o -> {
            if (o instanceof Light) {
                ((Light) o).setOn(lightSwitch);
                String isOn = lightSwitch ? "on" : "off";
                System.out.println("All lights were turned " + isOn + " by remote control");
            }
        });
    }
}
