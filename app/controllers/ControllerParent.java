package controllers;

import play.*;
import play.cache.Cache;
import play.data.binding.Binder;
import play.db.Evolutions;
import play.jobs.JobsPlugin;
import play.libs.IO;
import play.mvc.*;
import play.mvc.Scope.Session;
import play.utils.OrderSafeProperties;
import play.vfs.VirtualFile;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import models.*;

public class ControllerParent extends Controller {
	
	//Ce champs sert seulement à avoir une meilleure compréhension lors de l'accès aux properties.
	protected static Properties properties = Play.configuration;
	
	//Map des utilisateurs
	protected static Map<String, User> mapUser = new HashMap<String, User>();
		
	//A utiliser au début des méthodes
	public static User init(String idUser){
		//Permet de setter la valeur Access-Control-Allow-Origin 
		setCORS();
		
		//Permet de gérer la liste des users en session
		return manageSessionUser(idUser);
	}
	
	
	private static void setCORS() {		
		if(Play.mode.isDev()){
			Http.Header hd = new Http.Header(); 
			hd.name = "Access-Control-Allow-Origin"; 
			hd.values = new ArrayList<String>(); 
			hd.values.add("*"); 
			Http.Response.current().headers.put("Access-Control-Allow-Origin",hd);		
		}
	}	
	
	
	private static User manageSessionUser(String idUser){
				
		//On récupère la map en cache
		if(Cache.get("mapUser") != null){
			mapUser = (Map<String, User>) Cache.get("mapUser"); 
		}
	
		//Si le user n'est pas présent, on le crée
		if(idUser == null || !mapUser.containsKey(idUser)){
			
			//TODO voir quel méthode
			//On génère un nouvel identifiant utilisateur  
			idUser = (new Date()).toString();
			
			User newUser = new User(idUser, new Date());
			mapUser.put(idUser, newUser);
					
			//On mets la map en Cache
			Cache.add("mapUser", mapUser);
			return newUser;
		}
		return getUser(idUser);
	}
	
	protected static User getUser(String idUser){
		return mapUser.get(idUser);
	}
}