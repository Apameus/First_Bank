package model;

import java.util.Objects;

public record Employee(String username, String password,
                       String fullName, long phoneNumber) {

    public Employee {
        Objects.requireNonNull(username, "Username must not be null");
        Objects.requireNonNull(password, "Password must not be null");
        Objects.requireNonNull(fullName);
        if (fullName.indexOf(" ") == -1){
            throw new IllegalArgumentException("FullName has no whitespace");
        }
    }

    public Employee(String username, String password,
                    String firstName, String lastName,
                    long phoneNumber){
        this(username, password, firstName + " " + lastName, phoneNumber);
    }

    public String getFirstName(){
        String[] firstLast = fullName.split(" ");
        return firstLast[0];
    }

    public String getLastName(){
        String[] firstLast  = fullName.split(" ");
        return firstLast[1];
    }
}
