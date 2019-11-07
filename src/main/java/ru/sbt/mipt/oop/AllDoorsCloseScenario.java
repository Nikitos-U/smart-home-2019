package ru.sbt.mipt.oop;

class AllDoorsCloseScenario implements Scenarios {
    public void run(SmartHome smartHome, Room room){
        if (room.getName().equals("hall")) {
            for (Room homeRoom : smartHome.getRooms()) {
                for (Light light : homeRoom.getLights()) {
                    light.setOn(false);
                    SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
                    CommandManager.sendCommand(command);
                }
            }
        }
    }
}
