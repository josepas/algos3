import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.LinkedList;

class Rutas {

	/** 
	 * Implementacion del algoritmo Bellman Ford. 
	 *
	 * @param g 		Grafo 
	 * @param fuente 	El nodo que se va iniciar. 
	 * @param caso 		1=>Nodos pertenecientes al ciclo del fuente. 
	 *					0=>Nodos perteneciente a un ciclo. 
	 * @throws nodosDeCiclo Nodos que pertenecen a un ciclo negativo. 
	 */
	public static LinkedList<Nodo> bellmanFord(Grafo g, String fuente, int caso) {
		int m = g.numeroNodos();
		int n = g.numeroAristas();
		int i;
		Nodo aux;
		
		g.inicializarInf();
		g.obtenerNodo(fuente).cambiarPago(0);

		/** Relajación de Aristas */
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
		
		/** Chequeo de ciclos negativos */
		LinkedList<Nodo> nodosDeCiclo = new LinkedList<Nodo>();
	
		if (caso == 0) {	
			for ( Arista x : g.obtenerAristas() ) {

				aristaYprevio = x.obtenerIni().obtenerPago() + x.obtenerCosto();

				if ( aristaYprevio < x.obtenerFin().obtenerPago() && 
					!nodosDeCiclo.contains( x.obtenerIni() ) ) {
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

	/** 
	 * Encuentra los ciclos negativos disjuntos del grafo que se representa.
	 *
	 * @throws  nuevo archivo con la entrada.  
	 *			Si el archivo no existe da NoFileFoundException.
	 */
	public static void main(String[] args) {
 		/** Lectura y escritura */
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

			/** Se agregan los nodos. */
			ciudad = "";
			for (i=0; i<m; i++) {
				ciudad = sc.next();
				g.agregarNodo(ciudad, new Nodo( ciudad, sc.nextInt(), null) );
			}

			/** Se agregan las aristas. */
			for (i=0; i<n; i++) {
				origen = sc.next();
				destino = sc.next();
				costo = sc.nextInt();
				g.agregarArista(new Arista( g.obtenerNodo(origen), g.obtenerNodo(destino), 
				g.obtenerNodo(origen).obtenerPago() - costo) );

			}

			/** Se obtienen los ciclos. */
			nodosDeCiclo = bellmanFord(g, ciudad, 0);


			/** Escritura de resultados. */
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