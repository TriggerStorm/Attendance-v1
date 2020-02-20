/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.dal;


import attendance.v1.be.SubjectAttendance;

/**
 *
 * @author admin
 */
public class MockTester {
    public static MockDao mockdao = new MockDao();
    public static SubjectAttendance mockSA;
    public int mocktest;
        
    
    
 public static void main(String[] args) {
     toRun();
 }
 
 
 
    public static void toRun() {
        int count = mockdao.mockPrintOut();
        System.out.println("courses = " + count);
    }
    
    
}
