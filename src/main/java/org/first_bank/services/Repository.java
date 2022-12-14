package org.first_bank.services;

import java.util.List;

public interface Repository<T> {

    void save(T t);

    void delete(T t);

    List<T> findAll();
}
