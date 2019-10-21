package ru.sbt.mipt.oop;

import java.util.Collection;

public class Room implements Actionable{
    private static Collection<Light> lights;
    private static Collection<Door> doors;
    private static String name;

    public Room(Collection<Light> lights, Collection<Door> doors, String name) {
        this.lights = lights;
        this.doors = doors;
        this.name = name;
    }

    public Collection<Light> getLights() {
        return lights;
    }

    public Collection<Door> getDoors() {
        return doors;
    }

    public static String getName(String objectId) {
        for (Door door : doors) {
            if (door.getId().equals(objectId)) {
                return name;
            }
        }
        return null;
    }

    @Override
    public void execute(SensorEvent event) {
        for (Light light : lights) {
            light.execute(event);
        }
        for (Door door : doors) {
            door.execute(event);
        }
    }
}
