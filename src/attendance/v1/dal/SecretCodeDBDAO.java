/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.dal;

import attendance.v1.be.SubjectsHeld;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author macos
 */
public class SecretCodeDBDAO {
    private DBConnection db;
   public SubjectsHeld checkCode(int skey,String scode) throws SQLException, ParseException
   {
       
       db = new DBConnection();
       
       SubjectsHeld subjectHeld = null;
       try(Connection con = db.getConnection()){
           
            String SQLStmt = "SELECT * FROM SUBJECTSHELD WHERE subjectKey = '"+skey+"';";
            
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQLStmt);
            while(rs.next())
            {
                System.out.println("In the while loop");
                int subjectKey = rs.getInt("subjectKey");
                String savedDate = rs.getString("date");
                String secretCode = rs.getString("secretCode");
                
                LocalDateTime dateTimeHeld = stringToLocalDateTime(savedDate);
                LocalDateTime fourHoursAgo = LocalDateTime.now().minusHours(4);
                boolean fourHoursHavePassed = fourHoursAgo.isAfter(dateTimeHeld);
                
                
               /* SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
                Date d = f.parse(savedDate);
                long dateToCompare = d.getTime();             
               // long dateToCompare = Long.parseLong(savedDate);
                long currentDate = new Date().getTime();*/
                if(secretCode.equals(scode) && skey == subjectKey && /*(currentDate + 14400000) < dateToCompare*/ !fourHoursHavePassed)
                {
                    System.out.println("In the if statement");
                    subjectHeld = new SubjectsHeld(subjectKey, savedDate, secretCode);
                    return subjectHeld;
                }
            }
        }
       return subjectHeld;
   }
    
       public static LocalDateTime stringToLocalDateTime(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd['T'HH:mm:ss[Z]]");
        LocalDateTime later = LocalDateTime.parse(dateString, formatter);
        return later;
    }
   
}
