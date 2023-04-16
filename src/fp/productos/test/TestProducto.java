package fp.productos.test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import fp.productos.Precios;
import fp.productos.Producto;
import fp.productos.TipoVenta;

public class TestProducto {

	public static void main(String[] args) {
		Producto p1 = new Producto("459b05f3cb7f1cba0a36fdc042ff0056", LocalDateTime.of(2019, 3, 22, 17, 10, 0));
        System.out.println(p1);

    // Prueba del constructor 2
    List<String> category = new ArrayList<String>();
    category.add("Health|Home Health Care|Daily Living Aids");
    Producto p2 = new Producto("459b05f3cb7f1cba0a36fdc042ff0056",LocalDateTime.of(2019, 3, 22, 17, 10, 0), "In Style Eyes Cateye Two Tone Reading Glasses", new Precios(15.99, 19.99), TipoVenta.REBAJADO, 966478243, category, true, 306);
        System.out.println(p2);
    }



}

