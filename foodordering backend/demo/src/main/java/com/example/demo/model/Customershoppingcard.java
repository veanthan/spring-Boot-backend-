package com.example.demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Customershoppingcard {
    @Id
    private int customerId;
    private String iceCream;
    private String juice;
    private String snackes;
    @OneToMany( mappedBy = "shop",cascade = CascadeType.ALL)
    private List<Customer>cust;
    List<Customershoppingcard> getSortedPages(int pageNo, int pageSize,
            String sortBy) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSortedPages'");
    }

}
