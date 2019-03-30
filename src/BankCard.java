import java.util.Scanner;

public class BankCard {
    private static final int GROUP_SIZE = 4;
    private static final int CARD_NUMBER_LENGHT = 16;

    public static int luhnAlgorithm(String cardNumber) {
        int sumLuhnAlgorithm = 0;
        for (int i = 0; i < cardNumber.length(); i++) {
            int digit = Integer.parseInt(String.valueOf(cardNumber.charAt(i)));
            if (i % 2 == 0) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }
            sumLuhnAlgorithm += digit;
        }
        return sumLuhnAlgorithm;
    }

    public static boolean isCorrectCardNumber(int sumLuhnAlgorithm) {
        return sumLuhnAlgorithm % 10 == 0;
    }

    public static void printMessage(boolean valid, int sumLuhnAlgorithm, String cardNumber) {
        if (valid) {
            System.out.println("Correct. Checksum: " + sumLuhnAlgorithm + ". \nFor the entered combination: " + cardNumber);
        } else {
            System.out.println("Incorrect. Checksum: " + sumLuhnAlgorithm + ". \nFor the entered combination: " + cardNumber);
        }
    }

    public static String readUserInput() {
        System.out.println("Enter the 16th digit card number: ");
        Scanner scanner = new Scanner(System.in);
        String cardNumber = "";
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
            if (cardNumber.length() == CARD_NUMBER_LENGHT) {
                break;
            } else {
                System.out.println("Sorry. Try again.");
                cardNumber = "";
            }
        }
        return cardNumber;
    }

    public static String formatString(String string) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if (i != 0 && i % GROUP_SIZE == 0) {
                builder.append(" ");
            }
            builder.append(string.charAt(i));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println("This program verifies bank card number using Luhn algorithm.");
        String cardNumber = readUserInput();
        int sumLuhnAlgorithm =luhnAlgorithm(cardNumber);
        printMessage(isCorrectCardNumber(sumLuhnAlgorithm), sumLuhnAlgorithm, formatString(cardNumber));
    }
}
