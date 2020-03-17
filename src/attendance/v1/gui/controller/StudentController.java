/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.gui.controller;


import attendance.v1.be.SubjectAttendance;
import attendance.v1.gui.model.AttendanceModel;
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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Trigger
 */
public class StudentController implements Initializable {

    @FXML
    private Label date;
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
    private TableView<?> TBV_attendance;
    @FXML
    /*private TableColumn<SubjectAttendance>, String> TBV_monday;
    @FXML
    private TableColumn<SubjectAttendance>, String> TBV_tuesday;
    @FXML
    private TableColumn<SubjectAttendance>, String> tbv_wednesday;
    @FXML
    private TableColumn<SubjectAttendance>, String> TBV_thursday;
    @FXML
    private TableColumn<SubjectAttendance>, String> TBV_friday;*/
    
    private Button Bn_EditOwn;
    @FXML
    private TextField TF_code;
    @FXML
    private Button Bn_submit;
    
    
    @FXML
    private Label TF_logInAss;
    @FXML
    private Label Lb_subjet;
    @FXML
    private Label LB_AttendanceRate;
    
    private AttendanceModel Am;
    
    
    @FXML
    private Label Lb_logInUser;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        settingTableView();
        Lb_logInUser.setText("Student");
        TF_logInAss.setText("Student");
    }    
    private void settingTableView() {
        Am = new AttendanceModel(); 
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
    private void handle_SCO(ActionEvent event) {
       /* TBV_monday.setCellValueFactory(new PropertyValueFactory<>("monday"));
        TBV_tuesday.setCellValueFactory(new PropertyValueFactory<>("tuesday"));
        tbv_wednesday.setCellValueFactory(new PropertyValueFactory<>("wednesday"));
        TBV_thursday.setCellValueFactory(new PropertyValueFactory<>("thursdag"));
        TBV_friday.setCellValueFactory(new PropertyValueFactory<>("fredag"));       
        Lb_subjet.setText("SCO"); */       
                

       // TBV_attendance.setItems(Am.getSCOattendance());

    }

    @FXML
    private void handle_SDE(ActionEvent event) {
        
       /* TBV_monday.setCellValueFactory(new PropertyValueFactory<>("monday"));
        TBV_tuesday.setCellValueFactory(new PropertyValueFactory<>("tuesday"));
        tbv_wednesday.setCellValueFactory(new PropertyValueFactory<>("wednesday"));
        TBV_thursday.setCellValueFactory(new PropertyValueFactory<>("thursdag"));
        TBV_friday.setCellValueFactory(new PropertyValueFactory<>("friday"));       
        Lb_subjet.setText("SDE");      */  
                
       // TBV_attendance.setItems(Am.getSDEattendance());
    }

    @FXML
    private void handle_DBOS(ActionEvent event) {
        
       /* TBV_monday.setCellValueFactory(new PropertyValueFactory<>("monday"));
        TBV_tuesday.setCellValueFactory(new PropertyValueFactory<>("tuesday"));
        tbv_wednesday.setCellValueFactory(new PropertyValueFactory<>("wednesday"));
        TBV_thursday.setCellValueFactory(new PropertyValueFactory<>("thursdag"));
        TBV_friday.setCellValueFactory(new PropertyValueFactory<>("friday"));       
        Lb_subjet.setText("DB/OS");  */      
                

       // TBV_attendance.setItems(Am.getDBOSattendance());

    }

    @FXML
    private void handle_ITO(ActionEvent event) {
        /*TBV_monday.setCellValueFactory(new PropertyValueFactory<>("monday"));
        TBV_tuesday.setCellValueFactory(new PropertyValueFactory<>("tuesday"));
        tbv_wednesday.setCellValueFactory(new PropertyValueFactory<>("wednesday"));
        TBV_thursday.setCellValueFactory(new PropertyValueFactory<>("thursdag"));
        TBV_friday.setCellValueFactory(new PropertyValueFactory<>("friday"));       
        Lb_subjet.setText("ITO");   */     
                
       // TBV_attendance.setItems(Am.getITOattendance());
      

    }
    
}
