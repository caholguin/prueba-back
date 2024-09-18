package com.api.spring.prueba.controller;

import com.api.spring.prueba.dto.GetProductDTO;
import com.api.spring.prueba.dto.SaveProductDTO;
import com.api.spring.prueba.model.Product;
import com.api.spring.prueba.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/products")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductService productService;

    //@PreAuthorize("hasAuthority('READ_ALL_PRODUCTS')")
    @GetMapping
    public ResponseEntity<Page<GetProductDTO>> findAll(Pageable pageable) {

        Page<GetProductDTO> productsPage = productService.findAll(pageable);

        if(productsPage.hasContent()) {
            return new ResponseEntity<>(productsPage,HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PreAuthorize("hasAuthority('CREATE_ONE_PRODUCT')")
    @PostMapping()
    public ResponseEntity<GetProductDTO> create(@RequestBody @Valid SaveProductDTO saveProductDTO) {
        GetProductDTO product = productService.create(saveProductDTO);
        return new ResponseEntity<>(product,HttpStatus.CREATED);
    }


}
