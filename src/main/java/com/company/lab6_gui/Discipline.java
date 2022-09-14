package com.company.lab6_gui;

import java.io.Serial;
import java.io.Serializable;

public class Discipline implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String disciplineCode;
    private String disciplineName;
    private String teacher;
    private String groupCode;
    private int studentNumber;
    private int hoursLectureNumber;
    private int hoursPracticeNumber;
    private boolean termPaper;
    private boolean isExam;

    public Discipline(String disciplineCode, String disciplineName, String teacher,
                      String groupCode, int studentNumber, int hoursLectureNumber,
                      int hoursPracticeNumber, boolean termPaper, boolean isExam){
        this.disciplineCode = disciplineCode;
        this.disciplineName = disciplineName;
        this.teacher = teacher;
        this.groupCode = groupCode;
        this.studentNumber = studentNumber;
        this.hoursLectureNumber = hoursLectureNumber;
        this.hoursPracticeNumber = hoursPracticeNumber;
        this.termPaper = termPaper;
        this.isExam = isExam;
    }

    public String getDisciplineCode() {
        return disciplineCode;
    }

    public void setDisciplineCode(String disciplineCode) {
        this.disciplineCode = disciplineCode;
    }

    public String getDisciplineName() {
        return disciplineName;
    }

    public void setDisciplineName(String disciplineName) {
        this.disciplineName = disciplineName;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public int getHoursLectureNumber() {
        return hoursLectureNumber;
    }

    public void setHoursLectureNumber(int hoursLectureNumber) {
        this.hoursLectureNumber = hoursLectureNumber;
    }

    public int getHoursPracticeNumber() {
        return hoursPracticeNumber;
    }

    public void setHoursPracticeNumber(int hoursPracticeNumber) {
        this.hoursPracticeNumber = hoursPracticeNumber;
    }

    public boolean isTermPaper() {
        return termPaper;
    }

    public void setTermPaper(boolean termPaper) {
        this.termPaper = termPaper;
    }

    public boolean isExam() {
        return isExam;
    }

    public void setExam(boolean exam) {
        isExam = exam;
    }

    @Override
    public String toString(){
        return disciplineCode + " (" + disciplineName + "). Преподаватель: " + teacher + ". Код группы: "
                + groupCode + ", " + studentNumber + " студентов, " + hoursLectureNumber + " часов лекций, "
                + hoursLectureNumber + " часов практик, " + (termPaper? "есть курсовая работа, ": "нет курсовой работы, ")
                + (isExam? "экзамен.": "зачет.");
    }
}
