package ejercicios_Backend;

import java.util.Scanner;

public class CajeroAutomatico {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cuenta = 123456;
        int pin = 1234;
        double saldo = 1000.00;
        int opcion;
        double deposito, retiro;

   
        System.out.println("Bienvenido al cajero automático");
        System.out.print("Ingresa tu número de cuenta: ");
        int cuentaIngresada = scanner.nextInt();
        System.out.print("Ingresa tu PIN: ");
        int pinIngresado = scanner.nextInt();

        if (cuentaIngresada == cuenta && pinIngresado == pin) {
            do {
                System.out.println("Opciones disponibles:");
                System.out.println("1. Consultar saldo");
                System.out.println("2. Retirar dinero");
                System.out.println("3. Depositar dinero");
                System.out.println("4. Salir");
                System.out.print("Elige una opción: ");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Tu saldo actual es: " + saldo);
                        break;
                    case 2:
                        System.out.print("¿Cuánto deseas retirar? ");
                        retiro = scanner.nextDouble();
                        if (retiro > saldo) {
                            System.out.println("Fondos insuficientes");
                        } else {
                            saldo -= retiro;
                            System.out.println("Has retirado: " + retiro);
                            System.out.println("Nuevo saldo: " + saldo);
                        }
                        break;
                    case 3:
                        System.out.print("¿Cuánto deseas depositar? ");
                        deposito = scanner.nextDouble();
                        saldo += deposito;
                        System.out.println("Has depositado: " + deposito);
                        System.out.println("Nuevo saldo: " + saldo);
                        break;
                    case 4:
                        System.out.println("Gracias por usar el cajero");
                        break;
                    default:
                        System.out.println("Opción inválida");
                }
            } while (opcion != 4);
        } else {
            System.out.println("Número de cuenta o PIN incorrectos");
        }
        scanner.close();
    }
}

