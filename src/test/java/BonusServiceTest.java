package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BonusServiceTest {

    @Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService Service = new BonusService();

        // подготавливаем данные:
        long Amount = 1000;
        boolean Registered = true;
        long Expected = 30;

        // вызываем целевой метод:
        long Actual = Service.calculate(Amount, Registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(Expected, Actual);
    }

    @Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService Service = new BonusService();

        // подготавливаем данные:
        long Amount = 1_000_000;
        boolean Registered = true;
        long Expected = 500;

        // вызываем целевой метод:
        long Actual = Service.calculate(Amount, Registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(Expected, Actual);
    }

    @Test //проверка для незарегистрированных юзеров ниже лимита
    void shouldCalculateForBomzhAndUnderLimit() {
        BonusService Service = new BonusService();

        // подготавливаем данные:
        long Amount = 1000;
        boolean Registered = false;
        long Expected = 10;

        // вызываем целевой метод:
        long Actual = Service.calculate(Amount, Registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(Expected, Actual);
    }

    @Test //проверка для незарегистрированных юзеров выше лимита
    void shouldCalculateForBomzhAndOverLimit() {
        BonusService Service = new BonusService();

        // подготавливаем данные:
        long Amount = 1_000_000;
        boolean Registered = false;
        long Expected = 500;

        // вызываем целевой метод:
        long Actual = Service.calculate(Amount, Registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(Expected, Actual);
    }

    @Test //проверка Integer в assertEquals
    void shouldCalculateForIntWithLongInput() {
        BonusService Service = new BonusService();

        // подготавливаем данные:
        long Amount = 1_000_000;
        boolean Registered = false;
        long Expected = 500;

        // вызываем целевой метод:
        long Actual = Service.calculate(Amount, Registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(Actual, Expected);
    }

    @Test //проверка Integer в assertEquals
    void shouldCalculateBonusAroundLimit4Registered() {
        BonusService Service = new BonusService();

        // подготавливаем данные:
        long Amount = 16_666;
        boolean Registered = true;
        long Expected = 499;

        // вызываем целевой метод:
        long Actual = Service.calculate(Amount, Registered);

        System.out.println("Подсчитанный бонус для зарегистрированного: " + Actual + " руб.");

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(Actual, Expected);
    }

    @Test //проверка Integer в assertEquals
    void shouldCalculateBonusAroundLimit4Bomzh() {
        BonusService Service = new BonusService();

        // подготавливаем данные:
        long Amount = 49_987;
        boolean Registered = true;
        long Expected = 500;

        // вызываем целевой метод:
        long Actual = Service.calculate(Amount, Registered);

        System.out.println("Подсчитанный бонус для незарегистрированного: " + Actual + " руб.");

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(Actual, Expected);
    }
}

