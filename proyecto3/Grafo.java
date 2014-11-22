import java.util.*;

class Grafo {
	private HashMap<String, Nodo> nodos;
	private LinkedList<Arista> aristas;

	public Grafo(int m) {
		this.nodos = new HashMap<String, Nodo>(m);
		this.aristas = new LinkedList<Arista>(); 
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

	public HashMap<String, Nodo> obtenerNodos() {
		return this.nodos;
	}



}