import java.util.Scanner;

public class DepositCalculator {
    final double yearRate = 0.06;
    final int places = 2;

    double calculateComplexPercent(double amount, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return round(pay);
    }

    double calculateSimplePercent(double amount, int depositPeriod) {
        return round(amount + amount * yearRate * depositPeriod);
    }

    double round(double value) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void calculate() {
        int period;
        int action;

        Scanner input = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:") ;
        int amount = input.nextInt();
        System.out.println("Введите срок вклада в годах:") ;
        period = input.nextInt( );
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = input.nextInt();
        double out = 0;
        if (action == 1) {
            out = calculateSimplePercent(amount, period);
        } else if (action == 2) {
            out = calculateComplexPercent(amount, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + out);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculate();
    }
}
