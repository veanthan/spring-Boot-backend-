package com.example.demo.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Customershoppingcard;

public interface CustomerShoppingRepo extends JpaRepository<Customershoppingcard,Integer>{
    
        
    }
    

