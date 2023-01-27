package org.example;

public class BonusService {
    public int calculate(int Amount, boolean Registered) {
        // Тест на околограничные значения для зарегистированного не проходил из-за неудачного написания метода
        // BonusService, который неправильно округлял частное при подсчёте Bonus.
        int Percent = Registered ? 3 : 1;
        int Bonus = (int) Math.round(Amount * Percent/ 100); //я гуманитарий, отстаньте, пожалуйста
        int Limit = 500;
        if (Bonus > Limit) {
            Bonus = Limit;
        }
        return Bonus;
    }
}
