import java.util.*;


class  CSTREET {
	
	static class Arista implements Comparable<Arista> {
              
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

	public static int arbolMinCobertor(PriorityQueue<Arista> calles, int n) {
		int resultado;
		int conexiones;
		Arista calleAct;
		ConjDisjuntos edificios = new ConjDisjuntos(n+1);

		resultado = 0;
		conexiones = n;
		while ( !calles.isEmpty() ) {
			calleAct = calles.poll();
			System.out.println(calleAct.costo);
			if ( edificios.representante(calleAct.ini) != edificios.representante(calleAct.fin) ) {
				
				edificios.union(calleAct.ini,calleAct.fin);
				resultado = resultado + calleAct.costo;
				conexiones--;
			}
			if ( conexiones == 1 ) {
				return resultado;
			}

		}	
		return -1;
		
	}



	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t,p,n,m;
		int a,b,c;
		int i,j,k;

		t = sc.nextInt();
		
		while (t-- > 0) {
			
			p = sc.nextInt();
			n = sc.nextInt();	// numero de nodos
			m = sc.nextInt(); 	// numero de aristas
			PriorityQueue<Arista> calles = new PriorityQueue<Arista>(m);
			for (i=0; i<m; i++) {
				a = sc.nextInt();
				b = sc.nextInt();
				c = sc.nextInt();
				calles.offer(new Arista(a,b,c));
			}
			System.out.println(arbolMinCobertor(calles, n) * p);
			


		}

		







	}




}