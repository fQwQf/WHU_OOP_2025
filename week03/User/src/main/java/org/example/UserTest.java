package org.example;

public class UserTest {
    public static void main(String[] args) {
        User user = User.builder()
                .name("fQwQf")
                .age(18)
                .email("fQwQf6@outlook.com")
                .build();
        System.out.println(user.getAge());
        System.out.println(user.getName());
        System.out.println(user.getEmail());
    }
}