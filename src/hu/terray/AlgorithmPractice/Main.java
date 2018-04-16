package hu.terray.AlgorithmPractice;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println("Hello " + args[0] + "!");
        }
        Scanner commandInput = new Scanner(System.in);
        System.out.print("Write input, please ;) : ");
        String inputArgument = commandInput.next();

        SquareRootCalculator.calculateSquareRoot(Double.valueOf(inputArgument));
    }
}
