import java.util.*;

class ReinaBlanca {

	public static int minimizarMonedas(int[][] reino, boolean[][] visit, int n) {
		
		int i,j,k;		// Iteradores
		int mi,mj, min; // Minimo de la matriz
		ConjDisjuntos rb = new ConjDisjuntos(n);
		boolean arbolCM;
		int resultado = 0;

		min = 0;
		while (min != 1000) {
			mi = 0;
			mj = 0;
			min = 1000;
			// Consigo el camino mas barato
			for (i=0; i<n; i++) {
				for (j=i+1; j<n; j++) {

					if ( (reino[i][j] < min) && !visit[i][j] && reino[i][j] != -1) {
						mi = i;
						mj = j;
						min = reino[i][j];
					}
				}
			}		
			visit[mi][mj] = true;

			if ( rb.representante(mi) != rb.representante(mj) ) {
				rb.union(mi,mj);
				resultado = resultado + reino[mi][mj];
			}

			// Se consiguio ya el arbol cobertor?
			arbolCM = true;
			for (i=0; i<n; i++) {
				if ( rb.representante(i) != rb.representante(0) ) {
					arbolCM = false;
				}
			}
			if (arbolCM) {
				return resultado;
			}

		}
		return -1;
	}


	public static void main(String[] args) {
		
		int n;				// Numero de localidades
		int i,j,k;			// Iteradores
		int resultado;		// 

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
		for (i=0; i<n; i++) {
 			linea = sc.next();
 			aux = linea.toCharArray();
			for (j=i+1; j<n; j++) {
				if (aux[j] == '.') {
					reino[i][j] = -1; 
				} else {
					reino[i][j] = Character.digit(aux[j], 10);

				}
				visit[i][j] = false;
			}
		}

		resultado = minimizarMonedas(reino,visit,n);

		if ( resultado == -1 ) {
			System.out.println("FAIL");
		} else {
			System.out.println(resultado);
		}

	}

} 