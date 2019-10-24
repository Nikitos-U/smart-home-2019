package ru.sbt.mipt.oop;

import java.util.Collection;

public class Room implements Actionable{
    private  Collection<Light> lights;
    private  Collection<Door> doors;
    private  String name;

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

    public  String getName(){
        return name;
    }

    @Override
    public boolean execute(SensorEvent event) {
        for (Light light : lights) {
            if(light.execute(event)){
                System.out.println(", that happened in " + this.name);
            }
        }
        for (Door door : doors) {
            if(door.execute(event)){
                System.out.println(", that happened in " + this.name);
            }
        }
        return false;
    }
}
