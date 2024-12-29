import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var principal = (int) new Mortgage(1000_000, 1000, "Principal").mortgageQuestions();
        var rate = (float) new Mortgage(10, 0, "Annual Interest Rate: ").mortgageQuestions();
        var period = (int) new Mortgage(30, 0, "Period").mortgageQuestions();
        var report = new Report(principal, period, rate);
        report.printMortgage();
        report.printSchedule();
    }

}