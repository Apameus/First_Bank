package Serialization;

import model.CreditCard;
import services.Serializer;

public class CreditCardSerializer implements Serializer<CreditCard> {

    //{number} {pin} {balance} {active}

    @Override
    public String serialize(CreditCard creditCard) {
        return "%s %s %s %s".formatted(creditCard.number(), creditCard.pin(), creditCard.balance(), creditCard.active());
    }

    @Override
    public CreditCard parse(String line) {
        String[] values = line.split(" ");
        double balance = Double.parseDouble(values[2]);
        Boolean active = Boolean.parseBoolean(values[3]);
        return new CreditCard(values[0], values[1], balance, active) ;
    }
}
