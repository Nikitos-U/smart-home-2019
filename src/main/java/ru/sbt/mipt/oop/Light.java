package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class Light implements Actionable{
    private boolean isOn;
    private final String id;

    public Light(String id, boolean isOn) {
        this.id = id;
        this.isOn = isOn;
    }

    public boolean isOn() {
        return isOn;
    }

    String getId() {
        return id;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    @Override
    public boolean execute(SensorEvent event) {
        if (this.id.equals(event.getObjectId())) {
            if (event.getType() == LIGHT_ON) {
                this.setOn(true);
                System.out.print("Light " + this.id + " was turned on");
                return true;
            } else {
                this.setOn(false);
                System.out.print("Light " + this.id + " was turned off");
                return true;
            }
        }
        return false;
    }
}
