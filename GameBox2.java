import java.util.Scanner;
import java.util.Random;

public class GameBox {
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("      WELCOME TO THE GAME BOX!         ");
        System.out.println("========================================");
        
        boolean playAgain = true;
        
        while (playAgain) {
            displayMenu();
            int choice = getMenuChoice();
            
            switch (choice) {
                case 1:
                    playRockPaperScissors();
                    break;
                case 2:
                    playBinarySearchGuess();
                    break;
                case 3:
                    checkPalindrome();
                    break;
                case 4:
                    System.out.println("\nThanks for playing! Goodbye!");
                    playAgain = false;
                    continue;
                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
            
            if (playAgain) {
                System.out.println("\n========================================");
            }
        }
        
        scanner.close();
    }
    
    private static void displayMenu() {
        System.out.println("\nChoose a game:");
        System.out.println("1. Rock, Paper, Scissors");
        System.out.println("2. Guess My Number (Binary Search)");
        System.out.println("3. Palindrome Number Checker");
        System.out.println("4. Exit");
        System.out.print("\nYour choice: ");
    }
    
    private static int getMenuChoice() {
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.print("Please enter a number: ");
        }
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline
        return choice;
    }
    
    // ===== GAME 1: Rock, Paper, Scissors (biased towards rock) =====
    private static void playRockPaperScissors() {
        System.out.println("\n--- ROCK, PAPER, SCISSORS ---");
        System.out.println("Enter your choice:");
        System.out.println("1 - Rock");
        System.out.println("2 - Paper");
        System.out.println("3 - Scissors");
        System.out.print("Your choice: ");
        
        int playerChoice = getValidChoice(1, 3);
        int computerChoice = getBiasedComputerChoice();
        
        displayChoice("You chose", playerChoice);
        displayChoice("Computer chose", computerChoice);
        
        determineWinner(playerChoice, computerChoice);
    }
    
    private static int getValidChoice(int min, int max) {
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.print("Please enter a number between " + min + " and " + max + ": ");
        }
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        while (choice < min || choice > max) {
            System.out.print("Invalid choice. Enter a number between " + min + " and " + max + ": ");
            while (!scanner.hasNextInt()) {
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();
        }
        return choice;
    }
    
    private static int getBiasedComputerChoice() {
        // Biased towards rock (1)
        // Rock appears 50% of the time, Paper and Scissors each 25%
        int randomValue = random.nextInt(100);
        
        if (randomValue < 50) {
            return 1; // Rock (50% chance)
        } else if (randomValue < 75) {
            return 2; // Paper (25% chance)
        } else {
            return 3; // Scissors (25% chance)
        }
    }
    
    private static void displayChoice(String prefix, int choice) {
        System.out.print(prefix + ": ");
        switch (choice) {
            case 1:
                System.out.println("Rock");
                break;
            case 2:
                System.out.println("Paper");
                break;
            case 3:
                System.out.println("Scissors");
                break;
        }
    }
    
    private static void determineWinner(int player, int computer) {
        if (player == computer) {
            System.out.println("\nIt's a TIE!");
        } else if ((player == 1 && computer == 3) ||
                   (player == 2 && computer == 1) ||
                   (player == 3 && computer == 2)) {
            System.out.println("\nYou WIN! Congratulations!");
        } else {
            System.out.println("\nComputer WINS! Better luck next time!");
        }
    }
    
    // ===== GAME 2: Binary Search Number Guessing =====
    private static void playBinarySearchGuess() {
        System.out.println("\n--- BINARY SEARCH NUMBER GUESSING ---");
        System.out.println("Think of a number between 1 and 100.");
        System.out.println("I'll try to guess it using binary search!");
        System.out.println("Respond with:");
        System.out.println("  'h' if your number is higher");
        System.out.println("  'l' if your number is lower");
        System.out.println("  'c' if I guessed correctly");
        System.out.println("\nPress Enter when you're ready...");
        scanner.nextLine();
        
        int low = 1;
        int high = 100;
        int attempts = 0;
        boolean guessed = false;
        
        while (!guessed && low <= high) {
            int guess = low + (high - low) / 2;
            attempts++;
            
            System.out.println("\nAttempt #" + attempts);
            System.out.print("Is your number " + guess + "? (h/l/c): ");
            
            char response = getValidResponse();
            
            if (response == 'c') {
                System.out.println("\nYay! I guessed your number in " + attempts + " attempts!");
                guessed = true;
            } else if (response == 'h') {
                low = guess + 1;
            } else if (response == 'l') {
                high = guess - 1;
            }
        }
        
        if (!guessed) {
            System.out.println("\nHmm, something went wrong. Did you change your number?");
        }
    }
    
    private static char getValidResponse() {
        char response = ' ';
        boolean valid = false;
        
        while (!valid) {
            if (scanner.hasNextLine()) {
                String input = scanner.nextLine().trim().toLowerCase();
                if (input.length() > 0) {
                    response = input.charAt(0);
                    if (response == 'h' || response == 'l' || response == 'c') {
                        valid = true;
                    } else {
                        System.out.print("Invalid input. Enter h, l, or c: ");
                    }
                } else {
                    System.out.print("Please enter h, l, or c: ");
                }
            }
        }
        
        return response;
    }
    
    // ===== GAME 3: Palindrome Number Checker =====
    // NOTE: No Arrays or Strings allowed!
    private static void checkPalindrome() {
        System.out.println("\n--- PALINDROME NUMBER CHECKER ---");
        System.out.println("A palindromic number reads the same forwards and backwards.");
        System.out.println("Example: 16461 is palindromic");
        System.out.print("\nEnter a positive whole number: ");
        
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.print("Please enter a valid positive whole number: ");
        }
        int number = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        while (number < 0) {
            System.out.print("Please enter a positive number: ");
            while (!scanner.hasNextInt()) {
                scanner.next();
            }
            number = scanner.nextInt();
            scanner.nextLine();
        }
        
        boolean isPalindrome = isPalindromicNumber(number);
        
        System.out.println("\nNumber: " + number);
        if (isPalindrome) {
            System.out.println("Result: This IS a palindromic number! ✓");
        } else {
            System.out.println("Result: This is NOT a palindromic number.");
        }
    }
    
    private static boolean isPalindromicNumber(int n) {
        // Reverse the number and compare with original
        int original = n;
        int reversed = 0;
        
        while (n > 0) {
            int digit = n % 10;
            reversed = reversed * 10 + digit;
            n = n / 10;
        }
        
        return original == reversed;
    }
}
