package com.api.spring.prueba.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class GetDetailProductDTO implements Serializable {

    private Long id;
    private Long productId;
    private BigDecimal price;
    private String color;


    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Long getProductId(){
        return productId;
    }

    public void setProductId(Long productId){
        this.productId = productId;
    }

    public BigDecimal getPrice(){
        return price;
    }

    public void setPrice(BigDecimal price){
        this.price = price;
    }

    public String getColor(){
        return color;
    }

    public void setColor(String color){
        this.color = color;
    }
}
