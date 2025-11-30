package regex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a string: ");
        final String userInput = scanner.nextLine();
        scanner.close();
        System.out.println("You entered \"" + userInput + "\"");
        System.out.println(checkForPassword(userInput, 6));
        System.out.println(extractEmails(userInput));
        System.out.println(checkForDoubles(userInput));
    }

    /**
     * Returns whether a given string is non-empty, contains one lower case letter,
     * at least one upper case letter, at least one digit, and meets the minimum length.
     */
    public static boolean checkForPassword(String str, int minLength) {
        // Fix: Handle null input immediately
        if (str == null) {
            return false;
        }

        String regex = "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{" + minLength + ",}";
        return Pattern.matches(regex, str);
    }

    /**
     * Returns a list of email addresses that occur in a given string.
     */
    public static List<String> extractEmails(String str) {
        // Fix: Handle null input by returning an empty list
        if (str == null) {
            return new ArrayList<>();
        }

        final Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@(mail\\.)?utoronto\\.ca");
        final Matcher matcher = pattern.matcher(str);
        final List<String> result = new ArrayList<>();
        while (matcher.find()) {
            result.add(matcher.group());
        }
        return result;
    }

    /**
     * Checks whether a given string contains the same capital letter twice.
     */
    public static boolean checkForDoubles(String str) {
        // Fix: Handle null input immediately
        if (str == null) {
            return false;
        }

        return str.matches(".*([A-Z]).*\\1.*");
    }
}