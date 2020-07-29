package com.javatechie.spring.mongo.api.resource;

import com.javatechie.spring.mongo.api.model.Sales;
import com.javatechie.spring.mongo.api.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SalesController {

    @Autowired
    private SalesRepository repository;

    @PostMapping("/addSales")
    public String saveSales(@RequestBody Sales sales) {
        repository.save(sales);
        return "Added sales with id : " + sales.getId();
    }

    @GetMapping("/findAllSales")
    public List<Sales> getSales() {
        return repository.findAll();
    }

    @GetMapping("/findSales/{id}")
    public Optional<Sales> getSales(@PathVariable String id) {
        return repository.findById(id);
    }

    @PostMapping("/update/{id}")
    public Sales updateUser(@PathVariable("id") String id, @RequestBody Sales sales){

        Optional<Sales> db_sales = repository.findById(id);

        db_sales.get().setAddress(sales.getAddress());
        db_sales.get().setComments(sales.getComments());
        db_sales.get().setContact(sales.getContact());
        db_sales.get().setEmail(sales.getEmail());
        db_sales.get().setName(sales.getName());
        db_sales.get().setNumber(sales.getNumber());

        return repository.save(db_sales.get());
    }

    @DeleteMapping("/deleteSales/{id}")
    public String deleteSales(@PathVariable String id) {
        repository.deleteById(id);
        return "sales deleted with id : " + id;
    }
}
