/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.gui.controller;

import attendance.v1.be.LoggedInUser;
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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Trigger
 */
public class UserController implements Initializable {

    @FXML
    private TextField TF_email; 
    @FXML
    private Button Bn_ok; // go to edit or new user scean //filp
    @FXML
    private Button Bn_cansel; // done
    private JFXButton bn_edit; // this is a mock butten need to be remove
    private LoggedInUser lu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lu = LoggedInUser.getInstance();
    }    
    public void checkMail(String email) throws IOException{
       String name = TF_email.getText();
       lu.setEmailToCheck(email);
       if( email.equals(name) == email.equals("student@test.com"))
       {
           editUser();
       }
       else
       {
           newUser();
       }
    }
    

    @FXML
    private void handle_ok(ActionEvent event) throws IOException {
      
       String name = TF_email.getText();
       lu.setEmailToCheck(name);
        System.out.println("@@@@@@@@@@@@@@@@"+name);
       checkMail(name);
    }
    
    public void newUser() throws IOException{
    Parent root1;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/attendance/v1/gui/view/newUser.fxml")); // handle_ok and handle_edit need to be 1 butten if email is new new user if its in system edit user scean. //filp
        
        root1 = (Parent) fxmlLoader.load();
        
        fxmlLoader.<StudentController>getController();

        Stage addStage = new Stage();
        Scene addScene = new Scene(root1);

        
        addStage.setScene(addScene);
        addStage.show();
        
        Stage stage = (Stage) Bn_ok.getScene().getWindow();
        stage.close();
    }

    private void editUser() throws IOException {
        Parent root1;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/attendance/v1/gui/view/editUser.fxml")); // if email exsist it need to edit if not have to go to new user scean // filp
        root1 = (Parent) fxmlLoader.load();
        
        fxmlLoader.<StudentController>getController();

        Stage addStage = new Stage();
        Scene addScene = new Scene(root1);

        
        addStage.setScene(addScene);
        addStage.show();
        
        Stage stage = (Stage) bn_edit.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void Handle_cansel(ActionEvent event) {
        Stage stage = (Stage) Bn_cansel.getScene().getWindow();
        stage.close();
    }
    
}
