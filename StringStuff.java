import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
/**
 * String stuff program reads user input from
 * a txt file that has strings in it and then
 * it returns the largest run in the string and
 * displays the result in an output txt file.
 *
 *
 * @author Ketia Gaelle Kaze
 * @version 1.0
 * @since 2022-04-10
 */

class StringStuff {
    /**
     * Creating an empty public constructor.
     *
     */
    public StringStuff() { }

    /**
     * Display the maxRun to the console.
     *
     * @param String passed in
     * return maxRun
     */

    public static int MaxRun(String String) {
        // declare variables
        int count = 1;
        int maxRun;
        char[] StringArray = String.toCharArray();

        // find maximum run
        System.out.println(String);
        if (String.length() >= 1) {
            maxRun = 1;
            for (int charCount = 1; charCount
                    < StringArray.length; charCount++) {
                if (StringArray[charCount] == StringArray[charCount - 1]) {
                    count++;
                    if (count > maxRun) {
                        maxRun = count;
                    }
                } else {
                    count = 1;
                }
            }
        } else {
            maxRun = 0;
        }
        return maxRun;
    }

    /**
     * Main entry to the program.
     *
     * @param args nothing passed in
     *
     *
     */

    public static void main(String[] args) throws IOException {
        // declaring variables
        List<String> listOfStrings = new ArrayList<String>();
        String[] stringsArray;
        String[] resultStringsArray;
        StringBuilder builder = new StringBuilder();
        List<String> resultStrings = new ArrayList<String>();
        try {
            listOfStrings = Files.readAllLines(Paths.get("input.txt"));

        } catch (IOException exception) {
            exception.printStackTrace();
        }

        // transfer the string to an array from their list
        stringsArray = listOfStrings.toArray(new String[0]);
        try {
            // call function
            for (int counter1 = 0; counter1 < stringsArray.length; counter1++) {
                int result = MaxRun(stringsArray[counter1]);
                String resultSentence = "The max run of "
                        + stringsArray[counter1] + " is " + result;
                resultStrings.add(resultSentence);
            }

            // convert the result array to another array
            resultStringsArray = resultStrings.toArray(new String[0]);
            // build a string containing the elements of the array
            for (int counter2 = 0; counter2 
                    < resultStringsArray.length; counter2++) {
                builder.append(resultStringsArray[counter2]);
                builder.append("\n");
            }

            // tranfer the thing to the output file
            BufferedWriter writer = new BufferedWriter(new FileWriter(
                "/home/ubuntu/environment/Assign/Assign-02/"
                + "Assign-02-Java/output.txt"));
            writer.write(builder.toString());
            writer.close();
            System.out.println("Assigned the result to the output file");
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
