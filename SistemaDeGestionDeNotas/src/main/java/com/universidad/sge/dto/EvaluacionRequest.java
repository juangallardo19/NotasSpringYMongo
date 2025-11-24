package com.universidad.sge.dto;

public class EvaluacionRequest {
    private String nombre;
    private Double porcentaje;
    private String descripcion;
    private String cursoId;
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Double getPorcentaje() {
        return porcentaje;
    }
    
    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getCursoId() {
        return cursoId;
    }
    
    public void setCursoId(String cursoId) {
        this.cursoId = cursoId;
    }
}