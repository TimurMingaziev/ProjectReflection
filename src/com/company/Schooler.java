package com.company;

import java.io.Serializable;

/**
 * Created by Home on 09.06.2016.
 */
public class Schooler extends  Person implements Serializable {

    private Integer countsOf2 = 0;

    private Integer countsOfCallToParents= 0;



    public Schooler(String name, Integer age) {
        super(name, age);

    }


    public  void cry(){
        System.out.println("schoolkid crying");
    }

    public void setCountsOf2(Integer countsOf2){
        this.countsOf2 = countsOf2;
    }


    public void setCountsOfCallToParents(Integer countsOfCallToParents){
        this.countsOfCallToParents = countsOfCallToParents;
    }

    public Integer getCountsOf2(){
        return countsOf2;
    }

    public  Integer getCountsOfCallToParents(){
        return  countsOfCallToParents;
    }



}
