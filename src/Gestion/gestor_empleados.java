/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import java.util.ArrayList;
import modelo.Empleado;

/**
 *
 * @author ASUS
 */
public class gestor_empleados {
    private ArrayList<Empleado>empleados;
    private int contador;
    
    public gestor_empleados(){
        contador=0;
        empleados=new ArrayList<Empleado>();
    }
    
    public ArrayList<Empleado>getList(){
        return empleados;
    }
    
    public Empleado agregar(Empleado e){
        if (e!=null) {
            e.setCodigo(++contador);
            empleados.add(e);
            return e;
        }
        return null;
    }
    
    public Empleado modificar(Empleado e) {
        
        for(Empleado empleado : empleados) {
            if (empleado.getCodigo() == e.getCodigo()) {
                empleado.setNombre(e.getNombre());
                empleado.setApellido(e.getApellido());
                empleado.setRol(e.getRol());
                
                return empleado;
            }
        }
        
        return null;
        
    }
    
    public boolean eliminar(Empleado e) {
        return empleados.removeIf(x -> x.getCodigo() == e.getCodigo());
    }
    
    public Empleado buscar(int id) {
        for(Empleado e: empleados) {
            if (e.getCodigo() == id) {
                return e;
            }
        }
        
        return null;
    }
}
