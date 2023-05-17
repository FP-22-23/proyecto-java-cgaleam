package fp.productos;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Productos {
	
	List<Producto> getProductos();

	String toString();

	int hashCode();

	boolean equals(Object obj);
	
	//a. Obtiene el numero de elementos Producto
	
	Integer getNumeroProductos();
	
	//b. Añade un elemento Producto
	
	void anadirProducto(Producto p);
	
	//c. Añadir coleccion de elementos Producto
	
	void anadirListaProductos(Collection<Producto> p);
	
	//d. Eliminar elemento Producto
	
	void eliminarProducto(Producto p);
	
	//1. Existe producto cuyo precio inicial supere los 100?
	
	Boolean existeCodigoDado(Integer codigo);
	
	//2. Contador de productos pedidos por nombre
	
	Integer numProductosPorNombre(String nombre);
	
	//3. Producto con mas ventas totales que n por nombre
	
	List<Producto> productoMayorQuePorNombre (String nombre, Integer n);
	
	//4. Agrupar categoria por precio venta
	
	Map<TipoVenta, Set<Producto>> agrupaProductosPorPrecioVenta();
	
	//5. Contar productos por disponibilidad
	
	Map<TipoVenta, Integer> contarProductosPorTipoVenta();
	
	
	
//	---------------ENTREGA 3---------------
	
	//1. Existe producto cuyo codigo sea el dado? con Stream
			
	 Boolean existeCodigoDadoStream(Integer codigo);
	
	 
	 // 2. Contador de productos pedidos por nombre con Stream
	 
	 Integer numProductosPorNombreStream(String nombre);
	 
	 
	 // 3. Seleccion de producto con mas ventas totales que n por nombre con Stream
	 
	 List<Producto> productoMayorQuePorNombreStream(String nombre, Integer n);

	 
	 //4. Producto con mayor ventas totales con filtrado
	 
	 Producto productoMayorVentasTotales();
	 
	 
	 //5. Productos que estan disponibles ordenados por ventas totales
	 
	 List<Producto> productoDisponibleOrdenado();
	 
	 
	//6. Agrupar categoria por precio venta con Stream
	 
	 Map<TipoVenta, Long> contarProductosPorTipoVentaStream();
	 
	//7. Obtiene en cada precio venta el nombre del producto
		
	 Map<TipoVenta, Set<String>> getNombrePorPrecioVenta();
	 
	//8. Obtiene un Map cuyas claves son años y valores productos con mas ventas ese año
	 
	 Map<Integer, Producto> getProductoMasVendidoPorAño();
	 
	//9. Obtiene un SortedMap con claves el precio venta y valores los n mejores productos(
	//segun sus ventas totales)
	 
	 Map<TipoVenta, List<String>> getMejoresProductosPorPrecioVenta(Integer n);
	 
	//10. Devuelve la clave que es el nombre del producto con el mayor precio inicial del Map 
	 
	 public String getProductoMasCaro();
}
