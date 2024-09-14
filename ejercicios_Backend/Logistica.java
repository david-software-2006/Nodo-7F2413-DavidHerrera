package ejercicios_Backend;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Logistica {

    static class Envio {
        private String id;
        private String destino;
        private double peso;
        private double distancia;
        private String estado;

        public Envio(String id, String destino, double peso, double distancia) {
            this.id = id;
            this.destino = destino;
            this.peso = peso;
            this.distancia = distancia;
            this.estado = "En espera"; 
        }

        // Getters y setters
        public String getId() { return id; }
        public void setId(String id) { this.id = id; }
        public String getDestino() { return destino; }
        public void setDestino(String destino) { this.destino = destino; }
        public double getPeso() { return peso; }
        public void setPeso(double peso) { this.peso = peso; }
        public double getDistancia() { return distancia; }
        public void setDistancia(double distancia) { this.distancia = distancia; }
        public String getEstado() { return estado; }
        public void setEstado(String estado) { this.estado = estado; }

        
        public double calcularCosto() {
            final double COSTO_POR_KM = 1.5; 
            final double COSTO_POR_KG = 0.5; 
            return (distancia * COSTO_POR_KM) + (peso * COSTO_POR_KG);
        }

        @Override
        public String toString() {
            return String.format("ID: %s, Destino: %s, Peso: %.2f kg, Distancia: %.2f km, Estado: %s, Costo: %.2f",
                    id, destino, peso, distancia, estado, calcularCosto());
        }
    }

    static class Camion {
        private String id;
        private double capacidad;
        private boolean disponible;

        public Camion(String id, double capacidad) {
            this.id = id;
            this.capacidad = capacidad;
            this.disponible = true;
        }

        // Getters y setters
        public String getId() { return id; }
        public void setId(String id) { this.id = id; }
        public double getCapacidad() { return capacidad; }
        public void setCapacidad(double capacidad) { this.capacidad = capacidad; }
        public boolean isDisponible() { return disponible; }
        public void setDisponible(boolean disponible) { this.disponible = disponible; }

        @Override
        public String toString() {
            return String.format("ID: %s, Capacidad: %.2f kg, Disponible: %b",
                    id, capacidad, disponible);
        }
    }

    private Map<String, Envio> envios;
    private Map<String, Camion> camiones;

    public Logistica() {
        envios = new HashMap<>();
        camiones = new HashMap<>();
    }

    public void agregarEnvio(Envio envio) {
        envios.put(envio.getId(), envio);
    }

    public void agregarCamion(Camion camion) {
        camiones.put(camion.getId(), camion);
    }

    public void asignarCamion(String idEnvio, String idCamion) {
        Envio envio = envios.get(idEnvio);
        Camion camion = camiones.get(idCamion);

        if (envio == null || camion == null) {
            System.out.println("Envio o Camión no encontrados.");
            return;
        }

        if (!camion.isDisponible()) {
            System.out.println("El camión no está disponible.");
            return;
        }

        if (envio.getPeso() > camion.getCapacidad()) {
            System.out.println("El camión no tiene suficiente capacidad.");
            return;
        }

        envio.setEstado("En tránsito");
        camion.setDisponible(false);
        System.out.println("Envío " + idEnvio + " asignado al camión " + idCamion);
    }

    public void actualizarEstadoEnvio(String idEnvio, String nuevoEstado) {
        Envio envio = envios.get(idEnvio);
        if (envio == null) {
            System.out.println("Envío no encontrado.");
            return;
        }
        envio.setEstado(nuevoEstado);
        System.out.println("Estado del envío " + idEnvio + " actualizado a " + nuevoEstado);
    }

    public void mostrarReporte() {
        System.out.println("Reporte de Envíos:");
        for (Envio envio : envios.values()) {
            System.out.println(envio);
        }
        System.out.println("Reporte de Camiones:");
        for (Camion camion : camiones.values()) {
            System.out.println(camion);
        }
    }

    public static void main(String[] args) {
        Logistica logistica = new Logistica();
        Scanner scanner = new Scanner(System.in);

        
        System.out.println("Ingrese el ID del envío:");
        String idEnvio = scanner.nextLine();
        System.out.println("Ingrese el destino del envío:");
        String destino = scanner.nextLine();
        System.out.println("Ingrese el peso del envío (kg):");
        double peso = scanner.nextDouble();
        System.out.println("Ingrese la distancia del envío (km):");
        double distancia = scanner.nextDouble();
        scanner.nextLine();  

        Envio envio = new Envio(idEnvio, destino, peso, distancia);
        logistica.agregarEnvio(envio);

       
        System.out.println("Ingrese el ID del camión:");
        String idCamion = scanner.nextLine();
        System.out.println("Ingrese la capacidad del camión (kg):");
        double capacidad = scanner.nextDouble();
        scanner.nextLine(); 

        Camion camion = new Camion(idCamion, capacidad);
        logistica.agregarCamion(camion);

        
        System.out.println("Ingrese el ID del envío a asignar:");
        idEnvio = scanner.nextLine();
        System.out.println("Ingrese el ID del camión a asignar:");
        idCamion = scanner.nextLine();

        logistica.asignarCamion(idEnvio, idCamion);

        
        System.out.println("Ingrese el ID del envío para actualizar el estado:");
        idEnvio = scanner.nextLine();
        System.out.println("Ingrese el nuevo estado del envío:");
        String nuevoEstado = scanner.nextLine();

        logistica.actualizarEstadoEnvio(idEnvio, nuevoEstado);

       
        logistica.mostrarReporte();

        scanner.close();
    }
}
