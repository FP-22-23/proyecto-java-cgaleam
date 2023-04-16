package fp.productos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.SortedMap;
import java.util.TreeMap;

public class ProductoImpl implements Productos {
	
	private String pais;
	
	private List<Producto> productos;
	
	
	//Constructor 1
	
	public ProductoImpl(String pais) {
		this.pais=pais;
		productos= new ArrayList<Producto>();
	}
	
	//Constructor 2
	
	public ProductoImpl(String pais, List<Producto> productos) {
		this.pais=pais;
		this.productos= productos;
	}

	
	@Override
	public List<Producto> getProductos() {
		return productos;
	}
	
	
	//Representacion como cadena
	
	@Override
	public String toString() {
		return "ProductoImpl [productos=" + productos + "]";
	}

	
	//HashCode y crtiterio de igualdad
	
	@Override
	public int hashCode() {
		return Objects.hash(pais, productos);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductoImpl other = (ProductoImpl) obj;
		return Objects.equals(pais, other.pais) && Objects.equals(productos, other.productos);
	}



	//Obtener numero de elementos Producto
	
	public Integer getNumeroProductos() {
		return productos.size();
	}

	//Añadir elemento Producto
	
	public void anadirProducto(Producto p) {
		productos.add(p);
		
	}

	//Añadir coleccion de elementos Producto
	
	public void anadirListaProductos(List<Producto> productos) {
        for (Producto p: productos) {
            anadirProducto(p);
        }
    }
		
	

	//Eliminar elemento Producto
	
	public void eliminarProducto(Producto p) {
		productos.remove(p);
		
	}
	
	
	//Existe producto cuyo precio inicial supere los 100?
	
	public Boolean existePrecioInicialSuperaCien(Double precioInicial) {
		Boolean res= false;
		for(Producto producto:productos) {
			if(precioInicial>100) {
				res=true;
				break;
			}
		}
		return res;
	}

	//Contador de productos pedidos por nombre
	
	public Integer numProductosPorNombre(String nombre) {
		Integer res=0;
		for(Producto producto:productos) {
			if(producto.getNombre().equals(nombre)) {
				res++;
			}
		}
		return res;
	}

	
	//Producto con mas ventas totales que n por nombre
	
	public List<Producto> productoMayorQuePorNombre(String nombre, Integer n) {
		List<Producto> res= new LinkedList<Producto>();
		for(Producto producto:productos) {
			if(producto.getNombre().equals(nombre) && producto.getTotalVentas()>n) {
				res.add(producto);
			}
		}
		return res;
	}

	//Agrupar categoria por precio venta
	
	public Map<TipoVenta, List<Producto>> agrupaProductosPorPrecioVenta() {
		Map<TipoVenta, List<Producto>> res= new HashMap<>();
		for(Producto producto:productos) {
			TipoVenta clave= producto.getPrecioVenta();
			if(res.containsKey(clave)) {
				List<Producto> valor= res.get(clave);
				valor.add(producto);
				res.put(clave, valor);
				
			}else {
				List<Producto> valor= new ArrayList();
				valor.add(producto);
				res.put(clave, valor);
				
			}
		}
		
		return res;
	}

	//Contar productos por disponibilidad
	
	public SortedMap<Boolean, Integer> contarProductosPorDisponibilidad() {
		SortedMap<Boolean, Integer> res= new TreeMap<>();
		for (Producto producto:productos) {
				Boolean clave= producto.getDisponible();
				if(res.containsKey(clave)) {
					
					res.put(clave, res.get(clave) +1);
					
				}else {
					res.put(clave, 1);
				}
		}
		return res;
	}
	

	

}
