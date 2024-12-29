import java.util.Scanner;

public class Mortgage {
   private int max;
   private int min;
   private String prompt;

    public Mortgage(int max, int min, String prompt) {
        setMax(max);
        setMin(min);
        setPrompt(prompt);
    }

    private void setMax(int max) {
        this.max = max;
    }

    private void setMin(int min) {
        this.min = min;
    }

    private void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public double mortgageQuestions() {
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

}
