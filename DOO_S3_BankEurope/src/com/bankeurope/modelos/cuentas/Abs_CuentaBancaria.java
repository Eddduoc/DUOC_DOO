//@Eduardo Stegmaier

package com.bankeurope.modelos.cuentas;

public abstract class Abs_CuentaBancaria{

    protected int numero_cuenta;
    protected int saldo;
    protected double interes;
    
    //Constructor
    public Abs_CuentaBancaria(int numero_cuenta,int saldo,double interes){
        this.numero_cuenta = numero_cuenta;
        this.saldo = saldo;
        this.interes = interes;
    }
    public Abs_CuentaBancaria(int numero_cuenta){
        this.numero_cuenta = numero_cuenta;
        this.saldo = 0;
        this.interes = 0;
    }
    
    //get/set
    public int getCuenta(){
        return this.numero_cuenta;
    }
    public int getSaldo() {
        return saldo;
    }
    public void setSaldo(int new_saldo) {
        saldo = new_saldo;
    }
    public double getInteres() {
        return interes;
    }

    //Metodos abstractos
    public abstract int calcularInteres(int monto);
    public abstract void depositar(int monto);
    public abstract void mostrarTipoCuenta();
    public abstract void mostrarDatosCuenta();

    public void girar (int monto){
        if (monto<=saldo){
            saldo -= monto;
            System.out.println("Giro realizado exitosamente.");
        }else{
            System.out.println("Saldo insuficiente para girar " + monto);
        }   
    }
}    

