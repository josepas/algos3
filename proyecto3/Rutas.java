import java.io.*;
import java.util.*;

class Rutas {

	public static LinkedList<Nodo> bellmanFord(Grafo g, String fuente, int caso) {
		int m = g.numeroNodos();
		int n = g.numeroAristas();
		int i;
		Nodo aux;
		
		g.inicializarInf();
		g.obtenerNodo(fuente).cambiarPago(0);

		// Relajacion de Aristas
		int aristaYprevio;
		for (i=1; i<n; i++) {
						
			for ( Arista x : g.obtenerAristas() ) {

				aristaYprevio = x.obtenerIni().obtenerPago() + x.obtenerCosto();
				
				if ( aristaYprevio < x.obtenerFin().obtenerPago() ) {
					x.obtenerFin().cambiarPago(aristaYprevio);
					x.obtenerFin().cambiarPadre( x.obtenerIni() );
				}
			}
		}
		
		// Chequeo de ciclos negativos
		LinkedList<Nodo> nodosDeCiclo = new LinkedList<Nodo>();
	
		if (caso == 0) {	
			for ( Arista x : g.obtenerAristas() ) {

				aristaYprevio = x.obtenerIni().obtenerPago() + x.obtenerCosto();

				if ( aristaYprevio < x.obtenerFin().obtenerPago() && !nodosDeCiclo.contains( x.obtenerIni() ) ) {
					nodosDeCiclo.offer( x.obtenerIni() );
				}
			}
		}

		if (caso == 1) {
			Nodo x = g.obtenerNodo(fuente);

			nodosDeCiclo.push(x);
			aux = x.obtenerPadre();
			while( x.obtenerNombre() != aux.obtenerNombre() ) {
				nodosDeCiclo.push(aux);
				aux = aux.obtenerPadre();
				
			}
		}

		return nodosDeCiclo;

	}

	public static void main(String[] args) {
 		// lectura y escritura
 		Scanner sc = null;	
 		PrintWriter escritor = null;
 		try {
 			sc = new Scanner(new File(args[0]));
 			escritor = new PrintWriter(args[1]);
  
		} catch (FileNotFoundException e) {
			System.out.println("Error de lectura/escritura");
            e.printStackTrace();
        }
	
		Grafo g;
		int t; 
		int m,n;
		int i;
		int costo;
		String ciudad, origen, destino;
		LinkedList<Nodo> nodosDeCiclo = new LinkedList<Nodo>();
		LinkedList<Nodo> ciclo = new LinkedList<Nodo>();
		
		
		t = sc.nextInt();
		while (t-- > 0) {

			m = sc.nextInt();
			n = sc.nextInt();
			g = new Grafo(m, n);

			// Agrego los nodos
			ciudad = "";
			for (i=0; i<m; i++) {
				ciudad = sc.next();
				g.agregarNodo(ciudad, new Nodo( ciudad, sc.nextInt(), null) );
			}

			// Agrego las aristas
			for (i=0; i<n; i++) {
				origen = sc.next();
				destino = sc.next();
				costo = sc.nextInt();
				g.agregarArista(new Arista( g.obtenerNodo(origen), g.obtenerNodo(destino), g.obtenerNodo(origen).obtenerPago() - costo) );

			}

			// Encuentro los ciclos
			nodosDeCiclo = bellmanFord(g, ciudad, 0);


			// Escritura de resultados
			if ( nodosDeCiclo.isEmpty() ) {
				escritor.println("TODAS LAS RUTAS SON RENTABLES");
			} 


			HashSet<Nodo> eliminados = new HashSet<Nodo>();
			Nodo y;
			for ( Nodo x : nodosDeCiclo ) {
				if ( !eliminados.contains(x) ) {

					eliminados.add(x);
					ciclo = bellmanFord(g, x.obtenerNombre(), 1);
					
					while ( !ciclo.isEmpty() ) {
						y = ciclo.pop();
						eliminados.add(y);
						escritor.print(y.obtenerNombre() + " ");
					}
				}
				escritor.println();	
			}

			if (t != 0)
				escritor.println();
		}
		sc.close();
		escritor.close();
	}

}