package com.gary.eshop;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
public class EshopDatabase{
    private ConcurrentHashMap<Long, Product> db;

    public EshopDatabase(){
        db = new ConcurrentHashMap<>();
    }
    
    public boolean add(Product newProduct){
        boolean success = false;
        if (db.containsKey(newProduct.getId()))
            return success;

        try{
            db.put(newProduct.getId(),newProduct);
            success = true;
        }
        catch(Exception e){
            System.out.println(e.getStackTrace());
        }
        return success;
    }

    public List<Product> listAll(){
        System.out.println("Printing all keys and values of ConcurrentHashMap"); 
        for (ConcurrentHashMap.Entry<Long, Product> entry : db.entrySet()) { 
            Long key = entry.getKey(); 
            Product value = entry.getValue(); 
            System.out.println("key: " + key + " value: " + value.getName()); 
        }

        List<Product> lp = db.values().stream().collect(Collectors.toList());
        return lp;

    }
}