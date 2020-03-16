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

    private int ukey,skey;
    public StudentSubjects(int userKey, int subjectKey)
    {
        this.ukey = userKey;
        this.skey = subjectKey;

    }
    
    public int getUkey()
    {

        return ukey;
    }
    public int getSkey()
    {
        return skey;
    }
    public void setUkey(int userKey)
    {
            this.ukey = userKey;
    }
    public void setSkey(int subjectKey)
    {
        this.skey = subjectKey;

    }
}
