package fp.productos.test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import fp.productos.Precios;
import fp.productos.Producto;
import fp.productos.TipoVenta;

public class TestProducto {
	
	public static void main(String[] args) {
		List<String>categoria= new ArrayList<String>();
		categoria.add("Health|Home Health Care|Daily Living Aids");
		
		Producto p1= new Producto("459b05f3cb7f1cba0a36fdc042ff0056", LocalDateTime.of(2019, 3, 22, 17, 10, 0));
		System.out.println(p1);
		
		Producto p2= new Producto("6a1bddc2801cbba539be0c182498d4dd", LocalDateTime.of(2019, 3, 22, 17, 46, 0),
				"3-Pack Black Peel-Off Mask for Deep Cleansing, Purifying Skin, Removing Blackheads, Blemishes ( 3 Bonus Hair Removing Pen)",19.54 ,20.52 ,TipoVenta.AUMENTAPRECIO ,
				696000000, categoria,false,219, new Precios(20.0, 21.0));
		System.out.println(p2);
		
		p2.getMetodos();
	}
}
