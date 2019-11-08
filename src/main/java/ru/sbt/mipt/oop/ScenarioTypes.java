package ru.sbt.mipt.oop;

public enum ScenarioTypes {
    CLOSE_ALL_DOORS(new AllDoorsCloseScenario());
    Scenarios scenario;

    public Scenarios getScenario() {
        return scenario;
    }

    ScenarioTypes(Scenarios scenario) {
        this.scenario = scenario;
    }
}

