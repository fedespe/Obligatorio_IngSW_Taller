
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
            unEquipo.esValido();
            //Parte 4
            //valida que la edad este 16<=edad<=20
            validarEdadIntegrantes(unEquipo);
            //Parte 8
            //valida que la universidad donde cursan los integrantes debe ser 
            //del mismo pais que los paises habilitados
            validarPaisHabilitado(unEquipo);
            listaEquipos.add(unEquipo);
        }else{
            throw new ObligatorioTallerException("La lista de equipos esta completa");
        }
        return true;
    }
    public ArrayList<String> generarScoreboard(){
        return new ArrayList();
    }

    private void validarEdadIntegrantes(Equipo unEquipo) throws ObligatorioTallerException {
        for(Participante p:unEquipo.getIntegrantes()){
            p.validadEdadIntegrantes(fechaCompetencia);
        }
    }

    private void validarPaisHabilitado(Equipo unEquipo) throws ObligatorioTallerException {
       //Los integrantes del equipo pertenecen a la misma universidad
       //solo es necesario chequear con uno solo
       boolean retorno=false;
       //se podria hacer con un while
       for(Pais p: paisesHabilitados){
           //ver que se podria simplificar para llegar a el nombre del pais
           if(p.getNombre()==unEquipo.getIntegrantes().get(0).getUniversidad().getPais().getNombre())
                retorno=true;
       }
       if (!retorno){
           throw new ObligatorioTallerException("El nombre del pais correspondiente a la universidad no esta habilitada");
       }
    }
}
