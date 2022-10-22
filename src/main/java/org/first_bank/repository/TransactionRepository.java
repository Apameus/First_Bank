package org.first_bank.repository;

import org.first_bank.model.Transaction;
import org.first_bank.services.Repository;

import java.util.List;
import java.util.UUID;

public class TransactionRepository implements Repository<Transaction> {

    private final List<Transaction> transactionList;

    public TransactionRepository(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    @Override
    public void save(Transaction transaction) {
        transactionList.add(transaction);
    }

    @Override
    public void delete(Transaction transaction) {
        transactionList.remove(transaction);
    }

    @Override
    public List<Transaction> findAll() {
        return transactionList;
    }

    public Transaction findTransactionById(UUID id){
        for (Transaction transaction : transactionList){
            if (transaction.uuid().equals(id)){
                return transaction;
            }
        }
        return null;
    }
}
