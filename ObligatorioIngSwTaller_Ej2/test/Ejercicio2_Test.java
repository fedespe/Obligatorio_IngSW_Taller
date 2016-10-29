

import Logica.Equipo;
import Logica.ObligatorioTallerException;
import Logica.Pais;
import Logica.Participante;
import Logica.ProblemaResuelto;
import Logica.SedeRegional;
import Logica.Universidad;
import java.util.ArrayList;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class Ejercicio2_Test {
    
    public Ejercicio2_Test() {
    }
    
    private Pais pais1; 
    private Pais pais2; 
    private Pais pais3; 
    private Universidad universidad1;
    private Universidad universidad2;
    private Universidad universidad3;
    private SedeRegional sede;
    private Equipo equipo;
    private ArrayList<Participante> integrantes = new ArrayList();
    private Date fechaCompetencia;
    private ArrayList<Pais> paisesHabilitados;
    
    @Before
    public void setUp() throws ObligatorioTallerException {
        pais1=new Pais("Pais1");
        pais2=new Pais("Pais2");
        pais3=new Pais("Pais3");
        paisesHabilitados= new ArrayList();
        paisesHabilitados.add(pais1);
        paisesHabilitados.add(pais2);
        paisesHabilitados.add(pais3);
        fechaCompetencia=new Date(2017, 11, 10);
        sede = new SedeRegional(fechaCompetencia, 3, 4, "Sede1", paisesHabilitados);
        universidad1 = new Universidad("Univerisdad 1", pais1);
        universidad2 = new Universidad("Univerisdad 2", pais2);
        universidad3 = new Universidad("Univerisdad 3", pais3);
        
        Participante participante1 = new Participante("Nombre1 Apellido1", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
        Participante participante2 = new Participante("Nombre2 Apellido2", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
        Participante participante3 = new Participante("Nombre3 Apellido3", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
        integrantes.add(participante1);
        integrantes.add(participante2);
        integrantes.add(participante3);
        equipo=new Equipo("Equipo1NombreEquipo", integrantes);
        sede.registrarEquipo(equipo); 
    }
    
    @After
    public void tearDown() {
    }

    //****************************************************
    //Pruebas metodo equipo.puntaje()
    //****************************************************

    @Test
    public void calculoPuntaje1Problema0Errores()throws Exception {
        ArrayList<ProblemaResuelto> problemasResueltos=new ArrayList();
        ProblemaResuelto problema1=new ProblemaResuelto(1, 15, 0);
        problemasResueltos.add(problema1);
        equipo.setProblemasResueltos(problemasResueltos);
        int[] esperado =new int[]{1,15};
        int[] obtenido =equipo.puntaje();
        assertArrayEquals(esperado,obtenido);
    }
    
    @Test
    public void calculoPuntaje1Problema2Errores()throws Exception {
        ArrayList<ProblemaResuelto> problemasResueltos=new ArrayList();
        ProblemaResuelto problema1=new ProblemaResuelto(1, 15, 2);
        problemasResueltos.add(problema1);
        equipo.setProblemasResueltos(problemasResueltos);
        int[] esperado =new int[]{1,55};
        int[] obtenido =equipo.puntaje();
        assertArrayEquals(esperado,obtenido);
    }
    @Test
    public void calculoPuntaje2Problema0Errores()throws Exception {
        ArrayList<ProblemaResuelto> problemasResueltos=new ArrayList();
        ProblemaResuelto problema1=new ProblemaResuelto(1, 15, 0);
        ProblemaResuelto problema2=new ProblemaResuelto(2, 25, 0);
        problemasResueltos.add(problema1);
        problemasResueltos.add(problema2);
        equipo.setProblemasResueltos(problemasResueltos);
        int[] esperado =new int[]{2,40};
        int[] obtenido =equipo.puntaje();
        assertArrayEquals(esperado,obtenido);
    }
    @Test
    public void calculoPuntaje2Problema1Errores()throws Exception {
        ArrayList<ProblemaResuelto> problemasResueltos=new ArrayList();
        ProblemaResuelto problema1=new ProblemaResuelto(1, 15, 0);
        ProblemaResuelto problema2=new ProblemaResuelto(2, 25, 1);
        problemasResueltos.add(problema1);
        problemasResueltos.add(problema2);
        equipo.setProblemasResueltos(problemasResueltos);
        int[] esperado =new int[]{2,60};
        int[] obtenido =equipo.puntaje();
        assertArrayEquals(esperado,obtenido);
    }
    @Test
    public void calculoPuntaje2Problema3Errores()throws Exception {
        ArrayList<ProblemaResuelto> problemasResueltos=new ArrayList();
        ProblemaResuelto problema1=new ProblemaResuelto(1, 15, 2);
        ProblemaResuelto problema2=new ProblemaResuelto(2, 25, 1);
        problemasResueltos.add(problema1);
        problemasResueltos.add(problema2);
        equipo.setProblemasResueltos(problemasResueltos);
        int[] esperado =new int[]{2,100};
        int[] obtenido =equipo.puntaje();
        assertArrayEquals(esperado,obtenido);
    }
    @Test
    public void calculoPuntaje4Problema3Errores()throws Exception {
        ArrayList<ProblemaResuelto> problemasResueltos=new ArrayList();
        ProblemaResuelto problema1=new ProblemaResuelto(1, 15, 0);
        ProblemaResuelto problema2=new ProblemaResuelto(2, 25, 1);
        ProblemaResuelto problema3=new ProblemaResuelto(2, 5, 1);
        ProblemaResuelto problema4=new ProblemaResuelto(2, 20, 1);
        problemasResueltos.add(problema1);
        problemasResueltos.add(problema2);
        problemasResueltos.add(problema3);
        problemasResueltos.add(problema4);
        equipo.setProblemasResueltos(problemasResueltos);
        int[] esperado =new int[]{4,125};
        int[] obtenido =equipo.puntaje();
        assertArrayEquals(esperado,obtenido);
    }
    
}
