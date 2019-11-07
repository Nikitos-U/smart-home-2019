package ru.sbt.mipt.oop;

class AllDoorsCloseScenario implements EventHandler {
    @Override
    public void run(SensorEventType type, String objectId, SmartHome smartHome) {
        for (Room room: smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(objectId)) {
                    if (room.getName().equals("hall")) {
                        if (type.equals(SensorEventType.DOOR_CLOSED)) {
                            for (Room homeRoom : smartHome.getRooms()) {
                                for (Light light : homeRoom.getLights()) {
                                    light.setOn(false);
                                    System.out.println("Light " + light.getId() + " in room " + homeRoom.getName() + " was turned off.");
                                    SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
                                    CommandManager.sendCommand(command);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
