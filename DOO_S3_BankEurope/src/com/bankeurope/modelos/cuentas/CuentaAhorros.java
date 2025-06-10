
package com.bankeurope.modelos.cuentas;

public class CuentaAhorros extends Abs_CuentaBancaria {
    

    //Constructor
    public CuentaAhorros(int numero_cuenta,double interes){
        super(numero_cuenta,0,interes);
    }

    //Metodos
    @Override
    public int calcularInteres(int monto){  
        return (int)(monto * (interes));
    }
    @Override
    public void depositar(int monto){
        saldo += (monto + calcularInteres(monto));
    }
    @Override
    public void mostrarTipoCuenta(){
        System.out.println("Cuenta de Ahorro con " + interes*100 + " % de Interes: Deposite fondos o retire su dinero");
    }

    @Override
    public void mostrarDatosCuenta() {
        System.out.println("Número de cuenta Ahorro: " + numero_cuenta);
        System.out.println("Interes: " + interes*100 + " %");
        System.out.println("Fondos: " + saldo);
    }
    
    



}
