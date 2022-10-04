package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public record Customer(String fullName, Long phone,
                       List<CreditCard> creditCards,
                       List<Transaction> transactions) {

    public Customer{
        Objects.requireNonNull(fullName);
        if (!fullName.contains(" ")){
            throw new IllegalArgumentException("FullName must have a whitespace");
        }
        Objects.requireNonNull(creditCards);
        Objects.requireNonNull(transactions);
    }

    public Customer(String firstName,String lastName,
                    Long phone,
                    List<CreditCard> creditCards,
                    List<Transaction> transactions){
        this(firstName + " " + lastName, phone, new ArrayList<>(), new ArrayList<>());
    }
}









// fullName, phone, creditCard.numb