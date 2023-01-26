package org.example;

public class BonusService {
    public long calculate(long Amount, boolean Registered) {
        int Percent = Registered ? 3 : 1;
        long Bonus = (Amount / 100) * Percent; //я гуманитарий, отстаньте, пожалуйста
        long Limit = 500;
        if (Bonus > Limit) {
            Bonus = Limit;
        }
        return Bonus;
    }
}
