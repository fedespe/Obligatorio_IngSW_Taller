
package Logica;

import java.util.Date;

public class Participante {
    private String nombre;
    private Date fechaNacimiento;
    private String carreraQueCursa;
    private int ultimoSemestreCursado;
    private Universidad universidad;
    
    

    public void validarNombre() throws ObligatorioTallerException {
        verificarStringVacio(nombre);
        String[] nom=nombre.split(" ");
        int contador=0;
        for(String s:nom){
            if(s.length()>4){
                contador++;
            }
        }
        if(contador<2){
            throw new ObligatorioTallerException("Nombre no contiene al menos 2 palabras con mas de 4 caracteres");
        }
    }

    public void validarNombreCarrera() throws ObligatorioTallerException {
        verificarStringVacio(carreraQueCursa);
        if(carreraQueCursa.length()<5){
            throw new ObligatorioTallerException("CarreraQueCursa menor a 5 caracteres");
        }
    }
    
    private void verificarStringVacio(String s) throws ObligatorioTallerException{
        if("".equals(s)){
            throw new ObligatorioTallerException("CarreraQueCursa vacio");
        }   
    }

    public void validadEdadIntegrantes(Date fechaCompetencia) throws ObligatorioTallerException {
        //falta implementar
        int edad=calcularEdad(fechaCompetencia);
        if(edad<16 || edad>20)
            throw new ObligatorioTallerException("La edad del participante no es correcta");
    }

    private int calcularEdad(Date fechaCompetencia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNombreUniversidad() {
        return universidad.getNombre();
    }
}
