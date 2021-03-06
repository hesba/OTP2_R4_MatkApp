/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.r4.matkapp.mvc.controller.dbmanager;

import com.r4.matkapp.dao.UserDAO;
import com.r4.matkapp.mvc.model.User;

/**
 * Class for managing User Data Access Object
 *
 * @author Eero
 */
public class UserManager extends DatabaseManager<User> {

    /**
     * Creates a Manager with a {@link UserDAO}.
     */
    public UserManager() {
        super(new UserDAO(dbSession.getSessionFactory()));
    }
}
