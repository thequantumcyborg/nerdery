/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
 
import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.net.MalformedURLException;

/**
 *
 * @author User
 */
public class Snack {

    private long id;
    private String name;
    private boolean optional;
    private String purchaseloc;
    private long purchasecount;
    private String lastpurchase;
    private static String url = "https://api-snacks.nerderylabs.com/v1/snacks/?ApiKey=73963813-e1cf-4f21-abc6-9183fbf79a91";

    public Snack(long id, String name, boolean optional, String purchaseloc, long purchasecount, String lastpurchase) {
        this.id = id;
        this.name = name;
        this.optional = optional;
        this.purchaseloc = purchaseloc;
        this.purchasecount = purchasecount;
        this.lastpurchase = lastpurchase;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOptional() {
        return optional;
    }

    public void setOptional(boolean optional) {
        this.optional = optional;
    }

    public String getPurchaseloc() {
        return purchaseloc;
    }

    public void setPurchaseloc(String purchaseloc) {
        this.purchaseloc = purchaseloc;
    }

    public long getPurchasecount() {
        return purchasecount;
    }

    public void setPurchasecount(long purchasecount) {
        this.purchasecount = purchasecount;
    }

    public String getLastpurchase() {
        return lastpurchase;
    }

    public void setLastpurchase(String lastpurchase) {
        this.lastpurchase = lastpurchase;
    }

    @Override
    public String toString() {
        return "Snack{" + "id=" + id + ", name=" + name + ", optional=" + optional + ", purchaseloc=" + purchaseloc + ", purchasecount=" + purchasecount + ", lastpurchase=" + lastpurchase + '}';
    }

    //for v.2 use iterator pattern
    public static ArrayList getsnackList() throws IOException {
        ArrayList<Snack> snackList = new ArrayList();
        
        
        try {
           
            InputStream input = new URL(url).openStream();
            String genreJson = IOUtils.toString(input);

            JSONParser parser = new JSONParser();

            JSONArray tileJson = (JSONArray) parser.parse(genreJson);

            for (Object object : tileJson) {
                JSONObject aJson = (JSONObject) object;
   
                long id = (Long) aJson.get("id");
                String name = (String) aJson.get("name");
                boolean opt = (Boolean) aJson.get("optional");
                String loc = (String) aJson.get("purchaseLocations");
                long count = (Long) aJson.get("purchaseCount");
                String date = (String) aJson.get("lastPurchaseDate");
                JSONArray imgSize = (JSONArray) aJson.get("size");
                snackList.add(new Snack(id, name, opt, loc, count, date));

            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
       

        return snackList;
    }

}
