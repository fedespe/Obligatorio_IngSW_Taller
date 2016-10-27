
package Logica;

import java.util.ArrayList;
import java.util.Date;

public class Equipo {
    private String nombre;
    private ArrayList<Participante> integrantes;
    
    //Hubo que agregar al metodo es valido la fecha de la 
    //competencia para la validacion de la edad
    public boolean esValido(Date fechaCompetencia) throws ObligatorioTallerException{
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
}
