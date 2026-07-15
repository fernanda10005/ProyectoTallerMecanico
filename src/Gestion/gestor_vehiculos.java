/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import modelo.Vehiculo;
/**
 *
 * @author ASUS
 */
public class gestor_vehiculos extends gestor_generico<Vehiculo> {

    public Vehiculo modificar(Vehiculo v) {
        
        for (Vehiculo vehiculo : getList()) {
            
            if (vehiculo.getCodigo() == v.getCodigo()) {
                vehiculo.setPlaca(v.getPlaca());
                vehiculo.setMarca(v.getMarca());
                vehiculo.setModelo(v.getModelo());
                vehiculo.setAño(v.getAño());
                vehiculo.setTipo(v.getTipo());
                vehiculo.setCliente(v.getCliente());

                return vehiculo;
            }
        }
        return null;
    }
}
