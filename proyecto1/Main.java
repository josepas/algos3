import java.util.HashSet;


class  Proyecto1 {

	public static void main(String[] args) {

		Nodo epale = new Nodo("uuu");
	    Nodo agente86 = new Nodo("A");
	    Nodo agente69 = new Nodo("B");
		Nodo agente42 = new Nodo("C");
		Nodo agente18 = new Nodo("D");
				
	    HashSet<Nodo> red1 = new HashSet<Nodo>();
	    red1.add(agente69);
	    red1.add(agente86);

	    
	    System.out.println(epale.obtenerNombre());
	    epale.agregarAdyacente(agente42);
	    epale.imprimir();

	    epale.agregarAdyacente(agente18);
	    epale.imprimir();
	    epale.agregarVariosAdyacentes(red1);
	    epale.imprimir();

	}
}