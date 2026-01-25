package GameBox;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Random;

public class RockPaperScissors {
    public static void main(String[] args) throws IOException {
        Scanner terminal = new Scanner(System.in);
        System.out.println("Press \"G\" for game or \"D\" for driver followed by enter");
        String userInput = terminal.nextLine();
        if (userInput.compareTo("G") == 0) {
            RockPaperScissorsGame(System.in);
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
}