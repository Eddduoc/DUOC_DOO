
package com.bankeurope.modelos.cuentas;

public class CuentaCorriente extends Abs_CuentaBancaria {
    
    //Constructor
    public CuentaCorriente(int numero_cuenta){
        super(numero_cuenta,0,0);
    }
    public CuentaCorriente(int numero_cuenta,int interes){
        super(numero_cuenta,0,interes);
    }
    //Metodos
    @Override
    public int calcularInteres(int monto){
        return (int)(monto*interes);
    }
    @Override
    public void depositar(int monto){
        saldo += (monto + calcularInteres(monto));  
    }


    @Override
    public void mostrarTipoCuenta(){
        System.out.println("Cuenta Corriente: Deposite, gire dinero o consulte su saldo");
    }
    
    @Override
    public void mostrarDatosCuenta() {
        System.out.println("Número de cuenta corriente: " + numero_cuenta);
        System.out.println("Saldo: " + saldo);
    }

}
