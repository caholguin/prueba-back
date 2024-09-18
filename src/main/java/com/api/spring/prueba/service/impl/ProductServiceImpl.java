package com.api.spring.prueba.service.impl;

import com.api.spring.prueba.dto.GetProductDTO;
import com.api.spring.prueba.dto.SaveDetailProductDTO;
import com.api.spring.prueba.dto.SaveProductDTO;
import com.api.spring.prueba.mapper.ProductMapper;
import com.api.spring.prueba.model.DetailProduct;
import com.api.spring.prueba.model.Product;
import com.api.spring.prueba.repository.ProductRepository;
import com.api.spring.prueba.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<GetProductDTO> findAll(Pageable pageable){
        Page<Product> products = productRepository.findAll(pageable);
        return products.map(ProductMapper::toDTO);
    }

    @Override
    public GetProductDTO create(SaveProductDTO saveProductDTO){

        Product product = new Product();

        product.setName(saveProductDTO.getName());
        product.setBrand(saveProductDTO.getBrand());
        product.setModel(saveProductDTO.getModel());

        Product savedProduct = productRepository.save(product);

        List<DetailProduct> detailProducts = new ArrayList<>();
        for (SaveDetailProductDTO detailDTO : saveProductDTO.getData()) {
            DetailProduct detailProduct = new DetailProduct();
            detailProduct.setColor(detailDTO.getColor());
            detailProduct.setPrice(detailDTO.getPrice());
            detailProduct.setProductId(savedProduct.getId());

            detailProduct.setProduct(savedProduct);
            detailProducts.add(detailProduct);
        }

        savedProduct.setDetails(detailProducts);
        productRepository.save(savedProduct);

        return ProductMapper.toDTO(savedProduct);
    }


}
