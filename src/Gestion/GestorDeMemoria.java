/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

/**
 *
 * @author ASUS
 */
public class GestorDeMemoria {

    private static gestor_empleados adminEmpleados = new gestor_empleados();
    private static gestor_bahias adminBahias = new gestor_bahias();
    private static gestor_servicios adminServicios = new gestor_servicios();
    private static gestor_clientes adminClientes = new gestor_clientes();
    private static gestor_vehiculos adminVehiculos = new gestor_vehiculos();
    private static gestor_citas adminCitas = new gestor_citas();
    private static gestor_ordenes adminOrdenes = new gestor_ordenes();

    public static gestor_empleados getAdminEmpleados() {
        return adminEmpleados;
    }

    public static gestor_bahias getAdminBahias() {
        return adminBahias;
    }

    public static gestor_servicios getAdminServicios() {
        return adminServicios;
    }

    public static gestor_clientes getAdminClientes() {
        return adminClientes;
    }

    public static gestor_vehiculos getAdminVehiculos() {
        return adminVehiculos;
    }

    public static gestor_citas getAdminCitas() {
        return adminCitas;
    }

    public static gestor_ordenes getAdminOrdenes() {
        return adminOrdenes;
    }
}
