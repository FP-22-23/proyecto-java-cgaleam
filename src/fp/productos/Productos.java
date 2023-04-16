package fp.productos;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface Productos {
	
	List<Producto> getProductos();

	String toString();

	int hashCode();

	boolean equals(Object obj);
	
	//Obtiene el numero de elementos Producto
	
	Integer getNumeroProductos();
	
	//Añade un elemento Producto
	
	void anadirProducto(Producto p);
	
	//Añadir coleccion de elementos Producto
	
	void anadirListaProductos(List<Producto> productos);
	
	//Eliminar elemento Producto
	
	void eliminarProducto(Producto p);
	
	//Existe producto cuyo precio inicial supere los 100?
	
	Boolean existePrecioInicialSuperaCien(Double precioInicial);
	
	//Contador de productos pedidos por nombre
	
	Integer numProductosPorNombre(String nombre);
	
	//Producto con mas ventas totales que n por nombre
	
	List<Producto> productoMayorQuePorNombre (String nombre, Integer n);
	
	//Agrupar categoria por precio venta
	
	Map<TipoVenta, List<Producto>> agrupaProductosPorPrecioVenta();
	
	//Contar productos por disponibilidad
	
	Map<Boolean, Integer> contarProductosPorDisponibilidad();
	
	

}
