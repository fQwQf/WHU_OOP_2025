package org.example;

public class UserManualBuilder {
    private String name;
    private int age;
    private String email;

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String name;
        private int age;
        private String email;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public UserManualBuilder build() {
            var res = new UserManualBuilder();
            res.name = this.name;
            res.age = this.age;
            res.email = this.email;
            return res;
        }
    }



    @Override
    public String toString() {
        return "UserManualBuilder{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}