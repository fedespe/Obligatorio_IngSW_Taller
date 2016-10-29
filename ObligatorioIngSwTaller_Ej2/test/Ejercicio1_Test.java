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
    //Pruebas metodo sede.registrarEquipo(equipo)
    //****************************************************
    
    //PARTE 1
    
    @Test(expected = ObligatorioTallerException.class)
    public void ingresoEquipoFormadoPor1Integrantes() throws ObligatorioTallerException{
        Participante participante1 = new Participante("Nombre1 Apellido1", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
        integrantes.add(participante1);
        equipo=new Equipo("Equipo1NombreEquipo", integrantes);
        sede.registrarEquipo(equipo);
    }
    @Test(expected = ObligatorioTallerException.class)
    public void ingresoEquipoFormadoPor2Integrantes() throws ObligatorioTallerException{
        Participante participante1 = new Participante("Nombre1 Apellido1", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
        Participante participante2 = new Participante("Nombre2 Apellido2", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
        integrantes.add(participante1);
        integrantes.add(participante2);
        equipo=new Equipo("Equipo1NombreEquipo", integrantes);
        sede.registrarEquipo(equipo);
    }
    @Test(expected = ObligatorioTallerException.class)
    public void ingresoEquipoFormadoPor4Integrantes() throws ObligatorioTallerException{
        Participante participante1 = new Participante("Nombre1 Apellido1", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
        Participante participante2 = new Participante("Nombre2 Apellido2", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
        Participante participante3 = new Participante("Nombre3 Apellido3", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
        Participante participante4 = new Participante("Nombre4 Apellido4", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
        integrantes.add(participante1);
        integrantes.add(participante2);
        integrantes.add(participante3);
        integrantes.add(participante4);
        equipo=new Equipo("Equipo1NombreEquipo", integrantes);
        sede.registrarEquipo(equipo);
    }
    @Test
    public void ingresoEquipoFormadoPor3Integrantes() throws ObligatorioTallerException{
        Participante participante1 = new Participante("Nombre1 Apellido1", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
        Participante participante2 = new Participante("Nombre2 Apellido2", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
        Participante participante3 = new Participante("Nombre3 Apellido3", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
        integrantes.add(participante1);
        integrantes.add(participante2);
        integrantes.add(participante3);
        equipo=new Equipo("Equipo1NombreEquipo", integrantes);
        assertTrue(sede.registrarEquipo(equipo));
    }
    
    //PARTE 2
    
    @Test(expected = ObligatorioTallerException.class)
    public void nombreParticipantesVacio() throws ObligatorioTallerException{
        Participante participante1 = new Participante("", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
        Participante participante2 = new Participante("Nombre2 Apellido2", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
        Participante participante3 = new Participante("Nombre3 Apellido3", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
        integrantes.add(participante1);
        integrantes.add(participante2);
        integrantes.add(participante3);
        equipo=new Equipo("Equipo1NombreEquipo", integrantes);
        sede.registrarEquipo(equipo);
    }
    @Test(expected = ObligatorioTallerException.class)
    public void nombreParticipanteUnaPalabra() throws ObligatorioTallerException{
        Participante participante1 = new Participante("Nombre1", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
        Participante participante2 = new Participante("Nombre2 Apellido2", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
        Participante participante3 = new Participante("Nombre3 Apellido3", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
        integrantes.add(participante1);
        integrantes.add(participante2);
        integrantes.add(participante3);
        equipo=new Equipo("Equipo1NombreEquipo", integrantes);
        sede.registrarEquipo(equipo);
    }
    @Test(expected = ObligatorioTallerException.class)
    public void nombreParticipanteDosPalabraMenos4Caracteres() throws ObligatorioTallerException{
        Participante participante1 = new Participante("Nombre1 Ape", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
        Participante participante2 = new Participante("Nombre2 Apellido2", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
        Participante participante3 = new Participante("Nombre3 Apellido3", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
        integrantes.add(participante1);
        integrantes.add(participante2);
        integrantes.add(participante3);
        equipo=new Equipo("Equipo1NombreEquipo", integrantes);
        sede.registrarEquipo(equipo);
    }
    @Test
    public void nombreParticipanteDosPalabraCon5Caracteres() throws ObligatorioTallerException{
        Participante participante1 = new Participante("Nombr Apell", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
        Participante participante2 = new Participante("Nombre2 Apellido2", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
        Participante participante3 = new Participante("Nombre3 Apellido3", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
        integrantes.add(participante1);
        integrantes.add(participante2);
        integrantes.add(participante3);
        equipo=new Equipo("Equipo1NombreEquipo", integrantes);
        assertTrue(sede.registrarEquipo(equipo));
    }

    //PARTE 3
    
    @Test(expected = ObligatorioTallerException.class)
    public void ingresoNombreCarreraVacio() throws ObligatorioTallerException{
        Participante participante1 = new Participante("Nombre1 Apellido1", new Date(1998, 06, 19), "", 2, universidad1);
        Participante participante2 = new Participante("Nombre2 Apellido2", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
        Participante participante3 = new Participante("Nombre3 Apellido3", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
        integrantes.add(participante1);
        integrantes.add(participante2);
        integrantes.add(participante3);
        equipo=new Equipo("Equipo1NombreEquipo", integrantes);
        assertTrue(sede.registrarEquipo(equipo));
    }
    @Test(expected = ObligatorioTallerException.class)
    public void ingresoNombreCarreraMenos5Caracteres() throws ObligatorioTallerException{
        Participante participante1 = new Participante("Nombre1 Apellido1", new Date(1998, 06, 19), "Carr", 2, universidad1);
        Participante participante2 = new Participante("Nombre2 Apellido2", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
        Participante participante3 = new Participante("Nombre3 Apellido3", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
        integrantes.add(participante1);
        integrantes.add(participante2);
        integrantes.add(participante3);
        equipo=new Equipo("Equipo1NombreEquipo", integrantes);
        assertTrue(sede.registrarEquipo(equipo));
    }
    @Test
    public void ingresoNombreCarreraCon5Caracteres() throws ObligatorioTallerException{
        Participante participante1 = new Participante("Nombre1 Apellido1", new Date(1998, 06, 19), "Carre", 2, universidad1);
        Participante participante2 = new Participante("Nombre2 Apellido2", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
        Participante participante3 = new Participante("Nombre3 Apellido3", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
        integrantes.add(participante1);
        integrantes.add(participante2);
        integrantes.add(participante3);
        equipo=new Equipo("Equipo1NombreEquipo", integrantes);
        assertTrue(sede.registrarEquipo(equipo));
    }
    
    //Parte 4
    
    @Test(expected = ObligatorioTallerException.class)
    public void ingresoParticipanteCon15Anos() throws ObligatorioTallerException{
        Participante participante1 = new Participante("Nombre1 Apellido1", new Date(2002, 06, 19), "Carrera1", 2, universidad1);
        Participante participante2 = new Participante("Nombre2 Apellido2", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
        Participante participante3 = new Participante("Nombre3 Apellido3", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
        integrantes.add(participante1);
        integrantes.add(participante2);
        integrantes.add(participante3);
        equipo=new Equipo("Equipo1NombreEquipo", integrantes);
        assertTrue(sede.registrarEquipo(equipo));
    }
    
    @Test(expected = ObligatorioTallerException.class)
    public void ingresoParticipanteCon21Anos() throws ObligatorioTallerException{
        Participante participante1 = new Participante("Nombre1 Apellido1", new Date(1996, 06, 19), "Carrera1", 2, universidad1);
        Participante participante2 = new Participante("Nombre2 Apellido2", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
        Participante participante3 = new Participante("Nombre3 Apellido3", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
        integrantes.add(participante1);
        integrantes.add(participante2);
        integrantes.add(participante3);
        equipo=new Equipo("Equipo1NombreEquipo", integrantes);
        assertTrue(sede.registrarEquipo(equipo));
    }
    
    @Test
    public void ingresoParticipanteCon16Anos() throws ObligatorioTallerException{
        Participante participante1 = new Participante("Nombre1 Apellido1", new Date(2001, 06, 19), "Carrera1", 2, universidad1);
        Participante participante2 = new Participante("Nombre2 Apellido2", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
        Participante participante3 = new Participante("Nombre3 Apellido3", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
        integrantes.add(participante1);
        integrantes.add(participante2);
        integrantes.add(participante3);
        equipo=new Equipo("Equipo1NombreEquipo", integrantes);
        assertTrue(sede.registrarEquipo(equipo));
    }
    @Test
    public void ingresoParticipanteCon20Anos() throws ObligatorioTallerException{
        Participante participante1 = new Participante("Nombre1 Apellido1", new Date(1997, 06, 19), "Carrera1", 2, universidad1);
        Participante participante2 = new Participante("Nombre2 Apellido2", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
        Participante participante3 = new Participante("Nombre3 Apellido3", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
        integrantes.add(participante1);
        integrantes.add(participante2);
        integrantes.add(participante3);
        equipo=new Equipo("Equipo1NombreEquipo", integrantes);
        assertTrue(sede.registrarEquipo(equipo));
    }
    
    //PARTE 5
    
    @Test(expected = ObligatorioTallerException.class)
    public void ingresoParticipantesUniversidadesDistintas() throws ObligatorioTallerException{
        Participante participante1 = new Participante("Nombre1 Apellido1", new Date(1997, 06, 19), "Carrera1", 2, universidad1);
        Participante participante2 = new Participante("Nombre2 Apellido2", new Date(1998, 06, 19), "Carrera1", 2, universidad2);
        Participante participante3 = new Participante("Nombre3 Apellido3", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
        integrantes.add(participante1);
        integrantes.add(participante2);
        integrantes.add(participante3);
        equipo=new Equipo("Equipo1NombreEquipo", integrantes);
        assertTrue(sede.registrarEquipo(equipo));
    }
    @Test(expected = ObligatorioTallerException.class)
    public void ingresoParticipantesUniversidadesDistintas2() throws ObligatorioTallerException{
        Participante participante1 = new Participante("Nombre1 Apellido1", new Date(1997, 06, 19), "Carrera1", 2, universidad1);
        Participante participante2 = new Participante("Nombre2 Apellido2", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
        Participante participante3 = new Participante("Nombre3 Apellido3", new Date(1998, 06, 19), "Carrera1", 2, universidad2);
        integrantes.add(participante1);
        integrantes.add(participante2);
        integrantes.add(participante3);
        equipo=new Equipo("Equipo1NombreEquipo", integrantes);
        assertTrue(sede.registrarEquipo(equipo));
    }
    @Test
    public void ingresoParticipantesUniversidadesIguales() throws ObligatorioTallerException{
        Participante participante1 = new Participante("Nombre1 Apellido1", new Date(1997, 06, 19), "Carrera1", 2, universidad2);
        Participante participante2 = new Participante("Nombre2 Apellido2", new Date(1998, 06, 19), "Carrera1", 2, universidad2);
        Participante participante3 = new Participante("Nombre3 Apellido3", new Date(1998, 06, 19), "Carrera1", 2, universidad2);
        integrantes.add(participante1);
        integrantes.add(participante2);
        integrantes.add(participante3);
        equipo=new Equipo("Equipo1NombreEquipo", integrantes);
        assertTrue(sede.registrarEquipo(equipo));
    }
    
    //PARTE 6
    
    @Test(expected = ObligatorioTallerException.class)
    public void ingresoParticipantesCursando9Semestre() throws ObligatorioTallerException{
        Participante participante1 = new Participante("Nombre1 Apellido1", new Date(1997, 06, 19), "Carrera1", 9, universidad2);
        Participante participante2 = new Participante("Nombre2 Apellido2", new Date(1998, 06, 19), "Carrera1", 2, universidad2);
        Participante participante3 = new Participante("Nombre3 Apellido3", new Date(1998, 06, 19), "Carrera1", 2, universidad2);
        integrantes.add(participante1);
        integrantes.add(participante2);
        integrantes.add(participante3);
        equipo=new Equipo("Equipo1NombreEquipo", integrantes);
        assertTrue(sede.registrarEquipo(equipo));
    }
    @Test(expected = ObligatorioTallerException.class)
    public void ingresoParticipantesCursando1Semestre() throws ObligatorioTallerException{
        //Asumo que si esta cursando primer semestre ultimo semestre cursado esota en cero
        Participante participante1 = new Participante("Nombre1 Apellido1", new Date(1997, 06, 19), "Carrera1", 0, universidad2);
        Participante participante2 = new Participante("Nombre2 Apellido2", new Date(1998, 06, 19), "Carrera1", 2, universidad2);
        Participante participante3 = new Participante("Nombre3 Apellido3", new Date(1998, 06, 19), "Carrera1", 2, universidad2);
        integrantes.add(participante1);
        integrantes.add(participante2);
        integrantes.add(participante3);
        equipo=new Equipo("Equipo1NombreEquipo", integrantes);
        assertTrue(sede.registrarEquipo(equipo));
    }
    @Test
    public void ingresoParticipantesCursando8Semestre() throws ObligatorioTallerException{
        //Asumo que si esta cursando primer semestre ultimo semestre cursado esota en cero
        Participante participante1 = new Participante("Nombre1 Apellido1", new Date(1997, 06, 19), "Carrera1", 8, universidad2);
        Participante participante2 = new Participante("Nombre2 Apellido2", new Date(1998, 06, 19), "Carrera1", 2, universidad2);
        Participante participante3 = new Participante("Nombre3 Apellido3", new Date(1998, 06, 19), "Carrera1", 2, universidad2);
        integrantes.add(participante1);
        integrantes.add(participante2);
        integrantes.add(participante3);
        equipo=new Equipo("Equipo1NombreEquipo", integrantes);
        assertTrue(sede.registrarEquipo(equipo));
    }
    
    //PARTE 7
    
    @Test(expected = ObligatorioTallerException.class)
    public void ingresoNombreEquipoVacio() throws ObligatorioTallerException{
        //Asumo que si esta cursando primer semestre ultimo semestre cursado esota en cero
        Participante participante1 = new Participante("Nombre1 Apellido1", new Date(1997, 06, 19), "Carrera1", 8, universidad2);
        Participante participante2 = new Participante("Nombre2 Apellido2", new Date(1998, 06, 19), "Carrera1", 2, universidad2);
        Participante participante3 = new Participante("Nombre3 Apellido3", new Date(1998, 06, 19), "Carrera1", 2, universidad2);
        integrantes.add(participante1);
        integrantes.add(participante2);
        integrantes.add(participante3);
        equipo=new Equipo("", integrantes);
        assertTrue(sede.registrarEquipo(equipo));
    }
    
    @Test(expected = ObligatorioTallerException.class)
    public void ingresoNombreEquipo9Caracteres() throws ObligatorioTallerException{
        //Asumo que si esta cursando primer semestre ultimo semestre cursado esota en cero
        Participante participante1 = new Participante("Nombre1 Apellido1", new Date(1997, 06, 19), "Carrera1", 8, universidad2);
        Participante participante2 = new Participante("Nombre2 Apellido2", new Date(1998, 06, 19), "Carrera1", 2, universidad2);
        Participante participante3 = new Participante("Nombre3 Apellido3", new Date(1998, 06, 19), "Carrera1", 2, universidad2);
        integrantes.add(participante1);
        integrantes.add(participante2);
        integrantes.add(participante3);
        equipo=new Equipo("Equipo1No", integrantes);
        assertTrue(sede.registrarEquipo(equipo));
    }
    @Test(expected = ObligatorioTallerException.class)
    public void ingresoNombreEquipo21Caracteres() throws ObligatorioTallerException{
        //Asumo que si esta cursando primer semestre ultimo semestre cursado esota en cero
        Participante participante1 = new Participante("Nombre1 Apellido1", new Date(1997, 06, 19), "Carrera1", 8, universidad2);
        Participante participante2 = new Participante("Nombre2 Apellido2", new Date(1998, 06, 19), "Carrera1", 2, universidad2);
        Participante participante3 = new Participante("Nombre3 Apellido3", new Date(1998, 06, 19), "Carrera1", 2, universidad2);
        integrantes.add(participante1);
        integrantes.add(participante2);
        integrantes.add(participante3);
        equipo=new Equipo("Equipo1NombreEquipoEq", integrantes);
        assertTrue(sede.registrarEquipo(equipo));
    }
    @Test
    public void ingresoNombreEquipo20Caracteres() throws ObligatorioTallerException{
        //Asumo que si esta cursando primer semestre ultimo semestre cursado esota en cero
        Participante participante1 = new Participante("Nombre1 Apellido1", new Date(1997, 06, 19), "Carrera1", 8, universidad2);
        Participante participante2 = new Participante("Nombre2 Apellido2", new Date(1998, 06, 19), "Carrera1", 2, universidad2);
        Participante participante3 = new Participante("Nombre3 Apellido3", new Date(1998, 06, 19), "Carrera1", 2, universidad2);
        integrantes.add(participante1);
        integrantes.add(participante2);
        integrantes.add(participante3);
        equipo=new Equipo("Equipo1NombreEquipoE", integrantes);
        assertTrue(sede.registrarEquipo(equipo));
    }
    
    @Test
    public void ingresoNombreEquipo10Caracteres() throws ObligatorioTallerException{
        //Asumo que si esta cursando primer semestre ultimo semestre cursado esota en cero
        Participante participante1 = new Participante("Nombre1 Apellido1", new Date(1997, 06, 19), "Carrera1", 8, universidad2);
        Participante participante2 = new Participante("Nombre2 Apellido2", new Date(1998, 06, 19), "Carrera1", 2, universidad2);
        Participante participante3 = new Participante("Nombre3 Apellido3", new Date(1998, 06, 19), "Carrera1", 2, universidad2);
        integrantes.add(participante1);
        integrantes.add(participante2);
        integrantes.add(participante3);
        equipo=new Equipo("Equipo1Nom", integrantes);
        assertTrue(sede.registrarEquipo(equipo));
    }
    
    //PARTE 8
    
    @Test(expected = ObligatorioTallerException.class)
    public void ingresoUniversidadParticipanteDeUnPaisNoHabilitado() throws ObligatorioTallerException{
        //Asumo que si esta cursando primer semestre ultimo semestre cursado esota en cero
        Pais pais4=new Pais("Pais 4");
        Universidad universidad4=new Universidad("Universidad 4", pais4);
        Participante participante1 = new Participante("Nombre1 Apellido1", new Date(1997, 06, 19), "Carrera1", 8, universidad4);
        Participante participante2 = new Participante("Nombre2 Apellido2", new Date(1998, 06, 19), "Carrera1", 2, universidad4);
        Participante participante3 = new Participante("Nombre3 Apellido3", new Date(1998, 06, 19), "Carrera1", 2, universidad4);
        integrantes.add(participante1);
        integrantes.add(participante2);
        integrantes.add(participante3);
        equipo=new Equipo("Equipo1Nom", integrantes);
        assertTrue(sede.registrarEquipo(equipo));
    }
  
}
