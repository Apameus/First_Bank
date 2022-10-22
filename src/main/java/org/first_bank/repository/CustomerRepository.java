package org.first_bank.repository;

import org.first_bank.model.Customer;
import org.first_bank.services.Repository;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements Repository<Customer> {
    
    private final List<Customer> customerList;

    public CustomerRepository() {
        customerList = new ArrayList<>();
    }


    @Override
    public void save(Customer customer) {
        customerList.add(customer);
    }

    @Override
    public void delete(Customer customer) {
        customerList.remove(customer);
    }

    @Override
    public List<Customer> findAll() {
        return customerList;
    }
}
