/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorioingswtaller;

import Logica.Equipo;
import Logica.ObligatorioTallerException;
import Logica.Pais;
import Logica.Participante;
import Logica.ProblemaResuelto;
import Logica.SedeRegional;
import Logica.Universidad;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class ObligatorioIngSwTaller {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Pais pais1;
            Pais pais2;
            Pais pais3;
            Universidad universidad1;
            Universidad universidad2;
            Universidad universidad3;
            SedeRegional sede;
            Equipo equipo;
            ArrayList<Participante> integrantes = new ArrayList();
            Date fechaCompetencia;
            ArrayList<Pais> paisesHabilitados;
            
            
            pais1=new Pais("Pais1");
            pais2=new Pais("Pais2");
            pais3=new Pais("Pais3");
            paisesHabilitados= new ArrayList();
            paisesHabilitados.add(pais1);
            paisesHabilitados.add(pais2);
            paisesHabilitados.add(pais3);
            fechaCompetencia=new Date(2017-1900, 11, 10,17,00);//10 de diciembre de 2017
            sede = new SedeRegional(fechaCompetencia, 6, 4, "Sede1", paisesHabilitados);
            universidad1 = new Universidad("Univerisdad 1", pais1);
            universidad2 = new Universidad("Univerisdad 2", pais2);
            universidad3 = new Universidad("Univerisdad 3", pais3);
            
            Participante participante1 = new Participante("Nombre1 Apellido1", new Date(1998-1900, 06, 19), "Carrera1", 2, universidad1);
            Participante participante2 = new Participante("Nombre2 Apellido2", new Date(1998-1900, 06, 19), "Carrera1", 2, universidad1);
            Participante participante3 = new Participante("Nombre3 Apellido3", new Date(1998-1900, 06, 19), "Carrera1", 2, universidad1);
            integrantes.add(participante1);
            integrantes.add(participante2);
            integrantes.add(participante3);
            equipo=new Equipo("Equipo1NombreEquipo", integrantes); 
            
            ArrayList<ProblemaResuelto> problemasResueltos=new ArrayList();
            ProblemaResuelto problema1=new ProblemaResuelto(1, 15, 0);
            ProblemaResuelto problema2=new ProblemaResuelto(2, 25, 1);
            problemasResueltos.add(problema1);
            problemasResueltos.add(problema2);
            equipo.setProblemasResueltos(problemasResueltos);
            
            sede.registrarEquipo(equipo);
            
            integrantes=new ArrayList();
            Participante participante4 = new Participante("Nombre4 Apellido1", new Date(1998-1900, 06, 19), "Carrera1", 2, universidad1);
            Participante participante5 = new Participante("Nombre5 Apellido2", new Date(1998-1900, 06, 19), "Carrera1", 2, universidad1);
            Participante participante6 = new Participante("Nombre6 Apellido3", new Date(1998-1900, 06, 19), "Carrera1", 2, universidad1);
            integrantes.add(participante4);
            integrantes.add(participante5);
            integrantes.add(participante6);
            equipo=new Equipo("Equipo2NombreEquipo", integrantes);
            
            problemasResueltos=new ArrayList();
            problema1=new ProblemaResuelto(1, 15, 0);
            problema2=new ProblemaResuelto(2, 25, 1);
            ProblemaResuelto problema3=new ProblemaResuelto(2, 45, 1);
            ProblemaResuelto problema4=new ProblemaResuelto(2, 20, 1);
            problemasResueltos.add(problema1);
            problemasResueltos.add(problema2);
            problemasResueltos.add(problema3);
            problemasResueltos.add(problema4);
            equipo.setProblemasResueltos(problemasResueltos);
            
            sede.registrarEquipo(equipo);
             
            integrantes=new ArrayList();
            Participante participante10 = new Participante("Nombre7 Apellido1", new Date(1998-1900, 06, 19), "Carrera1", 2, universidad1);
            Participante participante11 = new Participante("Nombre8 Apellido2", new Date(1998-1900, 06, 19), "Carrera1", 2, universidad1);
            Participante participante12 = new Participante("Nombre9 Apellido3", new Date(1998-1900, 06, 19), "Carrera1", 2, universidad1);
            integrantes.add(participante10);
            integrantes.add(participante11);
            integrantes.add(participante12);
            equipo=new Equipo("Equipo4NombreEquipo", integrantes);
            
            problemasResueltos=new ArrayList();
            problema1=new ProblemaResuelto(1, 15, 0);
            problema2=new ProblemaResuelto(2, 25, 1);
            problema3=new ProblemaResuelto(2, 5, 1);
            problema4=new ProblemaResuelto(2, 20, 1);
            problemasResueltos.add(problema1);
            problemasResueltos.add(problema2);
            problemasResueltos.add(problema3);
            problemasResueltos.add(problema4);
            equipo.setProblemasResueltos(problemasResueltos);
            
            sede.registrarEquipo(equipo);
            
            integrantes=new ArrayList();
            Participante participante7 = new Participante("Nombre7 Apellido1", new Date(1998-1900, 06, 19), "Carrera1", 2, universidad1);
            Participante participante8 = new Participante("Nombre8 Apellido2", new Date(1998-1900, 06, 19), "Carrera1", 2, universidad1);
            Participante participante9 = new Participante("Nombre9 Apellido3", new Date(1998-1900, 06, 19), "Carrera1", 2, universidad1);
            integrantes.add(participante7);
            integrantes.add(participante8);
            integrantes.add(participante9);
            equipo=new Equipo("Equipo3NombreEquipo", integrantes);
            
            problemasResueltos=new ArrayList();
            problema1=new ProblemaResuelto(1, 15, 0);
            problema2=new ProblemaResuelto(2, 25, 1);
            problema3=new ProblemaResuelto(2, 5, 1);
            problema4=new ProblemaResuelto(2, 20, 1);
            problemasResueltos.add(problema1);
            problemasResueltos.add(problema2);
            problemasResueltos.add(problema3);
            problemasResueltos.add(problema4);
            equipo.setProblemasResueltos(problemasResueltos);
            
            sede.registrarEquipo(equipo);
           
            
            integrantes=new ArrayList();
            Participante participante13 = new Participante("Nombre7 Apellido1", new Date(1998-1900, 06, 19), "Carrera1", 2, universidad1);
            Participante participante14 = new Participante("Nombre8 Apellido2", new Date(1998-1900, 06, 19), "Carrera1", 2, universidad1);
            Participante participante15 = new Participante("Nombre9 Apellido3", new Date(1998-1900, 06, 19), "Carrera1", 2, universidad1);
            integrantes.add(participante13);
            integrantes.add(participante14);
            integrantes.add(participante15);
            equipo=new Equipo("Equipo5NombreEquipo", integrantes);
            
            problemasResueltos=new ArrayList();
            problema1=new ProblemaResuelto(1, 15, 0);
            problema2=new ProblemaResuelto(2, 25, 1);
            problema3=new ProblemaResuelto(2, 5, 1);
            problemasResueltos.add(problema1);
            problemasResueltos.add(problema2);
            problemasResueltos.add(problema3);
            equipo.setProblemasResueltos(problemasResueltos);
            
            sede.registrarEquipo(equipo);
            
            ArrayList<String> retorno=sede.generarScoreboard();
        } 
        catch (ObligatorioTallerException ex) {
            Logger.getLogger(ObligatorioIngSwTaller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
