/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.gui.controller;

import attendance.v1.be.User;
import attendance.v1.gui.model.UserModel;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Trigger
 */
public class LogInController implements Initializable {

    @FXML
    private TextField TF_email;
    @FXML
    private TextField TF_password;
    @FXML
    private JFXButton Bn_login;

    private UserModel userModle;
    private User user;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handle_login(ActionEvent event) throws IOException{
       userModle = new UserModel();
       String loginmail = TF_email.getText().trim();
       String passw = TF_password.getText().trim();
       int loginstate = userModle.CheckUser(loginmail, passw);//THIS line won't work for some reason, but i can't work out why, causes NullPointerException.
       if(loginstate==1){
           login(loginmail, passw);
       }
       
       else if(loginstate==2) {
           login(loginmail,passw);
       }
       else
        {
           System.out.println("Sorry wrong authentication");
        }
       
  /*     switch (loginstate) {
            case 1:  login(loginmail, passw);
                    break;
            case 2:  login(loginmail, passw);
                    break;
            case 3: System.out.println("Sorry wrong authentication");
                    break;
            
            default: System.out.println("Sorry wrong authentication");
       }*/

    }
    private void login(String mail, String password) throws IOException
    {
                
        Parent root1;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/attendance/v1/gui/view/Student.fxml"));
        root1 = (Parent) fxmlLoader.load();
        
        fxmlLoader.<StudentController>getController();

        Stage addStage = new Stage();
        Scene addScene = new Scene(root1);

        
        addStage.setScene(addScene);
        addStage.show();
        
        Stage stage = (Stage) Bn_login.getScene().getWindow();
        stage.close();
    }
}
