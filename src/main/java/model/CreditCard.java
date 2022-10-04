package model;

import java.util.Objects;

public record CreditCard(String number, String pin,
                         double balance, Boolean active) {

    public CreditCard {
        Objects.requireNonNull(number, "Number must not be null");
        if (pin.length() != 4) {
            throw new IllegalArgumentException("Pin must have 4 digits");
        }
        if (balance < 0){
            throw new IllegalArgumentException("Balance can't be negative");
        }
    }

}
