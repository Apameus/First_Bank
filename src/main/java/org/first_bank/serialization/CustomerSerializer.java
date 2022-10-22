package org.first_bank.serialization;

import org.first_bank.repository.CreditCardRepository;
import org.first_bank.repository.TransactionRepository;
import org.first_bank.model.CreditCard;
import org.first_bank.model.Customer;
import org.first_bank.model.Transaction;
import org.first_bank.services.Serializer;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.UUID;

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

    @Override
    public Customer parse(String line) {
        String[] values = line.split(",");;
        Long phone = parsePhoneNumber(values[1]);
        List<CreditCard> creditCards = parseCreditCards(values[2]);
        List<Transaction> transactions = parseTransactions(values[3]);
        return new Customer(values[0], phone, creditCards, transactions);
    }

    private List<Transaction> parseTransactions(String value) {
        List<Transaction> transactions = new ArrayList<>();
        if (value.equals("null")){
            return transactions;
        }

        String[] transactionsIds = value.split(",");
        for (var e : transactionsIds){
            transactions.add(transactionRepository.findTransactionById(UUID.fromString(e)));
        }

        return transactions;
    }

    private List<CreditCard> parseCreditCards(String value) {
        List<CreditCard> creditCards = new ArrayList<>();

        if (value.equals("null")){
            return creditCards;
        }

        String[] creditCardsNumbers = value.split(",");
        for (var e: creditCardsNumbers){
            creditCards.add(creditCardRepository.findByNumber(e));
        }

        return creditCards;
    }

    private Long parsePhoneNumber(String value) {
        if (value.equals("null")){
            return null;
        }
        return Long.parseLong(value);
    }

    private String joinTransactionIds(List<Transaction> transactions) {
        if (transactions.isEmpty()){
            return "null";
        }
        StringJoiner joiner = new StringJoiner(",");
        for (Transaction transaction : transactions){
            joiner.add((transaction.uuid().toString()));
        }
        return joiner.toString();
    }

    private String joinCreditCardNumbers(List<CreditCard> creditCards) {
        if (creditCards.isEmpty()){
            return "null";
        }
        StringJoiner joiner = new StringJoiner(",");
        for (CreditCard creditCard : creditCards){
            joiner.add(creditCard.number());
        }
        return joiner.toString();
    }
}
