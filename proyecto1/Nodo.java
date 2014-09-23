public class Nodo {

    // Campos de la clase Nodo
    // 
    public String[] nombre;
    public CONJUNTO adyacentes;
        
    // Constructor de Nodo
    public Nodo(String[] nuevoNombre) {
        this(nuevoNombre, null);
    }
    public Nodo(String[] nuevoNombre, CONJUNTO nuevoAdya) {
        this(nuevoNombre, nuevoAdya);
    }
    public Nodo(String[] nuevoNombre, CONJUNTO nuevoAdya) {
        this.nombre = nuevoNombre;
        this.adyacentes = nuevoAdya;
    }
           
    // Metodos de Nodo
    public void setCadence(int newValue) {
        cadence = newValue;
    }
        
}
