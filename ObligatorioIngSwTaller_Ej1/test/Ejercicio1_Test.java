/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Logica.Equipo;
import Logica.ObligatorioTallerException;
import Logica.Pais;
import Logica.Participante;
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

/**
 *
 * @author Usuario
 */
public class Ejercicio1_Test {
    
    private Pais pais1; 
    private Pais pais2; 
    private Pais pais3; 
    private Universidad universidad1;
    private Universidad universidad2;
    private Universidad universidad3;
    private SedeRegional sede;
    private Equipo equipo;
    private ArrayList<Participante> integrantes = new ArrayList();
    
    @Before
    public void setUp() {
        pais1=new Pais("Pais1");
        pais2=new Pais("Pais2");
        pais3=new Pais("Pais3");
        ArrayList<Pais> paisesHabilitados= new ArrayList();
        paisesHabilitados.add(pais1);
        paisesHabilitados.add(pais2);
        paisesHabilitados.add(pais3);
        Date fechaCompetencia=new Date(2017, 11, 10);
        sede = new SedeRegional(fechaCompetencia, 3, 4, "Sede1", paisesHabilitados);
        universidad1 = new Universidad("Univerisdad 1", pais1);
        universidad2 = new Universidad("Univerisdad 2", pais2);
        universidad3 = new Universidad("Univerisdad 3", pais3);
        
    }
    
    @After
    public void tearDown() {
    }

    //****************************************************
    //Pruebas parte A metodo Equipo.esValido
    //****************************************************
    
    @Test(expected = ObligatorioTallerException.class)
    public void ingresoEquipoFormadoPor1Integrantes() throws ObligatorioTallerException{
        Participante participante1 = new Participante("Nombre1 Apellido1", new Date(1987, 06, 1987), "Carrera1", 2, universidad1);
        integrantes.add(participante1);
        equipo=new Equipo("Equipo1", integrantes);
        sede.registrarEquipo(equipo);
    }
    @Test(expected = ObligatorioTallerException.class)
    public void ingresoEquipoFormadoPor2Integrantes() throws ObligatorioTallerException{
        Participante participante1 = new Participante("Nombre1 Apellido1", new Date(1987, 06, 1987), "Carrera1", 2, universidad1);
        Participante participante2 = new Participante("Nombre2 Apellido2", new Date(1987, 06, 1987), "Carrera1", 2, universidad1);
        integrantes.add(participante1);
        integrantes.add(participante2);
        equipo=new Equipo("Equipo1", integrantes);
        sede.registrarEquipo(equipo);
    }
    @Test(expected = ObligatorioTallerException.class)
    public void ingresoEquipoFormadoPor4Integrantes() throws ObligatorioTallerException{
        Participante participante1 = new Participante("Nombre1 Apellido1", new Date(1987, 06, 1987), "Carrera1", 2, universidad1);
        Participante participante2 = new Participante("Nombre2 Apellido2", new Date(1987, 06, 1987), "Carrera1", 2, universidad1);
        Participante participante3 = new Participante("Nombre3 Apellido3", new Date(1987, 06, 1987), "Carrera1", 2, universidad1);
        Participante participante4 = new Participante("Nombre4 Apellido4", new Date(1987, 06, 1987), "Carrera1", 2, universidad1);
        integrantes.add(participante1);
        integrantes.add(participante2);
        integrantes.add(participante3);
        integrantes.add(participante4);
        equipo=new Equipo("Equipo1", integrantes);
        sede.registrarEquipo(equipo);
    }
    @Test
    public void ingresoEquipoFormadoPor3Integrantes() throws ObligatorioTallerException{
        Participante participante1 = new Participante("Nombre1 Apellido1", new Date(1987, 06, 1987), "Carrera1", 2, universidad1);
        Participante participante2 = new Participante("Nombre2 Apellido2", new Date(1987, 06, 1987), "Carrera1", 2, universidad1);
        Participante participante3 = new Participante("Nombre3 Apellido3", new Date(1987, 06, 1987), "Carrera1", 2, universidad1);
        integrantes.add(participante1);
        integrantes.add(participante2);
        integrantes.add(participante3);
        equipo=new Equipo("Equipo1", integrantes);
        assertTrue(sede.registrarEquipo(equipo));
    }
    
}
