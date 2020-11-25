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
public class Alumno {
    private int idAlumno;
    private String apellido;
    private String nombre;
    private String telefono;
    private String email;
    private int idSexo;

    public Alumno(int idAlumno, String apellido, String nombre, String telefono, String email, int idSexo) {
        this.idAlumno = idAlumno;
        this.apellido = apellido;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.idSexo = idSexo;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdSexo() {
        return idSexo;
    }

    public void setIdSexo(int idSexo) {
        this.idSexo = idSexo;
    }

    
    
}
