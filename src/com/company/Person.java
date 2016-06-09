package com.company;

import java.io.Serializable;

/**
 * Created by Home on 09.06.2016.
 */
public class Person implements Serializable{

    private String name;
    public Integer age;

    public  Person (String name, Integer age){
        this.name = name;
        this.age = age;

    }

    public String getName() {
        return name;
    }

    public void sayHello() {

        System.out.println("Hello");
    }

    public void takeStep(Integer number){
        System.out.println("took " + number + " steps");
    }

}
