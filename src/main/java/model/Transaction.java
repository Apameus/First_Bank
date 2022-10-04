package model;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public record Transaction(UUID uuid, Boolean isDeposit,
                          double amount, Employee employee,
                          CreditCard creditCard, LocalDate time) {

    public Transaction {
        if (amount <= 0){
            throw new IllegalArgumentException("Amount can't be less or equal to zero");
        }
        Objects.requireNonNull(employee);
        Objects.requireNonNull(creditCard);
        Objects.requireNonNull(time);
    }
}
