package sv.edu.usam.guia7_201165;

public class Frutas {

    private String nombre;
    private String descripcion;

    public Frutas(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
}