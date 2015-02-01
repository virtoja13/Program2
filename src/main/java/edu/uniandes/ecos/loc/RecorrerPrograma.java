/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.loc;

import java.io.File;
import java.util.HashMap;

/**
 *
 * @author JAVIER
 */
public class RecorrerPrograma {
    
    public static void obtenerArchivosJava(String ruta, HashMap<String,String> rutaArchivosJava){
        File directorio = new File(ruta);
        File listaDirectorios[] = directorio.listFiles();
        for(int i = 0; i<listaDirectorios.length; i++){
            if(listaDirectorios[i].isDirectory()){
                obtenerArchivosJava(listaDirectorios[i].getAbsolutePath(), rutaArchivosJava);
            }
            else{
                if(listaDirectorios[i].getName().contains("java"))
                    rutaArchivosJava.put(listaDirectorios[i].getName(),listaDirectorios[i].getAbsolutePath());
            }
        }
    }
    
}

//error cast String listaDirectorios[] = directorio.listFiles();
//error retornando la lista se cambio el metodo para que la firma del metodo no retorne nada y se envie por parametro
//Error en donde almacenar la ruta de los archivos, se paso de un list a un map. error de dise;o