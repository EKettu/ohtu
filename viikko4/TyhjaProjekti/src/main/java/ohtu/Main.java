package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {

        String studentNr = "01234567";
        if (args.length > 0) {
            studentNr = args[0];
        }

        String url = "http://ohtustats2017.herokuapp.com/students/" + studentNr + "/submissions";

        String url2 = "https://ohtustats2017.herokuapp.com/courses/1.json/";

        String bodyText = Request.Get(url).execute().returnContent().asString();
        String bodyText2 = Request.Get(url2).execute().returnContent().asString();
//
//        System.out.println("json-muotoinen data:");
//        System.out.println(bodyText);
//        System.out.println(bodyText2);

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        Course course = mapper.fromJson(bodyText2, Course.class);

        System.out.println("Kurssi: " + course.getName() + ", " + course.getTerm());
        System.out.println("");
        System.out.println("Opiskelijanumero: " + subs[0].getStudent_number());
        int hours = 0;
        int tasks = 0;
        int week = 0;

        for (Submission submission : subs) {
            submission.printTasks();
            System.out.println("viikko " + submission.getWeek() + ":  tehtyjä tehtäviä yhteensä: " + submission.getTasksSize()
                    + " (maksimi " + course.getWeeks().get(week) + "), aikaa kului " + submission.getHours()
                    + " tuntia, tehdyt tehtävät " + submission.getExercises());
            hours += submission.getHours();
            tasks += submission.getTasksSize();
            week++;
        }
        System.out.println("");
        System.out.println("Yhteensä: " + tasks + " tehtävää " + hours + " tuntia");
    }
}
