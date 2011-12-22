package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void test() {
    	Client client = new Client();
        renderJSON(client);
    }

}