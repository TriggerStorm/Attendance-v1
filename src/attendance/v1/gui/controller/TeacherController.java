/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.gui.controller;
import attendance.v1.be.LoggedInUser;
import attendance.v1.be.SubjectAttendance;
import attendance.v1.gui.model.AttendanceModel;
import com.jfoenix.controls.JFXButton;
import java.io.File;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private TableView<SubjectAttendance> TBV_attendance;
    @FXML
    private TableColumn<SubjectAttendance, String> TBV_student;
    @FXML
    private TableColumn<SubjectAttendance, String> TBV_monday;
    @FXML
    private TableColumn<SubjectAttendance, String> TBV_tuesday;
    @FXML
    private TableColumn<SubjectAttendance, String> tbv_wednesday;
    @FXML
    private TableColumn<SubjectAttendance, String> TBV_thursday;
    @FXML
    private TableColumn<SubjectAttendance, String> TBV_friday;
    @FXML
    private TableColumn<SubjectAttendance, String> TBV_Attendance;
    @FXML
    private Button Bn_user;
    @FXML
    private Label Lb_loginas;
    @FXML
    private Label Lb_logInUser;
    @FXML
    private Label Lb_subjet;
    private AttendanceModel Am;
    @FXML
    private Label LB_AttendanceRate;
    @FXML
    private JFXButton bn_Showcode;
    private LoggedInUser lu;
    @FXML
    private ImageView img;
    @FXML
    private ImageView miniImg;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        settingTableView();
    }    
    private void settingTableView() {
        lu = LoggedInUser.getInstance();
        Am = new AttendanceModel();
        Lb_loginas.setText(lu.getUserName());
            Lb_logInUser.setText(lu.getUserName());
               Image image3 = new Image(lu.getUserIMG(), 50, 50, false, false);
               Image image2 = new Image(lu.getUserIMG(), 10, 10, false, false);
               
        miniImg.setImage(image2);
        img.setImage(image3);
 
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
    private void handle_attendancecode(ActionEvent event) throws IOException {
        Parent root1;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/attendance/v1/gui/view/generatedCode.fxml"));
        root1 = (Parent) fxmlLoader.load();
        
        fxmlLoader.<StudentController>getController();

        Stage addStage = new Stage();
        Scene addScene = new Scene(root1);

        
        addStage.setScene(addScene);
        addStage.show();
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

    @FXML
    private void handle_SCO(ActionEvent event) {
        TBV_monday.setCellValueFactory(new PropertyValueFactory<>("monday"));
        TBV_tuesday.setCellValueFactory(new PropertyValueFactory<>("tuesday"));
        tbv_wednesday.setCellValueFactory(new PropertyValueFactory<>("wednesday"));
        TBV_thursday.setCellValueFactory(new PropertyValueFactory<>("thursday"));
        TBV_friday.setCellValueFactory(new PropertyValueFactory<>("friday"));       
        TBV_student.setCellValueFactory(new PropertyValueFactory<>("Name"));        
        TBV_Attendance.setCellValueFactory(new PropertyValueFactory<>("percent"));        
       // TBV_attendance.setItems(Am.getSCOattendance());
        Lb_subjet.setText("SCO");
    }

    @FXML
    private void handle_DBOS(ActionEvent event) {
        TBV_monday.setCellValueFactory(new PropertyValueFactory<>("monday"));
        TBV_tuesday.setCellValueFactory(new PropertyValueFactory<>("tuesday"));
        tbv_wednesday.setCellValueFactory(new PropertyValueFactory<>("wednesday"));
        TBV_thursday.setCellValueFactory(new PropertyValueFactory<>("thursday"));
        TBV_friday.setCellValueFactory(new PropertyValueFactory<>("friday"));       
        TBV_student.setCellValueFactory(new PropertyValueFactory<>("Name"));        
        TBV_Attendance.setCellValueFactory(new PropertyValueFactory<>("percent"));        
        Lb_subjet.setText("DB/OS");        
       // TBV_attendance.setItems(Am.getDBOSattendance());
    }

    @FXML
    private void handle_ITO(ActionEvent event) {
        TBV_monday.setCellValueFactory(new PropertyValueFactory<>("monday"));
        TBV_tuesday.setCellValueFactory(new PropertyValueFactory<>("tuesday"));
        tbv_wednesday.setCellValueFactory(new PropertyValueFactory<>("wednesday"));
        TBV_thursday.setCellValueFactory(new PropertyValueFactory<>("thursday"));
        TBV_friday.setCellValueFactory(new PropertyValueFactory<>("fredag"));       
        TBV_student.setCellValueFactory(new PropertyValueFactory<>("Name"));        
        TBV_Attendance.setCellValueFactory(new PropertyValueFactory<>("percent"));        
        Lb_subjet.setText("ITO");        
       // TBV_attendance.setItems(Am.getITOattendance());
    }

    @FXML
    private void handle_SDE(ActionEvent event) {
        TBV_monday.setCellValueFactory(new PropertyValueFactory<>("monday"));
        TBV_tuesday.setCellValueFactory(new PropertyValueFactory<>("tuesday"));
        tbv_wednesday.setCellValueFactory(new PropertyValueFactory<>("wednesday"));
        TBV_thursday.setCellValueFactory(new PropertyValueFactory<>("thursday"));
        TBV_friday.setCellValueFactory(new PropertyValueFactory<>("fredag"));       
        TBV_student.setCellValueFactory(new PropertyValueFactory<>("Name"));        
        TBV_Attendance.setCellValueFactory(new PropertyValueFactory<>("percent"));        
        Lb_subjet.setText("SDE");        

        //TBV_attendance.setItems(Am.getSDEattendance());

    }

    @FXML
    private void handle_showcode(ActionEvent event) throws IOException {
        Parent root1;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/attendance/v1/gui/view/generatedCode.fxml"));
        root1 = (Parent) fxmlLoader.load();
        
        fxmlLoader.<StudentController>getController();

        Stage addStage = new Stage();
        Scene addScene = new Scene(root1);

        
        addStage.setScene(addScene);
        addStage.show();
    }
    
}
