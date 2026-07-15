/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import java.util.ArrayList;
import modelo.Servicio;

/**
 *
 * @author ASUS
 */
public class gestor_servicios {
    private ArrayList<Servicio>servicios;
    private int contador;
    
    public gestor_servicios(){
        contador=0;
        servicios = new ArrayList<Servicio>();
    }
    
    public ArrayList<Servicio>getList(){
        return servicios;
    }
    
    public Servicio agregar(Servicio s){
        if (s!=null) {
            s.setCodigo(++contador);
            servicios.add(s);
            return s;
        }
        return null;
    }
    
    public Servicio modificar(Servicio s) {
        for (Servicio servicio : servicios) {
            if (servicio.getCodigo() == s.getCodigo()) {
                servicio.setNombre(s.getNombre());
                servicio.setTipo(s.getTipo());
                servicio.setPrecio(s.getPrecio());
                
                return servicio;
            }
        }
        
        return null;
    }
    
    public boolean eliminar(Servicio s) {
        return servicios.removeIf(x -> x.getCodigo() == s.getCodigo());
    }
    
    public Servicio buscar(int codigo) {
        for (Servicio s : servicios) {
            if (s.getCodigo() == codigo) {
                return s;
            }
        }
        
        return null;
    }    
}
