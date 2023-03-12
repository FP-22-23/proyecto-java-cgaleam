package fp.productos;

import fp.utiles.Checkers;

public record Precios(Double precioInicial, Double precioFinal) {
	
	public void getPrecios() {
		System.out.println("Precios");
		System.out.println("==========================");
		System.out.println(this.precioInicial());
		System.out.println(this.precioFinal());
	}
	
	public boolean equals(Object o) {
		boolean res = false;
		if (o instanceof Precios);{
			Precios p = (Precios) o;
			res = this.precioInicial().equals(p.precioInicial()) &&
					this.precioFinal().equals(p.precioFinal());
		}
		return res;
	}
	
	public int compareTo(Precios p) {
		Checkers.checkNoNull(p);
		int res;
		res = precioInicial().compareTo(p.precioInicial());
		if (res==0) {
			res = precioFinal().compareTo(p.precioFinal());
		}
		return res;
	}
}
