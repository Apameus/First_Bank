package org.first_bank.serialization;

import org.first_bank.model.CreditCard;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardSerializerTest extends RandomModelGenerator{
    CreditCardSerializer serializer = new CreditCardSerializer();

    @Test
    @DisplayName("SerializeCreditCard")
    void serializeCreditCard(){
        CreditCard creditCard = createRandomCreditCard();
        String expectedLine = "%s %s %s %s".formatted(creditCard.number(), creditCard.pin(),
                                                        creditCard.balance(), creditCard.active());
        assertEquals(expectedLine, serializer.serialize(creditCard));

    }
}