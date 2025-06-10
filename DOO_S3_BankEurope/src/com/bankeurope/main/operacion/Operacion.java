
package com.bankeurope.main.operacion;
import com.bankeurope.modelos.clientes.*;
import com.bankeurope.modelos.cuentas.*;


import java.util.ArrayList;
import java.util.Scanner;

public class Operacion {
  
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Cliente> clientes = new ArrayList<>(); // Lista para almacenar clientes
    

    //get lista clientes
    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }

    // Ver lista de clientes
    public static void verListaClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            System.out.println("Lista de clientes:");
            for (Cliente cliente : clientes) {
                System.out.println("RUT: " + cliente.getRut() + " - Nombre: " + cliente.getNombre() + " " + cliente.getApellidoPaterno() + " " + cliente.getApellidoMaterno());
            }
        }
    }

    // Registrar cliente
    public static void registrarCliente() {
        System.out.println("Ingrese RUT del cliente (formato 12.345.678-9):");
        String rut = Validacion.validacionString(scanner, 11, 12); 
        int rut_int = Validacion.validarRut(rut,true);

        if (rut_int ==0){
            return;
        }
        //
        System.out.println("Ingrese su nombre:");
        String nombre = Validacion.validacionString(scanner, 1, 99);

        System.out.println("Ingrese su apellido paterno:");
        String apellido_paterno = Validacion.validacionString(scanner, 1, 99);

        System.out.println("Ingrese su apellido materno:");
        String apellido_materno = Validacion.validacionString(scanner, 1, 99);

        System.out.println("Ingrese su domicilio:");
        String domicilio = Validacion.validacionString(scanner, 1, 99);

        System.out.println("Ingrese su comuna:");
        String comuna = Validacion.validacionString(scanner, 1, 99);

        System.out.println("Ingrese su teléfono (9 dígitos):");
        int telefono = Validacion.validacion(scanner, 0, 999999999); 

        System.out.println("Ingrese tipo de cuenta bancaria (1.Corriente 2.Ahorro 3.Digital):");         
        int tipo_cuenta = Validacion.validacion(scanner,1,3);

        //Cuenta //Cliente
        Abs_CuentaBancaria cuenta ; 

        if (tipo_cuenta == 1) {
            cuenta = new CuentaCorriente(rut_int);
        } else if (tipo_cuenta == 2) {
            cuenta = new CuentaAhorros(rut_int, 0.03);
        } else {
            cuenta = new CuentaDigital(rut_int, 0.01);//calculo de interes queda int con montos>100
        }

        Cliente cliente = new Cliente(rut, nombre, apellido_paterno, apellido_materno, domicilio, comuna, telefono, cuenta);
        clientes.add(cliente); // Agregar cliente a la lista
        System.out.println("Cliente registrado exitosamente.");
    }

    // Ver datos de un cliente
    public static void verDatosCliente() {
        Cliente cliente = buscarCliente();

        if (cliente != null) {
            cliente.mostrarInformacionCliente();
        }
    }

    // Depositar dinero
    public static void depositar() {
        Cliente cliente = buscarCliente();

        if (cliente != null) {
            cliente.getCuenta().mostrarTipoCuenta();
            System.out.println("Ingrese el monto a depositar(mayor a $100 y menor a $10.000.000):");
            int monto = Validacion.validacion(scanner,100,10000000);
            cliente.getCuenta().depositar(monto);
            System.out.println("Depósito realizado exitosamente.");
        }
    }

    // Girar dinero
    public static void girar() {

        Cliente cliente = buscarCliente();
        if (cliente != null) {
            cliente.getCuenta().mostrarTipoCuenta();
            System.out.println("Ingrese el monto a girar:");
            int monto = Validacion.validacion(scanner,0,10000000);

            cliente.getCuenta().girar(monto);
            
        }
    }

    // Consultar saldo
    public static void consultarCuenta() {
        if (Validacion.listaClientesVacia()) {
            return;
        }
        Cliente cliente = buscarCliente();
        if (cliente != null) {
            cliente.getCuenta().mostrarTipoCuenta();
            cliente.getCuenta().mostrarDatosCuenta();
        }
    }

    // Método para buscar cliente por RUT
    private static Cliente buscarCliente() {
        Cliente cliente_encontrado = null;

        if (!Validacion.listaClientesVacia()){
            System.out.println("Ingrese el RUT del cliente (formato 12.345.678-9):");
            String rut = Validacion.validacionString(scanner, 11, 12);
            if (Validacion.validarRut(rut, false)!=0){
                for (Cliente cliente : clientes) {
                    if (cliente.getRut().equals(rut)) {
                        cliente_encontrado=cliente;
                    }
                }
                if (cliente_encontrado==null){
                    System.out.println("Error: Cliente no encontrado.\n");
                } 
            }   
        }
        return cliente_encontrado;
    }    


    
}
