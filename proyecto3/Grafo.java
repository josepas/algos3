import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Grafo {
	private HashMap<String, Nodo> nodos;
	private LinkedList<Arista> aristas;
	private int nAristas;
	private int nNodos;

	/** Constructor de la clase Grafo. */
	public Grafo(int m, int n) {
		this.nodos = new HashMap<String, Nodo>(m);
		this.aristas = new LinkedList<Arista>(); 
		this.nNodos = m;
		this.nAristas = n;
	} 

	/** 
	 * Devuelve todas las aristas.  
	 *
	 * @throws aristas. 
	 */
	public LinkedList<Arista> obtenerAristas() {
		return this.aristas;
	}
	
	/** 
	 * Implementacion del algoritmo Bellman Ford. 
	 *
	 * @param id		ID del nodo a agregar. 
	 * @param nodo 		El nodo a agregar. 
	 */
	public void agregarNodo(String id, Nodo nodo) {
		this.nodos.put(id, nodo);
	}

	/** 
	 * Agrega un arista. 
	 *
	 * @param nueva 	Aristas a agregar. 
	 */
	public void agregarArista(Arista nueva) {
		this.aristas.offer(nueva);
	}

	/** 
	 * Implementacion del algoritmo Bellman Ford. 
	 *
	 * @param  id 		id del nodo a pedir. 
	 * @throws nodo 	Obtiene el nodo con la id pedida. 
	 */
	public Nodo obtenerNodo(String id) {
		return this.nodos.get(id);

	}

	/** 
	 * Devuelve el número de nodos del grafo. 
	 *
	 * @throws nNodos  Número de nodos del grafo. 
	 */
	public int numeroNodos() {
		return this.nNodos;
	}

	/** 
	 * Devuelve el número de aristas del grafo. 
	 *
	 * @throws nAristas  Número de aristas del grafo. */
	public int numeroAristas() {
		return this.nAristas;
	}

	/** 
	 * Inicializa todos los pagos del grafo en infinito (Numero muy grande:10000)
	 */
	public void inicializarInf() {
		for (Map.Entry<String, Nodo> s : this.nodos.entrySet() ) {
			this.obtenerNodo( s.getKey() ).cambiarPago(10000);
		}
	}


}