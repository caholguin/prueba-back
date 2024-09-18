package com.api.spring.prueba.mapper;

import com.api.spring.prueba.dto.GetProductDTO;
import com.api.spring.prueba.model.Product;



public class ProductMapper {

    public static GetProductDTO toDTO(Product product){

        if(product == null) return null;

        GetProductDTO productDTO = new GetProductDTO();

        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setBrand(product.getBrand());
        productDTO.setModel(product.getModel());
        productDTO.setData(DetailProductMapper.toDtoList(product.getDetails()));

        return productDTO;
    }

}
