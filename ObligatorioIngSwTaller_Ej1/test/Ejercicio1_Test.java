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
import java.util.logging.Level;
import java.util.logging.Logger;
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
        fechaCompetencia=new Date(2017, 11, 10);
        sede = new SedeRegional(fechaCompetencia, 3, 4, "Sede1", paisesHabilitados);
        universidad1 = new Universidad("Univerisdad 1", pais1);
        universidad2 = new Universidad("Univerisdad 2", pais2);
        universidad3 = new Universidad("Univerisdad 3", pais3);
        
    }
    
    @After
    public void tearDown() {
    }

    //****************************************************
    //Pruebas metodo equipo.esValido(fechaCompetencia, paisesHabilitados)
    //****************************************************
    
    //PARTE 1
    //En algunos casos capturo la exception y comparo el mensaje 
    //Solo para ver que se puede realizar de las dos maneras
    //En caso que se quiera ver la exception sin capturarla se puede quitar al @Test
    //que espera una excetion, esto produce un error en el test tirando el mensaje de la exception
    @Test
    public void ingresoEquipoFormadoPor1Integrantes() {
        try {
            Participante participante1 = new Participante("Nombre1 Apellido1", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
            integrantes.add(participante1);
            equipo=new Equipo("Equipo1NombreEquipo", integrantes);
            equipo.esValido();
        } catch (ObligatorioTallerException ex) {
            assertEquals("Equipo no está formado por 3 integrantes", ex.getMessage());
        }      
    }
    @Test(expected = ObligatorioTallerException.class)
    public void ingresoEquipoFormadoPor2Integrantes() throws ObligatorioTallerException{
        Participante participante1 = new Participante("Nombre1 Apellido1", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
        Participante participante2 = new Participante("Nombre2 Apellido2", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
        integrantes.add(participante1);
        integrantes.add(participante2);
        equipo=new Equipo("Equipo1NombreEquipo", integrantes);
        equipo.esValido();
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
        equipo.esValido();
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
        assertTrue(equipo.esValido());
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
        equipo.esValido();
    }
    @Test
    public void nombreParticipanteUnaPalabra() {
        try {
            Participante participante1 = new Participante("Nombre1", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
            Participante participante2 = new Participante("Nombre2 Apellido2", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
            Participante participante3 = new Participante("Nombre3 Apellido3", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
            integrantes.add(participante1);
            integrantes.add(participante2);
            integrantes.add(participante3);
            equipo=new Equipo("Equipo1NombreEquipo", integrantes);
            equipo.esValido();
        } catch (ObligatorioTallerException ex) {
            assertEquals("Nombre no contiene al menos 2 palabras con mas de 4 caracteres", ex.getMessage());
        }
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
        equipo.esValido();
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
        assertTrue(equipo.esValido());
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
        assertTrue(equipo.esValido());
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
        assertTrue(equipo.esValido());
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
        assertTrue(equipo.esValido());
    }
    //PARTE 4 SE CONTROLA EN SEDE REGIONAL AL REGISTRAR EQUIPO
    
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
        assertTrue(equipo.esValido());
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
        assertTrue(equipo.esValido());
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
        assertTrue(equipo.esValido());
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
        assertTrue(equipo.esValido());
    }
    @Test(expected = ObligatorioTallerException.class)
    public void ingresoParticipantesCursando0Semestre() throws ObligatorioTallerException{
        //Asumo que si esta cursando primer semestre ultimo semestre cursado esota en cero
        Participante participante1 = new Participante("Nombre1 Apellido1", new Date(1997, 06, 19), "Carrera1", 0, universidad2);
        Participante participante2 = new Participante("Nombre2 Apellido2", new Date(1998, 06, 19), "Carrera1", 2, universidad2);
        Participante participante3 = new Participante("Nombre3 Apellido3", new Date(1998, 06, 19), "Carrera1", 2, universidad2);
        integrantes.add(participante1);
        integrantes.add(participante2);
        integrantes.add(participante3);
        equipo=new Equipo("Equipo1NombreEquipo", integrantes);
        assertTrue(equipo.esValido());
    }
    @Test(expected = ObligatorioTallerException.class)
    public void ingresoParticipantesCursando8Semestre() throws ObligatorioTallerException{
        //Asumo que si esta cursando primer semestre ultimo semestre cursado esota en cero
        Participante participante1 = new Participante("Nombre1 Apellido1", new Date(1997, 06, 19), "Carrera1", 8, universidad2);
        Participante participante2 = new Participante("Nombre2 Apellido2", new Date(1998, 06, 19), "Carrera1", 2, universidad2);
        Participante participante3 = new Participante("Nombre3 Apellido3", new Date(1998, 06, 19), "Carrera1", 2, universidad2);
        integrantes.add(participante1);
        integrantes.add(participante2);
        integrantes.add(participante3);
        equipo=new Equipo("Equipo1NombreEquipo", integrantes);
        assertTrue(equipo.esValido());
    }
    @Test
    public void ingresoParticipantesCursando7Semestre() throws ObligatorioTallerException{
        //Asumo que si esta cursando primer semestre ultimo semestre cursado esota en cero
        Participante participante1 = new Participante("Nombre1 Apellido1", new Date(1997, 06, 19), "Carrera1", 7, universidad2);
        Participante participante2 = new Participante("Nombre2 Apellido2", new Date(1998, 06, 19), "Carrera1", 2, universidad2);
        Participante participante3 = new Participante("Nombre3 Apellido3", new Date(1998, 06, 19), "Carrera1", 2, universidad2);
        integrantes.add(participante1);
        integrantes.add(participante2);
        integrantes.add(participante3);
        equipo=new Equipo("Equipo1NombreEquipo", integrantes);
        assertTrue(equipo.esValido());
    }
    @Test
    public void ingresoParticipantesCursando1Semestre() throws ObligatorioTallerException{
        //Asumo que si esta cursando primer semestre ultimo semestre cursado esota en cero
        Participante participante1 = new Participante("Nombre1 Apellido1", new Date(1997, 06, 19), "Carrera1", 1, universidad2);
        Participante participante2 = new Participante("Nombre2 Apellido2", new Date(1998, 06, 19), "Carrera1", 2, universidad2);
        Participante participante3 = new Participante("Nombre3 Apellido3", new Date(1998, 06, 19), "Carrera1", 2, universidad2);
        integrantes.add(participante1);
        integrantes.add(participante2);
        integrantes.add(participante3);
        equipo=new Equipo("Equipo1NombreEquipo", integrantes);
        assertTrue(equipo.esValido());
    }
    
    //PARTE 7
    
    @Test(expected = ObligatorioTallerException.class)
    public void ingresoNombreEquipoVacio() throws ObligatorioTallerException{
        //Asumo que si esta cursando primer semestre ultimo semestre cursado esota en cero
        Participante participante1 = new Participante("Nombre1 Apellido1", new Date(1997, 06, 19), "Carrera1", 7, universidad2);
        Participante participante2 = new Participante("Nombre2 Apellido2", new Date(1998, 06, 19), "Carrera1", 2, universidad2);
        Participante participante3 = new Participante("Nombre3 Apellido3", new Date(1998, 06, 19), "Carrera1", 2, universidad2);
        integrantes.add(participante1);
        integrantes.add(participante2);
        integrantes.add(participante3);
        equipo=new Equipo("", integrantes);
        assertTrue(equipo.esValido());
    }
    
    @Test(expected = ObligatorioTallerException.class)
    public void ingresoNombreEquipo9Caracteres() throws ObligatorioTallerException{
        //Asumo que si esta cursando primer semestre ultimo semestre cursado esota en cero
        Participante participante1 = new Participante("Nombre1 Apellido1", new Date(1997, 06, 19), "Carrera1", 7, universidad2);
        Participante participante2 = new Participante("Nombre2 Apellido2", new Date(1998, 06, 19), "Carrera1", 2, universidad2);
        Participante participante3 = new Participante("Nombre3 Apellido3", new Date(1998, 06, 19), "Carrera1", 2, universidad2);
        integrantes.add(participante1);
        integrantes.add(participante2);
        integrantes.add(participante3);
        equipo=new Equipo("Equipo1No", integrantes);
        assertTrue(equipo.esValido());
    }
    @Test(expected = ObligatorioTallerException.class)
    public void ingresoNombreEquipo21Caracteres() throws ObligatorioTallerException{
        //Asumo que si esta cursando primer semestre ultimo semestre cursado esota en cero
        Participante participante1 = new Participante("Nombre1 Apellido1", new Date(1997, 06, 19), "Carrera1", 7, universidad2);
        Participante participante2 = new Participante("Nombre2 Apellido2", new Date(1998, 06, 19), "Carrera1", 2, universidad2);
        Participante participante3 = new Participante("Nombre3 Apellido3", new Date(1998, 06, 19), "Carrera1", 2, universidad2);
        integrantes.add(participante1);
        integrantes.add(participante2);
        integrantes.add(participante3);
        equipo=new Equipo("Equipo1NombreEquipoEq", integrantes);
        assertTrue(equipo.esValido());
    }
    @Test
    public void ingresoNombreEquipo20Caracteres() throws ObligatorioTallerException{
        //Asumo que si esta cursando primer semestre ultimo semestre cursado esota en cero
        Participante participante1 = new Participante("Nombre1 Apellido1", new Date(1997, 06, 19), "Carrera1", 7, universidad2);
        Participante participante2 = new Participante("Nombre2 Apellido2", new Date(1998, 06, 19), "Carrera1", 2, universidad2);
        Participante participante3 = new Participante("Nombre3 Apellido3", new Date(1998, 06, 19), "Carrera1", 2, universidad2);
        integrantes.add(participante1);
        integrantes.add(participante2);
        integrantes.add(participante3);
        equipo=new Equipo("Equipo1NombreEquipoE", integrantes);
        assertTrue(equipo.esValido());
    }
    
    @Test
    public void ingresoNombreEquipo10Caracteres() throws ObligatorioTallerException{
        //Asumo que si esta cursando primer semestre ultimo semestre cursado esota en cero
        Participante participante1 = new Participante("Nombre1 Apellido1", new Date(1997, 06, 19), "Carrera1", 7, universidad2);
        Participante participante2 = new Participante("Nombre2 Apellido2", new Date(1998, 06, 19), "Carrera1", 2, universidad2);
        Participante participante3 = new Participante("Nombre3 Apellido3", new Date(1998, 06, 19), "Carrera1", 2, universidad2);
        integrantes.add(participante1);
        integrantes.add(participante2);
        integrantes.add(participante3);
        equipo=new Equipo("Equipo1Nom", integrantes);
        assertTrue(equipo.esValido());
    }
    
    //PARTE 8 SE CONTROLA EN SEDE REGIONAL A LA HORA DE REGISTRAR EQUIPO
    
  
    //****************************************************
    //Pruebas metodo sede.registrarEquipo(equipo)
    //****************************************************
    
    //Se testean algunas pruebas ya realizadas en equipo.esValido()
    //para saber que al integrar los metodos funcionan correctamente
    
    //PARTE 1 
    
    //En algunos casos capturo la exception y comparo el mensaje 
    //Solo para ver que se puede realizar de las dos maneras
    @Test
    public void ingresoEquipoFormadoPor1IntegrantesRG() {
        try {
            Participante participante1 = new Participante("Nombre1 Apellido1", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
            integrantes.add(participante1);
            equipo=new Equipo("Equipo1NombreEquipo", integrantes);
            sede.registrarEquipo(equipo);
        } catch (ObligatorioTallerException ex) {
            assertEquals("Equipo no está formado por 3 integrantes", ex.getMessage());
        }
    }
    @Test(expected = ObligatorioTallerException.class)
    public void ingresoEquipoFormadoPor2IntegrantesRG() throws ObligatorioTallerException{
        Participante participante1 = new Participante("Nombre1 Apellido1", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
        Participante participante2 = new Participante("Nombre2 Apellido2", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
        integrantes.add(participante1);
        integrantes.add(participante2);
        equipo=new Equipo("Equipo1NombreEquipo", integrantes);
        sede.registrarEquipo(equipo);
    }
    @Test(expected = ObligatorioTallerException.class)
    public void ingresoEquipoFormadoPor4IntegrantesRG() throws ObligatorioTallerException{
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
    public void ingresoEquipoFormadoPor3IntegrantesRG() throws ObligatorioTallerException{
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
    
    @Test
    public void nombreParticipantesVacioRG(){
        try {
            Participante participante1 = new Participante("", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
            Participante participante2 = new Participante("Nombre2 Apellido2", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
            Participante participante3 = new Participante("Nombre3 Apellido3", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
            integrantes.add(participante1);
            integrantes.add(participante2);
            integrantes.add(participante3);
            equipo=new Equipo("Equipo1NombreEquipo", integrantes);
            sede.registrarEquipo(equipo);
        } catch (ObligatorioTallerException ex) {
            assertEquals("String vacio", ex.getMessage());
        }
    }
    @Test(expected = ObligatorioTallerException.class)
    public void nombreParticipanteUnaPalabraRG() throws ObligatorioTallerException{
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
    public void nombreParticipanteDosPalabraMenos4CaracteresRG() throws ObligatorioTallerException{
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
    public void nombreParticipanteDosPalabraCon5CaracteresRG() throws ObligatorioTallerException{
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
    public void ingresoNombreCarreraVacioRG() throws ObligatorioTallerException{
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
    public void ingresoNombreCarreraMenos5CaracteresRG() throws ObligatorioTallerException{
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
    public void ingresoNombreCarreraCon5CaracteresRG() throws ObligatorioTallerException{
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
    public void ingresoParticipanteCon15AnosRG() throws ObligatorioTallerException{
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
    public void ingresoParticipanteCon21AnosRG() throws ObligatorioTallerException{
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
    public void ingresoParticipanteCon16AnosRG() throws ObligatorioTallerException{
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
    public void ingresoParticipanteCon20AnosRG() throws ObligatorioTallerException{
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
    public void ingresoParticipantesUniversidadesDistintasRG() throws ObligatorioTallerException{
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
    public void ingresoParticipantesUniversidadesDistintas2RG() throws ObligatorioTallerException{
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
    public void ingresoParticipantesUniversidadesIgualesRG() throws ObligatorioTallerException{
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
    public void ingresoParticipantesCursando9SemestreRG() throws ObligatorioTallerException{
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
    public void ingresoParticipantesCursando1SemestreRG() throws ObligatorioTallerException{
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
    public void ingresoParticipantesCursando7SemestreRG() throws ObligatorioTallerException{
        //Asumo que si esta cursando primer semestre ultimo semestre cursado esta en cero
        Participante participante1 = new Participante("Nombre1 Apellido1", new Date(1997, 06, 19), "Carrera1", 7, universidad2);
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
    public void ingresoNombreEquipoVacioRG() throws ObligatorioTallerException{
        //Asumo que si esta cursando primer semestre ultimo semestre cursado esota en cero
        Participante participante1 = new Participante("Nombre1 Apellido1", new Date(1997, 06, 19), "Carrera1", 7, universidad2);
        Participante participante2 = new Participante("Nombre2 Apellido2", new Date(1998, 06, 19), "Carrera1", 2, universidad2);
        Participante participante3 = new Participante("Nombre3 Apellido3", new Date(1998, 06, 19), "Carrera1", 2, universidad2);
        integrantes.add(participante1);
        integrantes.add(participante2);
        integrantes.add(participante3);
        equipo=new Equipo("", integrantes);
        assertTrue(sede.registrarEquipo(equipo));
    }
    
    @Test(expected = ObligatorioTallerException.class)
    public void ingresoNombreEquipo9CaracteresRG() throws ObligatorioTallerException{
        //Asumo que si esta cursando primer semestre ultimo semestre cursado esota en cero
        Participante participante1 = new Participante("Nombre1 Apellido1", new Date(1997, 06, 19), "Carrera1", 7, universidad2);
        Participante participante2 = new Participante("Nombre2 Apellido2", new Date(1998, 06, 19), "Carrera1", 2, universidad2);
        Participante participante3 = new Participante("Nombre3 Apellido3", new Date(1998, 06, 19), "Carrera1", 2, universidad2);
        integrantes.add(participante1);
        integrantes.add(participante2);
        integrantes.add(participante3);
        equipo=new Equipo("Equipo1No", integrantes);
        assertTrue(sede.registrarEquipo(equipo));
    }
    @Test(expected = ObligatorioTallerException.class)
    public void ingresoNombreEquipo21CaracteresRG() throws ObligatorioTallerException{
        //Asumo que si esta cursando primer semestre ultimo semestre cursado esota en cero
        Participante participante1 = new Participante("Nombre1 Apellido1", new Date(1997, 06, 19), "Carrera1", 7, universidad2);
        Participante participante2 = new Participante("Nombre2 Apellido2", new Date(1998, 06, 19), "Carrera1", 2, universidad2);
        Participante participante3 = new Participante("Nombre3 Apellido3", new Date(1998, 06, 19), "Carrera1", 2, universidad2);
        integrantes.add(participante1);
        integrantes.add(participante2);
        integrantes.add(participante3);
        equipo=new Equipo("Equipo1NombreEquipoEq", integrantes);
        assertTrue(sede.registrarEquipo(equipo));
    }
    @Test
    public void ingresoNombreEquipo20CaracteresRG() throws ObligatorioTallerException{
        //Asumo que si esta cursando primer semestre ultimo semestre cursado esota en cero
        Participante participante1 = new Participante("Nombre1 Apellido1", new Date(1997, 06, 19), "Carrera1", 7, universidad2);
        Participante participante2 = new Participante("Nombre2 Apellido2", new Date(1998, 06, 19), "Carrera1", 2, universidad2);
        Participante participante3 = new Participante("Nombre3 Apellido3", new Date(1998, 06, 19), "Carrera1", 2, universidad2);
        integrantes.add(participante1);
        integrantes.add(participante2);
        integrantes.add(participante3);
        equipo=new Equipo("Equipo1NombreEquipoE", integrantes);
        assertTrue(sede.registrarEquipo(equipo));
    }
    
    @Test
    public void ingresoNombreEquipo10CaracteresRG() throws ObligatorioTallerException{
        //Asumo que si esta cursando primer semestre ultimo semestre cursado esota en cero
        Participante participante1 = new Participante("Nombre1 Apellido1", new Date(1997, 06, 19), "Carrera1", 7, universidad2);
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
    public void ingresoUniversidadParticipanteDeUnPaisNoHabilitadoRG() throws ObligatorioTallerException{
        //Asumo que si esta cursando primer semestre ultimo semestre cursado esota en cero
        Pais pais4=new Pais("Pais 4");
        Universidad universidad4=new Universidad("Universidad 4", pais4);
        Participante participante1 = new Participante("Nombre1 Apellido1", new Date(1997, 06, 19), "Carrera1", 7, universidad4);
        Participante participante2 = new Participante("Nombre2 Apellido2", new Date(1998, 06, 19), "Carrera1", 2, universidad4);
        Participante participante3 = new Participante("Nombre3 Apellido3", new Date(1998, 06, 19), "Carrera1", 2, universidad4);
        integrantes.add(participante1);
        integrantes.add(participante2);
        integrantes.add(participante3);
        equipo=new Equipo("Equipo1Nom", integrantes);
        assertTrue(sede.registrarEquipo(equipo));
    }
    
    //PRUEBA MAXIMA CANTIDAD DE EQUIPOS
    @Test(expected = ObligatorioTallerException.class)
    public void ingresoMasEquiposDeLosQueSePuedeRG() throws ObligatorioTallerException{
        sede.setMaximoDeEquipos(1);
        Participante participante1 = new Participante("Nombre1 Apellido1", new Date(1997, 06, 19), "Carrera1", 7, universidad2);
        Participante participante2 = new Participante("Nombre2 Apellido2", new Date(1998, 06, 19), "Carrera1", 2, universidad2);
        Participante participante3 = new Participante("Nombre3 Apellido3", new Date(1998, 06, 19), "Carrera1", 2, universidad2);
        integrantes.add(participante1);
        integrantes.add(participante2);
        integrantes.add(participante3);
        equipo=new Equipo("Equipo1Nom", integrantes);
        sede.registrarEquipo(equipo);
        
        Participante participante4 = new Participante("Nombre4 Apellido4", new Date(1997, 06, 19), "Carrera1", 7, universidad1);
        Participante participante5 = new Participante("Nombre5 Apellido5", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
        Participante participante6 = new Participante("Nombre6 Apellido6", new Date(1998, 06, 19), "Carrera1", 2, universidad1);
        integrantes=new ArrayList();
        integrantes.add(participante4);
        integrantes.add(participante5);
        integrantes.add(participante6);
        
        assertTrue(sede.registrarEquipo(equipo));
    }
}
