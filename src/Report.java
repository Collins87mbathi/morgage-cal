import java.text.NumberFormat;

public class Report {
    private int principal;
    private int period;
    private float rate;
    private final byte MONTHS_IN_YEAR = 12;
    private final byte PERCENT = 100;
    public Report(int principal, int period, float rate) {
        setPrincipal(principal);
        setPeriod(period);
        setRate(rate);
    }

    private void setPeriod(int period) {
        this.period = period;
    }

    private void setPrincipal(int principal) {
        this.principal = principal;
    }

    private void setRate(float rate) {
        this.rate = rate;
    }

    public void printSchedule() {
        for (int months = 1; months <= period * MONTHS_IN_YEAR; months++) {
            float balance = (float) calculateBalance(months);
            System.out.println(balance);
        }
    }

    public void printMortgage() {
        String mortgage = calculateMortgage();
        System.out.println("MORTGAGE :");
        System.out.println("_______");
        System.out.println("Monthly payment" + mortgage);
        System.out.println("Balances: " + mortgage);
    }

    private String calculateMortgage() {
        int lastPeriod = period * MONTHS_IN_YEAR;
        float lastRate =  (rate/PERCENT)/MONTHS_IN_YEAR;
        double firstExpression = lastRate * Math.pow(1+lastRate, lastPeriod);
        double secondExpression = Math.pow(1+lastRate, lastPeriod) - 1;
        double expression = firstExpression/secondExpression;
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(principal * expression);
    }

    private double calculateBalance(int month) {
        int lastPeriod = period * MONTHS_IN_YEAR;
        float lastRate =  (rate/PERCENT)/MONTHS_IN_YEAR;
        return principal * (Math.pow(1+lastRate, lastPeriod) - Math.pow(1+lastRate, month))/ (Math.pow(1+lastRate, lastPeriod) - 1);
    }
}
