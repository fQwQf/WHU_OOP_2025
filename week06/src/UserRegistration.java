public class UserRegistration {

    public void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Illegal age!");
        }
    }

    public void validateName(String name) {
        if (name == null || name.trim().length() < 3) {
            throw new InvalidNameException("Illegal name!");
        }
    }

    public void registerUser(String name, int age) throws InvalidAgeException {
        System.out.println("Attempting to register user: Name='" + name + "', Age=" + age);

        validateName(name);
        validateAge(age);

        System.out.println("Registration successful!");
        System.out.println("User Details: Name = " + name + ", Age = " + age);
    }
}