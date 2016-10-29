
package Logica;

import java.util.ArrayList;
import java.util.Date;

public class SedeRegional {
    private Date fechaCompetencia;
    private int maximoDeEquipos;
    private int cantidadProblemas;
    private String nombreSede;
    private ArrayList<Equipo> listaEquipos=new ArrayList();
    private ArrayList<Pais> paisesHabilitados;

    public SedeRegional(Date fechaCompetencia, int maximoDeEquipos, int cantidadProblemas, String nombreSede, ArrayList<Pais> paisesHabilitados) {
        this.fechaCompetencia = fechaCompetencia;
        this.maximoDeEquipos = maximoDeEquipos;
        this.cantidadProblemas = cantidadProblemas;
        this.nombreSede = nombreSede;
        this.paisesHabilitados = paisesHabilitados;
    }

    public Date getFechaCompetencia() {
        return fechaCompetencia;
    }

    public void setFechaCompetencia(Date fechaCompetencia) {
        this.fechaCompetencia = fechaCompetencia;
    }

    public int getMaximoDeEquipos() {
        return maximoDeEquipos;
    }

    public void setMaximoDeEquipos(int maximoDeEquipos) {
        this.maximoDeEquipos = maximoDeEquipos;
    }

    public int getCantidadProblemas() {
        return cantidadProblemas;
    }

    public void setCantidadProblemas(int cantidadProblemas) {
        this.cantidadProblemas = cantidadProblemas;
    }

    public String getNombreSede() {
        return nombreSede;
    }

    public void setNombreSede(String nombreSede) {
        this.nombreSede = nombreSede;
    }

    public ArrayList<Equipo> getListaEquipos() {
        return listaEquipos;
    }

    public void setListaEquipos(ArrayList<Equipo> listaEquipos) {
        this.listaEquipos = listaEquipos;
    }

    public ArrayList<Pais> getPaisesHabilitados() {
        return paisesHabilitados;
    }

    public void setPaisesHabilitados(ArrayList<Pais> paisesHabilitados) {
        this.paisesHabilitados = paisesHabilitados;
    }
    
    
    public boolean registrarEquipo(Equipo unEquipo)throws ObligatorioTallerException{
        if(maximoDeEquipos>listaEquipos.size()){
            unEquipo.esValido(fechaCompetencia, paisesHabilitados);
            listaEquipos.add(unEquipo);
        }else{
            throw new ObligatorioTallerException("La lista de equipos esta completa");
        }
        return true;
    }
    public ArrayList<String> generarScoreboard(){
        return new ArrayList();
    }
}
