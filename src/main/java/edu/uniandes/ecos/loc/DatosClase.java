/*
*Clase que representa los datos de una clase
*@author: Jos� Javier Virviescas Toledo
*@version: 1.0
*/
package edu.uniandes.ecos.loc;

public class DatosClase {
    
    private String NombreClase;
    private long numeroLineas;
    private int numeroMetodos;

    public DatosClase(String NombreClase, long numeroLineas, int numeroMetodos) {
        this.NombreClase = NombreClase;
        this.numeroLineas = numeroLineas;
        this.numeroMetodos = numeroMetodos;
    }

    public String getNombreClase() {
        return NombreClase;
    }

    public long getNumeroLineas() {
        return numeroLineas;
    }

    public int getNumeroMetodos() {
        return numeroMetodos;
    }

    public void setNombreClase(String NombreClase) {
        this.NombreClase = NombreClase;
    }

    public void setNumeroLineas(long numeroLineas) {
        this.numeroLineas = numeroLineas;
    }

    public void setNumeroMetodos(int numeroMetodos) {
        this.numeroMetodos = numeroMetodos;
    }
    
}