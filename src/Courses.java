import java.util.ArrayList;

public class Courses {

    //these are all the variables that can be found in a Courses object
    private String Title;
    private String Subject;
    private String Section;
    private String Type;
    private int Term;
    private int CRN;
    private int Number;
    private double Average;
    private String Instructor;
    public int[] Grades;


    //getter methods for all the variables in a Courses object
    public String getSection() {

        return Section;
    }

    public String getType() {

        return Type;
    }

    public int getTerm() {

        return Term;
    }

    public int getCRN() {

        return CRN;
    }

    public double getAverage() {

        return Average;
    }

    public String getTitle() {

        return Title;
    }

    public String getSubject() {

        return Subject;
    }

    public int getNumber() {

        return Number;
    }

    public String getInstructor() {

        return Instructor;
    }

    public int[] getGrades() {

        return Grades;
    }

    //the following 6 methods all take in an ArrayList of Courses objects
    //and return a filtered ArrayList of courses that meet the specific requirements
    public static ArrayList<Courses> getCourseByDepartment(ArrayList<Courses> courses, String department) {
        ArrayList<Courses> filteredCourses = new ArrayList<Courses>();
        for(int i = 0; i < courses.size(); i++) {
            if(department.equals(courses.get(i).getSubject())) {
                filteredCourses.add(courses.get(i));
            }
        }
        return filteredCourses;
    }

    public static ArrayList<Courses> getCourseByInstructor(ArrayList<Courses> courses, String instructorName) {

        ArrayList <Courses> filteredCourses = new ArrayList<Courses>();
        for(int i = 0; i < courses.size(); i++) {
            if(courses.get(i).getInstructor().contains(instructorName)) {
                filteredCourses.add(courses.get(i));
            }
        }
        return filteredCourses;
    }

    public static ArrayList<Courses> getCourseInRange(ArrayList<Courses> courses, int minClassNumber, int maxClassNumber) {

        ArrayList <Courses> filteredCourses = new ArrayList<Courses>();
        for(int i = 0; i < courses.size(); i++) {
            if(courses.get(i).getNumber() >= minClassNumber && courses.get(i).getNumber() <= maxClassNumber) {
                filteredCourses.add(courses.get(i));
            }
        }
        return filteredCourses;
    }

    public static ArrayList<Courses> getCourseByStudentNumber(ArrayList<Courses> courses, int minStudents, int maxStudents) {

        ArrayList <Courses> filteredCourses = new ArrayList<Courses>();
        for(int i = 0; i < courses.size(); i++) {
            int students = 0;
            for(int j = 0; j < courses.get(i).getGrades().length; j++) {
                students += courses.get(i).getGrades()[j];
            }
            if(students >= minStudents && students <= maxStudents) {
                filteredCourses.add(courses.get(i));
            }
        }
        return filteredCourses;
    }

    public static ArrayList<Courses> getCoursesByAPlusses(ArrayList<Courses> courses, int minNumberOfAPlusses) {

        ArrayList <Courses> filteredCourses = new ArrayList<Courses>();
        for(int i = 0; i < courses.size(); i++) {
            if(courses.get(i).getGrades()[0] >= minNumberOfAPlusses) {
                filteredCourses.add(courses.get(i));
            }
        }
        return filteredCourses;
    }

    public static ArrayList<Courses> getCourseByTitle(ArrayList<Courses> courses, String title) {

        ArrayList <Courses> filteredCourses = new ArrayList<Courses>();
        for(int i = 0; i < courses.size(); i++) {
            if(courses.get(i).getTitle().contains(title)) {
                filteredCourses.add(courses.get(i));
            }
        }
        return filteredCourses;
    }

    //the following 3 methods aggregate data from an inputted array of Courses objects
    //and returns a value (int/double)
    public static int totalStudents(Courses[] courses) {


        int totalStudents = 0;
        for(int i = 0; i < courses.length; i++){
            for(int j = 0; j < courses[i].getGrades().length; j++) {
                totalStudents += courses[i].getGrades()[j];
            }
        }
        return totalStudents;
    }

    public static int studentsInGradeRange(Courses[] courses, String lowGrade, String highGrade) {
        int lowerBound;
        int upperBound;
        if(lowGrade == "A+" || lowGrade == "a+"){
            lowerBound = 0;
        } else if(lowGrade == "A" || lowGrade == "a"){
            lowerBound = 1;
        } else if(lowGrade == "A-" || lowGrade == "a-"){
            lowerBound = 2;
        } else if(lowGrade == "B+" || lowGrade == "b+"){
            lowerBound = 3;
        } else if(lowGrade == "B" || lowGrade == "b"){
            lowerBound = 4;
        } else if(lowGrade == "B-" || lowGrade == "b-"){
            lowerBound = 5;
        } else if(lowGrade == "C+" || lowGrade == "c+"){
            lowerBound = 6;
        } else if(lowGrade == "C" || lowGrade == "c"){
            lowerBound = 7;
        } else if(lowGrade == "C-" || lowGrade == "c-"){
            lowerBound = 8;
        } else if(lowGrade == "D+" || lowGrade == "d+"){
            lowerBound = 9;
        } else if(lowGrade == "D" || lowGrade == "d"){
            lowerBound = 10;
        } else if(lowGrade == "D-" || lowGrade == "d-"){
            lowerBound = 11;
        } else if(lowGrade == "F" || lowGrade == "f"){
            lowerBound = 12;
        } else if(lowGrade == "W" || lowGrade == "w"){
            lowerBound = 13;
        } else {
            lowerBound = -1;
        }

        if(highGrade == "A+" || highGrade == "a+"){
            upperBound = 0;
        } else if(highGrade == "A" || highGrade == "a"){
            upperBound = 1;
        } else if(highGrade == "A-" || highGrade == "a-"){
            upperBound = 2;
        } else if(highGrade == "B+" || highGrade == "b+"){
            upperBound = 3;
        } else if(highGrade == "B" || highGrade == "b"){
            upperBound = 4;
        } else if(highGrade == "B-" || highGrade == "b-"){
            upperBound = 5;
        } else if(highGrade == "C+" || highGrade == "c+"){
            upperBound = 6;
        } else if(highGrade == "C" || highGrade == "c"){
            upperBound = 7;
        } else if(highGrade == "C-" || highGrade == "c-"){
            upperBound = 8;
        } else if(highGrade == "D+" || highGrade == "d+"){
            upperBound = 9;
        } else if(highGrade == "D" || highGrade == "d"){
            upperBound = 10;
        } else if(highGrade == "D-" || highGrade == "d-"){
            upperBound = 11;
        } else if(highGrade == "F" || highGrade == "f"){
            upperBound = 12;
        } else if(highGrade == "W" || highGrade == "w"){
            upperBound = 13;
        } else {
            upperBound = -1;
        }



        int totalStudents = 0;
        for(int i = 0; i < courses.length; i++) {
            for(int j = upperBound; j <= lowerBound; j++) {
                totalStudents += courses[i].getGrades()[j];
            }
        }
        return totalStudents;

    }

    public static double meanOfGrades(Courses[] courses){

        double totalGPA = 0;
        for(int i = 0; i < courses.length; i++) {
            int totalStudents = 0;
            for(int j = 0; j < courses[i].getGrades().length; j++) {
                totalStudents += courses[i].getGrades()[j];
            }
            totalGPA += (totalStudents * courses[i].getAverage());
        }

        double averageGPA = totalGPA / totalStudents(courses);
        return averageGPA;
    }

}
