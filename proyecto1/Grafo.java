import java.util.HashSet;
import java.util.Iterator;

class Grafo {

	private HashSet<Nodo> nodos;

	// Constructor del Grafo
	//
	public Grafo() {
		this.nodos = new HashSet<Nodo>(); 
	}

	// Metodos del Grafo
	//
	public HashSet<Nodo> obtenerNodos () {
		return this.nodos;
	}

	public void agregarNodo (Nodo nuevoNodo) {
		this.nodos.add(nuevoNodo);
	}

	public void imprimir () {
		Iterator<Nodo> itr = this.nodos.iterator();
		while ( itr.hasNext() ) {
			itr.next().imprimir();

		}

	}

}