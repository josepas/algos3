import java.util.*;

class Arista {
	
	private Nodo ini;
	private Nodo fin;
	private int costo;

	public Arista(Nodo ini, Nodo fin, int costo) {
		this.ini = ini;
		this.fin = fin;
		this.costo = costo;
	}

	public int obtenerCosto() {
		return this.costo;
	}

	public Nodo obtenerIni() {
		return this.ini;
	}

	public Nodo obtenerFin() {
		return this.fin;
	}





}