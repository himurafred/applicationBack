package controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.User;

public class GestionJeux7Familles extends ControllerParent {
		
    public static void recuperationCartes(String idUser) {
    	User currentUser = init(idUser);
   
    	List<String> listeFamilles = Arrays.asList(properties.getProperty("listeFamilles").split(";"));
    	List<String> elementsFamille = Arrays.asList(properties.getProperty("elementsFamille").split(";"));
    	    	   	
    	//Récupération de la liste des familles
    	//Exemple utilisation properties    	
    	/*Map<String, List<String>> values = new HashMap<String, List<String>>();
    	values.put("listeFamille", listeFamilles);
    	values.put("elementsFamille", elementsFamille);
        renderJSON(values);*/
      	    	
    	System.out.println(currentUser);
    	
    	Map<String, String> values = new HashMap<String, String>();
    	values.put("msg", "Les cartes sont prêtes !");
    	renderJSON(values);
    }

}