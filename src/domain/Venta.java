package domain;

public class Venta {
    // Creamos los atributos de la clase
    private double monto;
    private String fecha;

    // Creamos el constructor de la clase
    public Venta(double monto, String fecha) {
        this.monto = monto;
        this.fecha = fecha;
    }

    // Creamos los getters
    public double getMonto() {
        return monto;
    }

    public String getFecha() {
        return fecha;
    }
}