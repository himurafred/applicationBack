package controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestionJeux7Familles extends ControllerParent {
		
    public static void recuperationCartes() {
    	
    	List<String> listeFamilles = Arrays.asList(ControllerParent.properties.getProperty("listeFamilles").split(";"));
    	List<String> elementsFamille = Arrays.asList(ControllerParent.properties.getProperty("elementsFamille").split(";"));
    	
    	//Récupération de la liste des familles
    	//Exemple utilisation properties    	
    	/*Map<String, List<String>> values = new HashMap<String, List<String>>();
    	values.put("listeFamille", listeFamilles);
    	values.put("elementsFamille", elementsFamille);
        renderJSON(values);*/
    
    	Map<String, String> values = new HashMap<String, String>();
    	values.put("msg", "Les cartes sont prêtes !");
    	renderJSON(values);
    }

}