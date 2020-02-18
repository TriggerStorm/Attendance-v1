/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.be;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Trigger
 */
public class User {
    private final IntegerProperty userkey = new SimpleIntegerProperty();
    private final StringProperty username = new SimpleStringProperty();
    private final StringProperty password = new SimpleStringProperty();
    private final StringProperty email = new SimpleStringProperty();
    private final StringProperty phonenr = new SimpleStringProperty();
    private final StringProperty address = new SimpleStringProperty();
    private final StringProperty teacher = new SimpleStringProperty();
    private final StringProperty userimg = new SimpleStringProperty();

    
    
    public int getuserkey() {
        return userkey.get();
    }

    public String getusername() {
        return username.get();
    }
    
    public String getpassword() {
        return password.get();
    }
    
    public String getemail() {
        return email.get();
    }
    
    public String getphonenr() {
        return phonenr.get();
    }
    
    public String getaddress() {
        return address.get();
    }
    
    public String getteacher() {
        return teacher.get();
    }

    public String getuserimg() {
        return userimg.get();
    }

}
