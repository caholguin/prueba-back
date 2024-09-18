package com.api.spring.prueba.mapper;

import com.api.spring.prueba.dto.OperationDTO;
import com.api.spring.prueba.dto.RoleDTO;
import com.api.spring.prueba.model.security.GrantedPermission;
import com.api.spring.prueba.model.security.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoleMapper {

    @Autowired
    private OperationMapper operationMapper;

    public RoleDTO toDTO(Role role) {
        RoleDTO roleDTO = new RoleDTO();

        roleDTO.setId(role.getId());
        roleDTO.setName(role.getName());

        List<OperationDTO> operationDTOs;

        if (role.getPermissions() != null) {
            operationDTOs = role.getPermissions().stream()
                    .map(GrantedPermission::getOperation)
                    .map(operationMapper::toDTO)
                    .collect(Collectors.toList());
        } else {
            operationDTOs = new ArrayList<>();
        }

        roleDTO.setOperations(operationDTOs);

        return roleDTO;
    }

    public Role toEntity(RoleDTO roleDTO) {
        Role role = new Role();

        role.setId(roleDTO.getId());
        role.setName(roleDTO.getName());

        return role;
    }
}
