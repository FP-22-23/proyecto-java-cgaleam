# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso  22/23)
Autor/a: Carlos Galea Magro   uvus:MTD8580

El objetivo de este proyecto es analizar los datos de los productos vendidos en las tiendas de Walmart en Estados Unidos, los cuales se encuentran en el dataset de Kaggle que se puede descargar con el siguiente enlace (https://www.kaggle.com/datasets/promptcloud/walmart-product-dataset-usa). El dataset original cuenta con 14 columnas. Así que, se ha recortado el número de columnas escogiendo 7 de las 14 columnas, también se han añadido algunas columnas como las columnas "Precio Final", "Precio Venta" y "Total Ventas", entre las columnas escogidas encontramos al menos una de cada tipo, es decir, de tipo String (cadena), tipo Integer(número entero), tipo Double (número real), tipo LocalDateTime (fecha), tipo Boolean y de tipo Enumerado.


## Estructura de las carpetas del proyecto

* **/src**: Contiene los diferentes archivos que forman parte del proyecto, es decir, contiene el código fuente.
  * **fp.productos**: Paquete que contiene los tipos del proyecto.
  * **fp.productos.test**: Paquete que contiene las clases de test del proyecto.
  * **fp.common**: Paquete que contiene los tipos auxiliares del proyecto
  * **fp.utiles**:  Paquete que contiene las clases utiles.
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
* **Precios**: de tipo record, representa un precio inicial y final de un producto.

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
- _precios_, de tipo Record, consultable y modificable.

**Constructores**: 

- C1: Crea un objeto de tipo Producto a partir de los siguientes parámetros: String id, LocalDateTime fechaInicio. El resto de parámetros tienen el valor null.
- C2: Crea un objeto de tipo Producto a partir de los siguientes parámetros: String id, LocalDateTime fechaInicio, String nombreProducto, Double precioInicial, Double precioFinal, PrecioVenta precioVenta, Integer codigo, List<String> categoria, Boolean disponible, Integer totalVentas, Record precios.


**Restricciones**:
 
- R1: El ID de cada producto no puede estar vacío.
- R2: El precio inicial de un producto no puede ser 0.

**Criterio de igualdad**: Dos productos son iguales si tienen el mismo nombre, disponibilidad y tienen el mismo precio final.

**Criterio de ordenación**: Los productos están ordenados primero por su disponibilidad, nombre y precio final.

**Otras operaciones**:
 
-	_Double getDiferenciaPrecio()_: Devuelve la diferencia de dinero entre el precio final e inicial del producto.

#### Tipos auxiliares
- _PrecioVenta_, enumerado. Puede tomar 3 valores distintos: REBAJADO, AUMENTAPRECIO, PRECIOINICIAL.

### Factoría
Clase de factoría para construir objetos de tipo Producto.

leerProductos: Método que recibe como parámetro una cadena que contiene el nombre y ruta del fichero CSV, y devuelve una lista de objetos del tipo.
•parsearBooleano: Método que parsea un booleano para convertirla en tipo requerido.
•parseaLista: Método que parsea la lista categoria para poder leerla sin problemas.

### Tipo Contenedor

Clase contenedora de los objetos de tipo Producto.

**Propiedades**:

- Pais, de tipo String, consultable. Pais donde se encuentra.
- 
**Constructores**: 

- C1: Crea un objeto de tipo Productos a partir del parametro String pais. El parámetros productos es una lista vacía.
- C2: Crea un objeto de tipo Productos a partir de los siguientes parámetros: String pais, List producto.
- C Stream: Crea un objeto de tipo Productos a partir de los siguientes parámetros: Stream<Producto>.
- C Collection: Crea un objeto de tipo Productos a partir de los siguientes parámetros: Collection<Producto>.
- C3: Crea un objeto de tipo Productos a partir de los siguientes parámetros: String pais, Stream<Producto>.

**Criterio de igualdad**: Dos productos son iguales si tienen el mismo pais y lista.

**Criterio de ordenación**: Describir el criterio de ordenación.

**Otras operaciones**:
 
 ----------ENTREGA 2-----------
-	void getNumeroProductos(): Obtiene el número de productos que existen en el objeto ProductoImpl. 
-	void anadirProducto(Producto p): Añade un producto al objeto ProductoImpl.
-	void anadirListaProductos(List productos): Añade una lista de productos al objeto ProductoImpl.
-	void eliminarProducto(Producto p): Elimina un producto del objeto ProductoImpl.
-	Boolean existeCodigoDado(Integer codigo): Existe producto cuyo codigo sea el dado? 
-	Integer numProductosPorNombre(String nombre): Contador de productos pedidos por nombre
-	List productoMayorQuePorNombre (String nombre, Integer n):Producto con mas ventas totales que n por nombre 
-	Map<String, List> agrupaProductosPorPrecioVenta(): Agrupar categoria por precio venta
-	Map<Integer, Integer> contarProductosPorDisponibilidad(): Contar productos por disponibilidad

----------ENTREGA 3-----------
-	Boolean existeCodigoDadoStream(Integer codigo): Existe producto cuyo codigo sea el dado? con Stream
-	Integer numProductosPorNombreStream(String nombre): Contador de productos pedidos por nombre con Stream
-	List<Producto> productoMayorQuePorNombreStream(String nombre, Integer n): Seleccion de producto con mas ventas totales que n por nombre con Stream
-	Producto productoMayorVentasTotales(): Producto con mayor ventas totales con filtrado
-	List<Producto> productoDisponibleOrdenado(): Productos que estan disponibles ordenados por ventas totales
-	Map<TipoVenta, List<Producto>> agrupaProductosPorPrecioVentaStream(): Agrupar categoria por precio venta con Stream
-	Map<TipoVenta, Set<String>> getNombrePorPrecioVenta(): Obtiene en cada precio venta el nombre del producto
-	Map<Integer, Producto> getProductoMasVendidoPorAño(): Obtiene un Map cuyas claves son años y valores productos con mas ventas ese año
-	Map<TipoVenta, List<String>> getMejoresProductosPorPrecioVenta(Integer n):Obtiene un SortedMap con claves el precio venta y valores los n mejores productos(segun sus ventas totales)
-	String getProductoMasCaro():Devuelve la clave que es el nombre del producto con el mayor precio inicial del Map 
