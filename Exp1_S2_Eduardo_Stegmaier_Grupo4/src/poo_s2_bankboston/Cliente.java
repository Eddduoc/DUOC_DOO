package poo_s2_bankboston;

public class Cliente {
    
    //Atributos
    private String rut;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String domicilio;
    private String comuna;
    private int telefono;
    private Cuenta_Abstracta cuenta;



    //Constructor
    public Cliente(String rut, String nombre, String apellido_paterno, String apellido_materno, String domicilio, String comuna, int telefono, Cuenta_Abstracta cuenta) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.domicilio = domicilio;
        this.comuna = comuna;
        this.telefono = telefono;
        this.cuenta = cuenta;
    }


    //Ver datos
    public void verDatosCliente(){
        System.out.println("Datos cliente:");

        System.out.println("RUT: " + rut + 
                           "\nNombre: " + nombre + 
                           "\nApellido Paterno: " + apellido_paterno + 
                           "\nApellido Materno: " + apellido_materno + 
                           "\nDomicilio: " + domicilio + 
                           "\nComuna: " + comuna + 
                           "\nTeléfono: " + telefono);

    cuenta.verDatosCuenta();
    }
    

    public String getRut() {
        return rut;
    }

    public Cuenta_Abstracta getCuenta() {
        return cuenta;
    }




}
