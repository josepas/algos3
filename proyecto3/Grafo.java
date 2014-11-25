import java.util.HashSet;
import java.util.Scanner;
import java.util.LinkedList;

class Grafo {
	private HashMap<String, Nodo> nodos;
	private LinkedList<Arista> aristas;
	private int nAristas;
	private int nNodos;

	public Grafo(int m, int n) {
		this.nodos = new HashMap<String, Nodo>(m);
		this.aristas = new LinkedList<Arista>(); 
		this.nNodos = m;
		this.nAristas = n;
	} 

	public LinkedList<Arista> obtenerAristas() {
		return this.aristas;
	}
	
	public void agregarNodo(String id, Nodo nodo) {
		this.nodos.put(id, nodo);
	}

	public void agregarArista(Arista nueva) {
		this.aristas.offer(nueva);
	}

	public Nodo obtenerNodo(String id) {
		return this.nodos.get(id);

	}

	public int numeroNodos() {
		return this.nNodos;
	}

	public int numeroAristas() {
		return this.nAristas;
	}

	public void inicializarInf() {
		for (Map.Entry<String, Nodo> s : this.nodos.entrySet() ) {
			this.obtenerNodo( s.getKey() ).cambiarPago(10000);
		}
	}


}