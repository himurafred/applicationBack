package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class ControllerParent extends Controller {

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