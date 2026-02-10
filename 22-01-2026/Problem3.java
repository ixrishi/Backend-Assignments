import java.util.*;

public class Problem3 {

    void factorial(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        System.out.println("Factorial of " + n + " is: " + factorial);
    }

    long add(int addend1, int addend2) {
        return (long) addend1 + (long) addend2;
    }

    boolean isEven(int n) {
        return n % 2 == 0;
    }

    public static void main(String[] args) {
        Problem3 obj = new Problem3();

        try (Scanner sc = new Scanner(System.in)) {

            System.out.println("Enter a positive number to find factorial and check Even/Odd:");
            int n = sc.nextInt();

            if (n < 0) {
                System.out.println("Enter a positive number");
                return;
            }

            obj.factorial(n);
            System.out.println("Sum of 10 and 20 is: " + obj.add(10, 20));
            System.out.println("Is even? " + obj.isEven(n));

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
