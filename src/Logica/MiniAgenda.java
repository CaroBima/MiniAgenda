

package Logica;
import Igu.FormPrincipal;
import Persistencia.Archivo;
import java.util.*;

public class MiniAgenda {

  
    
    public static void main(String[] args) {
      //  int indice = 0;
      //  Persona pers = new Persona();
      //  Persona leerPersona = new Persona();
      //  List<String> lista = new ArrayList<String>();
        
        
        //Crear y hacer visible el formulario
        // FormMiniAgenda formulario = new FormMiniAgenda();
        // formulario.setVisible(true);
        // formulario.setLocationRelativeTo(null);
        //Crear y hacer visible el formulario
        FormPrincipal formulario = new FormPrincipal();
        formulario.setVisible(true);
        formulario.setLocationRelativeTo(null);
        
        
        //Persona persona = new Persona("Pedro", "Paramo", "3546494118", "San Jeronimo 255");
        Archivo datos = new Archivo();
        
        datos.crearArchivo();
        //datos.agregarTexto(persona);
        
       
        /*lee un solo registro
        leerPersona = datos.leerRegistro();
        
        System.out.println("Persona leída");
        System.out.println("Nombre: " + leerPersona.getNombre());
        System.out.println("Apellido: " + leerPersona.getApellido());
        System.out.println("Teléfono: " + leerPersona.getTelefono());
        System.out.println("Dirección: " + leerPersona.getDireccion());
        */
        
        //lista = datos.leerTodosLosRegistros();
        
        /*
        Iterator iter = lista.iterator();
        int control = lista.size();
        int cantReg = control / 4;
        while(iter.hasNext() && cantReg!=0 ){ //recorro para obtener e imprimir los datos
            System.out.println(iter.next());
            cantReg--;
            
            
        }*/
        
    
    }
}
