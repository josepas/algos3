import java.util.*;

class main {
	
	public static boolean dfs(char[][] grafo, int i, int j, int m, int n,int prev) {

		// Casos base
		if (i<0 || i>m-1 || j<0 || j>n-1) {
			return false;
		}
		if ( grafo[i][j] == '#') {
			return false;
		}
		if ( (i==0 || i==m-1 || j==0 || j==n-1) && prev!=0 ) {
			return true;
		}
		
		if (prev == -1) 
			grafo[i][j-1] = '#';
		if (prev == 1) 
			grafo[i][j+1] = '#';
		if (prev == -2) 
			grafo[i+1][j] = '#';
		if (prev == 2) 
			grafo[i-1][j] = '#';

		return dfs(grafo, i+1,j,m,n,-2) || dfs(grafo, i-1,j,m,n,2) || dfs(grafo, i,j+1,m,n,-1) || dfs(grafo,i,j-1,m,n,1);
	}



	public static void main(String[] args) {

		int t, m, n;	
		int i, j, k; 	// iteradores
		int puntos;		// Cantidad de puntos en el contorno
		int x=0,y=0;		// Posicion de inicio
		char[][] matriz = new char[20][20]  ;
		
		String linea;
		Scanner sc = new Scanner(System.in);
	    t = sc.nextInt();

	    for (k=0; k<t; k++) {
	    	m = sc.nextInt();
	    	n = sc.nextInt();
	    	puntos = 0;

	    	// lectura de la matriz
	    	for (i=0; i<m; i++) {
	    		linea = sc.next();
	    		matriz[i] = linea.toCharArray();

	    		// conteo de puntos en el contorno
	    		if (i == 0 || i == m-1) {
	    			for (j=0; j<n; j++) {
	    				if (matriz[i][j] == '.') {
	    					puntos++;
	    					x = i;
	    					y = j;
	    				}
	    			}
	    		} else {
    				if (matriz[i][0] == '.') {
    					puntos++;
    					x = i;
	    				y = 0;
	    			}
    				if (matriz[i][n-1] == '.' && n-1!=0) {
    					puntos++;
    					x = i;
	    				y = n-1;
	    			}
    			}
    			
	    	}

	    	if (puntos != 2) {
				System.out.println("invalid");
				continue;
    		}

	    	if ( dfs(matriz,x,y,m,n,0) ) {
	    		System.out.println("valid");
	    	} else {
				System.out.println("invalid");	    		
	    	}
	    
	    }

	}
}
