package hu.terray.AlgorithmPractice;

public class SquareRootCalculator {
    public static void calculateSquareRoot(double numberToCountSquareRootFor) throws IllegalArgumentException {
        if (numberToCountSquareRootFor < 0) {
            throw new IllegalArgumentException("Argument should be not negative");
        }
        System.out.println("Square root:" + Math.sqrt(numberToCountSquareRootFor));
    }
}
