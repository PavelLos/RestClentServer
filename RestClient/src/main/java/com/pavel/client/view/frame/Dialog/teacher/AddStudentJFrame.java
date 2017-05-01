package com.pavel.client.view.frame.Dialog.teacher;




import com.pavel.client.controller.frame.AddStudentJFrameController;
import com.pavel.client.enumeration.view.ConstForView;
import com.pavel.common.enumiration.FormOfTraining;
import com.pavel.common.enumiration.GroupNumber;
import com.pavel.common.enumiration.StudentSex;
import com.pavel.client.teacher.StudentTable;
import com.pavel.client.view.fields.FieldsStudent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStudentJFrame extends JFrame {
    private FieldsStudent fieldsStudent;
    private AddStudentJFrameController addStudentJFrameController;

    public AddStudentJFrame(StudentTable studentTable) {
        setName(ConstForView.ADD_STUDENT);
        Box box = Box.createVerticalBox();
        fieldsStudent = new FieldsStudent();

        fieldsStudent.studentFIO(box);
        fieldsStudent.studentSex(box);
        fieldsStudent.studentForm(box);
        fieldsStudent.studentGroupNumber(box);
        okCancle(box);

        box.setBorder(new EmptyBorder(12, 12, 12, 12));
        setContentPane(box);
        pack();
        setResizable(false);
        setPreferredSize(new Dimension(600, box.getHeight()));
        setSize(new Dimension(400, box.getHeight() + 20));
        addStudentJFrameController = new AddStudentJFrameController(studentTable);
    }

    private void okCancle(Box box) {
        Box okBox = Box.createHorizontalBox();
        JButton okButton = new JButton(ConstForView.OK);
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = fieldsStudent.getSurnameJTextField().getText();
                String surname = fieldsStudent.getNameJTextField().getText();
                String middleName = fieldsStudent.getMiddlenameJTextField().getText();

                int  sex = StudentSex.valueOf(fieldsStudent.getStudentSexJComboBox().getSelectedItem().toString()).getValue();
                int group = GroupNumber.valueOf(fieldsStudent.getStudentGroupJComboBox().getSelectedItem().toString()).getValue();
                int form = FormOfTraining.valueOf(fieldsStudent.getStudentFormJComboBox().getSelectedItem().toString()).getValue();
                if (!surname.isEmpty() &&
                        !name.isEmpty() &&
                            !middleName.isEmpty()) {

                    addStudentJFrameController.addStudent(name, surname, middleName, sex, form, group);
                    freeJTextField();

                }
            }
        });
        JButton cancelButton = new JButton(ConstForView.CLOSE);
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                freeJTextField();
                dispose();
            }
        });


        okBox.add(Box.createHorizontalGlue());
        okBox.add(okButton);
        okBox.add(Box.createHorizontalStrut(12));
        okBox.add(cancelButton);
        box.add(okBox);
        box.add(Box.createVerticalStrut(12));
        box.add(Box.createHorizontalStrut(24));
    }

    private void freeJTextField() {
        fieldsStudent.getNameJTextField().setText("");
        fieldsStudent.getSurnameJTextField().setText("");
        fieldsStudent.getMiddlenameJTextField().setText("");
    }
}
