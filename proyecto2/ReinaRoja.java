import java.util.*;


class ReinaRoja {

	public void minimizarDisputas(char[][] reino) {
		

	}


	public static void main(String[] args) {
		
		int n;				// Numero de localidades
		int i,j,k;			// Iteradores
		boolean[][] visit;	// Matriz de Visitados
		char[][] reino;			
		
		String linea;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		visit = new boolean[n][n];
		reino = new char[n][n];
		ConjDisjuntos rr = new ConjDisjuntos(n);

		// Lectura de la matriz
		
		for (i=0; i<n; i++) {
 			linea = sc.next();
 			reino[i] = linea.toCharArray();
			for (j=i+1; j<n; j++) {
				visit[i][j] = false;
			}
		}
		minimizarDisputas(reino);		

	}

} 