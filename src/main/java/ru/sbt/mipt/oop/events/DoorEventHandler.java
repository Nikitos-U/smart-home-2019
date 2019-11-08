package ru.sbt.mipt.oop.events;

import ru.sbt.mipt.oop.*;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class DoorEventHandler implements EventHandler {
    public DoorEventHandler() {
        super();
    }
    @Override
    public void run(SensorEventType type, String objectId, SmartHome smartHome){
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(objectId)) {
                    if (type == DOOR_OPEN) {
                        door.setOpen(true);
                        System.out.println("Door " + door.getId() + " in room " + room.getName() + " was opened.");
                    } else {
                        door.setOpen(false);
                        System.out.println("Door " + door.getId() + " in room " + room.getName() + " was closed.");
                        // если мы получили событие о закрытие двери в холле - это значит, что была закрыта входная дверь.
                        // в этом случае мы хотим автоматически выключить свет во всем доме (это же умный дом!)
                        for (ScenarioTypes value : ScenarioTypes.values()) {
                            Scenarios scenario = value.getScenario();
                            scenario.run(smartHome,room);
                        }
                    }
                }
            }
        }
    }
}
