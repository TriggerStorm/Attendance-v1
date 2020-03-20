/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import attendance.v1.be.StudentSubject;
import attendance.v1.dal.StudentSubjectDBDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author admin
 *//**
 *
 * @author admin
 */
public class test {
        private StudentSubjectDBDAO studentSubjectDBDao = new StudentSubjectDBDAO();

    /**
     * @param args the command line arguments
     */
    public  void main(String[] args) throws SQLException {
        System.out.println("hi");
        int userKey = 594;
     List<StudentSubject> listss = studentSubjectDBDao.getSubjectsOfAStudent(userKey);
        System.out.println("list size = "  + listss.size());
    }
    
}
