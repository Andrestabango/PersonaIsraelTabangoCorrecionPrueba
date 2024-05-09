import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Cola {

    private PriorityQueue<PersonaIsraelTabango> personaIsraelTabangos;

    public Cola(){
        personaIsraelTabangos= new PriorityQueue<PersonaIsraelTabango>();
    }

    public void encolar(String cedula, String nombre, int edad, String genero, String region) throws Exception{
        if(buscarPersona(cedula)==null)
         personaIsraelTabangos.add(new PersonaIsraelTabango(cedula, nombre, edad,genero,region));
        else
            throw new Exception("La cedula ya esta registrada");
    }



    public List<PersonaIsraelTabango> listaPersonas (){
        List<PersonaIsraelTabango> lista=new LinkedList<>();
        for (PersonaIsraelTabango p: personaIsraelTabangos)
            lista.add(p);
        return lista;
    }

    public PersonaIsraelTabango buscarPersona(String cedula){
        for(PersonaIsraelTabango p: personaIsraelTabangos)
            if(p.getCedula().equals(cedula))
                return p;
        return null;
    }

    public List<PersonaIsraelTabango> listaEdadGenero(int edad, String genero) throws Exception{
        if(personaIsraelTabangos.isEmpty())
            throw new Exception("No hay personas registradas");
        else{
            List<PersonaIsraelTabango> lista =new LinkedList<>();
            for(PersonaIsraelTabango p: personaIsraelTabangos){
                if(p.getEdad()==edad && p.getGenero().equals(genero))
                    lista.add(p);
            }
            return lista;
        }

    }

    public List<PersonaIsraelTabango> listaEdadRegion(int edad, String region) throws Exception{
        if(personaIsraelTabangos.isEmpty())
            throw new Exception("No hay personas registradas");
        else{
            List<PersonaIsraelTabango> lista =new LinkedList<>();
            for(PersonaIsraelTabango p: personaIsraelTabangos){
                if(p.getEdad()==edad && p.getRegion().equals(region))
                    lista.add(p);
            }
            return lista;
        }

    }


}
