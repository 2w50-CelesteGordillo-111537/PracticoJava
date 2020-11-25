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
public class DTOAlumno {
    private String apellido;
    private String nombre;
    private String telefono;
    private String email;
    private String descripcion;

    public DTOAlumno(String apellido, String nombre, String telefono, String email, String descripcion) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.descripcion = descripcion;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    
}
