//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.example;

public class user_decompilation {
    private String name;
    private int age;
    private String email;

    User(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getEmail() {
        return this.email;
    }

    public static class UserBuilder {
        private String name;
        private int age;
        private String email;

        UserBuilder() {
        }

        public UserBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public User build() {
            return new User(this.name, this.age, this.email);
        }

        public String toString() {
            return "User.UserBuilder(name=" + this.name + ", age=" + this.age + ", email=" + this.email + ")";
        }
    }
}
