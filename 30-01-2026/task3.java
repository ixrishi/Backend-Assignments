import java.util.logging.Logger;

public class task3 {

    static Logger logger = Logger.getLogger(task3.class.getName());

    public static void main(String[] args) {

        String username = "Amogh";
        int age = 20;
        String email = "amogh@gmail.com";

        try {
            Validator.validateUsername(username);
            Validator.validateAge(age);
            Validator.validateEmail(email);

            System.out.println("Validation successful");

        } catch (InvalidUserException e) {
            System.out.println("User Error: " + e.getMessage());

        } catch (InvalidAgeException e) {
            System.out.println("Age Error: " + e.getMessage());

        } finally {
            logger.info("Validation is completed");
        }
    }
}

class InvalidUserException extends Exception {
    public InvalidUserException(String message) {
        super(message);
    }
}

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

class Validator {

    public static void validateUsername(String username) throws InvalidUserException {
        if (username == null || username.trim().length() < 3) {
            throw new InvalidUserException("Username must have at least 3 characters");
        }
    }

    public static void validateAge(int age)  throws InvalidAgeException {
        if (age <= 0) {
            throw new InvalidAgeException("Age must be positive");
        }
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above");
        }
    }

    public static void validateEmail(String email) throws InvalidUserException {
    if (email == null) {
        throw new InvalidUserException("Email cannot be null");
    }

    email = email.trim();

    String regex = "^[A-Za-z0-9._+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

    if (!email.matches(regex)) {
        throw new InvalidUserException("Invalid email format");
    }
}

}