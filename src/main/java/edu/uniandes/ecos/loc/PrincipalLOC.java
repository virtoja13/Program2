/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.loc;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
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
        HashMap<String,String>  map = new HashMap<String,String>();
        Contador contador = new Contador();
        map = (HashMap<String, String>)contador.lineasArvhivos(ruta);
        Iterator iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            resp.getWriter().println("Clase: "+entry.getKey() + ". Numero lineas: "+entry.getValue());
        }
    }
    
    public static void main(String[] args) throws Exception{
        Server server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new PrincipalLOC()),"/*");
        server.start();
        server.join();
    }     
}