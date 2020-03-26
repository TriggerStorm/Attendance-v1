/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.gui.controller;
import attendance.v1.be.LoggedInUser;
import attendance.v1.be.SubjectAttendance;
import attendance.v1.bll.BLLutilities;
import attendance.v1.bll.BllManager;
import attendance.v1.bll.CommandManager;
import attendance.v1.dal.DalManager;
import attendance.v1.gui.model.AttendanceModel;
import com.jfoenix.controls.JFXButton;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

    private BllManager bm;
    private BLLutilities bllu;
    private SubjectAttendance sa;
    @FXML
    private JFXButton btn_undo;
    @FXML
    private TableView<?> TBV_attendance1;
    @FXML
    private TableColumn<?, ?> TBV_student1;
    @FXML
    private TableColumn<?, ?> TBV_monday1;
    @FXML
    private TableColumn<?, ?> TBV_tuesday1;
    @FXML
    private TableColumn<?, ?> tbv_wednesday1;
    @FXML
    private TableColumn<?, ?> TBV_thursday1;
    @FXML
    private TableColumn<?, ?> TBV_friday1;
    @FXML
    private TableColumn<?, ?> TBV_Attendance1;

    public CommandManager cm;
    @FXML
    private Label LB_CTxt;
    @FXML
    private Label LB_Cprocent;

    public TeacherController()
    {
        cm = CommandManager.getInstance();
        bllu = new BLLutilities();
        lu = LoggedInUser.getInstance();
        Am = new AttendanceModel();
        bm = new BllManager();
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       Bn_gencode.setDisable(true);
       btn_undo.setVisible(false);
    }
    private void settingTableView() {
        Lb_loginas.setText(lu.getUserName());
            Lb_logInUser.setText(lu.getUserName());
               Image image3 = new Image(lu.getUserIMG(), 50, 50, false, false);
               Image image2 = new Image(lu.getUserIMG(), 10, 10, false, false);

        miniImg.setImage(image2);
        img.setImage(image3);
      if(!bllu.hasOneDayPass(bm.getLatestSubjectsHeldDate(lu.getSelectedSubjectKey())))
       Bn_gencode.setDisable(true);

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
        btn_undo.setVisible(true);
       Bn_gencode.setDisable(true);
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
        ObservableList<SubjectAttendance> scoList = FXCollections.observableArrayList(bm.getSubjectAttendanceListForAllStudentsInThatSubject(1));
        TBV_monday.setCellValueFactory(new PropertyValueFactory<SubjectAttendance, String>("monday"));
        TBV_tuesday.setCellValueFactory(new PropertyValueFactory<SubjectAttendance, String>("tuesday"));
        tbv_wednesday.setCellValueFactory(new PropertyValueFactory<SubjectAttendance, String>("wednesday"));
        TBV_thursday.setCellValueFactory(new PropertyValueFactory<SubjectAttendance, String>("thursday"));
        TBV_friday.setCellValueFactory(new PropertyValueFactory<SubjectAttendance, String>("friday"));
        TBV_student.setCellValueFactory(new PropertyValueFactory<SubjectAttendance, String>("Name"));
        TBV_Attendance.setCellValueFactory(new PropertyValueFactory<SubjectAttendance, String>("percent"));
       // TBV_attendance.setItems(Am.getSCOattendance());
       LB_AttendanceRate.setText(bm.getAverageOfAllStudentAttendancesInASubjectAsAString(1));
       Lb_subjet.setText("SCO");
        lu.setSelectedSubjectKey(1); // YOU NEED TO GIVE SUBJECTS KEY HERE MANUALLY SO IT WONT BE 1 FOR SDE/ITO etc.
       Bn_gencode.setDisable(false);
       if(!bllu.hasOneDayPass(bm.getLatestSubjectsHeldDate(lu.getSelectedSubjectKey())))
       Bn_gencode.setDisable(true);
       TBV_attendance.setItems(scoList);
    }

    @FXML
    private void handle_DBOS(ActionEvent event) {
       /* TBV_monday.setCellValueFactory(new PropertyValueFactory<>("monday"));
        TBV_tuesday.setCellValueFactory(new PropertyValueFactory<>("tuesday"));
        tbv_wednesday.setCellValueFactory(new PropertyValueFactory<>("wednesday"));
        TBV_thursday.setCellValueFactory(new PropertyValueFactory<>("thursday"));
        TBV_friday.setCellValueFactory(new PropertyValueFactory<>("friday"));
        TBV_student.setCellValueFactory(new PropertyValueFactory<>("Name"));
        TBV_Attendance.setCellValueFactory(new PropertyValueFactory<>("percent"));
        Lb_subjet.setText("DB/OS");
        lu.setSelectedSubjectKey(17);
        Bn_gencode.setDisable(false);
       if(!bllu.hasOneDayPass(bm.getLatestSubjectsHeldDate(lu.getSelectedSubjectKey())))
       Bn_gencode.setDisable(true);
       TBV_attendance.setItems(Am.getDBOSattendance()); */
    }

    @FXML
    private void handle_ITO(ActionEvent event) {
        ObservableList<SubjectAttendance> itoList = FXCollections.observableArrayList(bm.getSubjectAttendanceListForAllStudentsInThatSubject(9));
        TBV_monday.setCellValueFactory(new PropertyValueFactory<SubjectAttendance, String>("monday"));
        TBV_tuesday.setCellValueFactory(new PropertyValueFactory<SubjectAttendance, String>("tuesday"));
        tbv_wednesday.setCellValueFactory(new PropertyValueFactory<SubjectAttendance, String>("wednesday"));
        TBV_thursday.setCellValueFactory(new PropertyValueFactory<SubjectAttendance, String>("thursday"));
        TBV_friday.setCellValueFactory(new PropertyValueFactory<SubjectAttendance, String>("friday"));
        TBV_student.setCellValueFactory(new PropertyValueFactory<SubjectAttendance, String>("Name"));
        TBV_Attendance.setCellValueFactory(new PropertyValueFactory<SubjectAttendance, String>("percent"));
        LB_AttendanceRate.setText(bm.getAverageOfAllStudentAttendancesInASubjectAsAString(9));
        Lb_subjet.setText("ITO");
        lu.setSelectedSubjectKey(9);
        Bn_gencode.setDisable(false);
       if(!bllu.hasOneDayPass(bm.getLatestSubjectsHeldDate(lu.getSelectedSubjectKey())))
       Bn_gencode.setDisable(true);
       TBV_attendance.setItems(itoList);
    }

    @FXML
    private void handle_SDE(ActionEvent event) {
        ObservableList<SubjectAttendance> sdeList = FXCollections.observableArrayList(bm.getSubjectAttendanceListForAllStudentsInThatSubject(5));
        TBV_monday.setCellValueFactory(new PropertyValueFactory<SubjectAttendance, String>("monday"));
        TBV_tuesday.setCellValueFactory(new PropertyValueFactory<SubjectAttendance, String>("tuesday"));
        tbv_wednesday.setCellValueFactory(new PropertyValueFactory<SubjectAttendance, String>("wednesday"));
        TBV_thursday.setCellValueFactory(new PropertyValueFactory<SubjectAttendance, String>("thursday"));
        TBV_friday.setCellValueFactory(new PropertyValueFactory<SubjectAttendance, String>("friday"));
        TBV_student.setCellValueFactory(new PropertyValueFactory<SubjectAttendance, String>("Name"));
        TBV_Attendance.setCellValueFactory(new PropertyValueFactory<SubjectAttendance, String>("percent"));
        LB_AttendanceRate.setText(bm.getAverageOfAllStudentAttendancesInASubjectAsAString(5));
        Lb_subjet.setText("SDE");
        lu.setSelectedSubjectKey(5);
        Bn_gencode.setDisable(false);
       if(!bllu.hasOneDayPass(bm.getLatestSubjectsHeldDate(lu.getSelectedSubjectKey())))
       Bn_gencode.setDisable(true);

        TBV_attendance.setItems(sdeList);

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

    @FXML
    private void undo(ActionEvent event) {
        cm.undo();
        btn_undo.setVisible(false);
        Bn_gencode.setDisable(false);
    }

}
