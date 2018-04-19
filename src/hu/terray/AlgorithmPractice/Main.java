package hu.terray.AlgorithmPractice;

public class Main {

    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println("Hello " + args[0] + "!");
        }
        /*
        Scanner commandInput = new Scanner(System.in);
        System.out.print("Write input, please ;) : ");
        String inputArgument = commandInput.next();
        */

        String str = "123456";
        String str2 = "123";
        String str3 = "123456123";
        System.out.println(StringExercices.isShuffleOfStringsPreservedOrderRecursive(str, str2, str3));
    }


}
