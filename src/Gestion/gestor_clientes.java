/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import modelo.Cliente;

/**
 *
 * @author ASUS
 */
public class gestor_clientes extends gestor_generico<Cliente> {

    public Cliente modificar(Cliente c) {
        
        for (Cliente cliente : getList()) {
            
            if (cliente.getCodigo() == c.getCodigo()) {
                cliente.setDocumento(c.getDocumento());
                cliente.setNombre(c.getNombre());
                cliente.setApellido(c.getApellido());
                cliente.setContacto(c.getContacto());

                return cliente;
            }
        }
        return null;
    }
}