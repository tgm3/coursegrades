import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class CoursesTest {

    //this string is used to test the get functions on a singular Courses object
    public static final String EXAMPLE_COURSE = "{ \"CRN\": 29670, \"Subject\": \"ACCY\", \"Number\": 200, \"Title\": " +
            "\"Fundamentals of Accounting\", \"Section\": \"A\", \"Type\": \"LCD\", \"Term\": 120138, \"Instructor\": " +
            "\"Silhan, Peter A\", \"Grades\": [2, 29, 20, 20, 16, 15, 15, 9, 4, 2, 1, 2, 3, 0], \"Average\": 3.02 }";

    //this string is used to test the get functions, filtering methods, and aggregating methods
    //on an array of Courses objects
    public static final String EXAMPLE_COURSES = "[\n" + "{ \"CRN\": 31280, \"Subject\": \"ABE\", \"Number\": 466, \"Title\": " +
            "\"Engineering Off-Road Vehicles\", \"Section\": \"AL1\", \"Type\": \"LEC\", \"Term\": 120138, " +
            "\"Instructor\": \"Hansen, Alan C\", \"Grades\": [0, 6, 13, 6, 4, 2, 2, 3, 0, 0, 1, 0, 0, 0], " +
            "\"Average\": 3.26 },\n" +
            "  { \"CRN\": 57478, \"Subject\": \"ABE\", \"Number\": 488, \"Title\": \"Bioprocessing Biomass for Fuel\", " +
            "\"Section\": \"VS\", \"Type\": \"LEC\", \"Term\": 120138, \"Instructor\": \"Singh, Vijay\", \"Grades\": " +
            "[0, 5, 9, 6, 2, 0, 1, 1, 0, 0, 0, 0, 0, 0], \"Average\": 3.47 },\n" +
            "  { \"CRN\": 29670, \"Subject\": \"ACCY\", \"Number\": 200, \"Title\": \"Fundamentals of Accounting\", " +
            "\"Section\": \"A\", \"Type\": \"LCD\", \"Term\": 120138, \"Instructor\": \"Silhan, Peter A\", \"Grades\": " +
            "[2, 29, 20, 20, 16, 15, 15, 9, 4, 2, 1, 2, 3, 0], \"Average\": 3.02 },\n" +
            "  { \"CRN\": 39539, \"Subject\": \"ACCY\", \"Number\": 200, \"Title\": \"Fundamentals of Accounting\", " +
            "\"Section\": \"B\", \"Type\": \"LCD\", \"Term\": 120138, \"Instructor\": \"Silhan, Peter A\", \"Grades\": " +
            "[0, 23, 25, 27, 23, 20, 9, 3, 4, 1, 6, 1, 0, 0], \"Average\": 3.08 }]";

    public static Courses courses;

    public static Courses[] coursesList;

    //converts the first string "EXAMPLE_COURSE" into a Courses objects
    //and converts the second string "EXAMPLE_COURSES" into an array of Courses objects
    @Before
    public void setUp() throws Exception {
        Gson gson = new Gson();
        courses = gson.fromJson(EXAMPLE_COURSE,Courses.class);
        coursesList = gson.fromJson(EXAMPLE_COURSES, Courses[].class);
    }

    //these test the get functions on a single Courses objects
    @Test
    public void getType() {

        assertEquals("LCD",courses.getType());
    }

   @Test
    public void getSection() {

        assertEquals("A",courses.getSection());
    }

    @Test
    public void getCRN() {

        assertEquals(29670,courses.getCRN());
    }

    @Test
    public void getTerm() {

        assertEquals(120138,courses.getTerm());
    }

    @Test
    public void getTitle() {

        assertEquals("Fundamentals of Accounting",courses.getTitle());
    }

    @Test
    public void getSubject() {

        assertEquals("ACCY",courses.getSubject());
    }

    @Test
    public void getNumber() {

        assertEquals(200,courses.getNumber());
    }

    @Test
    public void getInstructor() {

        assertEquals("Silhan, Peter A",courses.getInstructor());
    }

    @Test
    public void getGrades() {
        int[] testGrades = {2, 29, 20, 20, 16, 15, 15, 9, 4, 2, 1, 2, 3, 0};
        assertArrayEquals(testGrades,courses.getGrades());
    }

    //these test the get functions on an array of Courses objects
    @Test
    public void getTypeFromList() {

        assertEquals("LEC",coursesList[0].getType());
    }

    @Test
    public void getSectionFromList() {

        assertEquals("AL1",coursesList[0].getSection());
    }

    @Test
    public void getCRNFromList() {

        assertEquals(31280,coursesList[0].getCRN());
    }

    @Test
    public void getTermFromList() {

        assertEquals(120138,coursesList[0].getTerm());
    }

    @Test
    public void getTitleFromList() {

        assertEquals("Engineering Off-Road Vehicles",coursesList[0].getTitle());
    }

    @Test
    public void getSubjectFromList() {

        assertEquals("ABE",coursesList[0].getSubject());
    }

    @Test
    public void getNumberFromList() {

        assertEquals(466,coursesList[0].getNumber());
    }

    @Test
    public void getInstructorFromList() {

        assertEquals("Hansen, Alan C",coursesList[0].getInstructor());
    }

    @Test
    public void getGradesFromList() {

        int[] testGrades = {0, 5, 9, 6, 2, 0, 1, 1, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(testGrades,coursesList[1].getGrades());
    }


    //these test the aggregation methods on an array of Courses objects
    @Test
    public void getTotalStudents() {

        assertEquals(341,Courses.totalStudents(coursesList));
    }

    @Test
    public void getTotalStudentsInRange() {

        assertEquals(339,Courses.studentsInGradeRange(coursesList,"w", "A"));
    }

    @Test
    public void getGPA() {

        assertEquals(3.25,Courses.meanOfGrades(coursesList),.25);
    }

    //these test the filtering methods on an array of Courses objects
    //each test creates its own ArrayList and adds the correctly filtered courses to that ArrayList
    //then compares the correct ArrayList to the ArrayList returned by the filtering method
    @Test
    public void getCoursesbySubject() {
        ArrayList<Courses> filteredCourses = new ArrayList<>();
        filteredCourses.add(coursesList[0]);
        filteredCourses.add(coursesList[1]);
        ArrayList<Courses> coursesListArray = new ArrayList<>();
        coursesListArray.addAll(Arrays.asList(coursesList));
        assertArrayEquals(filteredCourses.toArray(),Courses.getCourseByDepartment(coursesListArray, "ABE").toArray());
    }


    @Test
    public void getCoursesbyInstructor() {
        ArrayList<Courses> filteredCourses = new ArrayList<>();
        filteredCourses.add(coursesList[2]);
        filteredCourses.add(coursesList[3]);
        ArrayList<Courses> coursesListArray = new ArrayList<>();
        coursesListArray.addAll(Arrays.asList(coursesList));
        assertArrayEquals(filteredCourses.toArray(),Courses.getCourseByInstructor(coursesListArray,"Silhan").toArray());
    }

    @Test
    public void getCoursesInRange() {
        ArrayList<Courses> filteredCourses = new ArrayList<>();
        filteredCourses.add(coursesList[0]);
        filteredCourses.add(coursesList[1]);
        ArrayList<Courses> coursesListArray = new ArrayList<>();
        coursesListArray.addAll(Arrays.asList(coursesList));
        assertArrayEquals(filteredCourses.toArray(),Courses.getCourseInRange(coursesListArray, 460, 490).toArray());
    }

    @Test
    public void getCoursesByStudentNumber() {
        ArrayList<Courses> filteredCourses = new ArrayList<>();
        filteredCourses.add(coursesList[0]);
        filteredCourses.add(coursesList[2]);
        filteredCourses.add(coursesList[3]);
        ArrayList<Courses> coursesListArray = new ArrayList<>();
        coursesListArray.addAll(Arrays.asList(coursesList));
        assertArrayEquals(filteredCourses.toArray(),courses.getCourseByStudentNumber(coursesListArray, 30, 300).toArray());
    }

    @Test
    public void getCoursesByAPlusses() {
        ArrayList<Courses> filteredCourses = new ArrayList<>();
        filteredCourses.add(coursesList[2]);
        ArrayList<Courses> coursesListArray = new ArrayList<>();
        coursesListArray.addAll(Arrays.asList(coursesList));
        assertArrayEquals(filteredCourses.toArray(),Courses.getCoursesByAPlusses(coursesListArray, 1).toArray());
    }

    @Test
    public void getCoursesByTitle() {
        ArrayList<Courses> filteredCourses = new ArrayList<>();
        filteredCourses.add(coursesList[2]);
        filteredCourses.add(coursesList[3]);
        ArrayList<Courses> coursesListArray = new ArrayList<>();
        coursesListArray.addAll(Arrays.asList(coursesList));
        assertArrayEquals(filteredCourses.toArray(),Courses.getCourseByTitle(coursesListArray, "Accounting").toArray());
    }


}
