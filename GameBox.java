import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.time.Instant;
import java.util.Objects;
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
            PrintWriter outputWriter = new PrintWriter("RockPaperScissorsOutput.txt");
            for (int i = 1; i <=3; i++) {
              outputWriter.append("Test " + i + ": \n");
              System.out.println("Test " + i + ": \n");
              File driverTestInput = new File("RockPaperScissorsTest" + i +".txt");
              FileInputStream fileInput = new FileInputStream(driverTestInput);
              String outputLog = RockPaperScissorsGame(fileInput);
              outputWriter.append(outputLog);
            }
            System.out.println("Output saved to RockPaperScissorsOutput.txt");
            outputWriter.flush();
            outputWriter.close();
          } else if (userInteger % 4 == 2) {
            PrintWriter outputWriter = new PrintWriter("BinarySearchOutput.txt");
            for (int i = 1; i <=3; i++) {
              outputWriter.append("Test " + i + ": \n");
              System.out.println("Test " + i + ": \n");
              File driverTestInput = new File("BinarySearchTest" + i +".txt");
              FileInputStream fileInput = new FileInputStream(driverTestInput);
              String outputLog = BinarySearch(fileInput);
              outputWriter.append(outputLog);
            }
            System.out.println("Output saved to BinarySearchOutput.txt");
            outputWriter.flush();
            outputWriter.close();
          } else if (userInteger % 4 == 3) {
            PrintWriter outputWriter = new PrintWriter("Palindrome.txt");
            for (int i = 1; i <=3; i++) {
              outputWriter.append("Test " + i + ": \n");
              System.out.println("Test " + i + ": \n");
              File driverTestInput = new File("Palindrome" + i +".txt");
              FileInputStream fileInput = new FileInputStream(driverTestInput);
              String outputLog = Palindrome(fileInput);
              outputWriter.append(outputLog);
            }
            System.out.println("Output saved to Palindrome.txt");
            outputWriter.flush();
            outputWriter.close();
          } else if (userInteger % 4 == 0) {
            PrintWriter outputWriter = new PrintWriter("SpeedMathOutput.txt");
            for (int i = 1; i <=3; i++) {
              outputWriter.append("Test " + i + ": \n");
              System.out.println("Test " + i + ": \n");
              File driverTestInput = new File("SpeedMathTest" + i +".txt");
              FileInputStream fileInput = new FileInputStream(driverTestInput);
              String outputLog = CustomGame(fileInput);
              outputWriter.append(outputLog);
            }
            System.out.println("Output saved to SpeedMathOutput.txt");
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
        System.out.println("Welcome to Rock Paper Scissors, press enter \"Rock\", \"Paper\", or \"Scissors\", type \"exit\" to exit");
        Scanner terminal = new Scanner(input);
        String user_input = terminal.nextLine();
        StringBuffer outputLog = new StringBuffer();
        Random number_generator = new Random();
        while(user_input.compareTo("exit") != 0) {
            System.out.println("User Chooses: " + user_input);
            outputLog.append("User Chooses: " + user_input + "\n");
            int rand_int = number_generator.nextInt(4);
            if (rand_int == 0 || rand_int == 1) {
                System.out.println("System Chooses: Rock");
                outputLog.append("System Chooses: Rock \n");
                if (user_input.compareTo("Paper") == 0) {
                    System.out.println("User Wins!");
                    outputLog.append("User Wins! \n");
                    break;
                } else if (user_input.compareTo("Scissors") == 0) {
                    System.out.println("System Wins!");
                    outputLog.append("System Wins! \n");

                    break;
                } else {
                    System.out.println("Tie, start next round");
                    outputLog.append("Tie, start next round \n");
                }
            } else if (rand_int == 2) {
                System.out.println("System Chooses: Paper");
                outputLog.append("System Chooses: Paper \n");
                if (user_input.compareTo("Scissors") == 0) {
                    System.out.println("User Wins!");
                    outputLog.append("User Wins!\n");
                    break;
                } else if (user_input.compareTo("Rock") == 0) {
                    System.out.println("System Wins!");
                    outputLog.append("System Wins!\n");
                    break;
                } else {
                    System.out.println("Tie, start next round");
                    outputLog.append("Tie, start next round\n");
                }
            } else {
                System.out.println("System Chooses: Scissors");
                outputLog.append("System Chooses: Scissors \n");
                if (user_input.compareTo("Rock") == 0) {
                    System.out.println("User Wins!");
                    outputLog.append("User Wins!\n");
                    break;
                } else if (user_input.compareTo("Paper") == 0) {
                    System.out.println("System Wins!");
                    outputLog.append("System Wins!\n");
                    break;
                } else {
                    System.out.println("Tie, start next round");
                    outputLog.append("Tie, start next round\n");
                }
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
            System.out.println(userInput + "\n");
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

    private static boolean isPal (Integer inputLength, Integer userInteger) {
        Integer len = inputLength;
        for (int x = 0; x < inputLength/2; x++) {
            Integer last = userInteger % 10;
            Integer first = userInteger / (int) Math.pow(10, (len - 1));
            userInteger = userInteger % (int) Math.pow(10, (len - 1));
            userInteger = userInteger / 10;
            len = len - 2;
            if (!Objects.equals(first, last)) {
            return false;
            }
        }
        return true;
    }
    public static String Palindrome(InputStream input) {
        StringBuffer outputLog = new StringBuffer();
        System.out.println("Welcome to \"is this integer a palindrome?\", type \"exit\" to exit");
        outputLog.append("Welcome to \"is this integer a palindrome?\", type \"exit\" to exit \n");
        Scanner inputScanner = new Scanner(input);

        System.out.print("Enter a whole number: ");
        outputLog.append("Enter a whole number: ");
        String userInput = inputScanner.nextLine();

        Integer userInteger = Integer.parseInt(userInput);
        
        outputLog.append(userInput).append("\n");

        Integer inputLength = 1 + (int) Math.floor(Math.log10(userInteger));

        boolean palindrome = isPal(inputLength, userInteger);
        if (palindrome) {
            System.out.println(userInteger + " is a palindrome.");
            outputLog.append(userInteger).append(" is a palindrome. \n");
        } else {
            System.out.println(userInteger + " is NOT a palindrome.");
            outputLog.append(userInteger).append(" is NOT a palindrome. \n");
        }
        inputScanner.close();
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
      outputLog.append("What is " + numberOne);
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
    outputLog.append(numberTwo + " = ? \n");
    
    // TimeUnit.SECONDS.sleep(5);

    long timeStart = Instant.now().getEpochSecond();
    user_input = terminal.nextLine();
    int user_Integer = Integer.parseInt(user_input);
    int correctness = Math.abs(answer - user_Integer);
    long timeEnd = Instant.now().getEpochSecond();
    long length = timeEnd - timeStart;

    System.out.println("Your guess was " + user_Integer +"!");
    outputLog.append("Your guess was " + user_Integer + "! \n");
    System.out.println("You are " + correctness + " away from the correct answer: " + answer +". It took you " + length + " seconds!");
    outputLog.append("You are " + correctness + " away from the correct answer: " + answer +". It took you " + length + " seconds! \n");
    
    
    terminal.close();

    return outputLog.toString();
    }
}
