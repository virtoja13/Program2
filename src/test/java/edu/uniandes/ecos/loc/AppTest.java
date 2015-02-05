package edu.uniandes.ecos.loc;

import java.util.ArrayList;
import junit.framework.TestCase;

public class AppTest extends TestCase{

    public void testRecorrerProyecto(){
        ArrayList<DatosProyecto> proyectos = RecorrerPrograma.obtenerProyectos("projects");
        for(DatosProyecto proyecto: proyectos){
            assertTrue(proyecto.getNombreProyecto().equals("PSP0") || proyecto.getNombreProyecto().equals("PSP01"));
        }
    }

}