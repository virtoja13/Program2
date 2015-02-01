/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.loc;
import java.util.HashMap;

/**
 *
 * @author JAVIER
 */
public class PrincipalLOC {

    private static String ruta = "C:\\Users\\JAVIER\\Dropbox\\ANDES\\ECOS\\PrimerSemestre\\ConceptosAvanzadosIngSoftware\\Tareas\\Tarea2\\PSP01\\program2\\src";
    
    public static void main(String[] args){
        HashMap<String,String>  list = new HashMap<String,String>();
        Contador contador = new Contador();
        contador.lineasArvhivos(ruta);
    }     
}
