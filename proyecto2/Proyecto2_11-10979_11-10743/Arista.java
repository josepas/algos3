/** Clase Arista(Los caminos entre mensajeros) */
class Arista implements Comparable<Arista> {
          
    public int ini;
	public int fin;
	public int costo;
	
	/** Constructor del Arista */
	public Arista(int a, int b, int costo) {
		this.ini = a;
		this.fin = b;
		this.costo = costo;
	}

    /** 
	 * Compara los costos de dos aristas.
	 *
	 * @param x 	  Arista con el que voy a comparar.
	 * @throws costo  La diferencias entre el costo de los 2 aristas.
	 */
    public int compareTo(Arista x) {
        return this.costo - x.costo;
    }
}