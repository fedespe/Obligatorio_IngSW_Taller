
package Logica;

import java.util.ArrayList;
import java.util.Date;

public class Equipo {
    private String nombre;
    private ArrayList<Participante> integrantes;

    public Equipo(String nombre, ArrayList<Participante> integrantes) {
        this.nombre = nombre;
        this.integrantes = integrantes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Participante> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(ArrayList<Participante> integrantes) {
        this.integrantes = integrantes;
    }
    
    //Hubo que agregar al metodo es valido la fecha de la 
    //competencia para la validacion de la edad
    //Hubo que agregar una lista con los paises habilitados
    public boolean esValido(Date fechaCompetencia, ArrayList<Pais> paisesHabilitados) throws ObligatorioTallerException{
        //Parte 1
        //valida que hay 3 integrantes y que son distintos
        validar3IntegrantesDistintos();
        //Parte 2
        //valida que el nombre no es vacio y que tiene al menos 
        //2 pablabras con mas de 4 caracteres
        validarNombre();
        //Parte 3
        //valida que el nombre de la carrera no puede ser vacio
        //y por lo menos de 5 caracteres
        validarNombreCarrera();
        //Parte 4
        //valida que la edad este 16<=edad<=20
        //falta metodo en integrantes de calcular edad
        validarEdadIntegrantes(fechaCompetencia);//No esta hecho falta dato de fechaCompetencia
        //Parte 5
        //validad que los integrantes pertenezcan a la misma universidad
        validarIntegrantesUniversidad();
        //Parte 6
        //valida que los integrantes no hayan cursado mas de 8 semestres
        //y al menos deben haber cursado un semestre
        validarCantidadSemestres();
        //Parte 7
        //valida que el nombre del equipo no sea vacio 
        //y que tenga entre 10 y 20 caracteres inclusive
        validarNombreEquipo();
        //Parte 8
        //valida que la universidad donde cursan los integrantes debe ser 
        //del mismo pais que los paises habilitados
        validarPaisHabilitado(paisesHabilitados);
        return true;
    }
    public int[] puntaje(){
        int[] retorno= new int[3];
        return retorno;
    }

    private void validar3IntegrantesDistintos() throws ObligatorioTallerException {
        if(integrantes.size()!=3){
            throw new ObligatorioTallerException("Equipo no está formado por 3 integrantes");
        }
        if(integrantes.get(0)==integrantes.get(1) || integrantes.get(0)==integrantes.get(2)
                || integrantes.get(1)==integrantes.get(2)){
            throw new ObligatorioTallerException("Equipo no está formado por 3 integrantes");
        }
    }

    private void validarNombre() throws ObligatorioTallerException {
        for(Participante p:integrantes){
            p.validarNombre();
        }
    }

    private void validarNombreCarrera() throws ObligatorioTallerException {
        for(Participante p:integrantes){
            p.validarNombreCarrera();
        }
    }

    //falta calcular la edad en los integrantes
    private void validarEdadIntegrantes(Date fechaCompetencia) throws ObligatorioTallerException {
        for(Participante p:integrantes){
            p.validadEdadIntegrantes(fechaCompetencia);
        }
    }

    private void validarIntegrantesUniversidad() throws ObligatorioTallerException {
        if(integrantes.get(0).getNombreUniversidad()!=integrantes.get(1).getNombreUniversidad()
                || integrantes.get(0).getNombreUniversidad()!=integrantes.get(2).getNombreUniversidad()){
            throw new ObligatorioTallerException("Los integrantes deben pertencer a la misma universidad");
        }
    }

    private void validarCantidadSemestres() throws ObligatorioTallerException {
        integrantes.get(0).validarCantidadSemestres();
        integrantes.get(1).validarCantidadSemestres();
        integrantes.get(2).validarCantidadSemestres();
    }

    private void validarNombreEquipo() throws ObligatorioTallerException {
        verificarStringVacio(nombre);
        if(nombre.length()<10 || nombre.length()>20 ){
            throw new ObligatorioTallerException("Nombre del equipo vacio");
        }
    }
    //Se podria poner en una clase utilidades se utiliza tanto en participante 
    //como en equipo
    private void verificarStringVacio(String s) throws ObligatorioTallerException{
        if("".equals(s)){
            throw new ObligatorioTallerException("Nombre del equipo vacio");
        }   
    }

    private void validarPaisHabilitado(ArrayList<Pais> paisesHabilitados) throws ObligatorioTallerException{
       //Los integrantes del equipo pertenecen a la misma universidad
       //solo es necesario chequear con uno solo
       boolean retorno=false;
       //se podria hacer con un while
       for(Pais p: paisesHabilitados){
           //ver que se podria simplificar para llegar a el nombre del pais
           if(p.getNombre()==integrantes.get(0).getUniversidad().getPais().getNombre())
                retorno=true;
       }
       if (!retorno){
           throw new ObligatorioTallerException("El nombre del pais correspondiente a la universidad no esta habilitada");
       }
    }
}
