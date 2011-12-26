package controllers;

import play.*;
import play.db.Evolutions;
import play.jobs.JobsPlugin;
import play.libs.IO;
import play.mvc.*;
import play.utils.OrderSafeProperties;
import play.vfs.VirtualFile;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import models.*;

public class ControllerParent extends Controller {
	
	//Ce champs sert seulement à avoir une meilleure compréhension lors de l'accès aux properties.
	public static Properties properties = Play.configuration;
	
	@Before 
	public static void setCORS() { 		
		if(Play.mode.isDev()){
			Http.Header hd = new Http.Header(); 
			hd.name = "Access-Control-Allow-Origin"; 
			hd.values = new ArrayList<String>(); 
			hd.values.add("*"); 
			Http.Response.current().headers.put("Access-Control-Allow-Origin",hd);		
		}
	}	
}