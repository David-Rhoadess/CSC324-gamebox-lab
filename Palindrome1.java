import java.util.Objects;
import java.util.Scanner;

public class Palindrome1{
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
  public static void main(String[] args) {
    System.out.println("Welcome to \"is this integer a palindrome?\", type \"exit\" to exit");
    Scanner inputScanner = new Scanner(System.in);
    System.out.print("Enter a whole number: ");
    String userInput = inputScanner.nextLine();

    Integer userInteger = Integer.parseInt(userInput);

    Integer inputLength = 1 + (int) Math.floor(Math.log10(userInteger));

    boolean palindrome = isPal(inputLength, userInteger);
    if (palindrome) {
      System.out.println(userInteger + " is a palindrome.");
    } else {
      System.out.println(userInteger + " is NOT a palindrome.");
    }
    inputScanner.close();
  }
}
