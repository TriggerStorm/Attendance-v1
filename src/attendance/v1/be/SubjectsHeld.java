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
public class SubjectsHeld {
    private int skey;
    private String date,sCode;
    public SubjectsHeld(int subjectKey, String subDate, String secretCode)
    {
        this.skey = subjectKey;
        this.sCode = secretCode;
        this.date = subDate;
    }

    public int getSkey() {
        return skey;
    }

    public void setSkey(int skey) {
        this.skey = skey;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getsCode() {
        return sCode;
    }

    public void setsCode(String sCode) {
        this.sCode = sCode;
    }
    
}
 