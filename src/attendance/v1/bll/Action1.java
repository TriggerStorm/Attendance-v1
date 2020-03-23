/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.bll;

import attendance.v1.be.LoggedInUser;
import attendance.v1.gui.model.AttendanceModel;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author macos
 */

public class Action1 implements Action {
    private AttendanceModel Am;
    private BllManager bm;
    private LoggedInUser lu;

    private String name;

    public Action1(String name) {
        lu = LoggedInUser.getInstance();
        this.name = name;
    }

    @Override
    public void execute(String secretCode) {
        bm = new BllManager();
      Am = new AttendanceModel();
       LocalDateTime date = LocalDateTime.now();
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd['T'HH:mm:ss[Z]]");
        String dateString = date.format(formatter);
       lu.setSelectedSubjectsHeld(bm.newSubjectsHeld(lu.getSelectedSubjectKey(),dateString,secretCode)); 
    }

    @Override
    public void undo() {
        bm.deleteSubjectsHeld(lu.getSelectedSubjectsHeld());
    }

    @Override
    public String getName() {
        return this.name;
    }


}