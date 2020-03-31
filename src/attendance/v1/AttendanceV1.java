/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1;

import attendance.v1.be.User;
import attendance.v1.gui.model.TeacherModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Bruger
 */
public class AttendanceV1 extends Application {
    //private TeacherModel tm;

    /*public AttendanceV1(TeacherModel tm) {
        //this.tm = tm;
    }*/
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("gui/view/logIn.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
   /* public static void main(String[] args) {
        
        launch(args);
        Runnable obj1 = new TeacherModel();
        Thread t1;
        t1 = new Thread(obj1);
        t1.start();
    }*/
    
}
