class lab1 {
	public static void main(String[] args) {

		ConjDisjuntos disjset = new ConjDisjuntos(3);
		
		
		disjset.makeSet(2);
		disjset.makeSet(3);

		System.out.println(disjset.father[1]+" PAdre de 2");
		System.out.println(disjset.father[2]+" PAdre de 3");

		System.out.println(disjset.find(1));
		System.out.println(disjset.find(2)+" PAdre find de 2 ");
		System.out.println(disjset.find(3)+" PAdre find de 3 ");
		
		disjset.union(2,3);
		System.out.println(disjset.find(2)+" PAdre de 2 then" );
		System.out.println(disjset.find(3)+" PAdre de 3 then");
		
	}
}
