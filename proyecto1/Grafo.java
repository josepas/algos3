import java.util.HashSet;
import java.util.Iterator;	
import java.util.LinkedList;

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

	public HashSet obtenerAlacanzables (Nodo v) {
		HashSet<Nodo> alcanzables = new HashSet<Nodo>();
        LinkedList<Nodo> cola = new LinkedList<Nodo>();
        Nodo tmp;
        cola.offer(v);

        while ( !cola.isEmpty() ) {
        	tmp = cola.poll();
        	alcanzables.add(tmp);
        	System.out.println("Agrege " + tmp.nombre + " a los alcanzables de --> " + v.nombre);
        	for ( Nodo x : tmp.obtenerAdyacentes() ) {
        		cola.offer(x);
        	}
        }
        return alcanzables;
    }


/*
	public void aplanarRed (Nodo v) {
		LinkedList<Nodo> cola = new LinkedList<Nodo>();
		cola.offer(v);
		while (!cola.isEmpty()) {
			for (Nodo x : v.adyacentes) {
				v.adyacentes add
			}
		}
	}
*/
}