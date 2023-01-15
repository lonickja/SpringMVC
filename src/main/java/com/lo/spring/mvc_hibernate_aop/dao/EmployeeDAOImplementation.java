package com.lo.spring.mvc_hibernate_aop.dao;

import com.lo.spring.mvc_hibernate_aop.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class EmployeeDAOImplementation implements EmployeeDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    //При использовании @Transactional Spring берет на себя ответсвенность за открытие и закрытие транзакции
    //@Transactional
    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();

        //Variant 1
//        List<Employee> allEmployees = session.createQuery("from Employee",
//                Employee.class).getResultList();

        //Variant 2
        Query<Employee> query = session.createQuery("from Employee",Employee.class);
        List<Employee> allEmployees = query.getResultList();


        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();

        Employee employee = session.get(Employee.class, id);

        return employee;
    }
}
