public class Main {

    public static void main(String[] args) {

        startRegistration( "fQwQf", 18);

        startRegistration( "fQ", 18);

        startRegistration( "fQwQf", 17);

    }

    public static void startRegistration(String name, int age) {
        UserRegistration userRegistration = new UserRegistration();
        try {
            userRegistration.registerUser(name, age);
        } catch (InvalidAgeException e) {
            System.err.println("Registration Failed: " + e.getMessage());
        } catch (InvalidNameException e) {
            System.err.println("Registration Failed: " + e.getMessage());
        }
    }
}