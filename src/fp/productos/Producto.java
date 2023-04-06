package fp.productos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import fp.utiles.Checkers;

public class Producto implements Comparable<Producto> {
	
	//Atributos
	private String id;
	private LocalDateTime fechaInicio;
	private String nombre;
	private Double precioInicial;
	private Double precioFinal;
	private TipoVenta precioVenta;
	private Integer codigo;
	private List<String>categoria = new ArrayList<String>();
	private Boolean disponible;
	private Integer totalVentas;
	private Precios precios;
	
	//Getters y Setters
	public String getId() {     
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public LocalDateTime getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDateTime fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Double getPrecioInicial() {
		return precioInicial;
	}
	public void setPrecioInicial(Double precioInicial) {
		Checkers.check("Error en precio", precioVenta==precioVenta.REBAJADO && precioFinal<precioInicial);
		this.precioInicial = precioInicial;
	}
	public Double getPrecioFinal() {
		return precioFinal;
	}
	public void setPrecioFinal(Double precioFinal) {
		this.precioFinal = precioFinal;
	}
	public TipoVenta getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(TipoVenta precioVenta) {
		this.precioVenta = precioVenta;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public List<String> getCategoria() {
		return new ArrayList<String>(this.categoria);
	}
	public void setCategoria(List<String> categoria) {
		this.categoria = categoria;
	}

	public Boolean getDisponible() {
		return disponible;
	}
	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}
	public Integer getTotalVentas() {
		return totalVentas;
	}
	public void setTotalVentas(Integer totalVentas) {
		this.totalVentas = totalVentas;
	}
	

	public Precios getPrecios() {
		return precios;
	}
	public void setPrecios(Precios precios) {
		this.precios = precios;
	}
	
	//Restricciones
	private void checkId(String id) {
		Checkers.check("Cadena de id vacía", !(id == ""));
	}
	
	private void checkPrecioInicial(Double precioInicial) {
		Checkers.check("El precio inicial no puede ser 0", precioInicial > 0);
	}
	
	
	//Constructor 1 (recibe id y fechaInicio)
	
	public Producto (String id, LocalDateTime fechaInicio) {
		checkId(id);
		this.id=id;
		this.nombre=null;
		this.fechaInicio=fechaInicio;
		this.categoria=null;
		this.codigo=null;
		this.disponible=null;
		this.precioInicial=null;
		this.precioFinal=null;
		this.precioVenta=null;
		this.totalVentas=null;
		
	}
	
	//Constructor 2 (todas las propiedades)
	
	public Producto(String id, LocalDateTime fechaInicio, String nombre, Double precioInicial, Double precioFinal,
			TipoVenta precioVenta, Integer codigo, List<String>categoria , Boolean disponible, Integer totalVentas, Precios precios) {
		checkId(id);
		checkPrecioInicial(precioInicial);
		this.id = id;
		this.fechaInicio = fechaInicio;
		this.nombre = nombre;
		this.precioInicial = precioInicial;
		this.precioFinal = precioFinal;
		this.precioVenta = precioVenta;
		this.codigo = codigo;
		this.categoria = categoria;
		this.disponible = disponible;
		this.totalVentas = totalVentas;
		this.precios= precios;
	}
	
	//Propiedad derivada
	
	public Double getDiferenciaPrecio() {
		return this.precioFinal-this.precioInicial;
	}
	
	//Representacion como cadena
	@Override
	public String toString() {
		return "Producto [id=" + id + ", fechaInicio=" + fechaInicio + ", nombre=" + nombre + ", precioInicial="
				+ precioInicial + ", precioFinal=" + precioFinal + ", precioVenta=" + precioVenta + ", codigo=" + codigo
				+ ", categoria=" + categoria + ", disponible=" + disponible + ", totalVentas=" + totalVentas + ", precios="+ precios + "]";
	}
	
	
	//Criterio de igualdad
	
	@Override
	public int hashCode() {
		return Objects.hash(disponible, nombre, precioFinal);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(disponible, other.disponible) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(precioFinal, other.precioFinal);
	}
	
	//Criterio de orden natural
	
	@Override
	public int compareTo(Producto p) {
		int res=getDisponible().compareTo(p.getDisponible());
		if(res==0) {
			res=getNombre().compareTo(p.getNombre());
		if(res==0) {
			res=getPrecioFinal().compareTo(p.getPrecioFinal());
			}
		}
		return res;
	}
	
	//Metodos orientadoos al test
	
	public void getMetodos() {
		System.out.println("Producto");
		System.out.println("==========================");
		System.out.println("El nombre del producto es " +  this.getNombre());
		System.out.println("Tiene como id: " +  this.getId());
		System.out.println("Codigo:" + this.getCodigo());
		System.out.println("Fecha en la que sale " + this.getFechaInicio());
		System.out.println("Precio Inicial:" + this.getPrecioInicial());
		System.out.println("Precio Final: " +  this.getPrecioFinal());
		System.out.println("Tipo de venta " +  this.getPrecioVenta());
		System.out.println("Categoria " +  this.getCategoria());
		System.out.println("Disponibilidad " + this.getDisponible());
		System.out.println("Ventas totales " +  this.getTotalVentas());
		System.out.println("Precios " +  this.getPrecios());
		System.out.println("==========================");
		
	}
	
	
	
	
	
	
}
