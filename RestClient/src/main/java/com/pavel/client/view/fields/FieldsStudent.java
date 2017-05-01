package com.pavel.client.view.fields;



import com.pavel.client.enumeration.view.ConstForView;
import com.pavel.common.enumiration.FormOfTraining;
import com.pavel.common.enumiration.GroupNumber;
import com.pavel.common.enumiration.StudentSex;

import javax.swing.*;
import java.awt.*;

public class FieldsStudent {
    private JTextField idJTextField;
    private JTextField nameJTextField;
    private JTextField surnameJTextField;
    private JTextField middlenameJTextField;
    private JComboBox<StudentSex> studentSexJComboBox;
    private JComboBox<GroupNumber> studentGroupJComboBox;
    private JComboBox<FormOfTraining> studentFormJComboBox;

    public FieldsStudent() {

    }

    public void studentID(Box box){
        Box boxTeacherID = Box.createHorizontalBox();
        JLabel teacherIDLabel = new JLabel(ConstForView.ID);
        teacherIDLabel.setPreferredSize(new Dimension(260, teacherIDLabel.getHeight()));
        idJTextField = new JTextField(20);

        boxTeacherID.add(teacherIDLabel);
        boxTeacherID.add(Box.createHorizontalStrut(6));
        boxTeacherID.add(idJTextField);
        box.add(boxTeacherID);
        box.add(Box.createVerticalStrut(8));
    }

    public void studentFIO(Box box){
        Box boxStudentName = Box.createHorizontalBox();
        JLabel studentNameJLabel = new JLabel(ConstForView.FIO);
        studentNameJLabel.setPreferredSize(new Dimension(230, studentNameJLabel.getHeight()));
        nameJTextField = new JTextField(20);
        surnameJTextField = new JTextField(20);
        middlenameJTextField = new JTextField(20);

        boxStudentName.add(studentNameJLabel);
        boxStudentName.add(Box.createHorizontalStrut(6));
        boxStudentName.add(surnameJTextField);
        boxStudentName.add(Box.createHorizontalStrut(6));
        boxStudentName.add(nameJTextField);
        boxStudentName.add(Box.createHorizontalStrut(6));
        boxStudentName.add(middlenameJTextField);
        box.add(boxStudentName);
        box.add(Box.createVerticalStrut(8));
    }

    public void studentSex(Box box) {
        Box boxStudentSex = Box.createHorizontalBox();
        JLabel studentSexLabel = new JLabel(ConstForView.SEX);
        studentSexLabel.setPreferredSize(new Dimension(300, studentSexLabel.getHeight()));
        studentSexJComboBox = new JComboBox<StudentSex>(StudentSex.values());

        boxStudentSex.add(studentSexLabel);
        boxStudentSex.add(Box.createHorizontalStrut(6));
        boxStudentSex.add(studentSexJComboBox);
        box.add(boxStudentSex);
        box.add(Box.createVerticalStrut(8));
    }

    public void studentForm(Box box) {
        Box boxStudentForm = Box.createHorizontalBox();
        JLabel studentFormLabel = new JLabel(ConstForView.FORM);
        studentFormLabel.setPreferredSize(new Dimension(300, studentFormLabel.getHeight()));
        studentFormJComboBox = new JComboBox<FormOfTraining>(FormOfTraining.values());

        boxStudentForm.add(studentFormLabel);
        boxStudentForm.add(Box.createHorizontalStrut(6));
        boxStudentForm.add(studentFormJComboBox);
        box.add(boxStudentForm);
        box.add(Box.createVerticalStrut(8));
    }

    public void studentGroupNumber(Box box) {
        Box boxStudentGroup = Box.createHorizontalBox();
        JLabel studentGroupLabel = new JLabel(ConstForView.GROUP);
        studentGroupLabel.setPreferredSize(new Dimension(300, studentGroupLabel.getHeight()));
        studentGroupJComboBox = new JComboBox<GroupNumber>(GroupNumber.values());

        boxStudentGroup.add(studentGroupLabel);
        boxStudentGroup.add(Box.createHorizontalStrut(6));
        boxStudentGroup.add(studentGroupJComboBox);
        box.add(boxStudentGroup);
        box.add(Box.createVerticalStrut(8));
    }

    public JTextField getIdJTextField() {
        return idJTextField;
    }

    public JTextField getNameJTextField() {
        return nameJTextField;
    }

    public JTextField getSurnameJTextField() {
        return surnameJTextField;
    }

    public JTextField getMiddlenameJTextField() {
        return middlenameJTextField;
    }


    public JComboBox<StudentSex> getStudentSexJComboBox() {
        return studentSexJComboBox;
    }

    public JComboBox<GroupNumber> getStudentGroupJComboBox() {
        return studentGroupJComboBox;
    }

    public JComboBox<FormOfTraining> getStudentFormJComboBox() {
        return studentFormJComboBox;
    }
}
