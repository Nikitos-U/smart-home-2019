package ru.sbt.mipt.oop;

class AllDoorsCloseScenario implements Scenarios {
    @Override
    public void run(SensorEvent event, SmartHome smartHome) {
        for (Room homeRoom : smartHome.getRooms()) {
            if (homeRoom.getName().equals("hall") && homeRoom.getDoors().contains(event.getObjectId()) && event.getType().equals(SensorEventType.DOOR_CLOSED)) {
                for (Room room : smartHome.getRooms()) {
                    for (Light light : homeRoom.getLights()) {
                        light.setOn(false);
                        SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
                        EventManager.sendCommand(command);
                    }
                }
            }
        }
    }
}
