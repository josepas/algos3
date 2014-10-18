/*
        Autores:
                Daniela Socas   11-10979
                Jose Pascarella 11-10743

        Descripcion:
                Clase Nodo con la que se representa a 
		cada agente y sus conocidos.
*/


import java.util.HashSet;
import java.util.LinkedList;

public class Nodo {

    // Campos de la clase Nodo
    // 
    public String nombre;
    public HashSet<Nodo> adyacentes;
        
    // Constructor de Nodo
    // Construye el Nodo con los adyacentes vacios.
    public Nodo(String nuevoNombre) {
        this( nuevoNombre, new HashSet<Nodo>() );
    }

    //Construye el Nodo y sus adyacentes
    public Nodo(String nuevoNombre, HashSet<Nodo> nuevoAdya) {
        this.nombre = nuevoNombre;
        this.adyacentes = nuevoAdya;
    }
           
    // Metodos de Nodo
    // Da el nombre de un Nodo dado.
    //
    public String obtenerNombre() {
        return this.nombre;
    }

    // Da los adyacentes de un Nodo dado
    //
    public HashSet<Nodo> obtenerAdyacentes() {
        return this.adyacentes;
    }

    public void borrarAdyacentes() {
        this.adyacentes.removeAll(this.adyacentes);
    } 

    // Agrega adyacentes a un Nodo dado.
    //
    public void agregarAdyacente(Nodo nuevoAdya) {
        this.adyacentes.add(nuevoAdya);
    }
    

    // Agrega varios adyacentes a un Nodo dado.
    //
    public void agregarVariosAdyacentes(HashSet<Nodo> nuevosAdya) {
        this.adyacentes.addAll(nuevosAdya);
    }

    // Obtiene los nodos alcanzables(adyacentes directos e indirectos) de un Nodo.
    // 
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

    //Imprime el nodo de la forma: [<Nodo>]->[adyacentes de Nodo]
    //
    public void imprimir() {
        System.out.print("[" + this.nombre + "] -> [ ");
        for (Nodo x : this.adyacentes) {
            System.out.print(x.nombre + " ");   
        }
        System.out.println("]");

    }




}







