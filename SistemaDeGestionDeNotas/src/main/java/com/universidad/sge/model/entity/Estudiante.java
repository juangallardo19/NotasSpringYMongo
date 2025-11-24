package com.universidad.sge.model.entity;

import com.universidad.sge.model.enums.ClasificacionEnum;
import com.universidad.sge.model.enums.RolEnum;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "usuarios")
public class Estudiante extends Usuario {
    
    private List<String> cursosInscritos;
    private Double promedioGeneral;
    private ClasificacionEnum clasificacion;
    
    public Estudiante() {
        super();
        this.cursosInscritos = new ArrayList<>();
        this.clasificacion = ClasificacionEnum.SIN_CALIFICAR;
    }
    
    public Estudiante(String nombre, String apellido, String email, String username, String password) {
        super(nombre, apellido, email, username, password, RolEnum.ESTUDIANTE);
        this.cursosInscritos = new ArrayList<>();
        this.clasificacion = ClasificacionEnum.SIN_CALIFICAR;
    }
    
    @Override
    public String getDescripcionRol() {
        return "Estudiante - Puede consultar sus notas y promedios";
    }
    
    public void inscribirCurso(String cursoId) {
        this.cursosInscritos.add(cursoId);
    }
    
    public List<String> getCursosInscritos() {
        return cursosInscritos;
    }
    
    public void setCursosInscritos(List<String> cursosInscritos) {
        this.cursosInscritos = cursosInscritos;
    }
    
    public Double getPromedioGeneral() {
        return promedioGeneral;
    }
    
    public void setPromedioGeneral(Double promedioGeneral) {
        this.promedioGeneral = promedioGeneral;
    }
    
    public ClasificacionEnum getClasificacion() {
        return clasificacion;
    }
    
    public void setClasificacion(ClasificacionEnum clasificacion) {
        this.clasificacion = clasificacion;
    }
}