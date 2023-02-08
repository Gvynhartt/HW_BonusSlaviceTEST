package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class BonusServiceTest {

    @ParameterizedTest // для зарегистрированных и ниже лимита
        @CsvFileSource(resources ="/data.csv")

    void shouldCalculateForRegisteredAndUnderLimit(int Amount, int Expected, boolean Registered) {
        BonusService Service = new BonusService();

        // подготавливаем данные:
        //int Amount = 1000;
        //boolean Registered = true;
        //int Expected = 30;

        // вызываем целевой метод:
        int Actual = Service.calculate(Amount, Registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(Expected, Actual);
    }

    @ParameterizedTest // для зарегистрированных и выше лимита
        @CsvFileSource(resources ="/data.csv")
    void shouldCalculateForRegisteredAndOverLimit(int Amount, int Expected, boolean Registered) {
        BonusService Service = new BonusService();

        // подготавливаем данные:
        // int Amount = 1_000_000;
        // boolean Registered = true;
        // int Expected = 500;

        // вызываем целевой метод:
        int Actual = Service.calculate(Amount, Registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(Expected, Actual);
    }

    @ParameterizedTest //проверка для незарегистрированных юзеров ниже лимита
        @CsvFileSource(resources ="/data.csv")
    void shouldCalculateForBomzhAndUnderLimit(int Amount, int Expected, boolean Registered) {
        BonusService Service = new BonusService();

        // подготавливаем данные:
        // int Amount = 1000;
        // boolean Registered = false;
        // int Expected = 10;

        // вызываем целевой метод:
        int Actual = Service.calculate(Amount, Registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(Expected, Actual);
    }

    @ParameterizedTest //проверка для незарегистрированных юзеров выше лимита
     @CsvFileSource(resources = "/data.csv")
    void shouldCalculateForBomzhAndOverLimit(int Amount, int Expected, boolean Registered) {
        BonusService Service = new BonusService();

        // подготавливаем данные:
        // int Amount = 1_000_000;
        // boolean Registered = false;
        // int Expected = 500;

        // вызываем целевой метод:
        int Actual = Service.calculate(Amount, Registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(Expected, Actual);
    }

    @ParameterizedTest //проверка Integer в assertEquals
        @CsvFileSource(resources = "/data.csv")
    void shouldCalculateForIntWithLongInput(int Amount, int Expected, boolean Registered) {
        BonusService Service = new BonusService();

        // подготавливаем данные:
        // int Amount = 1_000_000;
        // boolean Registered = false;
        // int Expected = 500;

        // вызываем целевой метод:
        int Actual = Service.calculate(Amount, Registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(Actual, Expected);
    }

    @ParameterizedTest // проверка околограничных значений при подсчёте в Bonus service при регистрации
        @CsvFileSource(resources = "/data.csv")
    void shouldCalculateBonusAroundLimit4Registered(int Amount, int Expected, boolean Registered) {
        BonusService Service = new BonusService();

        // подготавливаем данные:
        //int Amount = 16_666;
        //boolean Registered = true;
        //int Expected = 499;

        // вызываем целевой метод:
        int Actual = Service.calculate(Amount, Registered);

        System.out.println("Подсчитанный бонус для зарегистрированного: " + Actual + " руб.");

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(Actual, Expected);
    }

    @ParameterizedTest // проверка околограничных значений при подсчёте в Bonus service без регистрации
        @CsvFileSource(resources = "/data.csv")
    void shouldCalculateBonusAroundLimit4Bomzh(int Amount, int Expected, boolean Registered) {
        BonusService Service = new BonusService();

        // подготавливаем данные:
        // int Amount = 49_987;
        // boolean Registered = true;
        // int Expected = 500;

        // вызываем целевой метод:
        int Actual = Service.calculate(Amount, Registered);

        System.out.println("Подсчитанный бонус для незарегистрированного: " + Actual + " руб.");

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(Actual, Expected);
    }
}

