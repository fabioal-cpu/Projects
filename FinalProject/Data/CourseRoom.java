package FinalProject.Data;

import java.util.ArrayList;

/*
Course stands for Class
 */
public class CourseRoom {

    private String nameCourse;
    private Teacher tAssignation;
    private int classRoom;
    private ArrayList<Student> sbyclass;

    public CourseRoom(String nameCourse, int classRoom, Teacher tAssignation, ArrayList sbyclass){
        this.nameCourse = nameCourse;
        this.classRoom = classRoom;
        this.tAssignation = tAssignation;
        this.sbyclass = sbyclass;

    }


    public String getCourse() {
        return nameCourse;
    }

    public void setCourse(String course) {
        this.nameCourse = course;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public Teacher gettAssignation() {
        return tAssignation;
    }

    public void settAssignation(Teacher tAssignation) {
        this.tAssignation = tAssignation;
    }

    public int getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(int classRoom) {
        this.classRoom = classRoom;
    }

    public ArrayList<Student> getSbyclass() {
        return (ArrayList<Student>) sbyclass;
    }

    public void setSbyclass(ArrayList<Student> sbyclass) {
        this.sbyclass = sbyclass;
    }
}
