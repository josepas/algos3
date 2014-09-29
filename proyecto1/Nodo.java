import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class Nodo {

    // Campos de la clase Nodo
    // 
    public String nombre;
    public HashSet<Nodo> adyacentes;
        
    // Constructor de Nodo
    public Nodo(String nuevoNombre) {
        this( nuevoNombre, new HashSet<Nodo>() );
    }

    public Nodo(String nuevoNombre, HashSet<Nodo> nuevoAdya) {
        this.nombre = nuevoNombre;
        this.adyacentes = nuevoAdya;
    }
           
    // Metodos de Nodo
    //
    public String obtenerNombre() {
        return this.nombre;
    }

    public HashSet<Nodo> obtenerAdyacentes() {
        return this.adyacentes;
    }

    public void agregarAdyacente(Nodo nuevoAdya) {
        this.adyacentes.add(nuevoAdya);
    }
    
    public void agregarVariosAdyacentes(HashSet<Nodo> nuevosAdya) {
        this.adyacentes.addAll(nuevosAdya);
    }

    public HashSet<Nodo> obtenerAlcanzables () {
        HashSet<Nodo> alcanzables = new HashSet<Nodo>();
        LinkedList<Nodo> cola = new LinkedList<Nodo>();
        Nodo tmp;
       
        cola.offer(this);
        while ( !cola.isEmpty() ) {
            tmp = cola.poll();
            alcanzables.add(tmp);
            for ( Nodo x : tmp.obtenerAdyacentes() ) {
                if ( !alcanzables.contains(x) ) {
                    cola.offer(x);
                }
            }
        }
        return alcanzables;
    }
    
    public void imprimir() {
        System.out.print("[" + this.nombre + "] -> [");
        Iterator<Nodo> itr = this.adyacentes.iterator();
        
        // verifica que los adyacentes no sean vacios
        if (itr.hasNext()) {
            System.out.print( itr.next().obtenerNombre() );
        }

        while(itr.hasNext()) {
            String i = itr.next().obtenerNombre();
            System.out.print(",  " + i);
        }
        System.out.println("]");
    }

}







