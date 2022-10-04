package Serialization;

import Repository.CreditCardRepository;
import Repository.TransactionRepository;
import model.CreditCard;
import model.Customer;
import model.Transaction;
import services.Serializer;

import java.util.List;
import java.util.StringJoiner;

public class CustomerSerializer implements Serializer<Customer> {

    //              null                null                        null
    // {fullName} {phone} {creditCards.number join ','} {transactions.id join ','}

    private final CreditCardRepository creditCardRepository;
    private final TransactionRepository transactionRepository;

    public CustomerSerializer(CreditCardRepository creditCardRepository, TransactionRepository transactionRepository) {
        this.creditCardRepository = creditCardRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public String serialize(Customer customer) {
        return "%s %s %s %s".formatted(customer.fullName(), customer.phone(),
                                        joinCreditCardNumbers(customer.creditCards()),
                                        joinTransactionIds(customer.transactions()));
    }

    private String joinTransactionIds(List<Transaction> transactions) {
        StringJoiner joiner = new StringJoiner(",");
        for (Transaction transaction : transactions){
            joiner.add((transaction.uuid().toString()));
        }
        return joiner.toString();
    }

    private String joinCreditCardNumbers(List<CreditCard> creditCards) {
        StringJoiner joiner = new StringJoiner(",");
        for (CreditCard creditCard : creditCards){
            joiner.add(creditCard.number());
        }
        return joiner.toString();
    }

    @Override
    public Customer parse(String line) {
        String[] values = line.split(" ");;
        long phone = Long.parseLong(values[1]);
        return new Customer(values[0], phone,);
    }
}
