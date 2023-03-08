# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso  22/23)
Autor/a: Carlos Galea Magro   uvus:cargalmag

El objetivo de este proyecto es analizar los datos de los productos vendidos en las tiendas de Walmart en Estados Unidos, los cuales se encuentran en el dataset de Kaggle que se puede descargar con el siguiente enlace (https://www.kaggle.com/datasets/promptcloud/walmart-product-dataset-usa). El dataset original cuenta con 14 columnas. Así que, se ha recortado el número de columnas escogiendo 7 de las 14 columnas, también se han añadido algunas columnas como las columnas "Precio Final", "Precio Venta" y "Total Ventas", entre las columnas escogidas encontramos al menos una de cada tipo, es decir, de tipo String (cadena), tipo Integer(número entero), tipo Double (número real), tipo LocalDateTime (fecha), tipo Boolean y de tipo Enumerado.


## Estructura de las carpetas del proyecto

* **/src**: Contiene los diferentes archivos que forman parte del proyecto, es decir, contiene el código fuente.
  * **fp.productos**: Paquete que contiene los tipos del proyecto.
  * **fp.productos.test**: Paquete que contiene las clases de test del proyecto.
  * **fp.common**: Paquete que contiene los tipos auxiliares del proyecto
  * **fp.utiles**:  Paquete que contiene las clases de utilidad. 
* **/data**: Contiene el dataset del proyecto
    * **walmart_com-ecommerce_product_details.csv**: Archivo csv que muestra información sobre algunos productos vendidos en tiendas de Walmart.
    
## Estructura del *dataset*

El dataset original se puede descargar con el siguiente enlace: https://www.kaggle.com/datasets/promptcloud/walmart-product-dataset-usa. El dataset del enlace cuenta con 14 columnas. Para la realización del proyecto se ha recortado el número de columnas escogiendo 8 de las 14 columnas, también se han añadido algunas columnas como las columnas "Precio Final", "Precio Venta", "Total Ventas", entre las columnas escogidas encontramos al menos una de cada tipo, es decir, de tipo String (cadena), tipo Integer(número entero), tipo Double (número real), tipo LocalDateTime (fecha con año, mes, día y la hora, minutos y segundos), tipo Boolean y de tipo Enumerado.
El dataset está compuesto por 11 columnas, con la siguiente descripción:

* **Id**: de tipo cadena, representa el ID del producto.
* **Fecha Inicio**: de tipo fecha, representa la fecha en la que se empieza a recolectar información sobre los productos. Muestra el año, mes, día, horas, minutos y segundos.
* **Nombre Producto**: de tipo cadena, representa el nombre del producto.
* **Precio**: de tipo real, representa el precio inicial del producto
* **Precio Final**: de tipo real, representa el precio tras las rebajas o aumentos de precio
* **Precio Venta**: de tipo cadena, representa el tipo de cambio que ha sufrido el precio inical al ponerse en venta.
* **Codigo**: de tipo entero, representa el código de barras de cada producto.
* **Categioria**: de tipo cadena, representa las distintas categorías a las que pertenece un producto.
* **Disponible**: de tipo booleano, representa si el producto está disponible o no actualmente. El producto está disponible si aparece como TRUE, si aparece como FALSE no está disponible
* **Total Ventas**: de tipo entero, representa el número total de veces que se ha vendido un producto.


## Tipos implementados

Los tipos que se han implementado en el proyecto son los siguientes:

### Tipo Base - Producto
Representa un producto concreto.

**Propiedades**:

- _id_, de tipo String, consultable y modificable. 
- _fechaInicio_, de tipo LocalDateTime, consultable y modificable. Muestra el año, mes, día, horas, minutos y segundos.
- _nombreProducto_, de tipo String, consultable y modificable.
- _precioInicial_, de tipo Double, consultable y modificable.
- _precioFinal_, de tipo Double, consultable y modificable.
- _precioVenta_, de tipo PrecioVenta, consultable y modificable. Puede ser de tres tipos distintos: Rebajado, PrecioInicial (no hay cambios en el precio) o AumentaPrecio.
- _codigo_, de tipo Integer, consultable y modificable.
- _categoria_, de tipo List<String>, consultable y modificable.
- _disponible_, de tipo Boolean, consultable y modificable.
- _totalVentas_, de tipo Integer, consultable y modificable.

**Constructores**: 

- C1: Crea un objeto de tipo Producto a partir de los siguientes parámetros: String id, String nombreProducto. El resto de parámetros tienen el valor _null_.
- C2: Crea un objeto de tipo Producto a partir de los siguientes parámetros: String id, LocalDateTime fechaInicio, String nombreProducto, Double precioInicial, Double precioFinal, PrecioVenta precioVenta, Integer codigo, List<String> categoria, Boolean disponible, Integer totalVentas.


**Restricciones**:
 
- R1: El ID de cada producto no puede estar vacío.
- R2: Si un producto no se ha vendido ninguna vez no puede estar agotado, por lo que debe de estar disponible, es decir, si el valor de _totalSales_ es 0, _available_ no podrá ser FALSE.


**Criterio de igualdad**: Dos productos son iguales si tienen el mismo ID y nombre, son de la misma marca y tienen el mismo precio inicial.

**Criterio de ordenación**: Los productos están ordenados primero por su precio inicial y después por el número total de ventas.

**Otras operaciones**:
 
-	_Double getGananciasTotales()_: Devuelve cuanto dinero se ha ganado con cada producto, para calcularlo multiplica el precio de venta del producto y el número total de ventas.

#### Tipos auxiliares
- _PrecioVenta_, enumerado. Puede tomar 3 valores distintos: Rebajado, PrecioInicial, AumentaPrecio.

### Factoría
Descripción breve de la factoría.

- _método 1_: Descripción del método 1.
-	_método 2_: Descripción del método 2.

### Tipo Contenedor

Descripción breve del tipo contenedor.

**Propiedades**:

- _propiedad1_, de tipo \<Tipo1\>, consultable. 
- _propiedad2_, de tipo \<Tipo2\>, consultable y modificable. 
- ...
- 
**Constructores**: 

- C1: Descripción del constructor 1.
- C2: Descripción del constructor 2.
- ...

**Restricciones**:
 
- R1: Descripción de la restricción 1.
- R2: Descripción de la restricción 2.
- ...
- 
**Criterio de igualdad**: Describir el criterio de igualdad

**Criterio de ordenación**: Describir el criterio de ordenación (si lo hay).

**Otras operaciones**:
 
-	_método 1_: Descripción del método 1.
- ...
