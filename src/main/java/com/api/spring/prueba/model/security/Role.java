package com.api.spring.prueba.model.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<GrantedPermission> permissions = new ArrayList<>();;

    public Role(){

    }

    public Role(Long id, String name, List<GrantedPermission> permissions){
        this.id = id;
        this.name = name;
        this.permissions = permissions;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public List<GrantedPermission> getPermissions(){
        if (permissions == null) {
            permissions = new ArrayList<>(); // Inicialización lazy
        }
        return permissions;
    }

    public void setPermissions(List<GrantedPermission> permissions){
        this.permissions = permissions;
    }

}
