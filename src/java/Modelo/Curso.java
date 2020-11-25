/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author desi
 */
public class Curso {
    private int idCurso;
    private String nombre;
    private double precioTotal;
    private String duracion;
    private int idModalidad;
    private int idTipoCurso;
    private String fechaInicio;
    private String descripcion;

    public Curso(int idCurso, String nombre, double precioTotal, String duracion, int idModalidad, int idTipoCurso, String fechaInicio, String descripcion) {
        this.idCurso = idCurso;
        this.nombre = nombre;
        this.precioTotal = precioTotal;
        this.duracion = duracion;
        this.idModalidad = idModalidad;
        this.idTipoCurso = idTipoCurso;
        this.fechaInicio = fechaInicio;
        this.descripcion = descripcion;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public int getIdModalidad() {
        return idModalidad;
    }

    public void setIdModalidad(int idModalidad) {
        this.idModalidad = idModalidad;
    }

    public int getIdTipoCurso() {
        return idTipoCurso;
    }

    public void setIdTipoCurso(int idTipoCurso) {
        this.idTipoCurso = idTipoCurso;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
