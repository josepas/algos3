class ConjDisjuntos {

	private int aristas[];
	private int rango[];

	public ConjDisjuntos(int n) {
		this.aristas = new int[n+1];
		this.rango = new int[n+1];
		for (int i=0; i<=n; i++) {
			this.aristas[i] = i;
			this.rango[i] = 0; 
		}	
	} 

	public int representante(int n) {
		if ( this.aristas[n] == n ) {
			return n;
		}
		this.aristas[n] = representante(this.aristas[n]);
		return this.aristas[n];
	}

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

}