import java.util.HashSet;
import java.util.Iterator;

public class Nodo {

    // Campos de la clase Nodo
    // 
    public String[] nombre;
    public HashSet adyacentes;
        
    // Constructor de Nodo
    public Nodo(String[] nuevoNombre) {
        this( nuevoNombre, new HashSet() );
    }
    public Nodo(String[] nuevoNombre, HashSet nuevoAdya) {
        this.nombre = nuevoNombre;
        this.adyacentes = nuevoAdya;
    }
           
    /*
    // Metodos de Nodo
    public void obtenerNombre() {
        System.out.println(nombre);
    }

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


