import java.util.*;
//import java.utils.ArrayList;

public class BFS {

	public void bfs (Nodo n) {

		Queue<Nodo> cola = new Queue<Nodo>();
		cola.offer(n);
		HashSet<Nodo> visitados = new HashSet<Nodo>();
		while (!cola.isEmpty()) {
			Nodo actual = cola.poll();
			System.out.println("Actual = " + actual.obtenerNombre);
			if (!visitados.contains(actual)) {
				visitados.add(actual);
				for (Nodo sig : actual.obtenerAdyacentes())
					cola.offer(sig);
			}
		}
	}
	
}