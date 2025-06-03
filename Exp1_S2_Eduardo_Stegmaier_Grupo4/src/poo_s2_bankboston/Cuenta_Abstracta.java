package poo_s2_bankboston;

public abstract class Cuenta_Abstracta implements InterfazCuentas {
    
    protected int numero_cuenta;
    protected int saldo;

    //Constructores
    public Cuenta_Abstracta(int numero_cuenta){
        this.numero_cuenta = numero_cuenta;
        this.saldo = 0;
    }
    public Cuenta_Abstracta(int numero_cuenta, int saldo){
        this.numero_cuenta = numero_cuenta;
        this.saldo = saldo;
    }

    //Metodos
    public abstract void mostrarInformacionCuenta();
    public abstract void depositar(int monto);
    public void girar (int monto){
        if (monto<=saldo){
            saldo -= monto;
        }
        else{
            System.out.println("Saldo insuficiente para girar " + monto);
        }   
    }

    // Get/Set
    public int getCuenta() {
        return numero_cuenta;
    }
    public int getSaldo() {
        return saldo;
    }
    public void setSaldo(int new_saldo) {
        saldo = new_saldo;
    }

}





