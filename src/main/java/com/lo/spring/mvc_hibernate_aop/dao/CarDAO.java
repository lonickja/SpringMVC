package com.lo.spring.mvc_hibernate_aop.dao;

import com.lo.spring.mvc_hibernate_aop.entity.Car;

import java.util.List;

public interface CarDAO {
    public List<Car> getAllCars();

    public void saveCar(Car car);

    public Car getCar(int id);
}
