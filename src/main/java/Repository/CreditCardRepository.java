package Repository;

import model.CreditCard;
import services.Repository;

import java.util.List;

public class CreditCardRepository implements Repository<CreditCard> {

    private final List<CreditCard> creditCardList;

    public CreditCardRepository(List<CreditCard> creditCardList) {
        this.creditCardList = creditCardList;
    }

    @Override
    public void save(CreditCard creditCard) {
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
