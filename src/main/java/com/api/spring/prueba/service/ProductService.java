package com.api.spring.prueba.service;

import com.api.spring.prueba.dto.GetProductDTO;
import com.api.spring.prueba.dto.SaveProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProductService {

    Page<GetProductDTO> findAll(Pageable pageable);

    GetProductDTO create(SaveProductDTO saveProductDTO);


}
