import java.io.*;
import java.util.*;

class main {

	public static void main(String[] args) {
 		Scanner sc = null;	
 		try {
 			sc = new Scanner(new File("entrada.in"));
  
		} catch (FileNotFoundException e) {
			System.out.println("No existe el archivo");
            e.printStackTrace();
        }
		
		Grafo g;
		int t; 
		int m,n;
		int i,j,k;
		String ciudad;
		

		t = sc.nextInt();

		while (t-- > 0) {

			m = sc.nextInt();
			n = sc.nextInt();
			g = new Grafo(m);

			// agrego los nodos
			for (i=0; i<m; i++) {
				ciudad = sc.next();
				g.agregarNodo(ciudad, new Nodo( ciudad, sc.nextInt(), null) );
			}

			// agrego las aristas
			for (i=0; i<n; i++) {
				g.agregarArista(new Arista(g.obtenerNodo( sc.next() ), g.obtenerNodo( sc.next() ), sc.nextInt() ) );
			}

			// Bellman-Ford
			for ( Arista x : g.obtenerAristas() ) {
				System.out.println(x.obtenerIni().obtenerNombre() + " - " + x.obtenerFin().obtenerNombre() + " " + x.obtenerCosto());
			}

			



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
			HashSet<Nodo> eliminados = new HashSet<Nodo>();

			for ( Arista x : g.obtenerAristas() ) {

				aristaYprevio = x.obtenerIni().obtenerPago() + x.obtenerCosto();

				if ( aristaYprevio < x.obtenerFin().obtenerPago() && !nodosDeCiclo.contains( x.obtenerIni() ) ) {
					System.out.println("Holaaaaaaa");
					nodosDeCiclo.offer( x.obtenerIni() );
				}
			}

			if ( nodosDeCiclo.isEmpty() ) {
				System.out.println("TODAS LAS RUTAS SON RENTABLES");
			}

			Nodo aux;
			for ( Nodo x : nodosDeCiclo ) {
				if ( !eliminados.contains(x) ) {

					eliminados.add(x);
					System.out.println(x.obtenerNombre());
					
					aux = x.obtenerPadre();
					while( x.obtenerNombre() != aux.obtenerPadre().obtenerNombre() ) {
						eliminados.add(aux);
						System.out.println(aux.obtenerNombre());

						aux = aux.obtenerPadre();
					}
				}
			}

		}
	}

}