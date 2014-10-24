import java.util.LinkedList;
import java.util.Random;

class ColaAleatorizada {

	private LinkedList<int[]> elems;
	private int cantidad;

	public ColaAleatorizada() {
		this.elems = new LinkedList<int[]>();
		this.cantidad = 0;

	}

	public boolean esVacia() {
		if ( this.cantidad == 0 )
			return true;
		return false;
	}

	public void agregarElem(int[] arista) {
		int[] aux = new int[2];
		aux[0] = arista[0];
		aux[1] = arista[1];
		this.elems.offer(aux);
		this.cantidad++;
	}

	public int[] extraerElem() {
		Random alt = new Random();
		int aleatorio =  alt.nextInt(this.cantidad);
		this.cantidad--;
		return this.elems.remove(aleatorio);
	}

}