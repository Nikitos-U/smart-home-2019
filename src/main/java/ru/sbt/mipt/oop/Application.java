package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.eventHandlers.AlarmDecorator;

import java.io.IOException;

public class Application {

    public static void main(String... args){
        // считываем состояние дома из файла
        ReadHomeState reader = new ReadHomeStateFromFile();
        SmartHome smartHome = reader.readCondition();
        // начинаем цикл обработки событий;
        EventIterator.iterate(smartHome);
    }
}
