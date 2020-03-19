/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.gui.controller;

import attendance.v1.be.LoggedInUser;
import attendance.v1.be.User;
import attendance.v1.dal.UserDBDAO;
import attendance.v1.be.Subject;
import attendance.v1.be.User;
import attendance.v1.bll.BllManager;
import attendance.v1.gui.model.UserModel;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
    private LoggedInUser lu;

    @FXML
    private TextField TF_email;
    @FXML
    private TextField TF_password;
    @FXML
    private JFXButton Bn_login;
    
    private BllManager bllManager;
    private UserModel userModle;
    private User user;
    private UserDBDAO udb;
    private Subject subject;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      lu = LoggedInUser.getInstance();
    }    

    @FXML

    private void handle_login(ActionEvent event) throws IOException, SQLException{
       userModle = new UserModel();
       String loginmail = TF_email.getText().trim();
       String passw = TF_password.getText().trim();
     //  UserDBDAO udb = new UserDBDAO();
//       lu.setEmail(udb.getUserByEmail(loginmail).getEmail());
     //  lu.setUserName(udb.getUserByEmail(loginmail).getUserName());
       int loginstate = userModle.CheckUser(loginmail, passw);//returns an int, as it also checks if it is a teacher or a student.
        switch (loginstate) {
            case 1:  teacherLogin(loginmail, passw); //teacher login needs creation and then place make something like teacherLogin method in stead.

                    break;
            case 2:  studentLogin(loginmail, passw); //student login 
                    
                    break;
            default: System.out.println("Sorry wrong authentication"); //Might want to make a popup here in stead....
       }

    }
    private void studentLogin(String mail, String password) throws IOException
    {
                

        Parent root1;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/attendance/v1/gui/view/Student.fxml"));
        root1 = (Parent) fxmlLoader.load();
        
        fxmlLoader.<StudentController>getController();

        Stage addStage = new Stage();
        Scene addScene = new Scene(root1);

        
        addStage.setScene(addScene);
        addStage.show();
        
        bllManager.getLoggedInUser(TF_email.getText());
        bllManager.getSubjectsOfAStudent(user.getUserKey());
        bllManager.getSpecificSubjects(subject.getSubjectKey());
        
        Stage stage = (Stage) Bn_login.getScene().getWindow();
        stage.close();
        
        
    }


    
    private void teacherLogin(String mail, String password) throws IOException {
        Parent root1;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/attendance/v1/gui/view/Teacher.fxml"));
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
