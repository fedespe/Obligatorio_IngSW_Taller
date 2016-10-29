
package Logica;

public class Universidad {
    private String nombre;
    private Pais pais;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Universidad(String nombre, Pais pais) {
        this.nombre = nombre;
        this.pais = pais;
    }
   
}
