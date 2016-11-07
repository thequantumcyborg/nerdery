/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.StringTokenizer;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Table;
import play.data.validation.Required;
import play.db.jpa.JPA;

/**
 *
 * @author User
 */
@Entity
@Table(name = "suggest")
public class Suggest {
    @Id
    private String suggest_id;
    @Column(name = "eid")
    private String eid;
    @Column(name = "snackid")
    private String sid;
    @Column(name = "stat_id")
    private String stat_id;

    public Suggest() {
    }
   
    public Suggest(String suggest_id, String eid, String sid, String stat_id) {
        this.suggest_id = suggest_id;
        this.eid = eid;
        this.sid = sid;
        this.stat_id = stat_id;
    }

    public String getSuggest_id() {
        return suggest_id;
    }

    public void setSuggest_id(String suggest_id) {
        this.suggest_id = suggest_id;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getStat_id() {
        return stat_id;
    }

    public void setStat_id(String stat_id) {
        this.stat_id = stat_id;
    }

    public static boolean postSelection(String sid, String eid) {
       
        
        boolean status=false;
        
      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "SnaFooAPI_JPA" );
      
      EntityManager entitymanager = emfactory.createEntityManager( );
      entitymanager.getTransaction( ).begin( );

      Suggest employee = new Suggest(); 
     
      employee.setSuggest_id("s001");
      employee.setEid("e001");
      employee.setSid("snack1001");
      employee.setStat_id("stat110");
      entitymanager.persist( employee );
      entitymanager.getTransaction( ).commit( );

      entitymanager.close( );
      emfactory.close( );
 
       
        status=true;
        
        
        
        return status;
       

    }

}
