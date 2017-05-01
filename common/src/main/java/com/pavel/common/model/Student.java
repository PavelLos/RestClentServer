package com.pavel.common.model;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Andrey
 */

/**
 * модель студента
 */
@Getter
@Setter
@XmlRootElement
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String midleName;
    private String sex;
    private String form;
    private String group;

    public Student() {
    }

    public Student(String firstName, String lastName, String midleName, String sex, String group, String form){
        this.firstName = firstName;
        this.lastName = lastName;
        this.midleName = midleName;
        this.sex = sex;
        this.group = group;
        this.form = form;
    }

    /**
     * мутод для получения поля студента
     * @param index - номер, поля которого нужно получить 
     * @return
     */
    public Object get(int index) {
        switch (index) {
            case 0:
                return getId();
            case 1:
                return getFirstName();
            case 2:
                return getLastName();
            case 3:
                return getMidleName();
            case 4:
                return getSex();
            case 5:
                return getForm();
            case 6:
                return getGroup();
            default:
                return "";
        }
    }

}
