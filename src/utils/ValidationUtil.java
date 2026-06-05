package utils;

public class ValidationUtil {

    public static boolean isValidId(int id) {
        if (id <= 0) {
            System.out.println("[ERROR] ID must be a positive number.");
            return false;
        }
        return true;
    }

    public static boolean isValidTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            System.out.println("[ERROR] Title cannot be empty.");
            return false;
        }
        return true;
    }

    public static boolean isValidCategory(String category) {
        if (category == null || category.trim().isEmpty()) {
            System.out.println("[ERROR] Category cannot be empty.");
            return false;
        }
        return true;
    }

    public static boolean isValidAmount(double amount) {
        if (amount <= 0) {
            System.out.println("[ERROR] Amount must be greater than zero.");
            return false;
        }
        return true;
    }

    public static boolean isValidAmountInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            System.out.println("[ERROR] Amount cannot be empty.");
            return false;
        }
        try {
            double amount = Double.parseDouble(input.trim());
            return isValidAmount(amount);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] Amount must be a valid number.");
            return false;
        }
    }

    public static boolean isValidDate(String date) {
        if (date == null || date.trim().isEmpty()) {
            System.out.println("[ERROR] Date cannot be empty.");
            return false;
        }
        if (!date.matches("\\d{2}-\\d{2}-\\d{4}")) {
            System.out.println("[ERROR] Date format must be DD-MM-YYYY.");
            return false;
        }
        return true;
    }

    public static boolean isValidMonth(int month) {
        if (month < 1 || month > 12) {
            System.out.println("[ERROR] Month must be between 1 and 12.");
            return false;
        }
        return true;
    }

    public static boolean isValidYear(int year) {
        if (year < 2000 || year > 2100) {
            System.out.println("[ERROR] Year must be between 2000 and 2100.");
            return false;
        }
        return true;
    }
}