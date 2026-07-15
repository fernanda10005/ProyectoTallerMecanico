/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import modelo.Bahia;
import modelo.EstadoBahia;
import modelo.EstadoOrden;
import modelo.OrdenTrabajo;
/**
 *
 * @author ASUS
 */
public class gestor_ordenes extends gestor_generico<OrdenTrabajo> {

    @Override
    public OrdenTrabajo agregar(OrdenTrabajo orden) {

        if (orden == null) {
            return null;
        }

        if (orden.getCita() == null || orden.getBahia() == null) {
            return null;
        }

        Bahia bahia = orden.getBahia();

        if (bahia.getEstado() != EstadoBahia.LIBRE) {
            return null;
        }

        OrdenTrabajo resultado = super.agregar(orden);

        if (resultado != null) {
            bahia.setEstado(EstadoBahia.OCUPADA);
            
            // AGREGAR ESTA LÍNEA: Traspasa automáticamente el servicio de la cita a la orden
            if (orden.getCita() != null && orden.getCita().getServicio() != null) {
                orden.agregarServicio(orden.getCita().getServicio());
            }
        }

        return resultado;
    }

    public boolean entregar(OrdenTrabajo orden, String fechaEntrega, EstadoBahia estadoFinalBahia) {

        if (orden == null) {
            return false;
        }

        if (orden.getEstado() != EstadoOrden.ACTIVA) {
            return false;
        }

        if (fechaEntrega == null || fechaEntrega.isBlank()) {
            return false;
        }

        if (estadoFinalBahia != EstadoBahia.LIBRE && estadoFinalBahia != EstadoBahia.EN_MANTENIMIENTO) {
            return false;
        }

        orden.setFechaEntrega(fechaEntrega);
        orden.setEstado(EstadoOrden.ENTREGADA);
        orden.getBahia().setEstado(estadoFinalBahia);

        return true;
        
    }
}