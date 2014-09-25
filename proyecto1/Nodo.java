import java.util.HashSet;
import java.util.Iterator;

public class Nodo {

    // Campos de la clase Nodo
    // 
    private String nombre;
    private HashSet<Nodo> adyacentes;
        
    // Constructor de Nodo
    public Nodo(String nuevoNombre) {
        this( nuevoNombre, new HashSet<Nodo>() );
    }
    
    public Nodo(String nuevoNombre, HashSet<Nodo> nuevoAdya) {
        this.nombre = nuevoNombre;
        this.adyacentes = nuevoAdya;
    }
           
    
    // Metodos de Nodo
    public String obtenerNombre() {
        return this.nombre;
    }

    /*
    public void obtenerAdyacentes() {
        System.out.println(nombre);
    }
    public void agregarAdyacente() {
        System.out.println(nombre);
    }
     
    public void agregarVariosAdyacente() {
        System.out.println(nombre);
    }    
    public void imprimir() {
        System.out.println("[" + this.nombre + "] -> [");
        itr = this.adyacentes.iterator();
        System.out.print( itr.next() );
        while(itr.hasNext()) {
            String i = itr.next();
            System.out.print(",  " + i);
        }
        System.out.println("]");

    }
    */
}







