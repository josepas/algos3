import java.util.*;

class Main {

	public static boolean roadFromTo(int[][] roads, int n, int value, int sum, int ini, int fin, int destino, int level) {
		if (sum > value)
			return false;
		if (fin == destino && sum > 0 && level>1) {
			return value == sum;
		}

		int i;
		boolean result = false;

		for (i=1; i<=n; i++) {
			if (i != ini) {
				result = result || roadFromTo(roads, n, value, sum + roads[ini][i], i, i, destino, level+1);
				if (result)
					break;					
			}
		}

		return result;
	}


	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t,n;
		int i,j,k; 
		int[][] roads = new int[200][200];

		// Lectura de la matriz
		t = sc.nextInt();
		while (t-- > 0) {
			n = sc.nextInt();
			for (i=1 ; i<=n; i++) {
				for (j=1; j<=n; j++) {
					roads[i][j] = sc.nextInt();
				}
			}

			for (i=1; i<=n; i++) {
				
				for (j=i; j<=n; j++) {
					if (j != i && !roadFromTo(roads, n, roads[i][j], 0, i, j, j,0)   ) {
						System.out.println(i + " " + j);
					}
				}

			}

		}  

	}

}