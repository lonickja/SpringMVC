package com.lo.spring.mvc_hibernate_aop.service;

import com.lo.spring.mvc_hibernate_aop.entity.Car;

import java.util.List;

public interface CarService {
    public List<Car> getAllCars();

    public void saveCar(Car car);

    public Car getCar(int id);

    public void deleteCar(int id);
}
