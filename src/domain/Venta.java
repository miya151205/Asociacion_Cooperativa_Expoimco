package domain;

public class Venta {
    // Creamos los atributos 
    private double monto;
    private String fecha; 

    // Creamos el constructor 
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