import java.util.Scanner;

public class Palindrome2 {
    public static void main(String[] args) {
        System.out.println("Pick a word to check if it's a palindrome.");

        Scanner scanner = new Scanner(System.in);

        String words = scanner.nextLine();

        scanner.close();

        int left = 0;
        int right = words.length() - 1;

        while (left < right) {
            if (words.charAt(left) != words.charAt(right)) {
                System.out.println("The word is not palindromic.");
                return;
            }

            left++;
            right--;
        }
        System.out.println("The word is palindromic!");
    }
}
