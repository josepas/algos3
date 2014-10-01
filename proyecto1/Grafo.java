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
	// Obtiene los nodos de un grafo
	//
	public HashSet<Nodo> obtenerNodos () {
		return this.nodos;
	}

	// Agrega un nodo dado al grafo. 
	// 
	public void agregarNodo (Nodo nuevoNodo) {
		this.nodos.add(nuevoNodo);
	}

	// Imprime todos los nodos de un grafo con sus adyacentes.
	// Los imprime de la forma: [<Nodo>]->[adyacentes de Nodo]
	//
	public void imprimir () {
		



		Iterator<Nodo> itr = this.nodos.iterator();
		while ( itr.hasNext() ) {
			itr.next().imprimir();
		}
	}

	// Crea un nuevo grafo donde los adyacentes de los Nodos son todos los nodos
	// alcanzables por el mismo (nodos conectados directa e indirectamente).
	//
	public Grafo aplanarRed () {
		Grafo h = new Grafo();
		for (Nodo x : this.nodos) {
			x.adyacentes = x.obtenerAlcanzables();
			h.agregarNodo(x);
		}
		return h;
	}

	// Imprime la mínima cantidad de nodos necesarios para estar conectado directa
	// e indirectamente a todos los nodos de un grafo. 
	//
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