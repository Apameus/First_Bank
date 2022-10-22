package org.first_bank.repository;

import org.first_bank.model.CreditCard;
import org.first_bank.services.Repository;

import java.util.List;

public class CreditCardRepository implements Repository<CreditCard> {

    private final List<CreditCard> creditCardList;

    public CreditCardRepository(List<CreditCard> creditCardList) {
        this.creditCardList = creditCardList;
    }

    @Override
    public void save(CreditCard creditCard) {
        CreditCard existingCard = findByNumber(creditCard.number());
        if (existingCard != null){
            throw new IllegalArgumentException("Two creditCards found with the same number:" + creditCard.number());
        }
        creditCardList.add(creditCard);
    }

    @Override
    public void delete(CreditCard creditCard) {
        creditCardList.remove(creditCard);
    }

    @Override
    public List<CreditCard> findAll() {
        return creditCardList;
    }

    public CreditCard findByNumber(String number){
        for (CreditCard creditCard : creditCardList){
            if (creditCard.number().equals(number)){
                return creditCard;
            }
        }
        return null;
    }
}
