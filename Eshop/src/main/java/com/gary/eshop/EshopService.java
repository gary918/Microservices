package com.gary.eshop;

//import java.util.List;

import org.springframework.http.HttpStatus;
import org.apache.logging.log4j.util.ProcessIdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeStrategies;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import io.dapr.client.DaprClient;
import io.dapr.client.DaprClientBuilder;
import io.dapr.client.domain.HttpExtension;


@Component
public class EshopService{
    @Autowired EshopDatabase edb;

    private final WebClient cataloguWebClient;
    private final WebClient orderWebClient;

    public EshopService(){
        cataloguWebClient = WebClient.create("http://localhost:3500");
        orderWebClient = WebClient.create("http://localhost:3600");
    }
    
    public HttpStatus addProduct(Product newProduct){
        if(edb.add(newProduct)){
            return HttpStatus.CREATED;
        }
        else{
            return HttpStatus.BAD_REQUEST;
        }

    }

    public Flux<Product> listAll(){

        return cataloguWebClient.get().uri("/v1.0/invoke/catalogue/method/listall")
        .retrieve()
        .bodyToFlux(Product.class);

    }

    public Product listOne(){

        return WebClient.create("http://localhost:3500").get().uri("/v1.0/invoke/catalogue/method/product")
        .retrieve()
        .bodyToMono(Product.class)
        .block();

    }

    
    public Mono<Product> product(){
        Mono<Product> entityMono = WebClient.create("http://localhost:3500").get().uri("/v1.0/invoke/catalogue/method/product")
        .accept(MediaType.APPLICATION_JSON)
        .retrieve()
        .bodyToMono(Product.class);

        return entityMono; 
    }


    public String listOutside(){

        return WebClient.create("https://api.zippopotam.us").get().uri("/us/90210")
        .retrieve()
        .bodyToMono(String.class)
        .block();

    }


    public String alldapr(){
        String responeString = "Nothing"; 
        try (DaprClient client = (new DaprClientBuilder()).build()) {
            byte[] response = client.invokeMethod("catalogue", "listall", "{\"name\":\"World!\"}", HttpExtension.GET,
                byte[].class).block();
            responeString = new String(response);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return responeString;
    }
}