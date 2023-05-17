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
		
//		List<Producto> productos = FactoriaProductos.leerProductos("data/walmart_com.csv");
		Productos productos = FactoriaProductos.leerProductos("data/walmart_com.csv");
		
        List<String> category = new ArrayList<String>();
        category.add("Health|Home Health Care|Daily Living Aids");
        Producto p1 = new Producto("459b05f3cb7f1cba0a36fdc042ff0056",LocalDateTime.of(2019, 3, 22, 17, 10, 0), "In Style Eyes Cateye Two Tone Reading Glasses", new Precios(15.99, 19.99), TipoVenta.REBAJADO, 966478243, category, true, 306);
        
 //     -----------------ENTREGA 2:Operaciones Basicas------------------------
        
        System.out.println("--------------------ENTREGA 2:Operaciones Basicas------------------------");
        
        //Test numero elementos del producto
        System.out.println("=Test getNumeroProductos=");
        System.out.println(" El numero total de productos es " + productos.getNumeroProductos());
        System.out.println();
        
        // Test anadirProducto
        System.out.println("=Test anadirProducto=");
        productos.anadirProducto(p1);
        System.out.println("¿Productos contiene a p1?: " +  productos.getProductos().contains(p1) + 
        		" El numero de elementos actual es: "+productos.getNumeroProductos());
        System.out.println();
        
//      //Test añadir coleccion de elementos Producto
//        System.out.println("=Test anadirListaProductos=");
//        productos.anadirListaProductos(Collection<Producto>p1);
//        System.out.println(productos.getNumeroProductos());
//        System.out.println();
        
      //Test eliminar elemento Producto
        System.out.println("=Test eliminarProducto=");
        productos.eliminarProducto(p1);
        System.out.println("¿Productos contiene a p1?: " +  productos.getProductos().contains(p1) + 
        		" El numero de elementos actual es: "+productos.getNumeroProductos());
        System.out.println();
        
//      -----------------ENTREGA 2:Métodos------------------------
        
        System.out.println("--------------------ENTREGA2:Metodos------------------------");
        
      //1. Test Existe producto cuyo precio inicial supere los 100?
        System.out.println("=Test Funcion 1.1 existe=");
        System.out.println(productos.existeCodigoDado(891000000));
        System.out.println();
        
        
      //2. Test contador de productos pedidos por nombre
        System.out.println("=Test Funcion 1.2 contador=");
        System.out.println(productos.numProductosPorNombre("In Style Eyes Cateye Two Tone Reading Glasses"));
        System.out.println();
        
        
      //3. Test Producto con mas ventas totales que n por nombre
        System.out.println("=Test Funcion 1.3 seleccion y filtrado=");
        System.out.println(productos.productoMayorQuePorNombre("In Style Eyes Cateye Two Tone Reading Glasses", 300));
        System.out.println();
        
      //4.  Agrupar productos por precio venta
        System.out.println("=Test Funcion 1.4 map1=");
        System.out.println(productos.agrupaProductosPorPrecioVenta());
        System.out.println();
        
        
      //5. Test Contar productos por Tipo de venta
        System.out.println("=Test Funcion 1.5 map2=");
        System.out.println(productos.contarProductosPorTipoVenta());
        System.out.println();
	
        
       //--------------------ENTREGA 3---------------------
        
        System.out.println("--------------------ENTREGA 3--------------------");
        
      //1. Test Existe producto cuyo precio inicial supere los 100? con Stream
        System.out.println("=Test Funcion 2.1 existe con Stream=");
        System.out.println(productos.existeCodigoDadoStream(891000000));
        System.out.println();
        
      //2.Test Contador de productos pedidos por nombre con Stream
        System.out.println("=Test Funcion 2.2 contador con Stream=");
        System.out.println(productos.numProductosPorNombreStream("In Style Eyes Cateye Two Tone Reading Glasses"));
        System.out.println();
        
      //3. Test Seleccion de producto con mas ventas totales que n por nombre con Stream
        System.out.println("=Test Funcion 2.3 seleccion y filtrado con Stream=");
        System.out.println(productos.productoMayorQuePorNombreStream("In Style Eyes Cateye Two Tone Reading Glasses", 300));
        System.out.println();
        
      //4.Test Producto con mayor precio inicial
        System.out.println("=Test Funcion 2.4 producto mayor ventas totales con filtrado=");
        System.out.println(productos.productoMayorVentasTotales());
        System.out.println();
        
      //5. Test Productos que estan disponibles ordenados por ventas totales
        System.out.println("=Test Funcion 2.5 productos disponibles ordenados por ventas totales=");
        System.out.println(productos.productoDisponibleOrdenado());
        System.out.println();
        
      //6. Agrupar categoria por precio venta con Stream
        System.out.println("=Test Funcion 2.6 contar producto por precio venta con Stream=");
        System.out.println(productos.contarProductosPorTipoVentaStream());
        System.out.println();
        
      //7. Obtiene en cada precio venta el nombre del producto
        System.out.println("=Test Funcion 2.7 nombres en precio venta=");
        System.out.println(productos.getNombrePorPrecioVenta());
        System.out.println();
        
      //8. Obtiene un Map cuyas claves son años y valores productos con mas ventas ese año
        System.out.println("=Test Funcion 2.8 Map<años, ventas totales>=");
        System.out.println(productos.getProductoMasVendidoPorAño());
        System.out.println();
        
      //9. Obtiene un SortedMap con claves el precio venta y valores los n mejores productos(
      		//segun sus ventas totales)
        System.out.println("=Test Funcion 2.9 SortedMap=");
        System.out.println(productos.getMejoresProductosPorPrecioVenta(3));
        System.out.println();
        
      //10. Devuelve la clave que es el nombre del producto con el mayor precio inicial del Map 
        System.out.println("=Test Funcion 2.10 clave del maximo=");
        System.out.println(productos.getProductoMasCaro());
        System.out.println();
	}
}
