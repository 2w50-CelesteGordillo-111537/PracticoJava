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
public class TipoCurso {
    private int idTipoCurso;
    private String descripcion;

    public TipoCurso(int idTipoCurso, String descripcion) {
        this.idTipoCurso = idTipoCurso;
        this.descripcion = descripcion;
    }

    public int getIdTipoCurso() {
        return idTipoCurso;
    }

    public void setIdTipoCurso(int idTipoCurso) {
        this.idTipoCurso = idTipoCurso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return  descripcion;
    }
    
    
}
