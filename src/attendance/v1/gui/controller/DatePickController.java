/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.gui.controller;

import attendance.v1.be.LoggedInUser;
import attendance.v1.bll.BLLutilities;
import attendance.v1.bll.BllManager;
import attendance.v1.gui.model.AttendanceModel;
import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.skin.DatePickerSkin;
import javafx.stage.Stage;

/**
 *
 * @author admin
 */
public class DatePickController {
    private AttendanceModel Am;
    private BLLutilities bllu;
    private BllManager bm;
    private LoggedInUser lu;

    DatePicker datePick;

       @FXML
    private Button Bn_DatePick;  
        
    
 /*   @FXML
    public void handle_DatePick (ActionEvent event) {  // Probably not needed
   //      public void start(Stage primaryStage) {
        try {
            Parent root1;
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/attendance/v1/gui/view/datePick.fxml"));
            root1 = (Parent) fxmlLoader.load();
            fxmlLoader.<StudentController>getController();
            
            Stage addStage = new Stage();
            Scene addScene = new Scene(root1, 400, 400);
            
            addScene.getStylesheets().add(getClass().getResource("Attendance.css").toExternalForm());
   //         DatePicker datePick = new DatePicker(LocalDate.now());
   DatePickerSkin datePickerSkin = new DatePickerSkin(datePick);
    //        Node popupContent = datePickerSkin.getPopupContent();
             //         root1.setCenter(popupContent);
            addStage.setScene(addScene);
            addStage.show();
            if (datePick.getValue() == null) {

            } else {
           LocalDate datePicked = datePick.getValue();
  //          String datePickedString = bllu.locaDateToString(datePicked);
            
  System.out.println("");
            Am.submitAbsence(lu.getUserKey(), datePicked);
            }
  
   
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }*/
}
