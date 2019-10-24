package ru.sbt.mipt.oop;

import java.io.IOException;

public class Application {

    public static void main(String... args) throws IOException {
        // считываем состояние дома из файла
        HomeCondition reader = new HomeConditionFromFile();
        SmartHome smartHome = reader.readCondition();
        // начинаем цикл обработки событий;
        System.out.println(smartHome.getRooms() + "OLOLOLOLOLO");
        EventManager.processEvent(smartHome);
    }
}
