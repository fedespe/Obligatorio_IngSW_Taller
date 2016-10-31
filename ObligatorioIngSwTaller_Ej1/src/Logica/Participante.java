
package Logica;

import java.util.Date;

public class Participante {
    private String nombre;
    private Date fechaNacimiento;
    private String carreraQueCursa;
    private int ultimoSemestreCursado;
    private Universidad universidad;

    public Participante(String nombre, Date fechaNacimiento, String carreraQueCursa, int ultimoSemestreCursado, Universidad universidad) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.carreraQueCursa = carreraQueCursa;
        this.ultimoSemestreCursado = ultimoSemestreCursado;
        this.universidad = universidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCarreraQueCursa() {
        return carreraQueCursa;
    }

    public void setCarreraQueCursa(String carreraQueCursa) {
        this.carreraQueCursa = carreraQueCursa;
    }

    public int getUltimoSemestreCursado() {
        return ultimoSemestreCursado;
    }

    public void setUltimoSemestreCursado(int ultimoSemestreCursado) {
        this.ultimoSemestreCursado = ultimoSemestreCursado;
    }

    public Universidad getUniversidad() {
        return universidad;
    }

    public void setUniversidad(Universidad universidad) {
        this.universidad = universidad;
    }
    
    

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
        int año = fechaCompetencia.getYear()- fechaNacimiento.getYear();
        int mes =fechaCompetencia.getMonth()- fechaNacimiento.getMonth();
        int dia = fechaCompetencia.getDay()- fechaNacimiento.getMonth();
        //Se ajusta el año dependiendo el mes y el día
        if(mes<0 || (mes==0 && dia<0)){
            año--;
        }
        //Regresa la edad en base a la fecha de nacimiento
        return año;
    }

    public String getNombreUniversidad() {
        return universidad.getNombre();
    }

    public void validarCantidadSemestres() throws ObligatorioTallerException {
        if(ultimoSemestreCursado<1 || ultimoSemestreCursado>=8){
            throw new ObligatorioTallerException("La cantidad de semestres cursados no es la correcta");
        }
    }
}
