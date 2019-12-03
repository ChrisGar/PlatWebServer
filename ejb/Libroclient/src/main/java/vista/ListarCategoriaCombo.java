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

import modelo.Categoria;
import negocio.GestionCategoriasRemote;

/**
 * Esta clase obtiene las listas de todos los ids, titulos, min_salary´s y 
 * max_salary´s, estas se almacenan en listas para poder mostrarlas 
 * dentro del GUI.
 * @author chris
 */
public class ListarCategoriaCombo 
{
    private GestionCategoriasRemote gc;
    private List<String> nombre_categoria = new ArrayList<String>();
   
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
              
            final String lookupName = "ejb:/testejbserver/GestionCategorias!negocio.GestionCategoriasRemote";
             
            
            this.gc = (GestionCategoriasRemote) context.lookup(lookupName);
            
              
        } catch (Exception ex) {  
            ex.printStackTrace();  
            throw ex;  
        }  
	}
    
    public boolean ListarCategoria()
    {       
       
        nombre_categoria.clear();
        boolean band=false;
        try {
			this.conectarInstancias();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	List<Categoria> categorias = gc.getCategorias();
	for(Categoria c : categorias) 
        {
            nombre_categoria.add(c.getNombre().toString());
            band=true;
	}
        
        return band;    
        
    } 

    public List<String> getNombre_categoria() {
        return nombre_categoria;
    }

    public void setNombre_categoria(List<String> nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }

    
    
}
    

