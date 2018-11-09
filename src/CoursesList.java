import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoursesList {


    //creates an array of Courses objects by parsing an input string
    public static List<Courses> getCourses(String str) {
        Gson gson = new Gson();

        List<Courses> coursesArray = Arrays.asList(gson.fromJson(str, Courses[].class));
        return coursesArray;
    }

}
