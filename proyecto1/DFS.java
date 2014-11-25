import java.util.*;


public class DFS {

	public void dfs (Grafo g, Nodo n) {

		Stack<Nodo> pila = new Stack<Nodo>();
		pila.push(n);
		HashSet<Nodo> visitados = new HashSet<Nodo>();
		while (!pila.isEmpty()) {
			Nodo actual = pila.pop();
			System.out.println("Actual = " + actual.obtenerNombre);
			if (!visitados.contains(actual)) {
				visitados.add(actual);
				for (Nodo sig : actual.obtenerAdyacentes())
					pila.push(sig);
			}
		}
	}
}