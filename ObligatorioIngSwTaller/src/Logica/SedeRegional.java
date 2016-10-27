
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
    
    
    public boolean registrarEquipo(Equipo unEquipo){
        return true;
    }
    public ArrayList<String> generarScoreboard(){
        return new ArrayList();
    }
}
