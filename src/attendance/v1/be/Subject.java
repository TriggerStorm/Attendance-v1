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
public class Subject {
    private int classKey;
    private String className;
    private String classIMG;
    private String associatedCourse;
    private String associatedTeacher;
    
    
    public Subject (int classKey, String className,String ClassIMG, String associatedCourse, String associatedTeacher ){
    
        this.classKey = classKey;
        this.className = className;
        this.classIMG = classIMG;
        this.associatedCourse = associatedCourse;
        this.associatedTeacher = associatedTeacher;
        
    }

    public int getClassKey() {
        return classKey;
    }

    public void setClassKey(int classKey) {
        this.classKey = classKey;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassIMG() {
        return classIMG;
    }

    public void setClassIMG(String ClassIMG) {
        this.classIMG = ClassIMG;
    }

    public String getAssociatedCourse() {
        return associatedCourse;
    }

    public void setAssociatedCourse(String associatedCourse) {
        this.associatedCourse = associatedCourse;
    }

    public String getAssociatedTeacher() {
        return associatedTeacher;
    }

    public void setAssociatedTeacher(String associatedTeacher) {
        this.associatedTeacher = associatedTeacher;
    }
    
    
}
