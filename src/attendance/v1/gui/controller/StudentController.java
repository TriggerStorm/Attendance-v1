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
import attendance.v1.dal.StudentSubjectDBDAO;
import attendance.v1.gui.model.AttendanceModel;
import attendance.v1.dal.UserDBDAO;
import static attendance.v1.dal.UserDBDAO.loggedInUser;
import com.jfoenix.controls.JFXButton;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.JLabel;

/**
 * FXML Controller class
 *
 * @author Trigger
 */
public class StudentController implements Initializable {

    int currentSubjectKey;
    
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
    private TableView<SubjectAttendance> TBV_attendance;
    @FXML
    private TableColumn<SubjectAttendance,String> TBV_monday;
    @FXML
    private TableColumn<SubjectAttendance, String> TBV_tuesday;
    @FXML
    private TableColumn<SubjectAttendance, String> tbv_wednesday;
    @FXML
    private TableColumn<SubjectAttendance, String> TBV_thursday;
    @FXML
    private TableColumn<SubjectAttendance, String> TBV_friday;
    
    @FXML
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
  
    private LoggedInUser lu;
    @FXML
    private Label Lb_logInUser;
    @FXML
    private ImageView img;
    @FXML
    private ImageView miniImg;
    private BLLutilities bllu;
    private BllManager bm;
    @FXML
    private AnchorPane pane;
    @FXML
    private GridPane gridPane;
    boolean cal = false;
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
/*        settingTableView();
         System.out.println("");
                System.out.println("Loggeg in as UserName" + UserDBDAO.loggedInUser.getUserName());
        Lb_logInUser.setText(UserDBDAO.loggedInUser.getUserName());
        TF_logInAss.setText(UserDBDAO.loggedInUser.getUserName());
    }    
     String dateString = "todays date";
     //   date = new JLabel(dateString);
*/      
         bllu = new BLLutilities();
            lu = LoggedInUser.getInstance();
         bm = new BllManager();
           // System.out.println(bllu.subjectsForGui().get(1).getSubjectKey());
       
          // LB_AttendanceRate.setText(arg0);
            settingTableView();
            TF_logInAss.setText(lu.getUserName());
            Lb_logInUser.setText(lu.getUserName());
               Image image3 = new Image(lu.getUserIMG(), 50, 50, false, false);
               Image image2 = new Image(lu.getUserIMG(), 10, 10, false, false);
               
        miniImg.setImage(image2);
        img.setImage(image3);
    
        
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
    private void handle_SCO(ActionEvent event) throws SQLException {
        lu.setSelectedSubjectKey(1);

       SubjectAttendance sAttendance = bm.getSubjectAttendanceForAStudent(lu.getUserKey(), 1);
       ObservableList<SubjectAttendance> attendance = FXCollections.observableArrayList(sAttendance);
        TBV_monday.setCellValueFactory(new PropertyValueFactory<SubjectAttendance, String>("monday"));
        TBV_tuesday.setCellValueFactory(new PropertyValueFactory<SubjectAttendance, String>("tuesday"));
        tbv_wednesday.setCellValueFactory(new PropertyValueFactory<SubjectAttendance, String>("wednesday"));
        TBV_thursday.setCellValueFactory(new PropertyValueFactory<SubjectAttendance, String>("thursday"));
        TBV_friday.setCellValueFactory(new PropertyValueFactory<SubjectAttendance, String>("friday"));
//        TBV_tuesday.setCellValueFactory(new PropertyValueFactory<>("tuesday"));
//        tbv_wednesday.setCellValueFactory(new PropertyValueFactory<>("wednesday"));
//        TBV_thursday.setCellValueFactory(new PropertyValueFactory<>("thursday"));
//        TBV_friday.setCellValueFactory(new PropertyValueFactory<>("friday"));
        LB_AttendanceRate.setText(sAttendance.getPercent());
       Lb_subjet.setText("SCO");    
 //      ObservableList<Attendance> list = FXCollections.observableArrayList(bm.getStudentAttendanceForSubject(lu.getUserKey(),bllu.subjectsForGui().get(1).getSubjectKey()));
      //   bm.getStudentAttendanceForSubject(lu.getUserKey(),bllu.subjectsForGui().get(1).getSubjectKey());
        TBV_attendance.setItems(attendance);

    }

