import java.util.*;

class ReinaRoja {

	public static int minimizarDisputas(char[][] reino, ColaAleatorizada aristas, int n) {
			
		int[] actual;			//
		int minimal;
		int nodosPorUnir;
		   
		ConjDisjuntos rr = new ConjDisjuntos(n);

		nodosPorUnir = n;
		minimal = 0;
		while ( !aristas.esVacia() ) {
			actual = aristas.extraerElem();

			if ( rr.representante(actual[0]) != rr.representante(actual[1]) ) {

				if ( nodosPorUnir > 2 ) {
					rr.union(actual[0], actual[1]);
					nodosPorUnir--;
				} else {
					minimal++;
				}
			}
		}
		return minimal;

	}


	public static void main(String[] args) {
		
		int n;				// Numero de localidades
		int itr=0;			// Numero de Iteraciones
		int i,j,k;			// Iteradores
		int[] aux = new int[2];
		int minimo=10000;
		int minimal;	
		
		String linea;
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		char[][] reino = new char[n][n];
		ColaAleatorizada aristas = new ColaAleatorizada();

		// Lectura de la matriz y del numero de 
		// iteraciones
		for (i=0; i<n; i++) {
 			linea = sc.next();
 			reino[i] = linea.toCharArray();
		}
		itr = sc.nextInt();

		for (k=0; k<itr; k++){
			for (i=0; i<n; i++) {
				for (j=i+1; j<n; j++) {
					if ( reino[i][j] != '.' ) {
						aux[0] = i;
						aux[1] = j;
						aristas.agregarElem(aux);
					}
				}
			}
			
			minimal = minimizarDisputas(reino, aristas, n);			
			if ( minimal < minimo )
				minimo = minimal;
		
		}
		System.out.println(minimo + " en " + itr + " iteraciones.");

	}

} 