import java.util.HashSet;
import java.util.Iterator;	

class Grafo {

	public HashSet<Nodo> nodos;

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

	public Grafo aplanarRed () {
		Grafo h = new Grafo();
		for (Nodo x : this.nodos) {
			x.adyacentes = x.obtenerAlcanzables();
			h.agregarNodo(x);
		}
		return h;
	}

	public int cobertores () {
		HashSet<Nodo> visitados = new HashSet<Nodo>();
		HashSet<Nodo> cobertores = new HashSet<Nodo>();
		int co = 0;

		for (Nodo x : this.nodos) {
			if ( !visitados.contains(x) ) {
				cobertores.add(x);
				visitados.addAll( x.obtenerAlcanzables() );
				co++;
			}			
		}
		for (Nodo x : cobertores) {
			System.out.print(x.nombre + " ");
		}
		System.out.println();
		return co;
	}

}