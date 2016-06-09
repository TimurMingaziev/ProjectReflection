package com.company;

import java.io.Serializable;

/**
 * Created by Home on 09.06.2016.
 */
public class Student extends Schooler implements Serializable {

    private static final Integer stipend = 1000;
    private Boolean studentBook = null;

    public Student(Boolean studentBook,String name, Integer age){
        super(name, age);
        this.studentBook = studentBook;
    }

    public Boolean isStudentBook(){
        if (studentBook)
            return  true;
        else
            return  false;
    }

    public void setStudentBook(Boolean studentBook){
        this.studentBook = studentBook;
    }

    public Integer getStipend(){
        return stipend;
    }

}
