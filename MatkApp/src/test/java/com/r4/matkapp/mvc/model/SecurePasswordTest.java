/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.r4.matkapp.mvc.model;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test Class for testing String encryption and user authentication.
 * 
 * @author Eero
 */
public class SecurePasswordTest {
    
    /**
     * Test User authentication method by authenticating User with correct input.
     * 
     * @custom.expectedResult true
     */
    @Test
    public void testAuthenticationSuccesfull() {
        
        SecurePassword sPass = new SecurePassword();
        String password = "";
        String encryptedPass = "";
        
        try {
            String salt = sPass.getNewSalt();
            password = "Password";
            encryptedPass = sPass.generateEncryptedPassword(password, salt);
            User u = new User(salt);
            String email = "email@email.em";
            u.setEmail(email);
            u.setPassword(encryptedPass);
            assertEquals(true,sPass.authenticateUser(u, password));
            
        } catch (Exception ex) {
            Logger.getLogger(SecurePasswordTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * Test User authentication method by authenticating User with incorrect input.
     * 
     * @custom.expectedResult false
     */
    @Test
    public void testAuthenticationFailed() {
        
        SecurePassword sPass = new SecurePassword();
        String password = "";
        String encryptedPass = "";
        
        try {
            String salt = sPass.getNewSalt();
            password = "Password";
            encryptedPass = sPass.generateEncryptedPassword(password, salt);
            password = "WrongPass";
            User u = new User(salt);
            String email = "email@email.em";
            u.setEmail(email);
            u.setPassword(encryptedPass);
            assertEquals(false, sPass.authenticateUser(u, password));
            
        } catch (Exception ex) {
            Logger.getLogger(SecurePasswordTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Test User authentication method by authenticating User with <code>null</code> input.
     * 
     * @custom.expectedResult false
     */
    @Test
    public void testNullUserAuthentication() {
        SecurePassword sPass = new SecurePassword();
        String password = "";
        String encryptedPass = "";
        
        try {
            String salt = sPass.getNewSalt();
            password = "Password";
            encryptedPass = sPass.generateEncryptedPassword(password, salt);
            User u = null;   
            assertEquals(false, sPass.authenticateUser(u, password));
            
        } catch (Exception ex) {
            Logger.getLogger(SecurePasswordTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
