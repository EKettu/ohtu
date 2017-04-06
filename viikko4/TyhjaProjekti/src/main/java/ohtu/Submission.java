package ohtu;

import java.util.ArrayList;
import java.util.List;

public class Submission {

    private String student_number;
    private int week;
    private int hours;

    private List<Boolean> tasks = new ArrayList<Boolean>();
    private String exercises = "";

    private boolean a1;
    private boolean a2;
    private boolean a3;
    private boolean a4;
    private boolean a5;
    private boolean a6;
    private boolean a7;
    private boolean a8;
    private boolean a9;
    private boolean a10;
    private boolean a11;
    private boolean a12;

    public void isA1() {
        if (a1) {
            tasks.add(a1);
            exercises += "1 ";
        }
    }

    public void isA2() {
        if (a2) {
            tasks.add(a2);
            exercises += "2 ";
        }
    }

    public void isA3() {
        if (a3) {
            tasks.add(a3);
            exercises += "3 ";
        }
    }

    public void isA4() {
        if (a4) {
            tasks.add(a4);
            exercises += "4 ";
        }
    }

    public void isA5() {
        if (a5) {
            tasks.add(a5);
            exercises += "5 ";
        }
    }

    public void isA6() {
        if (a6) {
            tasks.add(a6);
            exercises += "6 ";
        }
    }

    public void isA7() {
        if (a7) {
            tasks.add(a7);
            exercises += "7 ";
        }
    }

    public void isA8() {
        if (a8) {
            tasks.add(a8);
            exercises += "8 ";
        }
    }

    public void isA9() {
        if (a9) {
            tasks.add(a9);
            exercises += "9 ";
        }
    }

    public void isA10() {
        if (a10) {
            tasks.add(a10);
            exercises += "10 ";
        }
    }

    public void isA11() {
        if (a11) {
            tasks.add(a11);
            exercises += "11 ";
        }
    }

    public void isA12() {
        if (a12) {
            tasks.add(a12);
            exercises += "12 ";
        }
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setA1(boolean a1) {
        this.a1 = a1;
    }

    public void setA2(boolean a2) {
        this.a2 = a2;
    }

    public void setA3(boolean a3) {
        this.a3 = a3;
    }

    public void setA4(boolean a4) {
        this.a4 = a4;
    }

    public void setA5(boolean a5) {
        this.a5 = a5;
    }

    public void setA6(boolean a6) {
        this.a6 = a6;
    }

    public void setA7(boolean a7) {
        this.a7 = a7;
    }

    public void setA8(boolean a8) {
        this.a8 = a8;
    }

    public void setA9(boolean a9) {
        this.a9 = a9;
    }

    public void setA10(boolean a10) {
        this.a10 = a10;
    }

    public void setA11(boolean a11) {
        this.a11 = a11;
    }

    public void setA12(boolean a12) {
        this.a12 = a12;
    }

    public String getStudent_number() {
        return student_number;
    }

    public int getWeek() {
        return week;
    }

    public int getHours() {
        return hours;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    public void setWeek(int week) {
        this.week = week;
    }
    
    

    public void printTasks() {
        isA1();
        isA2();
        isA3();
        isA4();
        isA5();
        isA6();
        isA7();
        isA8();
        isA9();
        isA10();
        isA11();
        isA12();
        
       
    }
    
    public String getExercises() {
         return exercises;
    }
    
    public int getTasksSize() {
        return tasks.size();
    }

//    @Override
//    public String toString() {
//     //   String allTasks = printTasks();
//       // return printTasks();
////        return "viikko " + week + ":  tehtyjä tehtäviä yhteensä: " + tasks.size() 
////                + ", aikaa kului " + hours + " tuntia, tehdyt tehtävät " + allTasks;
//    }

}
