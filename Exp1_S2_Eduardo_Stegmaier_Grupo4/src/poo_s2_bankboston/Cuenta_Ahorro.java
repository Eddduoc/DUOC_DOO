package poo_s2_bankboston;

class Cuenta_Ahorro extends Cuenta_Abstracta {

    private int interes;

    //Constructor
    public Cuenta_Ahorro(int numero_cuenta,int interes){
        super(numero_cuenta);
        this.interes = interes;
    }

    public void mostrarInformacionCuenta(){

        System.out.println("Cuenta de Ahorro con " + interes + " % de Interes: Deposite fondos o retire su dinero");
    }
    public void depositar(int monto){
        saldo += monto * (1 + (interes/100) ) ;  // saldo int con depositos > 100
    }

    @Override
    public void verDatosCuenta() {
        System.out.println("Número de cuenta Ahorro: " + numero_cuenta);
        System.out.println("Interes: " + interes + " %");
        System.out.println("Fondos: " + saldo);
    }
    
    //getter
    public int getInteres() {
        return interes;
    }

}
