package fp.productos.test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import fp.productos.FactoriaProductos;
import fp.productos.Precios;
import fp.productos.Producto;
import fp.productos.Productos;
import fp.productos.TipoVenta;
import fp.productos.ProductoImpl;

public class TestProductos {

	public static void main(String[] args) {
		
		List<Producto> productos = FactoriaProductos.leerProductos("data/walmart_com.csv");
		
		ProductoImpl t1 = new ProductoImpl("Italia");
        System.out.println(t1);
        System.out.println();

        List<String> category = new ArrayList<String>();
        category.add("Health|Home Health Care|Daily Living Aids");
        Producto p1 = new Producto("459b05f3cb7f1cba0a36fdc042ff0056",LocalDateTime.of(2019, 3, 22, 17, 10, 0), "In Style Eyes Cateye Two Tone Reading Glasses", new Precios(15.99, 19.99), TipoVenta.REBAJADO, 966478243, category, true, 306);
    
        
        //Test numero elementos del producto
        System.out.println("Test getNumeroProductos");
        System.out.println(t1.getNumeroProductos());
        System.out.println();
        
        // Test anadirProducto
        System.out.println("Test anadirProducto");
        t1.anadirProducto(p1);
        System.out.println(t1);
        System.out.println();
        
      //Test añadir coleccion de elementos Producto
        System.out.println("Test anadirListaProductos");
        t1.anadirListaProductos(productos);
        System.out.println(t1);
        System.out.println();
        
      //Test eliminar elemento Producto
        System.out.println("Test eliminarProducto");
        t1.eliminarProducto(p1);
        System.out.println(t1);
        System.out.println();
        
        
      //Test Existe producto cuyo precio inicial supere los 100?
        System.out.println("Test existe");
        System.out.println(t1.existePrecioInicialSuperaCien(19.99));
        System.out.println();
        
        
      //Test contador de productos pedidos por nombre
        System.out.println("Test contador");
        System.out.println(t1.numProductosPorNombre("In Style Eyes Cateye Two Tone Reading Glasses"));
        System.out.println();
        
        
      //Producto con mas ventas totales que n por nombre
        System.out.println("Test map1");
        System.out.println(t1.productoMayorQuePorNombre("In Style Eyes Cateye Two Tone Reading Glasses", 100));
        System.out.println();
        
        
      //Agrupar categoria por precio venta
        System.out.println("Test map2");
        System.out.println(t1.agrupaProductosPorPrecioVenta());
        System.out.println();
	
	}
}
