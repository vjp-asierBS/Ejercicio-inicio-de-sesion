package validarusuarios;

import java.io.*;
import org.openide.util.Exceptions;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author abarrosos12
 */
public class Logica {

    private final static String FICHERO = "users.txt";

    public boolean leerFichero(String nombre, String contrasenya) {
        boolean validado = false;
        try {
            File f = new File(FICHERO);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String linea;
            String[] datosLinea;
            while ((linea = br.readLine()) != null) {
                if (linea.contains(";")) {
                    datosLinea = linea.split(";");
                    if (datosLinea[0].equalsIgnoreCase(nombre) && datosLinea[1].equalsIgnoreCase(contrasenya)) {
                        validado = true;
                    }
                }
            }
            br.close();
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
        return validado;
    }

    public void escribirFichero(String nombre, String contrasenya) {
        try {
            File f = new File(FICHERO);
            FileWriter fw = new FileWriter(f, true);
            
            fw.write("\n");
            fw.write(nombre + ";" + contrasenya);
            fw.close();
            System.out.println("Usuario introducido con éxito");
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
    }
}
