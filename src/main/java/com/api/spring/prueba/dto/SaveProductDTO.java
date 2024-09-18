package com.api.spring.prueba.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class SaveProductDTO implements Serializable {

    @NotBlank(message = "El nombre no puede estar vacio")
    private String name;

    @DecimalMin(value="0.01", message = "El precio debe ser mayor a cero")
    private BigDecimal price;

    private String brand;

    private String model;

    private List<SaveDetailProductDTO> data;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public BigDecimal getPrice(){
        return price;
    }

    public void setPrice(BigDecimal price){
        this.price = price;
    }

    public String getBrand(){
        return brand;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }

    public String getModel(){
        return model;
    }

    public void setModel(String model){
        this.model = model;
    }

    public List<SaveDetailProductDTO> getData(){
        return data;
    }

    public void setData(List<SaveDetailProductDTO> data){
        this.data = data;
    }
}
