package org.example;

import java.util.List;

public interface DAO {
    void insert(Car car);
    Car findById(int id);
    void update(int id, String model, int year);
    void deleteById(int id);
    void findAll();
}
