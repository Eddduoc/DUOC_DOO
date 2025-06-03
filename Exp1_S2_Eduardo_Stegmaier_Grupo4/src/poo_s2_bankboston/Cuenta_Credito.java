package poo_s2_bankboston;

class Cuenta_Credito extends Cuenta_Abstracta {
    private int cupo;

    //Constructor
    public Cuenta_Credito(int numero_cuenta,int saldo){
        super(numero_cuenta,saldo);   //Saldo = Monto disponible //Saldo inicial = cupo
        this.cupo = saldo;
    }

    //Metodos
    public void mostrarInformacionCuenta(){

        System.out.println("Cuenta de Credito: Consulte el cupo de su tarjeta de Credito o Page el monto adeudado");
    }
    public void depositar(int monto){
        if (saldo+monto <= cupo){
            saldo += monto ;  // pagar monto adeudado
            System.out.println("Pago efectuado");
        }else{
            System.out.println("Monto superior a deuda");
        }

    }
    @Override
    public void verDatosCuenta() {
        System.out.println("Número de cuenta Credito: " + numero_cuenta);
        System.out.println("Cupo: " + cupo);
        System.out.println("Monto Adeudado: " + (cupo-saldo) );
    }

    //getter
    public int getCupo() {
        return cupo;
    }

}