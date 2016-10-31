/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Logica.Equipo;
import Logica.ObligatorioTallerException;
import Logica.Pais;
import Logica.Participante;
import Logica.ProblemaResuelto;
import Logica.SedeRegional;
import Logica.Universidad;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class Ejercicio3_Test {
    
    public Ejercicio3_Test() {
    }
    private Pais pais1; 
    private Pais pais2; 
    private Pais pais3; 
    private Universidad universidad1;
    private Universidad universidad2;
    private Universidad universidad3;
    private SedeRegional sede;
    private Equipo equipo1;
    private Equipo equipo2;
    private Equipo equipo3;
    private Equipo equipo4;
    private Equipo equipo5;
    private ArrayList<Participante> integrantes = new ArrayList();
    private Date fechaCompetencia;
    private ArrayList<Pais> paisesHabilitados;
    @Before
    public void setUp() {
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
        
        //Equipo 1, 2 problemas resueltos, 60 min
        Participante participante1 = new Participante("Nombre1 Apellido1", new Date(1998-1900, 06, 19), "Carrera1", 2, universidad1);
        Participante participante2 = new Participante("Nombre2 Apellido2", new Date(1998-1900, 06, 19), "Carrera1", 2, universidad1);
        Participante participante3 = new Participante("Nombre3 Apellido3", new Date(1998-1900, 06, 19), "Carrera1", 2, universidad1);
        integrantes.add(participante1);
        integrantes.add(participante2);
        integrantes.add(participante3);
        equipo1=new Equipo("Equipo1NombreEquipo", integrantes); 

        ArrayList<ProblemaResuelto> problemasResueltos=new ArrayList();
        ProblemaResuelto problema1=new ProblemaResuelto(1, 15, 0);
        ProblemaResuelto problema2=new ProblemaResuelto(2, 25, 1);
        problemasResueltos.add(problema1);
        problemasResueltos.add(problema2);
        equipo1.setProblemasResueltos(problemasResueltos);
        
        //Equipo 2, 4 problemas resueltos, 165 min
        integrantes=new ArrayList();
        Participante participante4 = new Participante("Nombre4 Apellido1", new Date(1998-1900, 06, 19), "Carrera1", 2, universidad1);
        Participante participante5 = new Participante("Nombre5 Apellido2", new Date(1998-1900, 06, 19), "Carrera1", 2, universidad1);
        Participante participante6 = new Participante("Nombre6 Apellido3", new Date(1998-1900, 06, 19), "Carrera1", 2, universidad1);
        integrantes.add(participante4);
        integrantes.add(participante5);
        integrantes.add(participante6);
        equipo2=new Equipo("Equipo2NombreEquipo", integrantes);

        problemasResueltos=new ArrayList();
        problema1=new ProblemaResuelto(1, 15, 0);
        problema2=new ProblemaResuelto(2, 25, 1);
        ProblemaResuelto problema3=new ProblemaResuelto(2, 45, 1);
        ProblemaResuelto problema4=new ProblemaResuelto(2, 20, 1);
        problemasResueltos.add(problema1);
        problemasResueltos.add(problema2);
        problemasResueltos.add(problema3);
        problemasResueltos.add(problema4);
        equipo2.setProblemasResueltos(problemasResueltos);
        
        //Equipo 3 4 problemas resueltos, 125 min
        integrantes=new ArrayList();
        Participante participante7 = new Participante("Nombre7 Apellido1", new Date(1998-1900, 06, 19), "Carrera1", 2, universidad1);
        Participante participante8 = new Participante("Nombre8 Apellido2", new Date(1998-1900, 06, 19), "Carrera1", 2, universidad1);
        Participante participante9 = new Participante("Nombre9 Apellido3", new Date(1998-1900, 06, 19), "Carrera1", 2, universidad1);
        integrantes.add(participante7);
        integrantes.add(participante8);
        integrantes.add(participante9);
        equipo3=new Equipo("Equipo3NombreEquipo", integrantes);

        problemasResueltos=new ArrayList();
        problema1=new ProblemaResuelto(1, 15, 0);
        problema2=new ProblemaResuelto(2, 25, 1);
        problema3=new ProblemaResuelto(2, 5, 1);
        problema4=new ProblemaResuelto(2, 20, 1);
        problemasResueltos.add(problema1);
        problemasResueltos.add(problema2);
        problemasResueltos.add(problema3);
        problemasResueltos.add(problema4);
        equipo3.setProblemasResueltos(problemasResueltos);
        
        //Equipo 4, 4 problemas resueltos, 125 min        
        integrantes=new ArrayList();
        Participante participante10 = new Participante("Nombre10 Apellido10", new Date(1998-1900, 06, 19), "Carrera1", 2, universidad1);
        Participante participante11 = new Participante("Nombre11 Apellido11", new Date(1998-1900, 06, 19), "Carrera1", 2, universidad1);
        Participante participante12 = new Participante("Nombre12 Apellido12", new Date(1998-1900, 06, 19), "Carrera1", 2, universidad1);
        integrantes.add(participante10);
        integrantes.add(participante11);
        integrantes.add(participante12);
        equipo4=new Equipo("Equipo4NombreEquipo", integrantes);

        problemasResueltos=new ArrayList();
        problema1=new ProblemaResuelto(1, 15, 0);
        problema2=new ProblemaResuelto(2, 25, 1);
        problema3=new ProblemaResuelto(2, 5, 1);
        problema4=new ProblemaResuelto(2, 20, 1);
        problemasResueltos.add(problema1);
        problemasResueltos.add(problema2);
        problemasResueltos.add(problema3);
        problemasResueltos.add(problema4);
        equipo4.setProblemasResueltos(problemasResueltos);
        //Equipo 5 3 problemas resueltos 85 min
        integrantes=new ArrayList();
        Participante participante13 = new Participante("Nombre13 Apellido1", new Date(1998-1900, 06, 19), "Carrera1", 2, universidad1);
        Participante participante14 = new Participante("Nombre14 Apellido2", new Date(1998-1900, 06, 19), "Carrera1", 2, universidad1);
        Participante participante15 = new Participante("Nombre15 Apellido3", new Date(1998-1900, 06, 19), "Carrera1", 2, universidad1);
        integrantes.add(participante13);
        integrantes.add(participante14);
        integrantes.add(participante15);
        equipo5=new Equipo("Equipo5NombreEquipo", integrantes);

        problemasResueltos=new ArrayList();
        problema1=new ProblemaResuelto(1, 15, 0);
        problema2=new ProblemaResuelto(2, 25, 1);
        problema3=new ProblemaResuelto(2, 5, 1);
        problemasResueltos.add(problema1);
        problemasResueltos.add(problema2);
        problemasResueltos.add(problema3);
        equipo5.setProblemasResueltos(problemasResueltos);

    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void Equipo1pr2min60() throws ObligatorioTallerException{       
        sede.registrarEquipo(equipo1);
        
        ArrayList<String> esperado= new ArrayList();
        Format formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        esperado.add("Scoreboard de la competencia - Sede Sede1");
        esperado.add("10-12-2017 17:00");
        esperado.add("Posociones");
        esperado.add("<Equipo1NombreEquipo><2><60>");
        esperado.add("Ultima actualizacion: "+formatter.format(new Date()));
        
        ArrayList<String> obtenido=sede.generarScoreboard();
        assertEquals(esperado.toString(), obtenido.toString());
    }
    @Test
    public void Equipo1pr2min60Equipo2pr4min165() throws ObligatorioTallerException{       
        sede.registrarEquipo(equipo1);
        sede.registrarEquipo(equipo2);
        
        ArrayList<String> esperado= new ArrayList();
        Format formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        esperado.add("Scoreboard de la competencia - Sede Sede1");
        esperado.add("10-12-2017 17:00");
        esperado.add("Posociones");
        esperado.add("<Equipo2NombreEquipo><4><165>");
        esperado.add("<Equipo1NombreEquipo><2><60>");
        esperado.add("Ultima actualizacion: "+formatter.format(new Date()));
        
        ArrayList<String> obtenido=sede.generarScoreboard();
        assertEquals(esperado.toString(), obtenido.toString());
    }
    @Test
    public void Equipo2pr4min165Equipo1pr2min60() throws ObligatorioTallerException{       
        sede.registrarEquipo(equipo2);
        sede.registrarEquipo(equipo1);
        
        ArrayList<String> esperado= new ArrayList();
        Format formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        esperado.add("Scoreboard de la competencia - Sede Sede1");
        esperado.add("10-12-2017 17:00");
        esperado.add("Posociones");
        esperado.add("<Equipo2NombreEquipo><4><165>");
        esperado.add("<Equipo1NombreEquipo><2><60>");
        esperado.add("Ultima actualizacion: "+formatter.format(new Date()));
        
        ArrayList<String> obtenido=sede.generarScoreboard();
        assertEquals(esperado.toString(), obtenido.toString());
    }
    @Test
    public void Equipo1pr2min60Equipo2pr4min165Equipo3pr4min125() throws ObligatorioTallerException{       
        sede.registrarEquipo(equipo1);
        sede.registrarEquipo(equipo2);
        sede.registrarEquipo(equipo3);
        
        ArrayList<String> esperado= new ArrayList();
        Format formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        esperado.add("Scoreboard de la competencia - Sede Sede1");
        esperado.add("10-12-2017 17:00");
        esperado.add("Posociones");
        esperado.add("<Equipo3NombreEquipo><4><125>");
        esperado.add("<Equipo2NombreEquipo><4><165>");
        esperado.add("<Equipo1NombreEquipo><2><60>");
        esperado.add("Ultima actualizacion: "+formatter.format(new Date()));
        
        ArrayList<String> obtenido=sede.generarScoreboard();
        assertEquals(esperado.toString(), obtenido.toString());
    }
    @Test
    public void Equipo1pr2min60Equipo2pr4min165Equipo3pr4min125Equipo4pr4min125() throws ObligatorioTallerException{       
        sede.registrarEquipo(equipo1);
        sede.registrarEquipo(equipo2);
        sede.registrarEquipo(equipo3);
        sede.registrarEquipo(equipo4);
        
        ArrayList<String> esperado= new ArrayList();
        Format formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        esperado.add("Scoreboard de la competencia - Sede Sede1");
        esperado.add("10-12-2017 17:00");
        esperado.add("Posociones");
        esperado.add("<Equipo3NombreEquipo><4><125>");
        esperado.add("<Equipo4NombreEquipo><4><125>");
        esperado.add("<Equipo2NombreEquipo><4><165>");
        esperado.add("<Equipo1NombreEquipo><2><60>");
        esperado.add("Ultima actualizacion: "+formatter.format(new Date()));
        
        ArrayList<String> obtenido=sede.generarScoreboard();
        assertEquals(esperado.toString(), obtenido.toString());
    }
    @Test
    public void Equipo1pr2min60Equipo2pr4min165Equipo4pr4min125Equipo3pr4min125() throws ObligatorioTallerException{       
        sede.registrarEquipo(equipo1);
        sede.registrarEquipo(equipo2);
        sede.registrarEquipo(equipo4);
        sede.registrarEquipo(equipo3);
        
        ArrayList<String> esperado= new ArrayList();
        Format formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        esperado.add("Scoreboard de la competencia - Sede Sede1");
        esperado.add("10-12-2017 17:00");
        esperado.add("Posociones");
        esperado.add("<Equipo4NombreEquipo><4><125>");
        esperado.add("<Equipo3NombreEquipo><4><125>");
        esperado.add("<Equipo2NombreEquipo><4><165>");
        esperado.add("<Equipo1NombreEquipo><2><60>");
        esperado.add("Ultima actualizacion: "+formatter.format(new Date()));
        
        ArrayList<String> obtenido=sede.generarScoreboard();
        assertEquals(esperado.toString(), obtenido.toString());
    }
    @Test
    public void Equipo1pr2min60Equipo2pr4min165Equipo4pr4min125Equipo3pr4min125Equipo5pr3min85() throws ObligatorioTallerException{       
        sede.registrarEquipo(equipo1);
        sede.registrarEquipo(equipo2);
        sede.registrarEquipo(equipo4);
        sede.registrarEquipo(equipo3);
        sede.registrarEquipo(equipo5);
        
        ArrayList<String> esperado= new ArrayList();
        Format formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        esperado.add("Scoreboard de la competencia - Sede Sede1");
        esperado.add("10-12-2017 17:00");
        esperado.add("Posociones");
        esperado.add("<Equipo4NombreEquipo><4><125>");
        esperado.add("<Equipo3NombreEquipo><4><125>");
        esperado.add("<Equipo2NombreEquipo><4><165>");
        esperado.add("<Equipo5NombreEquipo><3><85>");
        esperado.add("<Equipo1NombreEquipo><2><60>");
        esperado.add("Ultima actualizacion: "+formatter.format(new Date()));
        
        ArrayList<String> obtenido=sede.generarScoreboard();
        assertEquals(esperado.toString(), obtenido.toString());
    }
}
