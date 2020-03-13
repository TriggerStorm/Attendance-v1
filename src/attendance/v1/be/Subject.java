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
    private int subjectKey;
    private String subjectName;
    private String subjectIMG;
    private String associatedCourse;
    private String associatedTeacher;
    
    
    public Subject (int classKey, String className,String ClassIMG, String associatedCourse, String associatedTeacher ){
    
        this.subjectKey = classKey;
        this.subjectName = className;
        this.subjectIMG = subjectIMG;
        this.associatedCourse = associatedCourse;
        this.associatedTeacher = associatedTeacher;
        
    }

    public int getClassKey() {
        return subjectKey;
    }

    public void setClassKey(int classKey) {
        this.subjectKey = classKey;
    }

    public String getClassName() {
        return subjectName;
    }

    public void setClassName(String className) {
        this.subjectName = className;
    }

    public String getClassIMG() {
        return subjectIMG;
    }

    public void setClassIMG(String ClassIMG) {
        this.subjectIMG = ClassIMG;
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
