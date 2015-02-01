/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.loc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 *
 * @author JAVIER
 */
public class PrincipalLOC extends HttpServlet {

    private static String ruta = "C:\\Users\\JAVIER\\Dropbox\\ANDES\\ECOS\\PrimerSemestre\\ConceptosAvanzadosIngSoftware\\Tareas\\Tarea2\\PSP01\\program2\\src";
        
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        mostrarLineas(req, resp);
    }
    
    private void mostrarLineas(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        Contador contador = new Contador();
        ArrayList<DatosClase> listaDatosClase = contador.lineasArvhivos(ruta);
        Iterator iterator = listaDatosClase.iterator();
        while(iterator.hasNext()){
            DatosClase dc = (DatosClase) iterator.next();
            resp.getWriter().println("Clase: "+dc.getNombreClase() + ". Numero lineas: "+dc.getNumeroLineas() + ". Numero metodos: " + dc.getNumeroMetodos());
        }
    }
    
    public static void main(String[] args) throws Exception{
        Server server = new Server(Integer.valueOf(System.getenv("PORT")));
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new PrincipalLOC()),"/*");
        server.start();
        server.join();
    }     
}

//Error de cast con iterator si hacer next