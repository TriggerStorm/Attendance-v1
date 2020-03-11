/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.dal;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import attendance.v1.be.User;

/**
 *
 * @author admin
 */
public class UserDBDAO {
        private DBConnection dbc;

    
        
    public User getUser() {
        User user = new User();
       return user; 
    }

   
}
