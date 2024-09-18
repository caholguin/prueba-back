package com.api.spring.prueba.mapper;

import com.api.spring.prueba.dto.OperationDTO;
import com.api.spring.prueba.model.security.Operation;
import org.springframework.stereotype.Component;

@Component
public class OperationMapper {

    public OperationDTO toDTO(Operation operation) {
        OperationDTO operationDTO = new OperationDTO();

        operationDTO.setId(operation.getId());
        operationDTO.setName(operation.getName());
        operationDTO.setPath(operation.getPath());
        operationDTO.setHttpMethod(operation.getHttpMethod());
        operationDTO.setPermitAll(operation.isPermitAll());

        return operationDTO;
    }

    public Operation toEntity(OperationDTO operationDTO) {
        Operation operation = new Operation();

        operation.setId(operationDTO.getId());
        operation.setName(operationDTO.getName());
        operation.setPath(operationDTO.getPath());
        operationDTO.setHttpMethod(operation.getHttpMethod());
        operationDTO.setPermitAll(operation.isPermitAll());

        return operation;
    }

}
