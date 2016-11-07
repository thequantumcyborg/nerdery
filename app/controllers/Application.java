package controllers;

import java.io.IOException;
import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    //emp db exists, use this just for test

    private static String username = "seifu.kirubel64@gmail.com";
    private static String eid = "ks001";

    public static void index() {
        
        render();
    }

    public static void home() {
        render("@Application.home", username);
    }

    public static void suggestion(String user) throws IOException {
        username = user;
        List snacklistAPI = Snack.getsnackList();
        ArrayList snacklist = new ArrayList();

        // on v.2 use enahanced for loop 
        for (int i = 0; i < snacklistAPI.size(); i++) {
            snacklist.add((Snack) snacklistAPI.get(i));
        }

        //on v.2 send export refernce of snack name from snack object instead
        render("@Application.suggest", snacklist, username);
    }

    public static void post_suggestion_selection(String sid, String user) throws IOException {

        boolean done = false;
        List snacklistAPI = Snack.getsnackList();
        ArrayList snacklist = new ArrayList();

        // on v.2 use enahanced for loop 
        for (int i = 0; i < snacklistAPI.size(); i++) {
            snacklist.add((Snack) snacklistAPI.get(i));
        }

        done = Suggest.postSelection(sid, eid);
        if (done) {
            String success = "Selection Submitted";
            //on v.2 send export refernce of snack name from snack object instead
            render("@Application.home", snacklist, success, username);
        } else {
            //on v2 use flash
            String error = "Selection failed please try again.";
            //on v.2 send export refernce of snack name from snack object instead
            render("@Application.suggest", snacklist, error, username);
        }

    }

    public static void post_suggestion_box(String name, String purchaseloc) {
        boolean done = false;

    }

}
