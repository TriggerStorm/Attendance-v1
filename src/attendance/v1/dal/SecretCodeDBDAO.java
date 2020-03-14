/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author macos
 */
public class SecretCodeDBDAO {
    private DBConnection db;
   public boolean checkCode(int skey,int scode) throws SQLException, ParseException
   {
       db = new DBConnection();
       
       try(Connection con = db.getConnection()){
           
            String SQLStmt = "SELECT * FROM SUBJECTSHELD WHERE subjectKey = '"+skey+"';";
            
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQLStmt);
                int subjectKey = rs.getInt("subjectKey");
                String savedDate = rs.getString("date");
                String secretCode = rs.getString("secretCode");
                SimpleDateFormat f = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
                Date d = f.parse(savedDate);
                long dateToCompare = d.getTime();             
               // long dateToCompare = Long.parseLong(savedDate);
                long currentDate = new Date().getTime();
                if(secretCode.equals(scode) && skey == subjectKey && currentDate + 14400000 < dateToCompare)
                    return true;
            }    
       return false;
   }
    
}
