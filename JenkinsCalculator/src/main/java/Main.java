import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        System.out.println("Welcome to xX_Uncle_D3w's_Xx calculator");

        System.out.println("Enter a command:");

        Scanner in = new Scanner(System.in);
        Calculator calculator = new Calculator();

        boolean run = true;
        while (run) {
            String func = in.next();
            if (func.equals("add")) {
                int a = in.nextInt();
                int b = in.nextInt();
                System.out.println(calculator.add(a, b));
            } else if (func.equals("subtract")) {
                int a = in.nextInt();
                int b = in.nextInt();
                System.out.println(calculator.subtract(a, b));
            } else if (func.equals("multiply")) {
                int a = in.nextInt();
                int b = in.nextInt();
                System.out.println(calculator.multiply(a, b));
            } else if (func.equals("divide")) {
                int a = in.nextInt();
                int b = in.nextInt();
                System.out.println(calculator.divide(a, b));
            } else if (func.equals("fibonacciNumberFinder")) {
                int a = in.nextInt();
                System.out.println(calculator.fibonacciNumberFinder(a));
            } else if (func.equals("intToBinary")) {
                int a = in.nextInt();
                System.out.println(calculator.intToBinaryNumber(a));
            } else if (func.equals("quit")) {
                System.out.println("Goodbye");
                run = false;
            }
        }

    }

}
