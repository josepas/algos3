class Arista implements Comparable<Arista> {
          
    public int ini;
	public int fin;
	public int costo;
	
	public Arista(int a, int b, int costo) {
		this.ini = a;
		this.fin = b;
		this.costo = costo;
	}
    
    public int compareTo(Arista x) {
        return costo - x.costo;
    }
}