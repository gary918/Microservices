package com.gary.eshop;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Product{
    public Long id;
    public String name;

    Product(@JsonProperty("id") Long id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
    return this.id;
    }

    public String getName() {
    return this.name;
    }
    
    @Override
    public boolean equals(Object o) {
  
      if (this == o)
        return true;
      if (!(o instanceof Product))
        return false;
      Product product = (Product) o;
      return Objects.equals(this.id, product.id);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name);
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + this.id + ", name='" + this.name + '\'' + '}';
    }
}