package ru.sbt.mipt.oop;

public enum ScenarioTypes {
    CloseAllDoors(new AllDoorsCloseScenario());
    Scenarios scenario;

    public Scenarios getScenario() {
        return scenario;
    }

    ScenarioTypes(Scenarios scenario) {
        this.scenario = scenario;
    }
}

