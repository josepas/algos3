import java.util.HashSet;
import java.util.Iterator;	
import java.util.LinkedList;

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

	public HashSet<Nodo> obtenerAlcanzables (Nodo v) {
		HashSet<Nodo> alcanzables = new HashSet<Nodo>();
        LinkedList<Nodo> cola = new LinkedList<Nodo>();
        Nodo tmp;
       
        cola.offer(v);
        while ( !cola.isEmpty() ) {
        	tmp = cola.poll();
        	alcanzables.add(tmp);
        	for ( Nodo x : tmp.obtenerAdyacentes() ) {
        		if ( !alcanzables.contains(x) ) {
        			cola.offer(x);
        		}
        	}
        }
        return alcanzables;
    }

	public Grafo aplanarRed () {
		Grafo h = new Grafo();
		for (Nodo x : this.nodos) {
			x.adyacentes = this.obtenerAlcanzables(x);
			h.agregarNodo(x);
		}
		return h;
	}
}