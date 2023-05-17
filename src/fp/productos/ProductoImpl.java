package fp.productos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductoImpl implements Productos {
	
	private String pais;
	
	private List<Producto> productos;
	
	
	//Constructor 1
	
	public ProductoImpl(String pais) {
		this.pais=pais;

	}
	
	//Constructor 2
	
	public ProductoImpl(String pais, List<Producto> productos) {
		this.pais=pais;
		this.productos= productos;
	}
	
	//Constructor con Stream
	
	public ProductoImpl(Stream<Producto> p) {
		this.productos = p.collect(Collectors.toList());
	}

	
	//Constructor con Collection
	
	public ProductoImpl(Collection<Producto> p) {
		this.productos = new ArrayList<Producto>(p);
		
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
	
	public void anadirListaProductos(Collection<Producto> p) {
		productos.addAll(p);
	}
	

	//Eliminar elemento Producto
	
	public void eliminarProducto(Producto p) {
		productos.remove(p);
		
	}
	
	
	//1. Existe producto cuyo codigo sea el dado? 
	/*
	 * @param: codigo
	 * @return: boolean que indica si existe o no
	 */
	
	public Boolean existeCodigoDado(Integer codigo) {
		Boolean res= false;
		for(Producto producto:productos) {
			if(producto.getCodigo().equals(codigo)) {
				res=true;
				break;
			}
		}
		return res;
	}

	//2. Contador de productos pedidos por nombre
	/*
	 * @param: nombre
	 * @return: Un entero que son el numero de productos con el nombre dado
	 */
	
	public Integer numProductosPorNombre(String nombre) {
		Integer res=0;
		for(Producto producto:productos) {
			if(producto.getNombre().equals(nombre)) {
				res++;
			}
		}
		return res;
	}

	
	//3. Seleccion de producto con mas ventas totales que n por nombre
	/*
	 * @param: nombre
	 * @param: un entero n
	 * @return: Productos con mas ventas que n
	 */
	
	public List<Producto> productoMayorQuePorNombre(String nombre, Integer n) {
		List<Producto> res= new LinkedList<Producto>();
		for(Producto producto:productos) {
			if(producto.getNombre().equals(nombre) && producto.getTotalVentas()>n) {
				res.add(producto);
			}
		}
		return res;
	}

	//4. Agrupar productos por precio venta
	/*
	 * @return: Productos de cada tipo de venta
	 */
	
	public Map<TipoVenta, Set<Producto>> agrupaProductosPorPrecioVenta() {
		Map<TipoVenta, Set<Producto>> res= new HashMap<TipoVenta, Set<Producto>>();
		for(Producto producto:productos) {
			TipoVenta clave= producto.getPrecioVenta();
			
			if(res.containsKey(clave)) {
				Set<Producto> valor= res.get(clave);
				valor.add(producto);
				res.put(clave, valor);
				
			}else {	
				Set<Producto> valor= new HashSet<Producto>();
				valor.add(producto);
				res.put(clave, valor);
				
			}
		}
		
		return res;
	}

	//5. Contar productos por Tipo de venta
	/*
	 * @return: Devuelve por cada tipo de venta un entero que corresponde al numero de productos de ese tipo
	 */
	
	public SortedMap<TipoVenta, Integer> contarProductosPorTipoVenta() {
		SortedMap<TipoVenta, Integer> res= new TreeMap<>();
		for (Producto producto:productos) {
				TipoVenta clave= producto.getPrecioVenta();
				if(res.containsKey(clave)) {
					
					res.put(clave, res.get(clave) +1);
					
				}else {
					res.put(clave, 1);
				}
		}
		return res;
	}
	
	//----------------------ENTREGA 3------------------------------------
	
	//Constructor 3:
	
	public ProductoImpl(String pais, Stream<Producto> productos) {
		this.pais=pais;
		this.productos = productos.collect(Collectors.toList());
	}
	
	
		//1. Existe producto cuyo codigo sea el dado?  con Stream
		/*
		 * @param: codigo
		 * @return: boolean que indica si existe o no
		 */
	
		public Boolean existeCodigoDadoStream(Integer codigo) {
			Boolean res= productos.stream()
						.anyMatch(p->p.getCodigo().equals(codigo));
			return res;  
		}
	
		
		//2. Contador de productos pedidos por nombre con Stream
		/*
		 * @param: nombre
		 * @return: Un entero que son el numero de productos con el nombre dado
		 */
		
		public Integer numProductosPorNombreStream(String nombre) {
			Long res= productos.stream()
						.filter(p->p.getNombre().equals(nombre))
						.count(); //El count trabaja solo con long
			
			return res.intValue();
		}
		
		
		//3. Seleccion de producto con mas ventas totales que n por nombre con Stream
		/*
		 * @param: nombre
		 * @param: n
		 * @return: Productos con mas ventas que n
		 */
		
		public List<Producto> productoMayorQuePorNombreStream(String nombre, Integer n) {
			List<Producto> res= productos.stream()
								.filter(p->p.getTotalVentas()>n &&  p.getNombre().equals(nombre)  )
								.collect(Collectors.toList());
			
			return res;
		}

		
		//4. Producto con mayor ventas totales con filtrado
		/*
		 * @return: El producto con mas ventas
		 */
		
		public Producto productoMayorVentasTotales() {
			Producto res= productos.stream()
								.filter(p->p.getTotalVentas()>400)
								.max(Comparator.comparing(Producto::getTotalVentas))
								.orElse(null);
			
			return res;
		}
		
			
		//5. Productos que estan disponibles ordenados por ventas totales de menor a mayor
		/* 
		 * @return: Lista de productos que estan disponibles ordenados por ventas totales de menor a mayor
		 */
		
		public List<Producto> productoDisponibleOrdenado() {
			return productos.stream()
									.filter(p->p.getDisponible().equals(true))
									.sorted(Comparator.comparing(Producto::getTotalVentas))
									.collect(Collectors.toList());
									
		
		}
		
		
		//6. Contar productos por Tipo de venta con Stream
		/*
		 * @return: Devuelve por cada tipo de venta un entero que corresponde al numero de productos de ese tipo
		 */
		
		public Map<TipoVenta, Long> contarProductosPorTipoVentaStream() {
			
			return productos.stream()
					.collect(Collectors.groupingBy(
							Producto::getPrecioVenta, Collectors.counting()));
					
		}
		
		 
		//7. Obtiene en cada precio venta el nombre del producto
		/*
		 * @return: Obtiene en cada precio venta el nombre del producto
		 */
		
		public Map<TipoVenta, Set<String>> getNombrePorPrecioVenta(){
			return productos.stream()
					.collect(Collectors.groupingBy(Producto::getPrecioVenta,
							Collectors.mapping(Producto::getNombre, Collectors.toSet())));
		}
		
		//8. Obtiene un Map cuyas claves son años y valores productos con mas ventas ese año
		/*
		 * @return: Obtiene un Map cuyas claves son años y valores productos con mas ventas ese año
		 */
		
		public Map<Integer, Producto> getProductoMasVendidoPorAño(){
	        Comparator<Producto> cmp = Comparator.comparing(p -> p.getTotalVentas());  //Comparator que compara los objetos tipo Producto con la propiedad getTotalVentas
	        return productos.stream().collect(Collectors.groupingBy(p -> p.getFechaInicio().getYear(), 
	                Collectors.collectingAndThen(Collectors.maxBy(cmp), 
	                        opt -> opt.get())));
	    }
		
		//9. Obtiene un SortedMap con claves el precio venta y valores los n mejores productos(
		//segun sus ventas totales)
		/*
		 * @param: n, entero 
		 * @return: Obtiene un SortedMap con claves el precio venta y valores los n mejores productos(
		//segun sus ventas totales)
		 */
		
		public Map<TipoVenta, List<String>> getMejoresProductosPorPrecioVenta(Integer n){
			return productos.stream()
					.collect(Collectors.groupingBy(Producto::getPrecioVenta, 
							TreeMap::new,
							Collectors.collectingAndThen(Collectors.toList(), 
									list -> getNombreTotalVentas(list, n))
							));
		}
		
		//Funcion auxiliar que devuelve una lista de nombres
		public List<String> getNombreTotalVentas(List<Producto> l, Integer n){
			return l.stream()
			.sorted(Comparator.comparing(Producto::getTotalVentas))
			.limit(n)
			.map(Producto::getNombre)
			.collect(Collectors.toList());
			
		}
		
		//10. Devuelve la clave que es el nombre del producto con el mayor precio inicial del Map 
		/*
		 * @return: Devuelve la clave que es el nombre del producto con el mayor precio inicial del Map
		 */
		
		public String getProductoMasCaro() {

	        Map<String, Double> aux = productos.stream()  //Creo primero un Map auxiliar 
	                .collect(Collectors.groupingBy(Producto::getNombre, 
	                		Collectors.averagingDouble(x->x.getPrecios().precioInicial())));
	        
	        return aux.entrySet().stream()
	        		.max(Comparator.comparing(Entry::getValue))
	        		.get()
	        		.getKey();
	    }
		
		
}
