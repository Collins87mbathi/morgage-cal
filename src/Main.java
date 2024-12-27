import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
         int principal = (int) mortgage("Principal", 1000_000, 1000);
         float rate = (float) mortgage("Annual Interest Rate: ", 10, 0);
         int period = (int) mortgage("Period:", 30, 0);

        String mortgage = calculateMortgage(principal, period, rate);
        System.out.println(mortgage);
    }

    public static double mortgage(String prompt, int max, int min) {
        Scanner scanner = new Scanner(System.in);
        double value = 0;
        while(true) {
            System.out.println(prompt);
            value = scanner.nextDouble();
            if (value > min && value <= max){
                break;
            }
            System.out.println("enter a period between" + " " +  min + " " + "and" +  " " + max);
        }
        return value;
    };

    public static String calculateMortgage(long principal, int period, float rate) {
        byte MONTHS_IN_YEAR = 12;
        byte PERCENT = 100;
        int lastPeriod = period * MONTHS_IN_YEAR;
        float lastRate =  (rate/PERCENT)/MONTHS_IN_YEAR;
        double firstExpression = lastRate * Math.pow(1+lastRate, lastPeriod);
        double secondExpression = Math.pow(1+lastRate, lastPeriod) - 1;
        double expression = firstExpression/secondExpression;
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String mor = currency.format(principal * expression);
        return  mor;
    }
}