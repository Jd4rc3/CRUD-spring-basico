package com.example.crud.service.interfaces;

public interface ICRUD<T> {
    T create(T t);

    T findById(Integer id);

    T update(T t, Integer id);

    void delete(Integer id);
}
