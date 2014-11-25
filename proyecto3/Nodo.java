class Nodo {

	private int pago;
	private Nodo padre;
	private String nombre;

	/** Constructor de la clase nodo. */
	public Nodo(String nombre, int pago, Nodo padre) {
		this.nombre = nombre;
		this.pago = pago;
		this.padre = padre;

	}

	/** Obtiene el nombre de un nodo. */
	public String obtenerNombre() {
		return this.nombre;
	}

	/** Obtiene el padre de un nodo. */
	public Nodo obtenerPadre() {
		return this.padre;
	}

	/** Obtiene el pago de un nodo. */
	public int obtenerPago() {
		return this.pago;
	}

	/** Cambia el pago de un nodo. */
	public void cambiarPago(int nuevoPago) {
		this.pago = nuevoPago;
	}

	/** Cambia el padre de un nodo. */
	public void cambiarPadre(Nodo nodo) {
		this.padre = nodo;
	}

}
