package com.example.demo.dao;

import java.util.List;

public interface DAO<T, ID> {

    List<T> findAll();

    T getById(ID id);

    long create(T t);

    long update(T t);

    void delete(Long id);


}
