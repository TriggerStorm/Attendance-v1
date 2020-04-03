/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.gui.controller;
import attendance.v1.be.Absence;
import attendance.v1.be.Attendance;
import attendance.v1.be.LoggedInUser;
import attendance.v1.be.Months;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
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
    @FXML
    private DatePicker datepick;

    private BLLutilities bllu;
    private BllManager bm;
    @FXML
    private AnchorPane pane;
    @FXML
    private GridPane gridPane;
    boolean cal = false;
    @FXML
    private ComboBox<Months> month_box;
    private Months m;
    
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         bllu = new BLLutilities();
         date.setText(bllu.locaDateNowToString());
        String date =  bllu.dateForCalendar(); //get current date
       String[] ymd = date.split(" "); // split values from each others
       int month = Integer.parseInt(ymd[1]);
        Months m = new Months();
        month_box.setItems(m.getList());
        month_box.getSelectionModel().select(month-1); // select current month as default
        month_box.setVisible(false);
                
/*        settingTableView();
         System.out.println("");
                System.out.println("Loggeg in as UserName" + UserDBDAO.loggedInUser.getUserName());
        Lb_logInUser.setText(UserDBDAO.loggedInUser.getUserName());
        TF_logInAss.setText(UserDBDAO.loggedInUser.getUserName());
    }    
     String dateString = "todays date";
     //   date = new JLabel(dateString);
*/      
        
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
    public void handle_DatePick (ActionEvent event) throws IOException {
    //  Shows a DatePicker and passes date picked to the Attendance Model
        Parent root1;  // Student controller
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/attendance/v1/gui/view/Student.fxml"));
        root1 = (Parent) fxmlLoader.load();  // loads StudentController
        fxmlLoader.<StudentController>getController();  // loads StudentController
        Stage datePickerStage = new Stage();  // New new stage for DatePicker
        datePickerStage.setTitle("Enter Day of Absence");  // not working yet
        Scene datePickerScene = new Scene(root1, 400, 400);  // creates datePickerScene
        datePickerScene.getStylesheets().add(getClass().getResource("/attendance/v1/gui/css/Attendance.css").toExternalForm());  // gets Attendance.css
        datePickerStage.setScene(datePickerScene);
     // block out past days. Not workng yet
   /*     final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {
                @Override
                public DateCell call(final DatePicker datePicker) {
                    return new DateCell() {
                        @Override
                        public void updateItem(LocalDate item, boolean empty) {
                            super.updateItem(item, empty);
                           
                            if (item.isBefore(LocalDate.now()));
          //                          checkInDatePicker.getValue().plusDays(1))) 
                            {
                                    setDisable(true);
                                    setStyle("-fx-background-color: #ffc0cb;");
                            }   
                    }
                };
            }
        };
     // end of block out past days.       
   */        datePickerStage.show();  // opens DatePicker
           LocalDate datePicked = datepick.getValue();  // gets DatePicker value
           datePickerStage.close();  // closes DatePicker
           Absence absence = new Absence(lu.getUserKey(), datePicked);
           absence.setStudentKey(lu.getUserKey());
           absence.setDate(datePicked);
           Am.submitAbsence(absence);  //  passes date picked to the Attendance Model
           
           gridPane.getChildren().clear();
           cal = false;
           setCalendar(month_box.getValue().getMonthNumber());
    }
    

    @FXML
    private void handle_SCO(ActionEvent event) throws SQLException {
        lu.setSelectedSubjectKey(1);
       cal = false;
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
        setCalendar(month_box.getValue().getMonthNumber());

    }

    @FXML
    private void handle_SDE(ActionEvent event) throws SQLException {
       lu.setSelectedSubjectKey(5);
       cal = false;
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
       setCalendar(month_box.getValue().getMonthNumber());
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
        cal = false;
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
        setCalendar(month_box.getValue().getMonthNumber());
      

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
           String date =  bllu.dateForCalendar(); 
       String[] ymd = date.split(" ");  
       int month = Integer.parseInt(ymd[1]);
        month_box.setVisible(true);
        setCalendar(month);
       
    }

    @FXML
    private void changeMonth(ActionEvent event) {
        gridPane.getChildren().clear();
        cal = false;
        setCalendar(month_box.getValue().getMonthNumber());
    }
    
    
    private void setCalendar(int month)
    {
         if(!cal) // to make calendar only once unless subject changed
        {
            String date =  bllu.dateForCalendar(); //get current date
       String[] ymd = date.split(" "); // split values from each others
       int year = Integer.parseInt(ymd[2]);
      int monthNow = Integer.parseInt(ymd[1]);
       int day = Integer.parseInt(ymd[0]); // converting day, month, year from date to ints
       YearMonth yearMonthObject = YearMonth.of(year,month);
       int daysInMonth = yearMonthObject.lengthOfMonth(); // getting how many days is in current month
       int text = 0;
            int monthFromDb = 0, yearFromDb = 0;
            ArrayList<Integer> attList = new ArrayList<>();// list below is list with subjectsHeld for logged student
      ObservableList<Attendance> list = FXCollections.observableArrayList(bm.getStudentAttendanceForSubject(lu.getUserKey(),lu.getSelectedSubjectKey()));
       for(int i = 0; i< list.size();i++)
       {
         String dayS = list.get(i).getDateHeld();  // getting date as string from list
         String sub = dayS.substring(0, 10);  //cutting time part
         String[] oday = sub.split("-");   // again split
        int onlyday = Integer.parseInt(oday[2]);
        monthFromDb = Integer.parseInt(oday[1]);
        yearFromDb = Integer.parseInt(oday[0]);   // again converting date to ints
        
           if(month == monthFromDb && year == yearFromDb) // chceck for right month and year from db
         attList.add(onlyday);  // adding day value to list
           
       }
       
       for(int i = 0;i <= daysInMonth/7;i++)
       {
           for(int j = 0;j<= daysInMonth/5;j++)  // creating gridpane 7x5
           {
               String dateTimeString ="";
               if(text<daysInMonth) // process below goal is to get weekday name from string for every day basing on localdatetime
               {  String str = Integer.toString(text+1)+"-"+Integer.toString(month)+"-"+Integer.toString(year); // creating string using selected year month and day
               DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d-M-yyyy",Locale.ENGLISH);
               LocalDateTime localDateTime = LocalDate.parse(str, dtf).atStartOfDay(); // parsing string as  localdate
         DateTimeFormatter formattter = DateTimeFormatter.ofPattern("EEEE");
        String dateTimeStringg = localDateTime.format(formattter);
               dateTimeString = dateTimeStringg;} // getting name of day from date
               
                Label[] weekDay = new Label[45];
                Label[] label = new Label[45];  
                //weekDay[text] = new Label();
                label[text] = new Label();    //  text is used as text for labels as well as number of index for them
                label[text].setText(Integer.toString(text+1)+"\n"+"\n"+"\n"+dateTimeString); // sets day number as label text as well as day name
              //  weekDay[text].setText(dateTimeString);
                StackPane stack = new StackPane();
               gridPane.setStyle("-fx-background-color: black, white ;\n" +   //creating empty gridpane
             "  -fx-background-insets: 0, 1 1 0 0 ;\n" + "-fx-padding: 1 ;\n");
               if(text<daysInMonth)  // adding labels until end of month
                stack.getChildren().add(label[text]); // adding label to stackpane    ,weekDay[text] 
                stack.setStyle("-fx-background-color: black, white ;\n" +   // creating empty stackpanes with labels
                "    -fx-background-insets: 0,0 0 1 1 ;");
                if((monthNow ==month && text< day-1) || (monthNow != month && text<daysInMonth && month < monthNow)) // adding absences to ALL days before current day
                    stack.setStyle("-fx-background-color: black, red ;\n" +
                "    -fx-background-insets: 0,0 0 1 1 ;");
           //     if(text< day-1 && monthNow == month)
            //        stack.setStyle("-fx-background-color: black, red ;\n" +
            //    "    -fx-background-insets: 0,0 0 1 1 ;");
                if(text == day && monthNow == month_box.getValue().getMonthNumber())  // change color of current day
                {
                gridPane.getChildren().get(text-1).setStyle("-fx-background-color: black, cyan ;\n" +
"    -fx-background-insets: 0, 0 0 1 1 ;");
                }
                if(text > day && monthNow == month_box.getValue().getMonthNumber())
                {
                    
                   List<String> absList = bm.getMonthlyAbsencesForAStudent(lu.getUserKey(),month);
                     for(int l = 0;l < absList.size();l++)
                     {
                         if(Integer.toString(text).equals(absList.get(l)))
                    gridPane.getChildren().get(text-1).setStyle("-fx-background-color: black, yellow ;\n" +
"    -fx-background-insets: 0, 0 0 1 1 ;");
                     }
                }
                if(monthNow < month_box.getValue().getMonthNumber())
                {
                      List<String> absList = bm.getMonthlyAbsencesForAStudent(lu.getUserKey(), month);
                     for(int l = 0;l < absList.size();l++)
                     {
                         if(Integer.toString(text).equals(absList.get(l)))
                    gridPane.getChildren().get(text-1).setStyle("-fx-background-color: black, yellow ;\n" +
"    -fx-background-insets: 0, 0 0 1 1 ;");}
                }
                gridPane.add(stack, j,i); // adding pane with label to gridpane 
                text++;
                
                  
               
           }
        }
       for(int i = 0; i<attList.size();i++)
       {
           int number = attList.get(i);
           if(number < day-2 || monthNow != month)  // for every day from list of days from db setting its corresponding pane color to Green
           gridPane.getChildren().get(number-1).setStyle("-fx-background-color: black, green ;\n" + "    -fx-background-insets: 0, 0 0 1 1 ;");
           // System.out.println(attList.get(i)+"@@@@@@@@");
       }
//       if(text > day && monthNow == month_box.getValue().getMonthNumber())
//                {
//                    System.out.println("@@@@@@@@@@@@@@");
//                   List<String> absList = bm.getMonthlyAbsencesForAStudent(text, month);
//                     ArrayList<String> arrlistofOptions = new ArrayList<String>(absList);
//                     for(int l = 0;l < arrlistofOptions.size();l++)
//                     {
//                         System.out.println(Integer.toString(day)+"=======?????"+arrlistofOptions.get(l));
//                         if(Integer.toString(day).equals(arrlistofOptions.get(l)))
//                    gridPane.getChildren().get(text-1).setStyle("-fx-background-color: black, yellow ;\n" +
//"    -fx-background-insets: 0, 0 0 1 1 ;");
//                     }
//                }
//                if(monthNow < month_box.getValue().getMonthNumber())
//                {
//                      List<String> absList = bm.getMonthlyAbsencesForAStudent(text, month);
//                     ArrayList<String> arrlistofOptions = new ArrayList<String>(absList);
//                     for(int l = 0;l < arrlistofOptions.size();l++)
//                     {
//                         if(Integer.toString(day).equals(arrlistofOptions.get(l)))
//                    gridPane.getChildren().get(text-1).setStyle("-fx-background-color: black, yellow ;\n" +
//"    -fx-background-insets: 0, 0 0 1 1 ;");}
//                }
       
       
       
       
       
       
       cal = true; 
        }
    }
    
}
