package com.api.spring.prueba.service;

import com.api.spring.prueba.dto.RoleDTO;
import com.api.spring.prueba.model.security.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
   Optional<Role> findDefaultRole();

   List<RoleDTO> getRoles();

   Optional<RoleDTO> findById(Long id);

   RoleDTO save(RoleDTO role);

   RoleDTO update(Long id,RoleDTO roleDto);

   void delete(Long id);
}
