import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.LinkedList;

class Rutas {

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
		
		t = sc.nextInt();
		while (t-- > 0) {

			m = sc.nextInt();
			n = sc.nextInt();
			g = new Grafo(m);

			// Agrego los nodos
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

			// Bellman-Ford

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
			
			for ( Arista x : g.obtenerAristas() ) {

				aristaYprevio = x.obtenerIni().obtenerPago() + x.obtenerCosto();

				if ( aristaYprevio < x.obtenerFin().obtenerPago() && !nodosDeCiclo.contains( x.obtenerIni() ) ) {
					nodosDeCiclo.offer( x.obtenerFin() );
				}
			}

			// Escritura de resultados
			if ( nodosDeCiclo.isEmpty() ) {
				escritor.println("TODAS LAS RUTAS SON RENTABLES");
			}

			HashSet<Nodo> eliminados = new HashSet<Nodo>();
			Nodo aux;
			for ( Nodo x : nodosDeCiclo ) {
				if ( !eliminados.contains(x) ) {

					eliminados.add(x);
					escritor.print(x.obtenerNombre() + " ");
					
					
					aux = x.obtenerPadre();
					while( x.obtenerNombre() != aux.obtenerNombre() ) {
						eliminados.add(aux);

						escritor.print(aux.obtenerNombre() + " ");

						aux = aux.obtenerPadre();
						
					}
					escritor.println();
				}
			}
			if (t != 0)
				escritor.println();
		}
		sc.close();
		escritor.close();
	}

}