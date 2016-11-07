package controllers;

import java.io.IOException;
import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        render();
    }

    public static void login(String username, String password) throws IOException {
        List snacklistAPI = Snack.getsnackList();
        ArrayList snacklist = new ArrayList();
       
        // on v.2 use enahanced for loop 
        for (int i = 0; i < snacklistAPI.size(); i++) {
            snacklist.add((Snack)snacklistAPI.get(i));
        }
       
        //on v.2 send export refernce of snack name from snack object instead
        render("@Application.suggest", snacklist);
    }

}
