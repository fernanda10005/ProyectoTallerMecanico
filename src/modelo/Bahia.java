/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author ASUS
 */
public class Bahia {
    
    private int codigo;
    private int capacidad;
    private TipoBahia tipo;
    private EstadoBahia estado;

    public Bahia(int codigo, int capacidad, TipoBahia tipo, EstadoBahia estado) {
        this.codigo = codigo;
        this.capacidad = capacidad;
        this.tipo = tipo;
        this.estado = estado;
    }

    public Bahia(int codigo, int capacidad, TipoBahia tipo) {
        this.codigo = codigo;
        this.capacidad = capacidad;
        this.tipo = tipo;
        this.estado = EstadoBahia.LIBRE;
    }
    
    public Bahia(int capacidad, TipoBahia tipo) {
        this.capacidad = capacidad;
        this.tipo = tipo;
        this.estado = EstadoBahia.LIBRE;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public TipoBahia getTipo() {
        return tipo;
    }

    public void setTipo(TipoBahia tipo) {
        this.tipo = tipo;
    }

    public EstadoBahia getEstado() {
        return estado;
    }

    public void setEstado(EstadoBahia estado) {
        this.estado = estado;
    }  
    
}
