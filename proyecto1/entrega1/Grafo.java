/*
	Autores:
		Daniela Socas 	11-10979
		Jose Pascarella	11-10743
	
	Descripcion:
		Clase Grafo con la que se representa la 
		red de agentes.
*/

import java.util.HashSet;

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
		for (Nodo x : this.nodos) {
			x.imprimir();
		}
	}

	// Crea un nuevo grafo donde los adyacentes de los Nodos son todos los nodos
	// alcanzables por el mismo (nodos conectados directa e indirectamente).
	//
	public Grafo aplanarRed () {
		Grafo h = new Grafo();
		HashSet<Nodo> tmp = new HashSet<Nodo>();
		for (Nodo x : this.nodos) {
			tmp = x.obtenerAlcanzables();
			x.borrarAdyacentes();
			x.agregarVariosAdyacentes(tmp); 
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
		System.out.print("Agentes cobertores: ");
		for (Nodo x : cobertores) {
			System.out.print(x.obtenerNombre() + " ");
		}				
		System.out.println();
		return co;
	}

}
