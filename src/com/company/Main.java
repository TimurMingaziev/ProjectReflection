package com.company;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.rmi.runtime.Log;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    private static final Logger LOG = LoggerFactory.getLogger("logfile");

    private static Integer count=100000;

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {

        long estimatedTime=0;
        long startTime = System.nanoTime();

        // Вызов метода обычным способом.
        testNormalMethod();
        estimatedTime = System.nanoTime() - startTime;
        LOG.info("non reflection  Methods=  " + estimatedTime);
        startTime = System.nanoTime();

        // Вызов метода рефлексией.
        testReflectionMethod();
        estimatedTime = System.nanoTime() - startTime;
        LOG.info(" reflection Methods =  " + estimatedTime);
        startTime = System.nanoTime();

        // Создание экземпляра класса Студент обычным способом
        testNormalCreateInst();
        estimatedTime = System.nanoTime() - startTime;
        LOG.info("non reflection instance =  " + estimatedTime);
        startTime = System.nanoTime();

        // Создание экземпляра класса Студент рефлекией
        testReflectionCreateInst();
        estimatedTime = System.nanoTime() - startTime;
        LOG.info("reflection instance =  " + estimatedTime);
        startTime = System.nanoTime();
    }

    public static void testNormalMethod(){

        Person person = new Person(Math.random() + "lol" , (int)Math.random());
        for (int i = 0; i< count;i++) {
            person.takeStep(1);
        }

    }

    public  static void testReflectionMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Person person = new Person(Math.random() + "lol" , (int)Math.random());
        Class c = person.getClass();
        Class[] paramTypes = new Class[] { Integer.class };
        Method method = c.getMethod("takeStep", paramTypes);
        Object[] args = new Object[] { new Integer(1) };


        for (int i = 0; i< count;i++) {
             method.invoke(person, args);
        }
    }

    public static void testNormalCreateInst(){
        for (int i = 0; i< count;i++) {
            new Student(true,Math.random() + "lol", (int)Math.random());
        }
    }

    public  static  void  testReflectionCreateInst() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        Class c = new Student(true,Math.random() + "lol", (int)Math.random()).getClass();
        Class[] paramTypes = new Class[] { Boolean.class, String.class, Integer.class};
        Constructor aConstrct = c.getConstructor(paramTypes);

        for(int i=0; i<count;i++) {
            Student student = (Student) aConstrct.newInstance(false, Math.random() + "lol", (int) Math.random());

        }
    }
}
