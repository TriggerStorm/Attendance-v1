/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.v1.be;

/**
 *
 * @author Trigger
 */
public class ScoMok {
    private String name;
    private int monday;
    private int tuesday;
    private int wensday;
    private int torsdag;
    private int fredag;
    private int procent;

    public ScoMok(String name,int monday,int tuesday,int wensday,int torsdag,int fredag,int procent) {
        this.name = name;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wensday = wensday;
        this.torsdag = torsdag;
        this.fredag = fredag;
        this.procent= procent;
    }
    
    

    public void setName(String name) {
        this.name = name;
    }

    public void setMonday(int monday) {
        this.monday = monday;
    }

    public void setTuesday(int tuesday) {
        this.tuesday = tuesday;
    }

    public void setWensday(int wensday) {
        this.wensday = wensday;
    }

    public void setTorsdag(int torsdag) {
        this.torsdag = torsdag;
    }

    public void setFredag(int fredag) {
        this.fredag = fredag;
    }

    public void setProcent(int procent) {
        this.procent = procent;
    }

    public String getName() {
        return name;
    }

    public int getMonday() {
        return monday;
    }

    public int getTuesday() {
        return tuesday;
    }

    public int getWensday() {
        return wensday;
    }

    public int getTorsdag() {
        return torsdag;
    }

    public int getFredag() {
        return fredag;
    }

    public int getProcent() {
        return procent;
    }
    
    
    
    
}
