package service;

import domain.Producto;

public class InventarioDeService {
    // Arreglo simple para almacenar productos (máximo 100)
    private Producto[] productos = new Producto[100];
    private int contadorProductos = 0;

    // Agregar un producto al inventario
    public void agregarProducto(Producto p) {
        productos[contadorProductos] = p;
        contadorProductos++;
    }

    // Mostrar inventario completo
    public void mostrarInventario() {
        System.out.println("=== INVENTARIO ===");
        for (int i = 0; i < contadorProductos; i++) {
            Producto p = productos[i];
            System.out.println("Código: " + p.getCodigo() + " | Nombre: " + p.getNombre() + " | Cantidad: "
                    + p.getCantidad() + " | Precio: " + p.getPrecioUnitario());
        }
    }

    // Buscar un producto por código
    public Producto buscarProducto(int codigo) {
        for (int i = 0; i < contadorProductos; i++) {
            if (productos[i].getCodigo() == codigo) {
                return productos[i];
            }
        }
        return null;
    }

    // Restar cantidad cuando se hace una venta
    public void restarCantidad(int codigo, int cantidadVendida) {
        Producto p = buscarProducto(codigo);
        if (p != null) {
            int nuevaCantidad = p.getCantidad() - cantidadVendida;
            p.setCantidad(nuevaCantidad);
        }
    }

}
