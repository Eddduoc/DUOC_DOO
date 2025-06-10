package com.bankeurope.modelos.clientes;

import com.bankeurope.modelos.cuentas.Abs_CuentaBancaria;

public class Cliente {
    
    //Atributos
    private String rut;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String domicilio;
    private String comuna;
    private int telefono;
    private Abs_CuentaBancaria cuenta;

    //Constructor
    public Cliente(String rut, String nombre, String apellido_paterno, String apellido_materno, String domicilio, String comuna, int telefono, Abs_CuentaBancaria cuenta) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.domicilio = domicilio;
        this.comuna = comuna;
        this.telefono = telefono;
        this.cuenta = cuenta;
    }
    //constructor de prueba
    public Cliente(String rut, Abs_CuentaBancaria cuenta) {
        this.rut = rut;
        this.nombre = "test";
        this.apellido_paterno = "---";
        this.apellido_materno = "---";
        this.domicilio = "---";
        this.comuna = "---";
        this.telefono = 123456789;
        this.cuenta = cuenta;
    }

    //Ver datos
    public void mostrarInformacionCliente(){
        System.out.println(" _________ \n  Datos cliente:\n _________");

        System.out.println("RUT: " + rut + 
                           "\nNombre: " + nombre + 
                           "\nApellido Paterno: " + apellido_paterno + 
                           "\nApellido Materno: " + apellido_materno + 
                           "\nDomicilio: " + domicilio + 
                           "\nComuna: " + comuna + 
                           "\nTeléfono: " + telefono);

    cuenta.mostrarDatosCuenta();
    }
    
    //get/set
    public String getRut() {
        return rut;
    }
    public Abs_CuentaBancaria getCuenta() {
        return cuenta;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellidoPaterno() {
        return apellido_paterno;
    }
    public String getApellidoMaterno() {
        return apellido_materno;
    }

}
