import java.util.*;

class ConjDisjuntos {

	//Atributos	 de mi Conjunto Disjunto
	//
	public int father[];
	public int rank[];

	//Constructor de mi Conjunto Disjunto
	//
	public ConjDisjuntos(int numConj){
		this.father = new int[numConj];
		this.rank = new int[numConj];

		for (int x=0; x<numConj;x++) {
			this.father[x] = -1;
			this.rank[x] = 0;
		}
	}	

	//Metodos del Conjunto Disjunto
	//
	//Crea un nuevo arbol con él mismo de padre
	//
	public void makeSet(int conj){
		this.father[conj-1]= 0;	
	}

	//Método que devuelve el padre de un árbol, hace comprensión de caminos
	//
	public int find(int conj){
		if (this.father[conj-1] == -1){
			return 0;	
		} else if (this.father[conj-1] != 0) {
			this.father[conj-1] = find(this.father[conj-1]);
			
		} 
		return  conj;		
	}

	//Metodo para unir por tamaño dos conjuntos disjuntos 
	//
	public void link(int x,int y){

		if (this.rank[x-1] == this.rank[y-1]){
			this.father[y-1]= x;
			this.rank[x-1] += 1; 

		} else if (this.rank[x-1] > this.rank[y-1]){
			this.father[y-1] = x;

		} else if (this.rank[x-1] < this.rank[y-1]){
			this.father[y-1] = x;
		}
	}

	public void union(int x, int y){

		link(find(x),find(y));
	}
}
