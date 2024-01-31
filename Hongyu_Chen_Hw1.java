import java.util.Scanner;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Homework1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Question 2:
        System.out.println("Question 2:");
        printMultiplicationTable();

        // Question 3:
        System.out.println("Question 3:");
        System.out.print("Enter a string (or 'q' to quit): ");
        String input = scanner.nextLine();
        while (!input.equalsIgnoreCase("q")) {
            if (isPalindrome(input)) {
                System.out.println("The string '" + input + "' is a palindrome.");
            } else {
                System.out.println("The string '" + input + "' is not a palindrome.");
            }
            System.out.print("Enter a string (or 'q' to quit): ");
            input = scanner.nextLine();
        }
        System.out.println("Goodbye!");

        // Question 4:
        System.out.println("\nQuestion 4:");
        System.out.print("Enter the first list(in the format: [a,b,c], [1,2,3]): ");
        String inputList1 = scanner.nextLine();
        System.out.print("Enter the second list(in the format: [a,b,c], [1,2,3]): ");
        String inputList2 = scanner.nextLine();
        List<String> combinedList = combineLists(inputList1, inputList2);
        if (combinedList == null) {
            System.out.println("Error: Lists are not of equal length.");
        } else {
            System.out.println("Combined list: " + combinedList);
        }

        // Question 5:
        System.out.println("\nQuestion 5:");
        for (int i = 1; i <= 100; i++) {
            System.out.print(fibonacci(i) + " ");
        }

        // Question 6:
        System.out.println("\n\nQuestion 6:");
        System.out.print("Enter a year: ");
        int year = scanner.nextInt();

        if (isLeapYear(year)) {
            System.out.println(year + " is a leap year.");
        } else {
            System.out.println(year + " is not a leap year.");
        }

        scanner.close();
    }

    // Question 2
    private static void printMultiplicationTable() {
        System.out.println("a multiplication table for numbers up to 12:");
        for (int i = 0; i <= 13; i++) {
            for (int j = 0; j <= 13; j++) {
                if (i == 0 && j == 0) {
                    System.out.printf("%4s", "");
                } else if (i == 0) {
                    System.out.printf("%4d", j - 1);
                } else if (j == 0) {
                    System.out.printf("%4d", i - 1);
                } else {
                    System.out.printf("%4d", (i - 1) * (j - 1));
                }
            }
            System.out.println();
        }
        System.out.println();
    }    
    
    // Question 3
    private static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    // Question 4
    private static List<String> combineLists(String inputString1, String inputString2) {
        List<String> combinedList = new ArrayList<>();

        // Remove brackets and split by commas
        String[] input1 = inputString1.replaceAll("\\[|\\]", "").split(",");
        String[] input2 = inputString2.replaceAll("\\[|\\]", "").split(",");

        if (input1.length != input2.length) {
            return null;
        }

        // Combine elements
        for (int i = 0; i < input1.length; i++) {
            combinedList.add(input1[i].trim());
            combinedList.add(input2[i].trim());
        }

        return combinedList;
    }

    // Question 5
    private static BigInteger fibonacci(int n) {
        if (n <= 2) {
            return BigInteger.ONE;
        } else {
            BigInteger fib1 = BigInteger.ONE;
            BigInteger fib2 = BigInteger.ONE;
            BigInteger fib = BigInteger.ZERO;
    
            for (int i = 3; i <= n; i++) {
                fib = fib1.add(fib2);
                fib1 = fib2;
                fib2 = fib;
            }
    
            return fib;
        }
    }    

    // Question 6
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
