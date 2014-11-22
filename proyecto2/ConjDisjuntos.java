/** Clase de Conjuntos Disjuntos. */
class ConjDisjuntos {

	private int aristas[];
	private int rango[];

	/**
	 * Crea n conjuntos disjuntos, cada uno con representante ellos mismo y rango = 1.   
	 *
	 * @param n Numero de conjuntos disjuntos.
	 */
	public ConjDisjuntos(int n) {
		this.aristas = new int[n];
		this.rango = new int[n];
		for (int i=0; i<n; i++) {
			this.aristas[i] = i;
			this.rango[i] = 1; 
		}	
	} 

	/**
	 * Busca el representante de un nodo. 
	 *
	 * @param n  Nodo al cual buscarle su representante. 
	 * @throws m El representante de un nodo.  
	 */
	public int representante(int n) {
		if ( this.aristas[n] == n ) {
			return n;
		}
		this.aristas[n] = representante(this.aristas[n]);
		return this.aristas[n];
	}

	/**
	 * Une dos conjuntos disjuntos.
	 *
	 * @param n Nodo 1 a unir.
	 * @param v Nodo 2 a unir.
	 */
	public void union(int n, int v) {
		n = representante(n);
		v = representante(v);

		if ( this.rango[n] == this.rango[v] ) {
			this.aristas[v] = n;
			this.rango[n]++;
		} else if ( this.rango[n] > this.rango[v] ) {
			this.aristas[v] = n;
		} else {
			this.aristas[n] = v;
		}
	}

	/**
	 * Imprime el nodo y su representante. 
	 *
	 * @param n Nodo a imprimir.
	 * @throws n -> Representante de n. 
	 */
	public void imprimir(int n) {
		for (int i=0; i<n; i++) {
			System.out.println(i + " --> " + this.aristas[i]);
		}
		System.out.println();
	}
}

	








