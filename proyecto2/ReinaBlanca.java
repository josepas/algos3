import java.util.*;


class ReinaBlanca {

	public void minimizarMonedas(char[][] reino, boolean[][] visit, int n) {
		
		int i,j,k;		// Iteradores
		int mi,mj, min; // Minimo de la matriz
		ConjDisjuntos rb = new ConjDisjuntos(n);
		int resultado = 0;

		mi=1;
		mj=1;
		while (mi != 0 && mj != 0) {

			mi = 0;
			mj = 0;
			min = 1000000;
			// Consigo el camino mas barato
			for (i=0; i<n; i++) {
				for (j=i+1; j<n; j++) {
					if ( (reino[i][j] < min) && !visit[i][j]) {
						mi = i;
						mj = j;
						min = reino[i][j];
						visit[i][j] = true;
					}
				}
			}		

			if ( rb.representante(mi) != rb.representante(mj) ) {
				rb.union(mi,mj);
				resultado = resultado + reino[mi][mj];
			}

			// Se consiguio ya el arbol cobertor?
			for (i=0; i<n; i++) {
				if ( rb.representante(i) != rb.representante(0) ) {
					continue;
				}
			}

		}

	}


	public static void main(String[] args) {
		
		int n;				// Numero de localidades
		int i,j,k;			// Iteradores
		boolean[][] visit;	// Matriz de Visitados
		int[][] reino;
		char[] aux;
					
		
		String linea;
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		aux = new char[n];
		visit = new boolean[n][n];
		reino = new int[n][n];
		

		// Lectura de la matriz
		
		System.out.println(n);
		for (i=0; i<n; i++) {
 			linea = sc.next();
 			aux = linea.toCharArray();
			for (j=i+1; j<n; j++) {
				if (aux[j] == '.') {
					reino[i][j] = -1; 
				} else {
					reino[i][j] = Character.digit(aux[j], 10);
				}

				System.out.print(reino[i][j]);
				visit[i][j] = false;
			}
			System.out.println();
		}
		// minimizarMonedas(reino,);

	}

} 