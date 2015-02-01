/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.loc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JAVIER
 */
public class Contador {
    
    public Map lineasArvhivos(String ruta){
        Map<String,String> lineasXArchivo = new HashMap();
        HashMap<String,String> listaClases = new HashMap<String,String>();
        RecorrerPrograma.obtenerArchivosJava(ruta, listaClases);
        try {
            Iterator iterator = listaClases.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry entry = (Map.Entry) iterator.next();
                long numeroLineas = 0;
                FileReader fr = new FileReader((String)entry.getValue());
                BufferedReader bf = new BufferedReader(fr);
                String linea = bf.readLine();
                while(linea!=null) {
                    if(!linea.trim().equals(""))
                        numeroLineas++;
                    linea = bf.readLine();
                }
                lineasXArchivo.put((String) entry.getKey(), String.valueOf(numeroLineas));
                System.out.println("Clase: "+entry.getKey()+". Numero de lineas: "+numeroLineas);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Contador.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IOException ex) {
            Logger.getLogger(Contador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lineasXArchivo;
    }
    
}
