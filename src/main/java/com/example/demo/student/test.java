package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;

public class test {
    /*public static void testt1(Student student, String name){
        if (!student.getName().equals(name)){
            System.out.println("Dung");
        }else {
            System.out.println("Sai");
        }
    }*/
    public static void testt(Student student,String name){

    }
    public static void main(String[] args) {
        Student DH1 = new Student(9L,"DH",
                "KT@123.com",
                LocalDate.of(2000,
                        Month.AUGUST,
                        8)
        );
        //testt1(DH1,"DH");


        /*(DH1,"DH") -> {if (!student.getName().equals(name)){
            System.out.println("Dung");
        }else {
            System.out.println("Sai");
        }} */
    }
}
