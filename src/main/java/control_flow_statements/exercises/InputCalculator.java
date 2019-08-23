package control_flow_statements.exercises;

import java.util.Scanner;

public class InputCalculator {
    public static void inputThenPrintSumAndAverage() {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int sum = 0;
        long avg = 0;
        while (true) {
            String s = scanner.next();
            count++;
            try {
                sum += Integer.parseInt(s);
            } catch (NumberFormatException e) {
                if (sum != 0) {
                    avg = Math.round((double) sum / --count);
                }
                System.out.println(String.format("SUM = %s AVG = %s", sum, avg));
                scanner.close();
                break;
            }
        }
    }

    public static void main(String[] args) {
        inputThenPrintSumAndAverage();
    }
}
