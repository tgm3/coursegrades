import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Data {

    public static final String[] JSON_FILES = {"Fall2013.json", "Fall2014.json", "Spring2013.json",
            "Spring2014.json", "Summer2013.json", "Summer2014.json"};

    /**
     * Return the names of the data files as an ArrayList
     *
     * @return an ArrayList of Strings containing the names of the JSON files
     */
    public static List<String> getJsonFilesAsList() {
        // Arrays is a Java library containing utility functions for working with Java arrays.  We're
        // using the 'asList' method which returns a List interface for an existing array.  We use
        // this to construct an actual ArrayList.  Observant readers might note that this function
        // returns an ArrayList, but the return type of the function is a List.  List is an interface
        // that ArrayList implements; we'll talk about interfaces on Tuesday.
        return new ArrayList<String>(Arrays.asList(JSON_FILES));
    }

    /**
     * This function reads the contents of a file located in the project's 'data' directory into a String
     *
     * @param filename contains the name of file
     * @return a String containing the file's contents
     */
    public static String getFileContentsAsString(String filename) {

        // Java uses Paths as an operating system-independent specification of the location of files.
        // In this case, we're looking for files that are in a directory called 'data' located in the
        // root directory of the project, which is the 'current working directory'.
        final Path path = FileSystems.getDefault().getPath("data", filename);

        try {
            // Read all of the bytes out of the file specified by 'path' and then convert those bytes
            // into a Java String.  Because this operation can fail if the file doesn't exist, we
            // include this in a try/catch block
            return new String(Files.readAllBytes(path));
        } catch (IOException e) {
            // Since we couldn't find the file, there is no point in trying to continue.  Let the
            // user know what happened and exit the run of the program.  Note: we're only exiting
            // in this way because we haven't talked about exceptions and throwing them in CS 126 yet.
            System.out.println("Couldn't find file: " + filename);
            System.exit(-1);
            return null;  // note that this return will never execute, but Java wants it there.
        }
    }
}
