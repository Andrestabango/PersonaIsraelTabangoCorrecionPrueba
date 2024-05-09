import javax.swing.*;

public class PersonaIsraelTabango implements  Comparable<PersonaIsraelTabango>{

    private String cedula;
    private String nombre;
    private int edad;
    private String genero;
    private String region;

    public PersonaIsraelTabango(){
        cedula="1153468311";
        nombre="Israel";
        edad=20;
        genero ="Masculino";
        region ="Sierra";
    }


    public PersonaIsraelTabango(String cedula, String nombre, int edad, String genero, String region) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.region = region;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString(){
        return "Cedula: "+ cedula+
                "\nNombre:"+nombre+
                "\nEdad:"+edad+
                "\nGenero:"+genero+
                "\nRegion:"+region;
    }

    @Override
    public int compareTo(PersonaIsraelTabango personaIsraelTabango){
        if(edad < personaIsraelTabango.getEdad())
            return -1;
        else if(edad> personaIsraelTabango.getEdad())
        return 1;
        else
            return 0;
    }


}
