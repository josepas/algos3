import java.util.LinkedList;

class Arista {
	
	private Nodo ini;
	private Nodo fin;
	private int costo;

	/** Constructor de la clase arista */
	public Arista(Nodo ini, Nodo fin, int costo) {
		this.ini = ini;
		this.fin = fin;
		this.costo = costo;
	}

	/** Obtiene el costo de un Arista. */
	public int obtenerCosto() {
		return this.costo;
	}

	/** Obtiene el nodo de salida. */
	public Nodo obtenerIni() {
		return this.ini;
	}

	/** Obtiene el nodo de llegada. */
	public Nodo obtenerFin() {
		return this.fin;
	}
}