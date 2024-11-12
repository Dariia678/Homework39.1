package com.example.controller;

import com.example.dao.CustomerDao;
import com.example.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerDao customerDao;

    @Autowired
    public CustomerController(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    // Эндпоинт для получения всех клиентов
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    // Эндпоинт для добавления нового клиента
    @PostMapping
    public void addCustomer(@RequestBody Customer customer) {
        customerDao.addCustomer(customer);
    }

    // Эндпоинт для получения клиента по ID
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        return customerDao.getCustomerById(id);
    }

    // Тестовый эндпоинт для проверки работы контроллера
    @GetMapping("/test")
    public String testEndpoint() {
        return "Test endpoint is working!";
    }
}