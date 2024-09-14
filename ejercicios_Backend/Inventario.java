package ejercicios_Backend;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventario {

    static List<Producto> productos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String opcion;

        do {
            System.out.println("\nSistema de Gestión de Inventario");
            System.out.println("1. Agregar nuevo producto");
            System.out.println("2. Realizar una venta");
            System.out.println("3. Consultar productos por categoría");
            System.out.println("4. Consultar productos por rango de precios");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    agregarProducto(scanner);
                    break;
                case "2":
                    realizarVenta(scanner);
                    break;
                case "3":
                    consultarPorCategoria(scanner);
                    break;
                case "4":
                    consultarPorPrecio(scanner);
                    break;
                case "5":
                    System.out.println("Gracias por usar el sistema de gestión de inventario.");
                    break;
                default:
                    System.out.println("Opción inválida. Inténtalo de nuevo.");
                    break;
            }
        } while (!opcion.equals("5"));

        scanner.close();
    }

    public static void agregarProducto(Scanner scanner) {
        System.out.print("Ingresa el nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingresa el precio del producto: ");
        double precio = scanner.nextDouble();
        System.out.print("Ingresa la cantidad disponible del producto: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingresa la categoría del producto: ");
        String categoria = scanner.nextLine();

        Producto nuevoProducto = new Producto(nombre, precio, cantidad, categoria);
        productos.add(nuevoProducto);

        System.out.println("Producto agregado con éxito.");
    }

    public static void realizarVenta(Scanner scanner) {
        System.out.print("Ingresa el nombre del producto a vender: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingresa la cantidad a vender: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        boolean encontrado = false;
        for (Producto producto : productos) {
            if (producto.nombre.equalsIgnoreCase(nombre)) {
                producto.vender(cantidad);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Producto no encontrado.");
        }
    }

    public static void consultarPorCategoria(Scanner scanner) {
        System.out.print("Ingresa la categoría para buscar: ");
        String categoria = scanner.nextLine();

        boolean encontrado = false;
        for (Producto producto : productos) {
            if (producto.categoria.equalsIgnoreCase(categoria)) {
                producto.mostrarProducto();
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron productos en esta categoría.");
        }
    }

    public static void consultarPorPrecio(Scanner scanner) {
        System.out.print("Ingresa el precio mínimo: ");
        double precioMinimo = scanner.nextDouble();
        System.out.print("Ingresa el precio máximo: ");
        double precioMaximo = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer

        boolean encontrado = false;
        for (Producto producto : productos) {
            if (producto.precio >= precioMinimo && producto.precio <= precioMaximo) {
                producto.mostrarProducto();
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron productos en ese rango de precios.");
        }
    }

    static class Producto {
        String nombre;
        double precio;
        int cantidad;
        String categoria;

        public Producto(String nombre, double precio, int cantidad, String categoria) {
            this.nombre = nombre;
            this.precio = precio;
            this.cantidad = cantidad;
            this.categoria = categoria;
        }

        public void mostrarProducto() {
            System.out.println("Nombre: " + nombre);
            System.out.println("Precio: $" + precio);
            System.out.println("Cantidad disponible: " + cantidad);
            System.out.println("Categoría: " + categoria);
        }

        public boolean vender(int cantidadVendida) {
            if (cantidadVendida <= cantidad) {
                cantidad -= cantidadVendida;
                System.out.println("Venta realizada con éxito.");
                return true;
            } else {
                System.out.println("Stock insuficiente.");
                return false;
            }
        }
    }
}
