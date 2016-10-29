
package Logica;

public class ProblemaResuelto {
    private int numeroProblema;
    private int minutos;
    private int penalizaciones;

    public int getNumeroProblema() {
        return numeroProblema;
    }

    public void setNumeroProblema(int numeroProblema) {
        this.numeroProblema = numeroProblema;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getPenalizaciones() {
        return penalizaciones;
    }

    public void setPenalizaciones(int penalizaciones) {
        this.penalizaciones = penalizaciones;
    }

    public ProblemaResuelto(int numeroProblema, int minutos, int penalizaciones) {
        this.numeroProblema = numeroProblema;
        this.minutos = minutos;
        this.penalizaciones = penalizaciones;
    }
    
    public int tiempoTotal(){
        return minutos+(20*penalizaciones);
    }
}
