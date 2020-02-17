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
public class Classes {
    private int classkey;
    private String className;
    private String ClassIMG;
    private String associatedCourse;
    private String associatedTeacher;
    
    
    public Classes (int classkey,String className,String ClassIMG,String associatedCourse,String associatedTeacher ){
    
        this.classkey = classkey;
        this.className = className;
        this.ClassIMG = ClassIMG;
        this.associatedCourse = associatedCourse;
        this.associatedTeacher = associatedTeacher;
        
    }

    public int getClasskey() {
        return classkey;
    }

    public void setClasskey(int classkey) {
        this.classkey = classkey;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassIMG() {
        return ClassIMG;
    }

    public void setClassIMG(String ClassIMG) {
        this.ClassIMG = ClassIMG;
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
