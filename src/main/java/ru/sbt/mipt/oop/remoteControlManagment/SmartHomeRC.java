package ru.sbt.mipt.oop.remoteControlManagment;
import ru.sbt.mipt.oop.rc.RemoteControl;
import ru.sbt.mipt.oop.remoteControlManagment.commands.RCCommandInterface;

import java.util.HashMap;
import java.util.Map;

public class SmartHomeRC implements RemoteControl {
    private final Map<String, RCCommandInterface> commands = new HashMap<>();
    private String rcId;

    public SmartHomeRC(String rcId){
        this.rcId = rcId;
    }

    public void addCommand(String buttonCode, RCCommandInterface command) {
        commands.put(buttonCode, command);
    }

    @Override
    public void onButtonPressed(String buttonCode, String rcId) {
        if (rcId.equals(this.rcId) && commands.containsKey(buttonCode)){
            commands.get(buttonCode).execute();
        }
    }
}