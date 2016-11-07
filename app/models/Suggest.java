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
// POJO Class Until JPA Fixed
//@Entity
//@Table(name = "suggest")
public class Suggest {

    // @Id
    private String suggest_id;
    //@Column(name = "eid")
    private String eid;
    //@Column(name = "snackid")
    private String sid;
    //@Column(name = "stat_id")
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

    public static boolean postSelection(int sid, int eid) {
        ArrayList<Integer> arrayList = new ArrayList();
        boolean status = false;
        /*  on v.2 REFARCTOR TO JPA
         EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("defaultPersistenceUnit");
      
         EntityManager entitymanager = emfactory.createEntityManager( );
         entitymanager.getTransaction( ).begin( );

         Suggest employee = new Suggest(); 
     
         employee.setSuggest_id("s001");
         employee.setEid(eid);
         employee.setSid(sid);
         employee.setStat_id("stat110");
         entitymanager.persist( employee );
         entitymanager.getTransaction( ).commit( );

         entitymanager.close( );
         emfactory.close( );
         */

        String url = "jdbc:mysql://us-cdbr-east-04.cleardb.com:3306/heroku_98dc3582d5c864d?reconnect=true";
        String user = "b196540d943a8f";
        String pwd = "fbd4ea41";

        Connection conn = null;
        Statement stmt = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pwd);
            /*-----------------NEW ID GENERATION------------------*/
            stmt = conn.createStatement();
            String sql = "SELECT suggest_id\n"
                    + "  FROM suggest;";
            stmt.executeQuery(sql);
            rs = stmt.getResultSet();

            while (rs.next()) {
                int b_seq = rs.getInt("suggest_id");

                arrayList.add(b_seq);

            }
            rs.close();

            Integer suggest_id = Collections.max(arrayList);

            suggest_id = suggest_id + 1;
            /*-----------------END ID GENERATION------------------*/

            PreparedStatement statement = conn.prepareStatement("INSERT INTO suggest (suggest_id, eid, sid,  stat_id) "
                    + "VALUES (?,?,?,?);");
            statement.setInt(1, suggest_id);
            statement.setInt(2, eid);
            statement.setInt(3, sid);
            statement.setInt(4, 2);

            statement.execute();
            statement.close();

            conn.close();
            status = true;

        } catch (SQLException se) {
            se.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try

        return status;

    }

}
