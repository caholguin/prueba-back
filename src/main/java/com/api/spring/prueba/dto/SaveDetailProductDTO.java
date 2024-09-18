package com.api.spring.prueba.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class SaveDetailProductDTO implements Serializable {

    private Long productId;
    private BigDecimal price;
    private String color;

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
