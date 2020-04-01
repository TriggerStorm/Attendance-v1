/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.gui.controller;
import attendance.v1.be.Attendance;
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
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
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
    private boolean cal = false;
    @FXML
    private GridPane gridPane;

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
         String date =  bllu.dateForCalendar(); 
       String[] ymd = date.split(" ");  
       int month = Integer.parseInt(ymd[1]);
        setCalendar(month);
       Bn_gencode.setDisable(true);
       btn_undo.setVisible(false);
       bn_Showcode.setVisible(false);

   

        Lb_loginas.setText(lu.getUserName());
            Lb_logInUser.setText(lu.getUserName());
               Image image3 = new Image(lu.getUserIMG(), 50, 50, false, false);
               Image image2 = new Image(lu.getUserIMG(), 10, 10, false, false);

        miniImg.setImage(image2);
        img.setImage(image3);
       
    }
    private void settingTableView() {
       
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
        bn_Showcode.setVisible(true);
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
        ObservableList<SubjectAttendance> itoList = FXCollections.observableArrayList(bm.getSubjectAttendanceListForAllStudentsInThatSubject(69));
        TBV_monday.setCellValueFactory(new PropertyValueFactory<SubjectAttendance, String>("monday"));
        TBV_tuesday.setCellValueFactory(new PropertyValueFactory<SubjectAttendance, String>("tuesday"));
        tbv_wednesday.setCellValueFactory(new PropertyValueFactory<SubjectAttendance, String>("wednesday"));
        TBV_thursday.setCellValueFactory(new PropertyValueFactory<SubjectAttendance, String>("thursday"));
        TBV_friday.setCellValueFactory(new PropertyValueFactory<SubjectAttendance, String>("friday"));
        TBV_student.setCellValueFactory(new PropertyValueFactory<SubjectAttendance, String>("Name"));
        TBV_Attendance.setCellValueFactory(new PropertyValueFactory<SubjectAttendance, String>("percent"));
        LB_AttendanceRate.setText(bm.getAverageOfAllStudentAttendancesInASubjectAsAString(9));
        Lb_subjet.setText("DB/OS");
        lu.setSelectedSubjectKey(69);
        Bn_gencode.setDisable(false);
       if(!bllu.hasOneDayPass(bm.getLatestSubjectsHeldDate(lu.getSelectedSubjectKey())))
       Bn_gencode.setDisable(true);
       TBV_attendance.setItems(itoList);
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
        bn_Showcode.setVisible(false);
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
        bn_Showcode.setVisible(false);
    }
    private void setCalendar(int month)
    {
         if(!cal) // to make calendar only once unless subject changed
        {
            String date =  bllu.dateForCalendar(); //get current date
       String[] ymd = date.split(" "); // split values from each others
       int year = Integer.parseInt(ymd[2]);
      // int month = Integer.parseInt(ymd[1]);
       int day = Integer.parseInt(ymd[0]); // converting day, month, year from date to ints
       YearMonth yearMonthObject = YearMonth.of(year,month);
       int daysInMonth = yearMonthObject.lengthOfMonth(); // getting how many days is in current month
       int text = 0;
//            int monthFromDb = 0, yearFromDb = 0;
//            ArrayList<Integer> attList = new ArrayList<>();  // list below is list with subjectsHeld for logged student
//      ObservableList<Attendance> list = FXCollections.observableArrayList(bm.getStudentAttendanceForSubject(lu.getUserKey(),lu.getSelectedSubjectKey()));
//       for(int i = 0; i< list.size();i++)
//       {
//         String dayS = list.get(i).getDateHeld();  // getting date as string from list
//         String sub = dayS.substring(0, 10);  //cutting time part
//         String[] oday = sub.split("-");   // again split
//        int onlyday = Integer.parseInt(oday[2]);
//        monthFromDb = Integer.parseInt(oday[1]);
//        yearFromDb = Integer.parseInt(oday[0]);   // again converting date to ints
//        
//           if(month == monthFromDb && year == yearFromDb) // chceck for right month and year from db
//         attList.add(onlyday);  // adding day value to list
//           
//       }
       
       for(int i = 0;i <= daysInMonth/7;i++)
       {
           for(int j = 0;j<= daysInMonth/5;j++)  // creating gridpane 7x5
           {
               
               
                Label[] label = new Label[45];  
                label[text] = new Label();    //  text is used as text for labels as well as number of index for them
                label[text].setText(Integer.toString(text+1)); // creating array of labels with text strarting from 1
                
                StackPane stack = new StackPane();
               gridPane.setStyle("-fx-background-color: black, white ;\n" +   //creating empty gridpane
             "  -fx-background-insets: 0, 1 1 0 0 ;\n" + "-fx-padding: 1 ;\n");
               if(text<daysInMonth)  // adding labels until end of month
                stack.getChildren().add(label[text]);      // adding label to stackpane
                stack.setStyle("-fx-background-color: black, white ;\n" +   // creating empty stackpanes with labels
                "    -fx-background-insets: 0,0 0 1 1 ;");
//                if(text< day-1) // adding absences to ALL days before current day
//                    stack.setStyle("-fx-background-color: black, red ;\n" +
//                "    -fx-background-insets: 0,0 0 1 1 ;");
//                if(text == day && month == monthFromDb)  // change color of current day
//                {
//                gridPane.getChildren().get(text-1).setStyle("-fx-background-color: black, cyan ;\n" +
//"    -fx-background-insets: 0, 0 0 1 1 ;");
//                }
                gridPane.add(stack, j,i); // adding pane with label to gridpane 
                text++;
                
                  
               
           }
        }
//       for(int i = 0; i<attList.size();i++)
//       {
//           int number = attList.get(i);
//           if(number < day-2)  // for every day from list of days from db setting its corresponding pane color to Green
//           gridPane.getChildren().get(number-1).setStyle("-fx-background-color: black, green ;\n" + "    -fx-background-insets: 0, 0 0 1 1 ;");
//           System.out.println(attList.get(i)+"@@@@@@@@");
//       }
       cal = true; 
        }
    }

    @FXML
    private void handle_getUser(MouseEvent event) {
         sa = TBV_attendance.getSelectionModel().getSelectedItem();
         LB_Cprocent.setText(bm.getAverageAttendanceOfAStudentsForAllSubjects(sa.getUserKey()));
         
    }

}
