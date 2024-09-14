package ejercicios_Backend;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SeguimientoHabitos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> habitos = new HashMap<>();
        String opcion;
        String habito;
        int progreso;

        System.out.println("Bienvenido a tu seguimiento de hábitos diarios");

     
        do {
            System.out.println("Elige una opción:");
            System.out.println("1. Añadir un hábito");
            System.out.println("2. Actualizar progreso de un hábito");
            System.out.println("3. Mostrar resumen diario");
            System.out.println("4. Salir");
            System.out.print("Opción: ");
            opcion = scanner.next();

            switch (opcion) {
                case "1":
                    System.out.print("Ingresa el nombre del nuevo hábito: ");
                    habito = scanner.next();
                    if (habitos.containsKey(habito)) {
                        System.out.println("Este hábito ya existe.");
                    } else {
                        habitos.put(habito, 0);
                        System.out.println("Hábito añadido: " + habito);
                    }
                    break;

                case "2":
                    System.out.print("Ingresa el nombre del hábito a actualizar: ");
                    habito = scanner.next();
                    if (habitos.containsKey(habito)) {
                        System.out.print("Ingresa el progreso de hoy (en minutos, por ejemplo): ");
                        progreso = scanner.nextInt();
                        habitos.put(habito, habitos.get(habito) + progreso);
                        System.out.println("Progreso actualizado para " + habito + ": " + habitos.get(habito) + " minutos.");
                    } else {
                        System.out.println("Este hábito no existe.");
                    }
                    break;

                case "3":
                    System.out.println("Resumen diario de hábitos:");
                    for (Map.Entry<String, Integer> entry : habitos.entrySet()) {
                        System.out.println("Hábito: " + entry.getKey() + ", Progreso: " + entry.getValue() + " minutos.");
                    }
                    break;

                case "4":
                    System.out.println("¡Adiós! Sigue trabajando en tus hábitos.");
                    break;

                default:
                    System.out.println("Opción inválida. Inténtalo de nuevo.");
                    break;
            }
        } while (!opcion.equals("4"));

        scanner.close();
    }
}
