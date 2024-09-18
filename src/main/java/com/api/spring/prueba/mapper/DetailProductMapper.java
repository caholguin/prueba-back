package com.api.spring.prueba.mapper;

import com.api.spring.prueba.dto.GetDetailProductDTO;
import com.api.spring.prueba.dto.GetProductDTO;
import com.api.spring.prueba.model.DetailProduct;
import com.api.spring.prueba.model.Product;

import java.util.List;

public class DetailProductMapper {

    public static GetDetailProductDTO toDTO(DetailProduct detailProduct){

        if(detailProduct == null) return null;

        GetDetailProductDTO detailProductDTO = new GetDetailProductDTO();

        detailProductDTO.setId(detailProduct.getId());
        detailProductDTO.setPrice(detailProduct.getPrice());
        detailProductDTO.setColor(detailProduct.getColor());
        detailProductDTO.setProductId(detailProduct.getProductId());

        return detailProductDTO;
    }

    public static List<GetDetailProductDTO> toDtoList(List<DetailProduct> products){

        if (products == null) return null;

        return products.stream()
                .map(DetailProductMapper::toDTO)
                .toList();
    }
}
