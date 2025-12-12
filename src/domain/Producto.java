package domain;

public class Producto {
    // Atributos simples de la clase
    private int codigo;
    private String nombre;
    private int cantidad;
    private double precioUnitario;

    // Constructores de la clase producto
    public Producto(int codigo, String nombre, int cantidad, double precioUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    // Métodos get y set para los atributos
    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    // Método set para la cantidad (para actualizar stock)
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}