package domain;

public class Producto {
      // Atributos simples
    private int codigo;
    private String nombre;
    private int cantidad;
    private double precioUnitario;

    // Constructor
    public Producto(int codigo, String nombre, int cantidad, double precioUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    // Métodos get y set (básicos)
    public int getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public int getCantidad() { return cantidad; }
    public double getPrecioUnitario() { return precioUnitario; }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}