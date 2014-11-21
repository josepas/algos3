import java.util.*;

class ReinaBlanca {

	public static int minimizarMonedas(PriorityQueue<Arista> caminos, int n) {
		
		int i,j,k;		// Iteradores
		ConjDisjuntos rb = new ConjDisjuntos(n);
		int conexiones;
		int resultado = 0;
		Arista caminoAct;

		conexiones = n;
		while ( !caminos.isEmpty() ) {

			caminoAct = caminos.poll();
			if ( rb.representante(caminoAct.ini) != rb.representante(caminoAct.fin) ) {
				rb.union(caminoAct.ini,caminoAct.fin);
				resultado = resultado + caminoAct.costo;
				conexiones--;
			}
			
			// Se consiguio ya el arbol cobertor?
			if (conexiones == 1) {
				return resultado;
			}

		}
		return -1;
	}

	public static void main(String[] args) {
		
		int n;				// Numero de localidades
		int i,j,k;			// Iteradores
		int resultado;		// 
		

		char[] aux;
		String linea;
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		PriorityQueue<Arista> caminos = new PriorityQueue<Arista>(n*n);
		aux = new char[n];
		
		// Lectura de la matriz
		for (i=0; i<n; i++) {
 			linea = sc.next();
 			aux = linea.toCharArray();
			for (j=i+1; j<n; j++) {
				if (aux[j] != '.') {
					caminos.offer( new Arista(i, j, Character.digit(aux[j], 10) ) );
				}
			}
		}

		resultado = minimizarMonedas(caminos, n);

		if ( resultado == -1 ) {
			System.out.println("FAIL");
		} else {
			System.out.println(resultado);
		}

	}

} 