/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.gui.controller;

import attendance.v1.bll.BllManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.time.LocalDate;

/**
 * FXML Controller class
 *
 * @author admin
 */


public class DatePickController implements Initializable {

    private BllManager bm;
    private LocalDate dateChosen;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bm = new BllManager();
    }    
    
}
