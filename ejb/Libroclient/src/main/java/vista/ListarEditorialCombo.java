/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import modelo.Autor;
import modelo.Editorial;
import negocio.GestionEditorialesRemote;

/**
 * Esta clase obtiene las listas de todos los ids, titulos, min_salary´s y 
 * max_salary´s, estas se almacenan en listas para poder mostrarlas 
 * dentro del GUI.
 * @author chris
 */
public class ListarEditorialCombo 
{
    private GestionEditorialesRemote ge;
    private List<String> nombre_editorial = new ArrayList<String>();
   
    /**
     * Metodo que contiene el queery SELECT para obtener los datos de la
     * tabla JOBS. Guarda los resultados en una lista segun sea el tipo de
     * atributo.
     * @param con Contiene la conexion con la tabla JOBS.
     */
    
    public void conectarInstancias() throws Exception {
		try {  
            final Hashtable<String, Comparable> jndiProperties =  
                    new Hashtable<String, Comparable>();  
            jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,  
                    "org.wildfly.naming.client.WildFlyInitialContextFactory");  
            jndiProperties.put("jboss.naming.client.ejb.context", true);  
              
            jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8090");  
            jndiProperties.put(Context.SECURITY_PRINCIPAL, "ejb");  
            jndiProperties.put(Context.SECURITY_CREDENTIALS, "ejb");  
              
            final Context context = new InitialContext(jndiProperties);  
              
            final String lookupName = "ejb:/testejbserver/GestionEditoriales!negocio.GestionEditorialesRemote";
             
            
            this.ge = (GestionEditorialesRemote) context.lookup(lookupName);
            
              
        } catch (Exception ex) {  
            ex.printStackTrace();  
            throw ex;  
        }  
	}
    public boolean ListarEditorial()
    {       
       
        nombre_editorial.clear();
        boolean band=false;
        try {
			this.conectarInstancias();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	List<Editorial> editoriales = ge.getEditoriales();
	for(Editorial e : editoriales) 
        {
            nombre_editorial.add(e.getNombre().toString());
            band=true;
	}
        
        return band;    
        
    }
	public GestionEditorialesRemote getGe() {
		return ge;
	}
	public void setGe(GestionEditorialesRemote ge) {
		this.ge = ge;
	}
	public List<String> getNombre_editorial() {
		return nombre_editorial;
	}
	public void setNombre_editorial(List<String> nombre_editorial) {
		this.nombre_editorial = nombre_editorial;
	} 


    
}
    

