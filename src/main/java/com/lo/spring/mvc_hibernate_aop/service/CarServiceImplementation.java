package com.lo.spring.mvc_hibernate_aop.service;

import com.lo.spring.mvc_hibernate_aop.dao.CarDAO;
import com.lo.spring.mvc_hibernate_aop.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceImplementation implements CarService{

    @Autowired
    private CarDAO carDAO;

    @Override
    @Transactional
    public List<Car> getAllCars() {
        return carDAO.getAllCars();
    }

    @Override
    @Transactional
    public void saveCar(Car car) {
        carDAO.saveCar(car);
    }

    @Override
    @Transactional
    public Car getCar(int id) {
        return carDAO.getCar(id);
    }

    @Override
    @Transactional
    public void deleteCar(int id) {
        carDAO.deleteCar(id);
    }
}
