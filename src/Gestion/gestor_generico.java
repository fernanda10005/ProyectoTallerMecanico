/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import java.util.ArrayList;
import modelo.Identificable;

/**
 *
 * @author ASUS
 */
public class gestor_generico <T extends Identificable> {
    protected ArrayList<T> lista;
    protected int contador;

    public gestor_generico() {
        lista = new ArrayList<T>();
        contador = 0;
    }

    public ArrayList<T> getList() {
        return lista;
    }

    public T agregar(T objeto) {
        if (objeto != null) {
            objeto.setCodigo(++contador);
            lista.add(objeto);
            return objeto;
        }
        return null;
    }

    public T buscar(int codigo) {
        for (T objeto : lista) {
            if (objeto.getCodigo() == codigo) {
                return objeto;
            }
        }
        return null;
    }

    public boolean eliminar(T objeto) {
        if (objeto != null) {
            return lista.removeIf(x -> x.getCodigo() == objeto.getCodigo());
        }
        return false;
    }    
}
