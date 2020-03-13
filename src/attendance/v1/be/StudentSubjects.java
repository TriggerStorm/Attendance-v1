/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.be;

/**
 *
 * @author Trigger, Filip, Cecillia and Alan
 */


public class StudentSubjects {
    private int uKey,sKey;
    public StudentSubjects(int userKey, int subjectKey)
    {
        this.uKey = userKey;
        this.sKey = subjectKey;
    }
    
    public int getUkey()
    {
        return uKey;
    }
    public int getSkey()
    {
        return sKey;
    }
}
