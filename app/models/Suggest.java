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
public class Suggest {
    @Required private String suggest_id;
    @Required private String eid;
    @Required private String sid;
    @Required private String stat_id;
}
