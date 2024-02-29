package com.example.demo.service;
import org.hibernate.id.uuid.CustomVersionOneStrategy;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.demo.controller.CustomerDetails;
import com.example.demo.model.Customer;
import com.example.demo.model.Customershoppingcard;
import com.example.demo.respository.CustomerRepo;
import com.example.demo.respository.CustomerShoppingRepo;

import java.util.List;

@Service
public class CustomerService {
    
    private CustomerRepo customerRepo;
    

    public CustomerService(CustomerRepo customerRepo)
    {
        this.customerRepo=customerRepo;
    }
    @Autowired
    private CustomerShoppingRepo shoprep;
    

    // @Override
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    // @Override
    public Customer getCustomerById(Long customerId) {
        return customerRepo.findById(customerId).orElse(null);

    }
    // @Override
   public Customer createCustomer(Customer customer)
   {
       return customerRepo.save(customer);
   }

    // @Override
    public Customer updateCustomer(Long customerId, Customer customer) {
        Customer existingCustomer = customerRepo.findById(customerId).orElse(null);
        if (existingCustomer != null) {
            existingCustomer.setFirstName(customer.getFirstName());
            existingCustomer.setLastName(customer.getLastName());
            existingCustomer.setEmail(customer.getEmail());
            existingCustomer.setPhoneNumber(customer.getPhoneNumber());
            return customerRepo.save(existingCustomer);
        }
        return null;
    }

    // @Override
    public void deleteCustomer(Long customerId) {
        customerRepo.deleteById(customerId);
    }
    public Customershoppingcard get(Customershoppingcard add)
    {
        return shoprep.save(add);
    }
    public  Customer get(Customer product)
    {
        
       return customerRepo.save(product);
    }


    public List<Customer> getSortedPages(int pageNo, int pageSize, String sortBy)
    {
        return customerRepo.findAll(PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.ASC, sortBy))).getContent();
    }
    
    public List<Customer> getPages(int pageNo,int pageSize)
    {
       return customerRepo.findAll(PageRequest.of(pageNo,pageSize)).getContent();
    }



}