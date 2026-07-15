/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import java.util.ArrayList;
import modelo.Bahia;

/**
 *
 * @author ASUS
 */

public class gestor_bahias {
    private ArrayList<Bahia>bahias;
    private int contador;
    
    public gestor_bahias(){
        contador=0;
        bahias = new ArrayList<Bahia>();
    }
    
    public ArrayList<Bahia>getList(){
        return bahias;
    }
    
    public Bahia agregar(Bahia b) {
        if (b != null) {
            b.setCodigo(++contador);
            bahias.add(b);
            return b;
        }
        return null;
    }
    
    public Bahia modificar(Bahia b) {
        
        for (Bahia bahia : bahias) {
            if (bahia.getCodigo() == b.getCodigo()) {
                bahia.setCapacidad(b.getCapacidad());
                bahia.setTipo(b.getTipo());
                bahia.setEstado(b.getEstado());
                
                return bahia;
            }
        }
        
        return null;
    }
    
    public boolean eliminar(Bahia b) {
        return bahias.removeIf(x -> x.getCodigo() == b.getCodigo());
    }
    
    public Bahia buscar(int codigo) {
        for (Bahia b : bahias) {
            if (b.getCodigo() == codigo) {
                return b;
            }
        }
        return null;
    }    
}
