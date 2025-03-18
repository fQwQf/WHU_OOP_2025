package org.example;

public class UserManualTest {
    public static void main(String[] args) {
        UserManualBuilder user = UserManualBuilder.builder()
                .name("fQwQf")
                .age(18)
                .email("fQwQf6@outlook.com")
                .build();
        System.out.println(user.toString());
    }
}
