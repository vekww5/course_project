package ru.rsatu;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

import java.util.TimeZone;

@QuarkusMain
public class RunProject {
    public static void main(String ... args) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        System.out.println("Запуск проекта");
        Quarkus.run(args);
    }
}
