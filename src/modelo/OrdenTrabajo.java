/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class OrdenTrabajo implements Identificable {

    private int codigo;
    private Cita cita;
    private Bahia bahia;
    private String fechaRecepcion;
    private String fechaEntrega;
    private EstadoOrden estado;

    private ArrayList<Servicio> servicios;
    private ArrayList<DetalleRepuesto> repuestos;

    public OrdenTrabajo(int codigo, Cita cita, Bahia bahia, String fechaRecepcion) {

        this.codigo = codigo;
        this.cita = cita;
        this.bahia = bahia;
        this.fechaRecepcion = fechaRecepcion;
        this.fechaEntrega = "";
        this.estado = EstadoOrden.ACTIVA;

        this.servicios = new ArrayList<Servicio>();
        this.repuestos = new ArrayList<DetalleRepuesto>();
    }

    @Override
    public int getCodigo() {
        return codigo;
    }

    @Override
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    public Bahia getBahia() {
        return bahia;
    }

    public void setBahia(Bahia bahia) {
        this.bahia = bahia;
    }

    public String getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(String fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public EstadoOrden getEstado() {
        return estado;
    }

    public void setEstado(EstadoOrden estado) {
        this.estado = estado;
    }

    /*Devuelve los servicios registrados en la orden.*/
    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    /*Devuelve los repuestos registrados en la orden.*/
    public ArrayList<DetalleRepuesto> getRepuestos() {
        return repuestos;
    }

    /*Agrega un servicio solamente si la orden sigue activa.*/
    public boolean agregarServicio(Servicio servicio) {
        if (servicio != null && estado == EstadoOrden.ACTIVA) {
            servicios.add(servicio);
            return true;
        }
        return false;
    }

    /*Agrega un repuesto solamente si la orden sigue activa.*/
    public boolean agregarRepuesto(DetalleRepuesto repuesto) {
        if (repuesto != null && estado == EstadoOrden.ACTIVA) {
            repuestos.add(repuesto);
            return true;
        }
        return false;
    }
    
    /*Calculos*/

    public double calcularTotalServicios() {

        double total = 0;

        for (Servicio servicio : servicios) {
            total += servicio.getPrecio();
        }
        return total;
    }

    public double calcularTotalRepuestos() {

        double total = 0;

        for (DetalleRepuesto repuesto : repuestos) {
            total += repuesto.calcularSubtotal();
        }
        return total;
    }

    public double calcularTotal() {
        return calcularTotalServicios() + calcularTotalRepuestos();
    }
    
}
