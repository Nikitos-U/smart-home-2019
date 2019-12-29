package ru.sbt.mipt.oop;

public class Application {

    public static void main(String... args){
        // считываем состояние дома из файла
        ReadHomeState reader = new ReadHomeStateFromFile();
        SmartHome smartHome = reader.readCondition();
        // начинаем цикл обработки событий;
        EventProcessor.process(smartHome);
    }
}
