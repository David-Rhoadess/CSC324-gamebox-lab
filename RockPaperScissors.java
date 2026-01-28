
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class RockPaperScissors {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner terminal = new Scanner(System.in);
        System.out.println("Press \"G\" for game or \"D\" for driver followed by enter");
        String userInput = terminal.nextLine();
        if (userInput.compareTo("G") == 0) {
            CustomGame(System.in);
            //RockPaperScissorsGame(System.in);
        } else if (userInput.compareTo("D") == 0) {
            File driverTestInput = new File("RockPaperScissorsTest1.txt");
            FileInputStream fileInput = new FileInputStream(driverTestInput);
            String outputLog = RockPaperScissorsGame(fileInput);
            PrintWriter outputWriter = new PrintWriter("RockPaperScissorsTest1Output.txt");
            outputWriter.write(outputLog);
            outputWriter.flush();
            outputWriter.close();
        } else {
            terminal.close();
            throw new IOException("Valid inputs are G or D");
        }
        terminal.close();
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
    TimeUnit.SECONDS.sleep(5);

    if (!terminal.hasNext()) {
        System.out.println("Too slow, answer: " + answer);

    } else {
      user_input = terminal.nextLine();
      int user_Integer = Integer.parseInt(user_input);
      double percentageCorrect = 0.0;
      if (user_Integer > answer) {
        percentageCorrect = (100 * ((double) user_Integer/(double) answer)) % 100;
      } else {
        percentageCorrect = 100 - (100 * ((double) user_Integer/(double) answer)) % 100;
      }
      

    System.out.println("You are " + percentageCorrect + "% away from the correct answer: " + answer +".");
    }

    

    return outputLog.toString();
    }
}