
public void bfs (int i) {

		LinkedList cola = new LinkedList();
		cola.addLast(i);
		LinkedList visitados = new LinkedList();
		while (!cola.isEmpty()) {
			int actual = cola.getFirst();
			
			if (!visitados.contains(actual)) {
				visitados.add(actual);
				for (Nodo sig : actual.obtenerAdyacentes())
					cola.offer(sig);