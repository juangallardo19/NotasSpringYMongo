package com.universidad.sge.model.entity;

import com.universidad.sge.model.enums.RolEnum;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuarios")
public class Administrador extends Usuario {
    
    public Administrador() {
        super();
    }
    
    public Administrador(String nombre, String apellido, String email, String username, String password) {
        super(nombre, apellido, email, username, password, RolEnum.ADMIN);
    }
    
    @Override
    public String getDescripcionRol() {
        return "Administrador del Sistema - Puede crear cursos y usuarios";
    }
}