import java.util.*;

class colaAleatorizada {

	private LinkedList<Integer> elems;
	private int cantidad;

	public colaAleatorizada() {
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

	public static void main(String[] args) {

		colaAleatorizada prueba = new colaAleatorizada();	
		prueba.agregarElem(899);
		prueba.agregarElem(53);
		prueba.agregarElem(122);
		prueba.agregarElem(233);
		prueba.agregarElem(2);
		prueba.agregarElem(123);
		prueba.agregarElem(2313);
		prueba.agregarElem(1);
		prueba.agregarElem(232);
		prueba.agregarElem(23);
		prueba.extraerElem();
		prueba.extraerElem();
		prueba.extraerElem();
	}


}