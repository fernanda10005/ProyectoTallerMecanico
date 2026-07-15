/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

/**
 *
 * @author ASUS
 */
public class Fecha {

    public static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/uuuu") .withResolverStyle(ResolverStyle.STRICT);

    public static boolean validarFecha(String fecha) {

        if (fecha == null || fecha.trim().equals("")) {
            return false;
        }

        try {
            LocalDate.parse(fecha.trim(), FORMATO);
            return true;

        } 
        catch (DateTimeParseException e) {
            return false;
        }
    }

    public static LocalDate convertirFecha(String fecha) {
        return LocalDate.parse(fecha.trim(),FORMATO);
    }
}