    @FXML
    private void handle_SDE(ActionEvent event) throws SQLException {
       lu.setSelectedSubjectKey(5);
        SubjectAttendance sAttendance = bm.getSubjectAttendanceForAStudent(lu.getUserKey(), 5);
       ObservableList<SubjectAttendance> attendance = FXCollections.observableArrayList(sAttendance);
        TBV_monday.setCellValueFactory(new PropertyValueFactory<SubjectAttendance, String>("monday"));
        TBV_tuesday.setCellValueFactory(new PropertyValueFactory<SubjectAttendance, String>("tuesday"));
        tbv_wednesday.setCellValueFactory(new PropertyValueFactory<SubjectAttendance, String>("wednesday"));
        TBV_thursday.setCellValueFactory(new PropertyValueFactory<SubjectAttendance, String>("thursday"));
        TBV_friday.setCellValueFactory(new PropertyValueFactory<SubjectAttendance, String>("friday"));
      //  TBV_tuesday.setCellValueFactory(new PropertyValueFactory<>("tuesday"));
      //  tbv_wednesday.setCellValueFactory(new PropertyValueFactory<>("wednesday"));
      //  TBV_thursday.setCellValueFactory(new PropertyValueFactory<>("thursdag"));
      //  TBV_friday.setCellValueFactory(new PropertyValueFactory<>("friday")); 
  //     ObservableList<Attendance> list = FXCollections.observableArrayList(bm.getStudentAttendanceForSubject(lu.getUserKey(),bllu.subjectsForGui().get(0).getSubjectKey()));
        LB_AttendanceRate.setText(sAttendance.getPercent());
        Lb_subjet.setText("SDE");       
                
       TBV_attendance.setItems(attendance);
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
        lu.setSelectedSubjectKey(9);

        SubjectAttendance sAttendance = bm.getSubjectAttendanceForAStudent(lu.getUserKey(),9);
       ObservableList<SubjectAttendance> attendance = FXCollections.observableArrayList(sAttendance);
        TBV_monday.setCellValueFactory(new PropertyValueFactory<SubjectAttendance, String>("monday"));
        TBV_tuesday.setCellValueFactory(new PropertyValueFactory<SubjectAttendance, String>("tuesday"));
        tbv_wednesday.setCellValueFactory(new PropertyValueFactory<SubjectAttendance, String>("wednesday"));
        TBV_thursday.setCellValueFactory(new PropertyValueFactory<SubjectAttendance, String>("thursday"));
        TBV_friday.setCellValueFactory(new PropertyValueFactory<SubjectAttendance, String>("friday"));
        /*TBV_monday.setCellValueFactory(new PropertyValueFactory<>("monday"));
        TBV_tuesday.setCellValueFactory(new PropertyValueFactory<>("tuesday"));
        tbv_wednesday.setCellValueFactory(new PropertyValueFactory<>("wednesday"));
        TBV_thursday.setCellValueFactory(new PropertyValueFactory<>("thursdag"));
        TBV_friday.setCellValueFactory(new PropertyValueFactory<>("friday"));       
 */       Lb_subjet.setText("ITO");        
        LB_AttendanceRate.setText(sAttendance.getPercent());
        TBV_attendance.setItems(attendance);

      

     }
    
    @FXML
    private void submitAttendance(ActionEvent event)
    {
        String selectedSubject = Lb_subjet.getText();
        String code = TF_code.getText();
        Am.submitAttendance(code, selectedSubject);
        if(lu.getAttendanceSubmitted())
        {
             Alert a = new Alert(AlertType.INFORMATION); 
         a.setContentText("Attendance Submitted");
         a.show();
        }
        else
        {
            Alert a = new Alert(AlertType.INFORMATION); 
         a.setContentText("Error either code is invalid or it expired");
         a.show();
        }
        lu.setBooleanToFalse();
    }

    @FXML
    private void handle_pane(MouseEvent event) {
  
    }

    @FXML
    private void changeView(Event event) throws SQLException {
        if(!cal)
        {
            String date =  bllu.dateForCalendar();
       String[] ymd = date.split(" ");
       int year = Integer.parseInt(ymd[2]);
       int month = Integer.parseInt(ymd[1]);
       int day = Integer.parseInt(ymd[0]);
       YearMonth yearMonthObject = YearMonth.of(year,month);
       int daysInMonth = yearMonthObject.lengthOfMonth();
       int text = 0;
            int monthFromDb, yearFromDb ;
            ArrayList<Integer> attList = new ArrayList<>();
      ObservableList<Attendance> list = FXCollections.observableArrayList(bm.getStudentAttendanceForSubject(lu.getUserKey(),lu.getSelectedSubjectKey()));
       for(int i = 0; i< list.size();i++)
       {
         String dayS = list.get(i).getDateHeld();
         String sub = dayS.substring(0, 10);
         String[] oday = sub.split("-");
        int onlyday = Integer.parseInt(oday[2]);
        monthFromDb = Integer.parseInt(oday[1]);
        yearFromDb = Integer.parseInt(oday[0]);
        
           if(month == monthFromDb && year == yearFromDb)
         attList.add(onlyday);
           
       }
       
       for(int i = 0;i <= daysInMonth/7;i++)
       {
           for(int j = 0;j<= daysInMonth/5;j++)
           {
               
               
                Label[] label = new Label[45];
                label[text] = new Label();
                label[text].setText(Integer.toString(text+1));
                
                StackPane stack = new StackPane();
               gridPane.setStyle("-fx-background-color: black, white ;\n" +
             "  -fx-background-insets: 0, 1 1 0 0 ;\n" + "-fx-padding: 1 ;\n");
               if(text<daysInMonth)
                stack.getChildren().add(label[text]);
                stack.setStyle("-fx-background-color: black, white ;\n" +
                "    -fx-background-insets: 0,0 0 1 1 ;");
                if(text< day-1)
                    stack.setStyle("-fx-background-color: black, red ;\n" +
                "    -fx-background-insets: 0,0 0 1 1 ;");
                if(text == day)
                {
                gridPane.getChildren().get(text-1).setStyle("-fx-background-color: black, cyan ;\n" +
"    -fx-background-insets: 0, 0 0 1 1 ;");
                }
                gridPane.add(stack, j,i);
                text++;
                
                  
               
           }
        }
       for(int i = 0; i<attList.size();i++)
       {
           int number = attList.get(i);
           System.out.println("ELEMENTY LIST "+attList.get(i));
           if(number < day-2)
           gridPane.getChildren().get(number-1).setStyle("-fx-background-color: black, green ;\n" + "    -fx-background-insets: 0, 0 0 1 1 ;");
       }
       cal = true;
        }
    }
    
    
    
}
