
package Logica;

import java.util.ArrayList;
import java.util.Date;

public class SedeRegional {
    private Date fechaCompetencia;
    private int maximoDeEquipos;
    private int cantidadProblemas;
    private String nombreSede;
    private ArrayList<Equipo> listaEquipos;
    private ArrayList<Pais> paisesHabilitados;
    
    
    public boolean registrarEquipo(Equipo unEquipo)throws ObligatorioTallerException{
        if(maximoDeEquipos>listaEquipos.size()){
            unEquipo.esValido(fechaCompetencia, paisesHabilitados);
        }else{
            throw new ObligatorioTallerException("La lista de equipos esta completa");
        }
        return true;
    }
    public ArrayList<String> generarScoreboard(){
        return new ArrayList();
    }
}
