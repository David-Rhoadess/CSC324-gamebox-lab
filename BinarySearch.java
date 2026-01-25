import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println("Welcome to word guessing game! Pick a integer from 1 to 100.");
           
        int lower = 1;
        int higher = 100;
        int mid;
        Scanner scanner = new Scanner(System.in);

        while (lower <= higher) {
            mid = lower + (higher - lower) / 2;
            System.out.println("Is this the number you think of? " + mid);
            System.out.println("Enter equal, up, or down");
            char userInput = scanner.next().charAt(0);
            if (userInput == 'e') {
                System.out.println("Your number is " + mid);
                break;
            } else if (userInput == 'u') {
                lower = mid + 1;
            } else if (userInput == 'd') {
                higher = mid - 1;
            } else {
                System.out.println("Please enter equal, up, or down");
            }
        }
        scanner.close();
    }
}
