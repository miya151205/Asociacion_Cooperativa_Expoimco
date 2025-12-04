package domain;

public class Venta {
 
        private double monto;
    private String fecha; // Para este nivel, la fecha será un simple String

    public Venta(double monto, String fecha) {
        this.monto = monto;
        this.fecha = fecha;
    }

    public double getMonto() { return monto; }
    public String getFecha() { return fecha; }
}