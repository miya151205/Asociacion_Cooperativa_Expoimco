package App;

import java.util.Scanner;
import service.VentaService;
import service.InventarioDeService;
import service.FinanzaService;
import domain.Producto;

public class Ejecucion {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        VentaService ventas = new VentaService();
        InventarioDeService inventario = new InventarioDeService();
        FinanzaService finanzas = new FinanzaService();

        int opcion;

        do {
            System.out.println("====== MENU PRINCIPAL ======");
            System.out.println("1. Agregar producto");
            System.out.println("2. Mostrar inventario");
            System.out.println("3. Registrar venta");
            System.out.println("4. Mostrar ventas");
            System.out.println("5. Total de ventas por día");
            System.out.println("6. Registrar inversión");
            System.out.println("7. Mostrar estado financiero");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = leerEnteroSeguro("Número inválido");

            switch (opcion) {

                case 1:
                    agregarProducto(sc, inventario);
                    break;

                case 2:
                    inventario.mostrarInventario();
                    break;

                case 3:
                    registrarVenta(sc, ventas, inventario, finanzas);
                    break;

                case 4:
                    ventas.mostrarVentas();
                    break;

                case 5:
                    System.out.print("Ingrese fecha (AAAA-MM-DD): ");
                    String fecha = sc.nextLine();
                    double total = ventas.totalDiario(fecha);
                    System.out.println("Total vendido ese día: $" + total);
                    break;

                case 6:
                    registrarInversion(sc, finanzas);
                    break;

                case 7:
                    finanzas.mostrarFinanzas();
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        sc.close();
    }


    // ===================== OPCIÓN 1: AGREGAR PRODUCTO =====================

    public static void agregarProducto(Scanner sc, InventarioDeService inventario) {

        System.out.print("Ingrese código del producto: ");
        int codigo = leerEnteroSeguro("Código inválido");

        System.out.print("Ingrese nombre del producto: ");
        String nombre = sc.nextLine(); // acepta espacios

        System.out.print("Ingrese cantidad inicial: ");
        int cantidad = leerEnteroSeguro("Cantidad inválida");

        System.out.print("Ingrese precio unitario: ");
        double precio = leerDoubleSeguro("Precio inválido");

        Producto p = new Producto(codigo, nombre, cantidad, precio);

        inventario.agregarProducto(p);

        System.out.println("Producto agregado correctamente.\n");
    }


    // ===================== OPCIÓN 3: REGISTRAR VENTA =====================

    public static void registrarVenta(Scanner sc,
                                      VentaService ventas,
                                      InventarioDeService inventario,
                                      FinanzaService finanzas) {

        System.out.print("Código del producto vendido: ");
        int codigo = leerEnteroSeguro("Código inválido");

        Producto p = inventario.buscarProducto(codigo);

        if (p == null) {
            System.out.println("ERROR: El producto no existe.\n");
            return;
        }

        System.out.print("Cantidad vendida: ");
        int cantidadVendida = leerEnteroSeguro("Cantidad inválida");

        if (cantidadVendida > p.getCantidad()) {
            System.out.println("ERROR: No hay suficiente stock.\n");
            return;
        }

        double monto = cantidadVendida * p.getPrecioUnitario();
        String fecha = obtenerFechaActual();

        ventas.registrarVenta(monto, fecha);

        inventario.restarCantidad(codigo, cantidadVendida);

        finanzas.registrarGanancia(monto);

        System.out.println("Venta registrada. Stock actualizado.\n");
    }


    // ===================== OPCIÓN 6: REGISTRAR INVERSIÓN =====================

    public static void registrarInversion(Scanner sc, FinanzaService finanzas) {

        System.out.print("Monto invertido: ");
        double monto = leerDoubleSeguro("Monto inválido");

        finanzas.registrarInversion(monto);

        System.out.println("Inversión registrada correctamente.\n");
    }


    // ===================== MÉTODOS SEGUROS =====================

    public static int leerEnteroSeguro(String mensaje) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println(mensaje + ". Intente nuevamente:");
            }
        }
    }

    public static double leerDoubleSeguro(String mensaje) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine());
            } catch (Exception e) {
                System.out.println(mensaje + ". Intente nuevamente:");
            }
        }
    }

    public static String obtenerFechaActual() {
        return java.time.LocalDate.now().toString();
    }
}
