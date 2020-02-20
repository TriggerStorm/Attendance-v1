/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.gui.controller;

import attendance.v1.be.ScoMok;
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
    private TextField attendance;
    @FXML
    private TableView<ScoMok> TBV_attendance;
    @FXML
    private TableColumn<ScoMok, String> TBV_monday;
    @FXML
    private TableColumn<ScoMok, String> TBV_tuesday;
    @FXML
    private TableColumn<ScoMok, String> tbv_wednesday;
    @FXML
    private TableColumn<ScoMok, String> TBV_thursday;
    @FXML
    private TableColumn<ScoMok, String> TBV_friday;
    @FXML
    private Button Bn_EditOwn;
    @FXML
    private TextField message;
    @FXML
    private TextField message1;
    @FXML
    private TextField TF_code;
    @FXML
    private Button Bn_submit;
    
    private AttendanceModel Am;
    @FXML
    private Label TF_logInAss;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        settingTableView();
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
        TBV_monday.setCellValueFactory(new PropertyValueFactory<>("monday"));
        TBV_tuesday.setCellValueFactory(new PropertyValueFactory<>("tuesday"));
        tbv_wednesday.setCellValueFactory(new PropertyValueFactory<>("wensday"));
        TBV_thursday.setCellValueFactory(new PropertyValueFactory<>("torsdag"));
        TBV_friday.setCellValueFactory(new PropertyValueFactory<>("fredag"));       
                
                
        TBV_attendance.setItems(Am.getScoAttendance());
    }

    @FXML
    private void handle_SDE(ActionEvent event) {
        
        TBV_monday.setCellValueFactory(new PropertyValueFactory<>("monday"));
        TBV_tuesday.setCellValueFactory(new PropertyValueFactory<>("tuesday"));
        tbv_wednesday.setCellValueFactory(new PropertyValueFactory<>("wensday"));
        TBV_thursday.setCellValueFactory(new PropertyValueFactory<>("torsdag"));
        TBV_friday.setCellValueFactory(new PropertyValueFactory<>("fredag"));       
                
                
        TBV_attendance.setItems(Am.getSdeAttendance());
    }

    @FXML
    private void handle_DBOS(ActionEvent event) {
        
        TBV_monday.setCellValueFactory(new PropertyValueFactory<>("monday"));
        TBV_tuesday.setCellValueFactory(new PropertyValueFactory<>("tuesday"));
        tbv_wednesday.setCellValueFactory(new PropertyValueFactory<>("wensday"));
        TBV_thursday.setCellValueFactory(new PropertyValueFactory<>("torsdag"));
        TBV_friday.setCellValueFactory(new PropertyValueFactory<>("fredag"));       
                
                
        TBV_attendance.setItems(Am.getDBOSAttandance());
    }

    @FXML
    private void handle_ITO(ActionEvent event) {
         TBV_monday.setCellValueFactory(new PropertyValueFactory<>("monday"));
        TBV_tuesday.setCellValueFactory(new PropertyValueFactory<>("tuesday"));
        tbv_wednesday.setCellValueFactory(new PropertyValueFactory<>("wensday"));
        TBV_thursday.setCellValueFactory(new PropertyValueFactory<>("torsdag"));
        TBV_friday.setCellValueFactory(new PropertyValueFactory<>("fredag"));       
                
                
        TBV_attendance.setItems(Am.getItoAttandance());
      
    }
    
}
