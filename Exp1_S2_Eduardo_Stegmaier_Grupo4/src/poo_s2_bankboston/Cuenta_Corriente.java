package poo_s2_bankboston;


class Cuenta_Corriente extends Cuenta_Abstracta {

    //Constructor
    public Cuenta_Corriente(int numero_cuenta){
        super(numero_cuenta);
    }
    

    public void mostrarInformacionCuenta(){

        System.out.println("Cuenta Corriente: Deposite, gire dinero o consulte su saldo");
    }
    public void depositar(int monto){
        saldo += monto;  
    }

    @Override
    public void verDatosCuenta() {
        System.out.println("Número de cuenta corriente: " + numero_cuenta);
        System.out.println("Saldo: " + saldo);
    }
    
}
