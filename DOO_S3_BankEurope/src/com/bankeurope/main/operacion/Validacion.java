
package com.bankeurope.main.operacion;
import com.bankeurope.modelos.clientes.Cliente;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Validacion {
    
    //Metodo para validar rut
    public static int validarRut( String rut ,boolean nuevo){

        int rut_int=0;
        if (!rut.matches("^\\d{1,2}\\.\\d{3}\\.\\d{3}-[0-9Kk]$")) {
            System.out.println("El RUT no cumple con el formato esperado (ej. 12.345.678-9).\n");
        }else{
            String rutLimpio = rut.replace(".", "").replace("-", "");
            if (rutLimpio.length() == 8 || rutLimpio.length() == 9) {
                try {
                    rut_int = Integer.parseInt(rutLimpio.substring(0, rutLimpio.length() - 1)); // Sin dígito verificador
                } catch (NumberFormatException e) {
                    System.out.println("Error: El RUT ingresado no es válido.\n");
                }
            }else {
                System.out.println("Error: El RUT ingresado no es válido.\n");
            }
        }               
        
        if ( nuevo){
            for (Cliente cliente : Operacion.getClientes()) {
                if (cliente.getRut().equals(rut)) {
                    System.out.println("Error: El RUT ya está registrado.\n");
                    rut_int=0;
                }
            }
        }
        return rut_int;
    }    

    //metodo comprobar lista clientes vacia
    public static boolean listaClientesVacia(){
        boolean _return=false;
        if (Operacion.getClientes().isEmpty()) {
            System.out.println("No hay clientes registrados.");
            _return= true;
        }
        return _return;
    }

    // Método para validar entrada del usuario como int en un rango
    public static int validacion(Scanner scanner, int min, int max) {
        int entrada = 0;
        boolean entradaValida = false;
        do {
            try {
                entrada = scanner.nextInt();
                if (entrada < min || entrada > max) {
                    System.out.println("Selección incorrecta. Ingrese un valor válido (" + min + "-" + max + ")");
                } else {
                    entradaValida = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Por favor, ingrese un número entero válido.");
                scanner.next();
            }
        } while (!entradaValida);
        scanner.nextLine(); 
        return entrada;
    }

    // Método para validar entrada del usuario como String
    public static String validacionString(Scanner scanner, int min, int max) {
        String entrada = "";
        boolean entrada_valida = false;
        do {
            entrada = scanner.nextLine();
            int largo = entrada.length();
            if (largo >= min && largo <= max) {
                entrada_valida = true;
            } else {
                System.out.println("Error: La entrada debe tener entre " + min + " y " + max + " caracteres.");
            }
        } while (!entrada_valida);
        return entrada;
    }

}
