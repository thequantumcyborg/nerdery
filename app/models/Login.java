/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import play.data.validation.Required;

/**
 *
 * @author User
 */
public class Login {
    // validator
    @Required private String login_id;
    @Required private String eid;
    @Required private String username;
    @Required private String password;

    public Login(String login_id, String eid, String username, String password) {
        this.login_id = login_id;
        this.eid = eid;
        this.username = username;
        this.password = password;
    }

    public String getLogin_id() {
        return login_id;
    }

    public void setLogin_id(String login_id) {
        this.login_id = login_id;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
