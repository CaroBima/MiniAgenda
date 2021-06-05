/*
CRUD en txt
crear archivo agenda.txt
agregar registros
leer los registros
 */
package Persistencia;

import Logica.Persona;
import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;

public class Archivo {

    File archivo;

    public void crearArchivo() {
        archivo = new File("agenda.txt");

        try {
            if (archivo.createNewFile()) { //crea un nuevo archivo, si ya existe no hace nada
                //JOptionPane.showMessageDialog(null, "Archivo creado");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Ha sucedido un error" + ex);
        }

    }

    public void agregarRegistro(Persona persona) {
        try {
            FileWriter escribir = new FileWriter(archivo, true); //el boolean true indica que vamos a añadir y no sobreescribir 
            //escribir.write("Hola mundo"); //sobrescribe al ejecutar el programa de nuevo
            //escribir.write("\nSobrescribe?");
            escribir.append("Nombre:" + persona.getNombre()  + " ");
            escribir.append("\nApellido:" + persona.getApellido()  + " ");
            escribir.append("\nTeléfono:" + persona.getTelefono()  + " ");
            escribir.append("\nDirección:" + persona.getDireccion()  + " " );
            //escribir.append("\nIndice:" + persona.getIndice());
            escribir.append("\n*****\n");
            escribir.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Ha sucedido un error" + ex);
        }
    }

    public Persona leerRegistro() {
        String cadena = "algo"; //para leer el registro
        String registroCompleto[] = new String[5]; //usado para recuperar los datos de la persona y pasarlos a un objeto persona
        String datoFinal[] = new String[5];
        Persona persona = new Persona(); // el valor que voy a retornar
        String nombre, apellido, telefono, direccion;
        int contadorReg = 0;

        try {
            FileReader lector = new FileReader(archivo);
            BufferedReader lectura = new BufferedReader(lector);

            try {
                //cadena = lectura.readLine();
                //System.out.println(cadena);
                while (cadena != null && !cadena.equals("*****")) { //recupera 1 registro

                    cadena = lectura.readLine();
                    //System.out.println(cadena);
                    registroCompleto[contadorReg] = cadena; //guardo los datos en un vector para despues pasarlos a persona
                    contadorReg++;
                }
                for (int i = 0; i < 4; i++) {
                    String[] parts = registroCompleto[i].split(":");
                    datoFinal[i] = parts[1];
                }
                persona.setNombre(datoFinal[0]);
                persona.setApellido(datoFinal[1]);
                persona.setTelefono(datoFinal[2]);
                persona.setDireccion(datoFinal[3]);

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Ha sucedido un error" + ex);
            }

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Ha sucedido un error" + ex);
        }

        return persona;
    }

    public List leerTodosLosRegistros() {
        ArrayList<String> recupero = new ArrayList<String>();
        String cadena = "algo"; //para leer cada linea y controlar si se llego al fin del archivo
        String registro[] = new String[5]; // para guardar cada registro del archivo
        String datoFinal;

        //comienzo lectura del archivo
        try {
            FileReader lector = new FileReader(archivo); //abrir archivo para leer 
            BufferedReader lectura = new BufferedReader(lector); //abrir archivo para leer

            while (cadena != null){ //veo si es el final del archivo
                int contadorRegistro = 0;
                try {
                    cadena = lectura.readLine();
                    
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Ha sucedido un error" + ex);
                }
                
                while ( cadena != null && !cadena.equals("*****")) {
                    if (cadena.contains(":")) {
                        // Hacer split.
                        String partes = cadena.split(":")[1];
                        datoFinal = partes; //probado, recupera los registros divididos
                        registro[contadorRegistro] = datoFinal; // probado, guarda los registros
                        recupero.add(registro[contadorRegistro]); //agrego lo recuperado a una lista
                        contadorRegistro++;
                    } //else {
                        //throw new IllegalArgumentException("String " + cadena + " no contiene :");
                    //}

                    //vuelvo a leer la siguiente cadena
                    try {
                        cadena = lectura.readLine();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Ha sucedido un error" + ex);
                    }
               
                }
            }

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Ha sucedido un error" + ex);
        }
      
        return recupero;
    }

   
}
