package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BonusServiceTest {

    @Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService Service = new BonusService();

        // подготавливаем данные:
        int Amount = 1000;
        boolean Registered = true;
        int Expected = 30;

        // вызываем целевой метод:
        int Actual = Service.calculate(Amount, Registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(Expected, Actual);
    }

    @Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService Service = new BonusService();

        // подготавливаем данные:
        int Amount = 1_000_000;
        boolean Registered = true;
        int Expected = 500;

        // вызываем целевой метод:
        int Actual = Service.calculate(Amount, Registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(Expected, Actual);
    }

    @Test //проверка для незарегистрированных юзеров ниже лимита
    void shouldCalculateForBomzhAndUnderLimit() {
        BonusService Service = new BonusService();

        // подготавливаем данные:
        int Amount = 1000;
        boolean Registered = false;
        int Expected = 10;

        // вызываем целевой метод:
        int Actual = Service.calculate(Amount, Registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(Expected, Actual);
    }

    @Test //проверка для незарегистрированных юзеров выше лимита
    void shouldCalculateForBomzhAndOverLimit() {
        BonusService Service = new BonusService();

        // подготавливаем данные:
        int Amount = 1_000_000;
        boolean Registered = false;
        int Expected = 500;

        // вызываем целевой метод:
        int Actual = Service.calculate(Amount, Registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(Expected, Actual);
    }

    @Test //проверка Integer в assertEquals
    void shouldCalculateForIntWithLongInput() {
        BonusService Service = new BonusService();

        // подготавливаем данные:
        int Amount = 1_000_000;
        boolean Registered = false;
        int Expected = 500;

        // вызываем целевой метод:
        int Actual = Service.calculate(Amount, Registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(Actual, Expected);
    }

    @Test //проверка околограничных значений при подсчёте в Bonus service при регистрации
    void shouldCalculateBonusAroundLimit4Registered() {
        BonusService Service = new BonusService();

        // подготавливаем данные:
        int Amount = 16_666;
        boolean Registered = true;
        int Expected = 499;

        // вызываем целевой метод:
        int Actual = Service.calculate(Amount, Registered);

        System.out.println("Подсчитанный бонус для зарегистрированного: " + Actual + " руб.");

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(Actual, Expected);
    }

    @Test //проверка околограничных значений при подсчёте в Bonus service без регистрации
    void shouldCalculateBonusAroundLimit4Bomzh() {
        BonusService Service = new BonusService();

        // подготавливаем данные:
        int Amount = 49_987;
        boolean Registered = true;
        int Expected = 500;

        // вызываем целевой метод:
        int Actual = Service.calculate(Amount, Registered);

        System.out.println("Подсчитанный бонус для незарегистрированного: " + Actual + " руб.");

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(Actual, Expected);
    }
}

