package com.universidad.sge.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "notas")
public class Nota {
    
    @Id
    private String id;
    private Double valor;
    private String estudianteId;
    private String evaluacionId;
    private String cursoId;
    private Double aportePromedio;
    private String observaciones;
    private LocalDateTime fechaRegistro;
    private String profesorRegistro;
    
    public Nota() {
        this.fechaRegistro = LocalDateTime.now();
    }
    
    public void calcularAporte(Double porcentaje) {
        if (this.valor != null && porcentaje != null) {
            this.aportePromedio = this.valor * (porcentaje / 100.0);
        }
    }
    
    public boolean validarRango() {
        return valor >= 0.0 && valor <= 5.0;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public Double getValor() {
        return valor;
    }
    
    public void setValor(Double valor) {
        this.valor = valor;
    }
    
    public String getEstudianteId() {
        return estudianteId;
    }
    
    public void setEstudianteId(String estudianteId) {
        this.estudianteId = estudianteId;
    }
    
    public String getEvaluacionId() {
        return evaluacionId;
    }
    
    public void setEvaluacionId(String evaluacionId) {
        this.evaluacionId = evaluacionId;
    }
    
    public String getCursoId() {
        return cursoId;
    }
    
    public void setCursoId(String cursoId) {
        this.cursoId = cursoId;
    }
    
    public Double getAportePromedio() {
        return aportePromedio;
    }
    
    public void setAportePromedio(Double aportePromedio) {
        this.aportePromedio = aportePromedio;
    }
    
    public String getObservaciones() {
        return observaciones;
    }
    
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }
    
    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    public String getProfesorRegistro() {
        return profesorRegistro;
    }
    
    public void setProfesorRegistro(String profesorRegistro) {
        this.profesorRegistro = profesorRegistro;
    }
}