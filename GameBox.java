
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.time.Instant;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;

public class GameBox {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner terminal = new Scanner(System.in);
        System.out.println("Press \"G\" for game or \"D\" for driver followed by enter");
        String userInput = terminal.nextLine();
        if (userInput.compareTo("G") == 0) {  
            CustomGame(System.in);
            //RockPaperScissorsGame(System.in);
        } else if (userInput.compareTo("D") == 0) {
          System.out.println("Enter 1 number 1-16 to select a game: ");
          userInput = terminal.nextLine();
          int userInteger = Integer.parseInt(userInput);
          if (userInteger % 4 == 1) {
            File driverTestInput = new File("RockPaperScissorsTest1.txt");
            FileInputStream fileInput = new FileInputStream(driverTestInput);
            String outputLog = RockPaperScissorsGame(fileInput);
            PrintWriter outputWriter = new PrintWriter("RockPaperScissorsTest1Output.txt");
            outputWriter.write(outputLog);
            outputWriter.flush();
            outputWriter.close();
          } else if (userInteger % 4 == 2) {
            File driverTestInput = new File("BinarySearchTest1.txt");
            FileInputStream fileInput = new FileInputStream(driverTestInput);
            String outputLog = BinarySearch(fileInput);
            PrintWriter outputWriter = new PrintWriter("BinarySearchOutput.txt");
            outputWriter.write(outputLog);
            outputWriter.flush();
            outputWriter.close();
          } else if (userInteger % 4 == 3) {
            File driverTestInput = new File("Palindrome.txt");
            FileInputStream fileInput = new FileInputStream(driverTestInput);
            String outputLog = Palindrome(fileInput);
            PrintWriter outputWriter = new PrintWriter("PalindromeOutput.txt");
            outputWriter.write(outputLog);
            outputWriter.flush();
            outputWriter.close();
          } else if (userInteger % 4 == 0) {
            File driverTestInput = new File("SpeedMath.txt");
            FileInputStream fileInput = new FileInputStream(driverTestInput);
            String outputLog = CustomGame(fileInput);
            PrintWriter outputWriter = new PrintWriter("SpeedMathOutput.txt");
            outputWriter.write(outputLog);
            outputWriter.flush();
            outputWriter.close();
          } 
        } else {
            terminal.close();
            throw new IOException("Valid inputs are G or D");
        }
        terminal.close();
        System.exit(0);
    }

    public static String RockPaperScissorsGame(InputStream input) {
        System.out.println("Welcome to Rock Paper Scissors, press enter to get my next choice, type \"exit\" to exit");
        Scanner terminal = new Scanner(input);
        String user_input = terminal.nextLine();
        StringBuffer outputLog = new StringBuffer();
        Random number_generator = new Random();
        while(user_input.compareTo("exit") != 0) {
            int rand_int = number_generator.nextInt(4);
            if (rand_int == 0 || rand_int == 1) {
                System.out.println("Rock");
                outputLog.append("Rock \n");
            } else if (rand_int == 2) {
                System.out.println("Paper");
                outputLog.append("Paper \n");
            } else {
                System.out.println("Scissors");
                outputLog.append("Scissors \n");
            }
            user_input = terminal.nextLine();
        }
        terminal.close();
        return outputLog.toString();
    }

    public static String BinarySearch(InputStream input) {
        System.out.println("Welcome to word guessing game! Pick a integer from 1 to 100.");
            
        int lower = 1;
        int higher = 100;
        int mid;
        Scanner scanner = new Scanner(input);
        StringBuffer outputLog = new StringBuffer();

        while (lower <= higher) {
            mid = lower + (higher - lower) / 2;
            System.out.println("Is this the number you think of? " + mid);
            outputLog.append("Is this the number you think of? " + mid + "\n");
            System.out.println("Enter equal, up, or down");
            outputLog.append("Enter equal, up, or down\n");
            char userInput = scanner.next().charAt(0);
            outputLog.append(userInput + "\n");
            if (userInput == 'e') {
                System.out.println("Your number is " + mid);
                outputLog.append("Your number is " + mid + "\n");
                break;
            } else if (userInput == 'u') {
                lower = mid + 1;
            } else if (userInput == 'd') {
                higher = mid - 1;
            } else {
                System.out.println("Please enter equal, up, or down");
                outputLog.append("Please enter equal, up, or down\n");
            }
        }
        scanner.close();
        return outputLog.toString();
    }

    public static String CustomGame(InputStream input) throws InterruptedException {
      System.out.println("Welcome to Speed Math, press enter to begin, type \"exit\" to exit");
      Scanner terminal = new Scanner(input);
      String user_input = terminal.nextLine();
      StringBuffer outputLog = new StringBuffer();
      Random number_generator = new Random();
      int numberOne = number_generator.nextInt(100);
      int numberTwo = number_generator.nextInt(100);
      int operationNumber = number_generator.nextInt(4);
      int answer = 0;
      Timer clock = new Timer();

      System.out.print("What is " + numberOne);
      if (operationNumber == 0) {
        System.out.print(" + ");
        outputLog.append(" + ");
        answer = numberOne + numberTwo;
    } else if (operationNumber == 1) {
        System.out.print(" - ");
        outputLog.append(" - ");
        answer = numberOne - numberTwo;
    } else if (operationNumber == 2) {
      System.out.print(" * ");
      outputLog.append(" * ");
      answer = numberOne * numberTwo;
    } else {
        System.out.print(" mod ");
        outputLog.append(" mod ");
        answer = numberOne % numberTwo;
    }
    System.out.println(numberTwo + " = ?");
    // TimeUnit.SECONDS.sleep(5);

    long timeStart = Instant.now().getEpochSecond();
    user_input = terminal.nextLine();
    int user_Integer = Integer.parseInt(user_input);
    double percentageCorrect = 0.0;
    if (answer == 0) {
      percentageCorrect = user_Integer;
    } else if (user_Integer > answer) {
      percentageCorrect = (100 * ((double) user_Integer/(double) answer)) % 100;
    } else {
      percentageCorrect = 100 - (100 * ((double) user_Integer/(double) answer)) % 100;
    }
    long timeEnd = Instant.now().getEpochSecond();
    long length = timeEnd - timeStart;

    System.out.println("You are " + percentageCorrect + "% away from the correct answer: " + answer +". It takes you " + length + " seconds!");
    
    terminal.close();

    return outputLog.toString();
    }
}