
package com.bankeurope.modelos.cuentas;

public class CuentaDigital extends Abs_CuentaBancaria {
    
    //Constructor
    public CuentaDigital(int numero_cuenta,double interes){
        super(numero_cuenta,0,interes);
    }
    //Metodos
    @Override
    public int calcularInteres(int monto){ 
        return (int)(monto * interes);
    }
    @Override
    public void depositar(int monto){
        saldo += (monto + calcularInteres(monto));  
    }
    
    @Override
    public void mostrarTipoCuenta(){
        System.out.println("Cuenta Digital");
    }
    
    @Override
    public void mostrarDatosCuenta() {
        System.out.println("Número de cuenta digital: " + numero_cuenta);
        System.out.println("Interes: " + interes*100 + " %");
        System.out.println("Saldo: " + saldo);
    }
}
