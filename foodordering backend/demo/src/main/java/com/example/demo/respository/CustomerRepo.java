package com.example.demo.respository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer , Long> {
    // You can define custom methods for specific queries if needed
}
