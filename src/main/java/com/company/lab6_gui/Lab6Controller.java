package com.company.lab6_gui;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Lab6Controller {

    @FXML
    private TextField disciplineCodeTextField;
    @FXML
    private TextField disciplineNameTextField;
    @FXML
    private TextField teacherTextField;
    @FXML
    private TextField groupCodeTextField;
    @FXML
    private TextField studentNumberTextField;
    @FXML
    private TextField hoursLectureNumberTextField;
    @FXML
    private TextField hoursPracticeNumberTextField;
    @FXML
    private CheckBox termPaperCheckBox;
    @FXML
    private RadioButton isExamRadioButton;
    @FXML
    private TextArea outputTextArea;

    private final String filename = "savedDisciplines.txt";

    private List<Discipline> getDisciplines(){
        try{
            FileInputStream fileInputStream = new FileInputStream(filename);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (List<Discipline>) objectInputStream.readObject();
        } catch (Exception e) {return new ArrayList<Discipline>();}
    }

    @FXML
    protected void onSaveButtonClick() {
        int studentNumber = 0;
        int hoursLectureNumber = 0;
        int hoursPracticeNumber = 0;
        try{
            studentNumber = Integer.parseUnsignedInt(studentNumberTextField.getText());
        } catch (NumberFormatException e){}
        try{
            hoursLectureNumber = Integer.parseUnsignedInt(hoursLectureNumberTextField.getText());
        } catch (NumberFormatException e){}
        try{
            hoursPracticeNumber = Integer.parseUnsignedInt(hoursPracticeNumberTextField.getText());
        } catch (NumberFormatException e){}

        Discipline discipline = new Discipline(disciplineCodeTextField.getText(),
                disciplineNameTextField.getText(), teacherTextField.getText(),
                groupCodeTextField.getText(), studentNumber, hoursLectureNumber,
                hoursPracticeNumber, termPaperCheckBox.isSelected(), isExamRadioButton.isSelected());
        outputTextArea.setText("Запись сохранена: " + discipline);


        List<Discipline> disciplineList = getDisciplines();

        disciplineList.add(discipline);
        try{
            FileOutputStream outputStream = new FileOutputStream(filename);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(disciplineList);
            objectOutputStream.close();
        } catch (Exception e) {return;}
    }
    @FXML
    protected void findTeacher() {
        List<Discipline> disciplineList = getDisciplines();

        disciplineList = disciplineList.stream().filter((a) -> a.getTeacher().equals(teacherTextField.getText()))
                .toList();

        String rez = "";
        for(Discipline i : disciplineList)
            rez += i + "\n";
        outputTextArea.setText(rez);
    }
    @FXML
    protected void findGroupCode() {
        List<Discipline> disciplineList = getDisciplines();

        disciplineList = disciplineList.stream().filter((a) -> a.getGroupCode().equals(groupCodeTextField.getText()))
                .toList();

        String rez = "";
        for(Discipline i : disciplineList)
            rez += i + "\n";
        outputTextArea.setText(rez);
    }
    @FXML
    protected void findTermPaper() {
        List<Discipline> disciplineList = getDisciplines();

        disciplineList = disciplineList.stream().filter((a) -> a.isTermPaper() == termPaperCheckBox.isSelected())
                .toList();

        String rez = "";
        for(Discipline i : disciplineList)
            rez += i + "\n";
        outputTextArea.setText(rez);
    }
    @FXML
    protected void findIsExam() {
        List<Discipline> disciplineList = getDisciplines();

        disciplineList = disciplineList.stream().filter((a) -> a.isExam() == isExamRadioButton.isSelected())
                .toList();

        String rez = "";
        for(Discipline i : disciplineList)
            rez += i + "\n";
        outputTextArea.setText(rez);
    }
}