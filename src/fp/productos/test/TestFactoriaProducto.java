package fp.productos.test;

import java.util.List;

import fp.productos.FactoriaProductos;
import fp.productos.Producto;
import fp.productos.Productos;

public class TestFactoriaProducto {

	public static void main(String[] args) {
        // Prueba del método leerProductos
        List<Producto> productos = FactoriaProductos.leerProductos("./data/walmart_com.csv");
        System.out.println("Se han leído " + productos.size() + " productos");
        for(Producto p:productos) {
            System.out.println(p);
        }
    }
}
