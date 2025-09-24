public class ExceptionHandling {
    public static void main(String[] args) {
        System.out.println("Exception Handling in Java");
        int a = 10;
        int b = 0;
        try {
            int c = a / b; // this will throw ArithmeticException
            System.out.println("Result: " + c);
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero");
        } finally {
            System.out.println("This block is always executed");
        }
        System.out.println("End of program");
    }
}
