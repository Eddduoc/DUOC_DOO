package poo_s2_bankboston;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class BankBostonMain {

    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Cliente> clientes = new ArrayList<>(); // Lista para almacenar clientes

    public static void main(String[] args) {
        int opcion_menu = 0;

        System.out.println("Bienvenido a Bank Boston");
        do {
            System.out.println("\nSeleccione una opcion:");
            System.out.println(" 1. Registrar Cliente \n 2. Ver datos cliente \n 3. Depositar/pagar linea de credito \n 4. Girar/Retirar Fondos \n 5. Consultar detalles cuenta \n 6. Salir");
            opcion_menu = Validacion(scanner, 1, 6);

            switch (opcion_menu) {
                case 1:
                    registrarCliente();
                    break;
                case 2:
                    verDatosCliente();
                    break;
                case 3:
                    depositar();
                    break;
                case 4:
                    girar();
                    break;
                case 5:
                    consultarCuenta();
                    break;
                case 6:
                    System.out.println("Gracias por usar Bank Boston. ¡Adiós!");
                    break;
            }
        } while (opcion_menu != 6);

        scanner.close();
    }

    // Registrar cliente
    public static void registrarCliente() {
        System.out.println("Ingrese RUT del cliente (formato 12.345.678-9):");
        String rut = ValidacionString(scanner, 11, 12); 
        int rut_int;

        // Verificar rut // (covertir a metodo)
        for (Cliente cliente : clientes) {
            if (cliente.getRut().equals(rut)) {
                System.out.println("Error: El RUT ya está registrado.");
                return;
            }
        }
        try {
            String rutLimpio = rut.replace(".", "").replace("-", "");
            rut_int = Integer.parseInt(rutLimpio.substring(0, rutLimpio.length() - 1)); // Sin dígito verificador
        } catch (NumberFormatException e) {
            System.out.println("Error: El RUT ingresado no es válido.");
            return;
        }
        //

        System.out.println("Ingrese su nombre:");
        String nombre = ValidacionString(scanner, 1, 99);

        System.out.println("Ingrese su apellido paterno:");
        String apellido_paterno = ValidacionString(scanner, 1, 99);

        System.out.println("Ingrese su apellido materno:");
        String apellido_materno = ValidacionString(scanner, 1, 99);

        System.out.println("Ingrese su domicilio:");
        String domicilio = ValidacionString(scanner, 1, 99);

        System.out.println("Ingrese su comuna:");
        String comuna = ValidacionString(scanner, 1, 99);

        System.out.println("Ingrese su teléfono (9 dígitos):");
        int telefono = Validacion(scanner, 0, 999999999); 

        System.out.println("Ingrese tipo de cuenta bancaria (1.Corriente 2.Ahorro 3.Credito):");
        int tipo_cuenta = Validacion(scanner,1,3);

        //Cuenta //Cliente
        
        Cuenta_Abstracta cuenta ; 

        if (tipo_cuenta == 1) {
            cuenta = new Cuenta_Corriente(rut_int);
        } else if (tipo_cuenta == 2) {
            cuenta = new Cuenta_Ahorro(rut_int, 2);
        } else {
            cuenta = new Cuenta_Credito(rut_int, 1000000); // Saldo inicial de 1,000,000
        }

        Cliente cliente = new Cliente(rut, nombre, apellido_paterno, apellido_materno, domicilio, comuna, telefono, cuenta);
        clientes.add(cliente); // Agregar cliente a la lista
        System.out.println("Cliente registrado exitosamente.");
    }

    // Ver datos de un cliente
    public static void verDatosCliente() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }
        Cliente cliente = buscarCliente();
        if (cliente != null) {
            cliente.verDatosCliente();
        }
    }

    // Depositar dinero
    public static void depositar() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }
        Cliente cliente = buscarCliente();
        cliente.getCuenta().mostrarInformacionCuenta();
        
        System.out.println("Ingrese el monto a depositar:");
        int monto = Validacion(scanner,0,10000000);
        if (monto > 100) {
            cliente.getCuenta().depositar(monto);
            System.out.println("Depósito realizado exitosamente.");
        } else {
            System.out.println("Error: El monto debe ser mayor a 100.");
        }
        
    }

    // Girar dinero
    public static void girar() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }
        Cliente cliente = buscarCliente();
        cliente.getCuenta().mostrarInformacionCuenta();
        if (cliente != null) {
            System.out.println("Ingrese el monto a girar:");
            int monto = Validacion(scanner,0,10000000);
            if (monto > 0 && cliente.getCuenta().getSaldo() >= monto) {
                cliente.getCuenta().girar(monto);
                System.out.println("Giro realizado exitosamente.");
            } else {
                System.out.println("Error: Monto inválido o saldo insuficiente.");
            }
        }
    }

    // Consultar saldo
    public static void consultarCuenta() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }
        Cliente cliente = buscarCliente();
        if (cliente != null) {
            cliente.getCuenta().mostrarInformacionCuenta();
            cliente.getCuenta().verDatosCuenta();
        }
    }

    // Método auxiliar para buscar cliente por RUT
    private static Cliente buscarCliente() {
        System.out.println("Ingrese el RUT del cliente (formato 12.345.678-9):");
        String rut = ValidacionString(scanner, 11, 12);
        for (Cliente cliente : clientes) {
            if (cliente.getRut().equals(rut)) {
                return cliente;
            }
        }
        System.out.println("Error: Cliente no encontrado.");
        return null;
    }


    // Método para validar entrada del usuario como int en un rango
    public static int Validacion(Scanner scanner, int min, int max) {
        int entrada = 0;
        boolean entradaValida = false;
        do {
            try {
                entrada = scanner.nextInt();
                if (entrada < min || entrada > max) {
                    System.out.println("Selección incorrecta. Ingrese un valor válido (" + min + "-" + max + ")");
                } else {
                    entradaValida = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Por favor, ingrese un número entero válido.");
                scanner.next();
            }
        } while (!entradaValida);
        scanner.nextLine(); // Limpiar buffer
        return entrada;
    }

    // Método para validar entrada del usuario como String
    private static String ValidacionString(Scanner scanner, int min, int max) {
        String entrada = "";
        boolean entrada_valida = false;
        do {
            entrada = scanner.nextLine();
            int largo = entrada.length();
            if (largo >= min && largo <= max) {
                entrada_valida = true;
            } else {
                System.out.println("Error: La entrada debe tener entre " + min + " y " + max + " caracteres.");
            }
        } while (!entrada_valida);
        return entrada;
    }
}