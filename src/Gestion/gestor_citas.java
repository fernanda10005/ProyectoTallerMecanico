/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import modelo.Bahia;
import modelo.Cita;
import modelo.EstadoBahia;
import modelo.Servicio;
import modelo.TipoBahia;
import modelo.TipoServicio;

/**
 *
 * @author ASUS
 */

public class gestor_citas extends gestor_generico<Cita> {

    @Override
    public Cita agregar(Cita cita) {

        if (cita != null && bahiaDisponible(cita)) {
            return super.agregar(cita);
        }
        return null;
    }

   private boolean bahiaDisponible(Cita cita) {
        Servicio servicio = cita.getServicio();
        if (servicio == null) return false;

        TipoBahia tipoRequerido = obtenerTipoBahiaRequerida(servicio.getTipo());
        if (tipoRequerido == null) return false;

        // 1. Contar cuántas bahías totales existen en el taller de este tipo específico
        int totalBahiasDeEsteTipo = 0;
        for (Bahia b : GestorDeMemoria.getAdminBahias().getList()) {
            if (b != null && b.getTipo() == tipoRequerido) {
                totalBahiasDeEsteTipo++;
            }
        }

        // 2. Contar cuántas citas ya se agendaron para este mismo tipo en la misma fecha
        int citasRegistradas = 0;
        for (Cita c : getList()) {
            if (c != null && c.getFecha().equals(cita.getFecha())) {
                TipoBahia tipoCita = obtenerTipoBahiaRequerida(c.getServicio().getTipo());
                if (tipoCita == tipoRequerido) {
                    citasRegistradas++;
                }
            }
        }

        // 3. Cruzar con órdenes activas que estén bloqueando bahías de este tipo en la misma fecha
        int ordenesBloqueantes = 0;
        for (modelo.OrdenTrabajo o : GestorDeMemoria.getAdminOrdenes().getList()) {
            if (o != null && o.getEstado() == modelo.EstadoOrden.ACTIVA && o.getBahia().getTipo() == tipoRequerido) {
                if (o.getCita() != null && o.getCita().getFecha().equals(cita.getFecha())) {
                    ordenesBloqueantes++;
                }
            }
        }

        // El sistema valida la disponibilidad real restando las reservas y ocupaciones concurrentes
        return (citasRegistradas + ordenesBloqueantes) < totalBahiasDeEsteTipo;
    }

    private TipoBahia obtenerTipoBahiaRequerida(TipoServicio tipoServicio) {

        if (tipoServicio == TipoServicio.CAMBIO_DE_ACEITE) {
            return TipoBahia.MECANICA_GENERAL;
        }

        if (tipoServicio
                == TipoServicio.ALINEACION_Y_BALANCEO) {

            return TipoBahia.MECANICA_GENERAL;
        }

        if (tipoServicio
                == TipoServicio.DIAGNOSTICO_ELECTRONICO) {

            return TipoBahia.ELECTRICIDAD;
        }
        return null;
    }
    
 }