/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.be;

/**
 *
 * @author macos
 */
public class StudentSubjects {
    private int Ukey,Skey;
    public StudentSubjects(int Userkey, int Subjectkey)
    {
        this.Ukey = Userkey;
        this.Skey = Subjectkey;
    }
    
    public int getUkey()
    {
        return Ukey;
    }
    public int getSkey()
    {
        return Skey;
    }
}
