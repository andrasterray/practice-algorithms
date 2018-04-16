package hu.terray.AlgorithmPractice;

/**
 * Class with one static method to divide the first argument with the second.
 */
public class DivideTwoNumbers {

    /**
     * Dividing the first argument with the second.
     *
     * @param toBeDivided number to divide with the divisor
     * @param divisor     number to divise the first argument with
     * @throws IllegalArgumentException Thrown when the divisor is 0
     */
    public static void divider(int toBeDivided, int divisor) throws IllegalArgumentException {
        if (divisor == 0) {
            throw new IllegalArgumentException("Argument 'divisor' is 0");
        }
        System.out.println("Result for " + toBeDivided + "/" + divisor + " = " + toBeDivided / divisor);
    }
}
