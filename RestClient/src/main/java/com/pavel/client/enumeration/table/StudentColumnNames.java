package com.pavel.client.enumeration.table;


import com.pavel.client.enumeration.view.ConstForView;

/**
 * enum, содержащий заголовки таблицы
 */
public enum StudentColumnNames {
    ID(ConstForView.ID),
    NAME(ConstForView.NAME),
    SURNAME(ConstForView.SURNAME),
    SECONDNAME(ConstForView.SECONDNAME),
    SEX(ConstForView.SEX),
    FORM(ConstForView.FORM),
    GROUP(ConstForView.GROUP);

    private String name;

    StudentColumnNames(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
