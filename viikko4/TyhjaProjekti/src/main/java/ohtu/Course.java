package ohtu;

import java.util.ArrayList;
import java.util.List;

public class Course {

    private String name;
    private String term;
    private int week1;
    private int week2;
    private int week3;

    private List<Integer> weeks = new ArrayList<Integer>();

    public void setName(String name) {
        this.name = name;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public void setWeek1(int week1) {
        weeks.add(week1);
        this.week1 = week1;
    }

    public void setWeek2(int week2) {
        weeks.add(week2);
        this.week2 = week2;
    }

    public void setWeek3(int week3) {
        weeks.add(week3);
        this.week3 = week3;
    }

    public String getName() {
        return name;
    }

    public String getTerm() {
        return term;
    }

    public int getWeek1() {
        weeks.add(week1);
        return week1;
    }

    public int getWeek2() {
        weeks.add(week2);
        return week2;
    }

    public int getWeek3() {
        weeks.add(week3);
        return week3;
    }

    public List<Integer> getWeeks() {
        weeks.add(week1);
        weeks.add(week2);
        weeks.add(week3);
        return weeks;
    }

    public void setWeeks(List<Integer> weeks) {
        this.weeks = weeks;
    }

}
