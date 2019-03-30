import java.util.Scanner;

public class BankCard {
    private static final int groupNumber = 4;
    private static String cardNumber = "";
    private static int sum;

    public static boolean isCorrectCardNumber(String string) {
        sum = 0;
        for (int i = 0; i < string.length(); i++) {
            int digit = Integer.parseInt(String.valueOf(string.charAt(i)));
            if (i % 2 == 0) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }
            sum += digit;
        }
        return (sum % 10 == 0) ? true : false;
    }

    public static void printsMessage(boolean check) {
        if (check) {
            System.out.println("Correct. Checksum: " + sum + ". \nFor the entered combination: " + cardNumber);
        } else {
            System.out.println("Incorrect. Checksum: " + sum + ". \nFor the entered combination: " + cardNumber);
        }
    }

    public static void readUserInput() {
        System.out.println("Enter the 16th digit card number: ");
        Scanner scanner = new Scanner(System.in);
        boolean count = true;
        while (count) {
            String number = scanner.nextLine();
            for (int i = 0; i < number.length(); i++) {
                char digit = number.charAt(i);
                if (Character.isSpaceChar(digit)) {
                    continue;
                } else if (Character.isDigit(digit)) {
                    cardNumber += Character.toString(digit);
                }
            }
            if (cardNumber.length() == 16) {
                count = false;
            } else {
                System.out.println("Sorry. Try again.");
                cardNumber = "";
            }
        }
    }

    public static String formatString(String string) {
        String sortString = "";
        for (int i = 0; i < string.length(); i++) {
            if (i != 0 && i % groupNumber == 0) {
                if (i < string.length()) {
                    sortString += " ";
                }
            }
            sortString += String.valueOf(string.charAt(i));
        }
        return sortString;
    }

    public static void main(String[] args) {
        System.out.println("This program verifies bank card number using Luhn algorithm.");
        readUserInput();
        boolean result = isCorrectCardNumber(cardNumber);
        cardNumber = formatString(cardNumber);
        printsMessage(result);
    }
}