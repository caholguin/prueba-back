package com.api.spring.prueba.service.impl;

import com.api.spring.prueba.dto.OperationDTO;

import com.api.spring.prueba.mapper.OperationMapper;
import com.api.spring.prueba.model.security.Operation;
import com.api.spring.prueba.repository.security.OperationRepository;
import com.api.spring.prueba.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OperationServiceImpl implements OperationService {

    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    private OperationMapper operationMapper;



    @Override
    public List<OperationDTO> getOperations(){
        List<Operation> roles = operationRepository.findAll();
        return roles.stream()
                .map(operationMapper::toDTO)
                .collect(Collectors.toList());
    }
}
