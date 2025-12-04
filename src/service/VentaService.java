package service;

import domain.Venta;

public class VentaService {
    
    private Venta[] ventas = new Venta[200];
    private int contadorVentas = 0;

    // Registrar una venta
    public void registrarVenta(double monto, String fecha) {
        ventas[contadorVentas] = new Venta(monto, fecha);
        contadorVentas++;
    }

    // Mostrar ventas
    public void mostrarVentas() {
        System.out.println("=== REGISTRO DE VENTAS ===");
        for (int i = 0; i < contadorVentas; i++) {
            Venta v = ventas[i];
            System.out.println("Monto: " + v.getMonto() + " | Fecha: " + v.getFecha());
        }
    }

    // Total diario
    public double totalDiario(String fechaBuscada) {
        double total = 0;

        for (int i = 0; i < contadorVentas; i++) {
            if (ventas[i].getFecha().equals(fechaBuscada)) {
                total += ventas[i].getMonto();
            }
        }
        return total;
    }
}
