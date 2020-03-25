/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Default;

import attendance.v1.bll.BllManager;
import attendance.v1.gui.model.UserModel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cille
 */
public class TestLoginAddAndEditUser {
    UserModel um;
    
    public TestLoginAddAndEditUser() {
        this.um = new UserModel();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void testLogin() {
        assertEquals(1, um.CheckUser("cmedgewick0@i2i.jp", "UzF3TMVo" )); //testing that it returns a one for a teacher login
        assertEquals(2, um.CheckUser("pfilipputti3@google.pl", "Ss9Mwkug9g" )); ///testing that it returns a 2 for a student login
        assertEquals(0, um.CheckUser("pfilipputti3@google.pl", "123456789" )); //testing that it returns a 0 for a false password
        assertEquals(0, um.CheckUser("pfilipputti3@goooogle.pl", "123456789" )); //testing that it returns a 0 for a false email
    }
    
    
}
