package service;

public class FinanzaService {
    private double inversiones = 0;
    private double ganancias = 0;

    // Registrar inversión
    public void registrarInversion(double valor) {
        inversiones += valor;
    }

    // Registrar ganancia
    public void registrarGanancia(double valor) {
        ganancias += valor;
    }

    // Mostrar datos
    public void mostrarFinanzas() {
        System.out.println("--- ESTADO FINANCIERO ---");
        System.out.println("Total inversiones: " + inversiones);
        System.out.println("Total ganancias: " + ganancias);
    }
}
