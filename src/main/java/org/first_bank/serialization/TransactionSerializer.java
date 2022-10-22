package org.first_bank.serialization;

import org.first_bank.repository.CreditCardRepository;
import org.first_bank.repository.EmployeeRepository;
import org.first_bank.model.CreditCard;
import org.first_bank.model.Employee;
import org.first_bank.model.Transaction;
import org.first_bank.services.Serializer;

import java.time.LocalDate;
import java.util.UUID;

public class TransactionSerializer implements Serializer<Transaction> {

    private final EmployeeRepository employeeRepository;
    private final CreditCardRepository creditCardRepository;

    public TransactionSerializer(EmployeeRepository employeeRepository, CreditCardRepository creditCardRepository) {
        this.employeeRepository = employeeRepository;
        this.creditCardRepository = creditCardRepository;
    }

    //{Uuid} {isDeposit} {amount} {employee.username} {creditCard.number} {time}

    @Override
    public String serialize(Transaction transaction) {
        return "%s %s %s %s %s %s".formatted(transaction.uuid(), transaction.isDeposit(),
                                                    transaction.amount(), transaction.employee().username(),
                                                    transaction.creditCard().number(), transaction.time());
    }

    @Override
    public Transaction parse(String line) {
        String[] values = line.split(" ");
        UUID uuid = UUID.fromString(values[0]);
        boolean isDeposit = Boolean.parseBoolean(values[1]);
        double amount = Double.parseDouble(values[2]);
        Employee employee = employeeRepository.findEmployeeByUsername(values[3]);
        CreditCard creditCard = creditCardRepository.findByNumber(values[4]);
        LocalDate time = LocalDate.parse(values[5]);
        return new Transaction(uuid, isDeposit, amount, employee, creditCard, time);
    }
}
