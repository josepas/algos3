import java.util.Scanner;
import java.util.*;

class Main {

	public static void main(String[] args) {

		//Lee la entrada 
		//
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int x=0; x<t;x++) {
			int row = sc.nextInt();
			int column = sc.nextInt();
			int[][] matrix = new int[row][column];

			//Transforma la entrada de cada test en una matriz de adyacencias
			//
			for (int y=0; y<row;y++) {

				String pared = sc.next();
				char paredArreglada[] = pared.toCharArray();

				for (int z=0; z<column; z++) {
					if (paredArreglada[z] == '.'){
						matrix[y][z] = 1;

					} else if (paredArreglada[z] == '#'){
						matrix[y][z] = 1;						
					}
				}
			}

			//Lee la matriz de ady. y hace BFS para ver si existe un camino
			//
			boolean start = false;

			while ( start == false){

				for (int h=0; h<column; h++){

					if (matrix[0][h] == 1){
						start = true;
						int sR = 0;
						int sC = h;
						
					} else if (matrix[0][h] != 1) {
						for (int r=1;r<row; r++) {
							if (matrix[r][0] == 1) {
								start = true;
								int sR = r;
								int sC = 0;
								break;
							} else if (matrix[r][column-1] == 1) {
								start = true;
								int sR = r;
								int sC = column-1;
								break;
							} else {
								System.out.println("Invalid");
							}
						}
					}
				}
			}
			//
			//
			if (start = true) {
				boolean camino = false; 
				

			}


	}

}
}