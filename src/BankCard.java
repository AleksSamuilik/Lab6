import java.util.Scanner;

public class BankCard {
    private static String cardNumber;
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the 16th digit card number: ");
        while (true) {
            String number = scanner.nextLine();
            number = number.replaceAll("\\s", "");
            try {
                long digit = Long.parseLong(number);
                if (digit > 0 && number.length() == 16) {
                    cardNumber = number;
                    break;
                } else
                    System.out.println("Sorry. Try again!");
            } catch (NumberFormatException e) {
                System.out.println("Sorry. Try again!");
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        System.out.println("This program verifies bank card number using Luhn algorithm.");
        readUserInput();
        printsMessage(isCorrectCardNumber(cardNumber));
    }

}


