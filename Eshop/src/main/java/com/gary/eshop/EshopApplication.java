package com.gary.eshop;

//import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;



@SpringBootApplication
@RestController
public class EshopApplication {
	@Autowired 
	EshopService es;

	public static void main(String[] args) {
		SpringApplication.run(EshopApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@PostMapping("/product/add")
	public HttpStatus addProduct(@RequestBody Product newProduct){
		return es.addProduct(newProduct);
	}

	@GetMapping("/product/listall")
	public Flux<Product> listAll() {
		return es.listAll();
	}

	@GetMapping("/product/listone")
	public Product listOne() {
		return es.listOne();
	}

	@GetMapping("/product/listoutside")
	public String listOutside() {
		return es.listOutside();
	}

	@GetMapping("/product/product")
	public Mono<Product> product() {
		return es.product();
	}

	@GetMapping("/product/alldapr")
	public String alldapr() {
		return es.alldapr();
	}

}
