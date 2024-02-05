package br.com.nord.enums;

import lombok.Getter;

@Getter
public enum UserRole {
    ADMIN("admin"),
    USER("user");

    private final String name;

    UserRole(String name) {
        this.name = name;
    }

    public static UserRole fromString(String name) {
        for (UserRole role : UserRole.values()) {
            if (role.name.equalsIgnoreCase(name)) {
                return role;
            }
        }
        throw new IllegalArgumentException("Invalid role name: " + name);
    }

    @Override
    public String toString() {
        return name;
    }
}
