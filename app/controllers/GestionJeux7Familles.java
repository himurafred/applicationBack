package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.Http;

public class GestionJeux7Familles extends Controller {

	
	@Before 
	public static void setCORS() { 
		Http.Header hd = new Http.Header(); 
		hd.name = "Access-Control-Allow-Origin"; 
		hd.values = new ArrayList<String>(); 
		hd.values.add("*"); 
		Http.Response.current().headers.put("Access-Control-Allow-Origin",hd);		
	}
	
    public static void recuperationCartes() {
    	Map<String, String> values = new HashMap<String, String>();
    	values.put("msg", "récupération des cartes done !");
        renderJSON(values);
    }

}