package fp.productos;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import fp.utiles.*;
import fp.productos.Producto;

public class FactoriaProductos {

	public static List<Producto> leerProductos(String nombreFichero){
        List<Producto> res = new ArrayList<Producto>();
        try {
            List<String> lineas = Files.readAllLines(Paths.get(nombreFichero));
            lineas.remove(0);
            for (String linea: lineas) {
                res.add(parsearProducto(linea));
            }
        } catch (IOException e) {
        	System.out.println("No se ha encontrado el fichero"+ nombreFichero);
        }
        return res;
    }
	
	public static Producto parsearProducto(String linea) {
		String[] trozos=linea.split(";");
		Checkers.check("Error en elementos producto", trozos.length==10);
		String id=trozos[0].trim();
		LocalDateTime fechaInicio=LocalDateTime.parse(trozos[1].trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy H:mm"));
		String nombre= trozos[2].trim();
		Double precioInicial=Double.valueOf(trozos[3].trim());
		Double precioFinal=Double.valueOf(trozos[4].trim());
		Precios precios= new Precios(precioInicial, precioFinal);
		TipoVenta precioVenta= TipoVenta.valueOf(trozos[5].trim().toUpperCase());
		Integer codigo=Integer.valueOf(trozos[6].trim());
		List<String>categoria=parseaLista(trozos[7].trim());
		Boolean disponible=parseaBooleano(trozos[8].trim());
		Integer totalVentas=Integer.valueOf(trozos[9].trim());
		
		
	return new Producto( id, fechaInicio, nombre, precios,  precioVenta, codigo, categoria , disponible, totalVentas);
	
	}
		private static Boolean parseaBooleano(String cadena) {
			Boolean res = null;
			cadena = cadena.toUpperCase();
			if (cadena.equals("VERDADERO")) {
				res = true;
			}else {
				res = false;
			}
			return res;
		
	}
		
		public static  List<String> parseaLista(String cadena){

			String [] trozos=cadena.split("|");
			List<String> lista=new ArrayList<>();
			for(String t:trozos) {
				lista.add(t.trim());
				
			}
			return lista;
			
		}
}
