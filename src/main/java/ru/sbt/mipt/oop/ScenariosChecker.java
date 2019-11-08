package ru.sbt.mipt.oop;

public class ScenariosChecker {
    public static void check(SensorEvent event,SmartHome smartHome) {
        for (ScenarioTypes type : ScenarioTypes.values()) {
            Scenarios scenario = type.getScenario();
            scenario.run(event, smartHome);
        }
    }
}
