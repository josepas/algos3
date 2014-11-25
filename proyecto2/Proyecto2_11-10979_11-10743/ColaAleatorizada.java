import java.util.LinkedList;
import java.util.Random;

/** Extrae elementos aleatorios de una cola. */
class ColaAleatorizada {

	private LinkedList<int[]> elems;
	private int cantidad;

	/** Constructor de la Cola Aleatorizada */
	public ColaAleatorizada() {
		this.elems = new LinkedList<int[]>();
		this.cantidad = 0;

	}

	/** 
	 * Te dice si la cola es vacia o no. 
	 *
	 * @throws true => es vacia. false => es falso. 
	 */
	public boolean esVacia() {
		if ( this.cantidad == 0 )
			return true;
		return false;
	}

	/**
	 * Agrega un arista a la cola. 
	 * @param arista El arista a agregar a la cola. 
	 */
	public void agregarElem(int[] arista) {
		int[] aux = new int[2];
		aux[0] = arista[0];
		aux[1] = arista[1];
		this.elems.offer(aux);
		this.cantidad++;
	}

	/** 
	 * Extrae un elemento aleatorio de la cola.
	 */
	public int[] extraerElem() {
		Random alt = new Random();
		int aleatorio =  alt.nextInt(this.cantidad);
		this.cantidad--;
		return this.elems.remove(aleatorio);
	}
 
}