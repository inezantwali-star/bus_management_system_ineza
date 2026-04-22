package utils;

import java.util.Set;

public class InputValidator {

    public static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    public static boolean isValidPhone(String phone) {
        return phone != null && phone.matches("^\\+?[0-9]{7,15}$");
    }

    public static boolean isValidEmail(String email) {
        return email != null && email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }

    public static boolean isPositiveNumber(double value) {
        return value > 0;
    }

    public static boolean isPositiveInt(int value) {
        return value > 0;
    }

    public static boolean isValidId(String id) {
        return id != null && id.matches("^[A-Za-z0-9_-]{3,20}$");
    }

    public static boolean isValidBusType(String type) {
        String[] valid = {"CITY", "EXPRESS", "LUXURY", "SCHOOL", "TOURIST", "ELECTRIC"};
        for (String v : valid) {
            if (v.equalsIgnoreCase(type)) return true;
        }
        return false;
    }

    // ── NEW: duplicate ID check ───────────────────────────────────────────────
    public static boolean isDuplicateId(String id, Set<String> usedIds) {
        return usedIds.contains(id);
    }

    public static String validateNotEmpty(String value, String fieldName) {
        if (isNullOrEmpty(value)) {
            return fieldName + " cannot be empty.";
        }
        return null;
    }

    public static String validatePhone(String phone) {
        if (!isValidPhone(phone)) {
            return "Invalid phone number. Use 7–15 digits, optional leading '+'.";
        }
        return null;
    }

    public static String validateEmail(String email) {
        if (!isValidEmail(email)) {
            return "Invalid email format. Example: user@example.com";
        }
        return null;
    }

    public static String validatePositiveDouble(String input, String fieldName) {
        try {
            double val = Double.parseDouble(input);
            if (val <= 0) return fieldName + " must be a positive number.";
        } catch (NumberFormatException e) {
            return fieldName + " must be a valid number, not text.";
        }
        return null;
    }

    public static String validatePositiveInt(String input, String fieldName) {
        try {
            int val = Integer.parseInt(input);
            if (val <= 0) return fieldName + " must be a positive integer.";
        } catch (NumberFormatException e) {
            return fieldName + " must be a whole number, not text.";
        }
        return null;
    }
}