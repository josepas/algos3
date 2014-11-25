
class Nodo {

	private int pago;
	private Nodo padre;
	private String nombre;

	public Nodo(String nombre, int pago, Nodo padre) {
		this.nombre = nombre;
		this.pago = pago;
		this.padre = padre;

	}
	public String obtenerNombre() {
		return this.nombre;
	}

	public Nodo obtenerPadre() {
		return this.padre;
	}

	public int obtenerPago() {
		return this.pago;
	}

	public void cambiarPago(int nuevoPago) {
		this.pago = nuevoPago;
	}

	public void cambiarPadre(Nodo nodo) {
		this.padre = nodo;
	}

}
