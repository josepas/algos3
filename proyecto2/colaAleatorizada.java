import java.util.LinkedList;
import java.util.Random;

class ColaAleatorizada {

	private LinkedList<Integer> elems;
	private int cantidad;

	public ColaAleatorizada() {
		this.elems = new LinkedList<Integer>();
		this.cantidad = 0;

	}

	public boolean esVacia() {
		if ( this.cantidad == 0 )
			return true;
		return false;
	}

	public void agregarElem(int n) {
		this.elems.offer(n);
		this.cantidad++;
	}

	public int extraerElem() {
		if ( !this.esVacia() ) {
			Random alt = new Random();
			int aleatorio =  alt.nextInt(this.cantidad);
			this.cantidad--;
			return this.elems.remove(aleatorio);
		}
		return -1;
	}
}