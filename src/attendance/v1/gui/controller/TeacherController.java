/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.gui.controller;

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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Trigger
 */
public class TeacherController implements Initializable {

    @FXML
    private Label date;
    @FXML
    private Button Bn_EditOwn;
    @FXML
    private AnchorPane header;
    @FXML
    private Label title;
    @FXML
    private Button Bn_SDE;
    @FXML
    private Button Bn_SCO;
    @FXML
    private Button Bn_ITO;
    @FXML
    private Button Bn_DBOS;
    @FXML
    private AnchorPane body1;
    @FXML
    private JFXButton Bn_gencode;
    @FXML
    private TextField attendance;
    @FXML
    private TableView<?> TBV_attendance;
    @FXML
    private TableColumn<?, ?> TBV_student;
    @FXML
    private TableColumn<?, ?> TBV_monday;
    @FXML
    private TableColumn<?, ?> TBV_tuesday;
    @FXML
    private TableColumn<?, ?> tbv_wednesday;
    @FXML
    private TableColumn<?, ?> TBV_thursday;
    @FXML
    private TableColumn<?, ?> TBV_friday;
    @FXML
    private TableColumn<?, ?> TBV_Attendance;
    @FXML
    private Button Bn_user;
    @FXML
    private Label Lb_loginas;
    @FXML
    private Label Lb_logInUser;
    @FXML
    private Label Lb_subjet;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handle_editown(ActionEvent event) throws IOException {
        Parent root1;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/attendance/v1/gui/view/editOwn.fxml"));
        root1 = (Parent) fxmlLoader.load();
        
        fxmlLoader.<StudentController>getController();

        Stage addStage = new Stage();
        Scene addScene = new Scene(root1);

        
        addStage.setScene(addScene);
        addStage.show();
        
        
    }



    @FXML
    private void handle_attendancecode(ActionEvent event) {
    }

    @FXML
    private void Handle_user(ActionEvent event) throws IOException {
        Parent root1;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/attendance/v1/gui/view/user.fxml"));
        root1 = (Parent) fxmlLoader.load();
        
        fxmlLoader.<StudentController>getController();

        Stage addStage = new Stage();
        Scene addScene = new Scene(root1);

        
        addStage.setScene(addScene);
        addStage.show();
        
        
    }
    
}
