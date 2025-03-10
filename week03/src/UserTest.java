public class UserTest {
    public static void main(String[] args) {
        User user = User.builder()
                .name("Alice")
                .age(30)
                .email("alice@example.com")
                .address("123 Main St")
                .phone("555-1234")
                .gender("Female")
                .occupation("Engineer")
                .build();
        System.out.println(user);
    }
}