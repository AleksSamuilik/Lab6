import java.util.Scanner;

public class BankCard {
    private static final int groupSize = 4;
    private static final int cardNumberLength = 16;
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
        return sum % 10 == 0;
    }

    public static void printMessage(boolean valid, String string) {
        if (valid) {
            System.out.println("Correct. Checksum: " + sum + ". \nFor the entered combination: " + string);
        } else {
            System.out.println("Incorrect. Checksum: " + sum + ". \nFor the entered combination: " + string);
        }
    }

    public static void readUserInput() {
        System.out.println("Enter the 16th digit card number: ");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String number = scanner.nextLine();
            for (int i = 0; i < number.length(); i++) {
                char digit = number.charAt(i);
                if (Character.isSpaceChar(digit)) {
                    continue;
                } else if (Character.isDigit(digit)) {
                    cardNumber += Character.toString(digit);
                } else {
                    cardNumber = "";
                    break;
                }
            }
            if (cardNumber.length() == cardNumberLength) {
                break;
            } else {
                System.out.println("Sorry. Try again.");
                cardNumber = "";
            }
        }
    }

    public static String formatString(String string) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if (i != 0 && i % groupSize == 0) {
                if (i < string.length()) {
                    builder.append(" ");
                }
            }
            builder.append(string.charAt(i));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println("This program verifies bank card number using Luhn algorithm.");
        readUserInput();
        isCorrectCardNumber(cardNumber);
        printMessage(isCorrectCardNumber(cardNumber), formatString(cardNumber));
    }
}