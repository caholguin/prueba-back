package com.api.spring.prueba.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class GetProductDTO implements Serializable {

    private Long id;

    private String name;

    private String brand;

    private String model;

    private List<GetDetailProductDTO> data;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
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

    public List<GetDetailProductDTO> getData(){
        return data;
    }

    public void setData(List<GetDetailProductDTO> data){
        this.data = data;
    }
}
