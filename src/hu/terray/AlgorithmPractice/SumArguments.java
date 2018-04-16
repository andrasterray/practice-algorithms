package hu.terray.AlgorithmPractice;

/**
 * Class with one static method to sum int array and print the result to stdout.
 * A bit out of SRP :)
 */
public class SumArguments {
    public static void sumIntArgs(int[] numbersToSum){
        int sum = 0;
        for(int numberToAdd: numbersToSum){
            sum += numberToAdd;
        }
        System.out.println(sum);
    }
}
