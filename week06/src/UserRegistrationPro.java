import java.util.logging.Logger;

public class UserRegistrationPro {
    private static final Logger logger = Logger.getLogger(UserRegistrationPro.class.getName());

    public void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            logger.warning("Age illegal: " + age);
            throw new InvalidAgeException("Illegal age!");
        }
    }

    public void validateName(String name) {
        if (name == null || name.trim().length() < 3) {
            logger.warning("Name too short: " + name);
            throw new InvalidNameException("Short name!");
        }
        validateFormat(name);
    }

    // 更深层次的验证方法
    private void validateFormat(String name) throws InvalidNameException {
        if (!name.matches("[\\u4E00-\\u9FA5A-Za-z]+")) {
            throw new InvalidNameException("Name illegal!");
        }
    }

    public void registerUser(String name, int age) throws ApplicationException {
        try {
            validateName(name);
            validateAge(age);
            logger.info("Registration successful!" + name);
            logger.info("User Details: Name = " + name + ", Age = " + age);
        } catch (InvalidAgeException | InvalidNameException e) {
            throw new ApplicationException("Registration fail!", e);
        }
    }
}