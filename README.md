# Sistema de Inventario y Ventas — Proyecto de la distribuidora Tuberias Expoimco

**Resumen rápido:** Proyecto Java sencillo para gestionar inventario, registrar ventas e inversiones financieras. Ideal como ejercicio pedagógico o punto de partida para sistemas de punto de venta (POS) pequeños.

---

## 🧭 1. Resumen del proyecto

Este repositorio contiene una aplicación de consola Java que permite:
- Añadir productos a un inventario.
- Registrar ventas y actualizar stock.
- Mantener un registro financiero (inversiones y ganancias).

Está pensado como un prototipo educativo, con clases claras y responsabilidad separada entre capas (Domain / Service / App).

---

## 🎯 2. Objetivo general y alcance

**Objetivo:** Proveer una base simple y clara para el manejo de inventario y ventas con una interfaz de consola que permita comprender el flujo de negocio básico.

**Alcance:**
- Gestión de productos (agregar, listar, buscar).
- Registro de ventas y cálculo de totales por día.
- Registro básico de finanzas (inversiones y ganancias).
- No incluye persistencia (salvo la memoria en ejecución), autenticación ni UI web.

---

## 🏗️ 3. Estructura del sistema (Domain / Service / App / Utils)

- `src/domain/` → Modelos de dominio (POJOs): `Producto`, `Venta`.
- `src/service/` → Lógica de negocio (servicios): `InventarioDeService`, `VentaService`, `FinanzaService`.
- `src/App/` → Punto de entrada: `Ejecucion.java` (menu de consola, validaciones y orquestación).
- `docs/plantuml/` → Diagramas PlantUML (generados a partir del análisis).

---

## 📚 4. Explicación detallada de las clases principales

### domain.Producto
- **Propósito:** Representa un artículo del inventario.
- **Atributos importantes:**
	- `codigo` (int): identificador único.
	- `nombre` (String)
	- `cantidad` (int): stock disponible.
	- `precioUnitario` (double)
- **Métodos relevantes:** getters y `setCantidad(int)` para actualizar stock.
- **Relaciones:** Es gestionado por `InventarioDeService`.

**Ejemplo de uso:**
```java
Producto p = new Producto(1001, "Tubo PVC 3/4", 50, 12.50);
inventario.agregarProducto(p);
```

---

### domain.Venta
- **Propósito:** Representa una venta realizada.
- **Atributos:**
	- `monto` (double)
	- `fecha` (String, formato `AAAA-MM-DD`)
- **Métodos:** getters simples.
- **Relaciones:** Es gestionada por `VentaService`.

---

### service.InventarioDeService
- **Propósito:** Administrar productos en memoria.
- **Atributos:** `Producto[] productos`, `contadorProductos`.
- **Métodos clave:**
	- `agregarProducto(Producto p)`
	- `mostrarInventario()`
	- `buscarProducto(int codigo)` → retorna `Producto` o `null`.
	- `restarCantidad(int codigo, int cantidadVendida)`
- **Comportamiento:** Arreglo simple con límite de 100 elementos (propuesta para mejorar con colecciones genéricas o persistencia).

**Ejemplo:**
```java
Producto p = inventario.buscarProducto(1001);
if (p != null) inventario.restarCantidad(1001, 2);
```

---

### service.VentaService
- **Propósito:** Registrar y mostrar ventas.
- **Atributos:** `Venta[] ventas`, `contadorVentas`.
- **Métodos clave:**
	- `registrarVenta(double monto, String fecha)`
	- `mostrarVentas()`
	- `totalDiario(String fecha)` → suma `monto` por fecha.

---

### service.FinanzaService
- **Propósito:** Llevar totales de inversiones y ganancias.
- **Atributos:** `inversiones`, `ganancias` (double).
- **Métodos:** `registrarInversion`, `registrarGanancia`, `mostrarFinanzas()`.

---

### App.Ejecucion
- **Propósito:** Interfaz de consola y orquestación de servicios.
- **Funciones principales:** menú interactivo, validación de entrada (métodos `leerEnteroSeguro` y `leerDoubleSeguro`), y métodos auxiliares para registrar ventas e inversiones.
- **Flujo principal (simplificado):**
	1. El usuario selecciona "Registrar venta".
	2. Se valida si el producto existe y hay stock.
	3. Si procede, se registra la venta, se actualiza inventario y finanzas.

**Ejemplo de ejecución (línea de comandos):**
```bash
javac -d out src\\App\\Ejecucion.java src\\domain\\*.java src\\service\\*.java
java -cp out App.Ejecucion
```
---

## 🏢 10. SECCIÓN ESPECIAL: Empresa Cliente – Tubos Expoimco S.A. 

**Logo:** `docs/logo.png` 

**Descripción breve:**
Tubos Expoimco S.A. es una distribuidora de materiales de tubería y accesorios para la construcción e industria. En este proyecto, Tubos Expoimco actúa como cliente y caso de uso para el prototipo de gestión de inventarios y ventas.

**Tabla de datos:**
________________________________________________________________________________________________________________________________
|       Nombre        |     Dirección       | Ciudad |     Contacto     |                    Enlace a mapa                     |
|---------------------|---------------------|--------|----------------- |------------------------------------------------------|
| Tubos Expoimco S.A. | Calle N°5 NRO 1-138 |  Ureña | +58 424-7215353  | [Ver mapa](https://maps.app.goo.gl/bcxaGqWFWP4VvSpNA)| 

**Misión / Visión**
- **Misión:** Suministrar materiales de tubería con calidad y entrega oportuna para proyectos residenciales e industriales.
- **Visión:** Ser el distribuidor líder regional con soluciones integrales y atención al cliente de excelencia.

---

## 👥 11. SECCIÓN ESPECIAL: Colaboradores del Proyecto
__________________________________________________________________________________________________
| Nombre |               Rol                       |                  GitHub                     |  
|--------|-----------------------------------------|---------------------------------------------|
| Miryian| Desarrollador de la rama domain y Main  | [miya151205](https://github.com/miya151205) |
| keiner | Desarrollador de la rama service        | [keiner-png](https://github.com/keiner-png) |
| Jhon   | Desarrollador de la rama App            | [Jhon-0703](https://github.com/Jhon-0703)   |

## 🔗 12. Redes Sociales / Badges

<p>
	<a href="https://instagram.com/whoismiyaa"><img alt="Instagram" src="https://www.instagram.com/whooismiyaa?igsh=MXN6Y3Z4MWV5bXczNA=="></a>
    <a href="https://instagram.com/kejos_72"><img alt="Instagram" src="https://www.instagram.com/kejos_72?igsh=ZWQzcjNlMjFkMzA0"></a>
</p>
 
 ### Ubicacion de la Empresa
 [Ver en Google Maps](https://maps.app.goo.gl/bcxaGqWFWP4VvSpNA) 






