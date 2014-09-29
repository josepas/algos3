class  Proyecto1 {

	public static void main(String[] args) {

		Nodo v1 = new Nodo("A");
		Nodo v2 = new Nodo("B");
	    Nodo v3 = new Nodo("C");
	    Nodo v4 = new Nodo("D");
		Nodo v5 = new Nodo("E");
	    
		v1.agregarAdyacente(v2);
		v1.agregarAdyacente(v3);
		v2.agregarAdyacente(v1);
		v2.agregarAdyacente(v2);
		v3.agregarAdyacente(v1);
		v4.agregarAdyacente(v5);
		v5.agregarAdyacente(v5);
		v5.agregarAdyacente(v4);

		Grafo g = new Grafo();
		Grafo h = new Grafo();

		g.agregarNodo(v1);
		g.agregarNodo(v2);
		g.agregarNodo(v3);
		g.agregarNodo(v4);
		g.agregarNodo(v5);
		g.imprimir();
		g.cobertores();
		h = g.aplanarRed();
		h.imprimir();		

	}
}