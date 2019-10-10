package ru.sbt.mipt.oop;

import java.io.IOException;

public class Application {

    public static void main(String... args) throws IOException {
        // считываем состояние дома из файла
        SmartHome smartHome = HomeCondition.readHomeCondition();
        // начинаем цикл обработки событий
        EventManager.processEvent(smartHome);
    }
}
