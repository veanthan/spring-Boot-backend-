package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Customer;
import com.example.demo.model.Customershoppingcard;
import com.example.demo.service.CustomerService;

@RestController
// @RequestMapping("/api/customer")     
public class CustomerDetails {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomerId(@PathVariable Long customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping("/customer")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer savedCustomer = customerService.createCustomer(customer);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long customerId, @RequestBody Customer customer) {
        Customer updatedCustomer = customerService.updateCustomer(customerId, customer);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long customerId) {
        customerService.deleteCustomer(customerId);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/foodDetails")
      public Customer get(@RequestBody Customer customer)
        {
           return customerService.get(customer);
        }

    @PostMapping("/Add")
    public Customershoppingcard get(@RequestBody Customershoppingcard add)
    {
        return customerService.get(add);
    }

    @GetMapping("/getfood")
    public List<Customer> getPages(@RequestParam("pageNo") int pageNo,@RequestParam("pageSize") int pageSize)
    {
        return customerService.getPages(pageNo,pageSize);

    }
    @GetMapping("/getfoods/sort")
    public List<Customer> getfoods(@RequestParam("pageNo") int pageNo,@RequestParam("pageSize") int pageSize,@RequestParam("sortBy") String sortBy)
    {
        return customerService.getSortedPages(pageNo,pageSize,sortBy);
    }
}















