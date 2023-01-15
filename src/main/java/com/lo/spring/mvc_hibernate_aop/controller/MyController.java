package com.lo.spring.mvc_hibernate_aop.controller;

import com.lo.spring.mvc_hibernate_aop.entity.Car;
import com.lo.spring.mvc_hibernate_aop.entity.Employee;
import com.lo.spring.mvc_hibernate_aop.service.CarService;
import com.lo.spring.mvc_hibernate_aop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CarService carService;

    @RequestMapping("/")
    public String showAllEmployees(Model model){

        List<Employee> allEmployees = employeeService.getAllEmployees();

        model.addAttribute("allEmps", allEmployees);

        return "all-employees";
    }

    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        return "adding-employee-view";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.saveEmployee(employee);

        return "redirect:/";
    }

    @RequestMapping("/updateEmployee")
    public String updateEmployee(@RequestParam("empId") int id, Model model){
        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("employee", employee);

        return "adding-employee-view";
    }

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("empId") int id){
        employeeService.deleteEmployee(id);

        return "redirect:/";
    }

    @RequestMapping("/cars")
    public String showAllCars(Model model){
        List<Car> allCars = carService.getAllCars();
        model.addAttribute("allCars", allCars);

        return "all-cars";
    }

    @RequestMapping("/addNewCar")
    public String addNewCar(Model model){
        Car car = new Car();
        model.addAttribute("car", car);

        return "adding-car-view";
    }

    @RequestMapping("/saveCar")
    public String saveCar(@ModelAttribute("car") Car car){
        carService.saveCar(car);

        return "redirect:/cars";
    }

    @RequestMapping("/updateCar")
    public String updateCar(@RequestParam("carId") int id, Model model){
        Car car = carService.getCar(id);
        model.addAttribute("car", car);

        return "adding-car-view";
    }

    @RequestMapping("/deleteCar")
    public String deleteCar(@RequestParam("carId") int id){
        carService.deleteCar(id);

        return "redirect:/cars";
    }
}
