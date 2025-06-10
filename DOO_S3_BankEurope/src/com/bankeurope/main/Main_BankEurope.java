
package com.bankeurope.main;

import com.bankeurope.main.operacion.*;
import java.util.Scanner;

public class Main_BankEurope {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion_menu = 0;

        System.out.println(" _________________________\n  Bienvenido a Bank Europe\n _________________________");
        do {
            System.out.println(" _______________________\n          Menu \n _______________________");
            System.out.println("\nSeleccione una opcion:");
            System.out.println(" 1. Registrar Cliente \n 2. Ver datos cliente \n 3. Depositar "+
                            "\n 4. Girar/Retirar Fondos \n 5. Consultar detalles cuenta \n 6. Ver lista clientes \n 7. Salir\n");
            opcion_menu = Validacion.validacion(scanner, 1, 6);

            switch (opcion_menu) {
                case 1:
                    Operacion.registrarCliente();
                    break;
                case 2:
                    Operacion.verDatosCliente();
                    break;
                case 3:
                    Operacion.depositar();
                    break;
                case 4:
                    Operacion.girar();
                    break;
                case 5:
                    Operacion.consultarCuenta();
                    break;
                case 6:
                    if (!Validacion.listaClientesVacia()) {
                        Operacion.verListaClientes();
                    }
                    break;
                case 7:
                    System.out.println("Gracias por usar Bank Europe. ¡Adiós!");
                    break;
            }
        } while (opcion_menu != 7);

    }
}
