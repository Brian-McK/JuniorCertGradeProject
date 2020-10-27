package com.dkit.sd2b.BrianMcKenna;

/*
 * @author Brian McKenna - SD2B - D00197352
 * @since 27-10-2020
 * /* GitHub Repository Link - https://github.com/Brian-McK/JuniorCertGradeProject
 */

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class JuniorCertResults
{
    public static void main( String[] args )
    {
        // method call for finding the .txt file and executing the calculations
        readTxtFile("JC_Results.txt");
    }

    /** readTxtFile - Reads in the pathway to the file
     * Within this method, other methods are executed **/

    public static void readTxtFile(String pathname)
    {
        // try find the file, if file not found then catch the error
        try {
            File jcResults = new File(pathname);

            // calling the useDelimiter method on the scanner object with arguments
            Scanner scan = new Scanner(jcResults).useDelimiter("[,\r\n]+");

            // maximum of 8 subjects taken
            int maxSubjects = 8;

            while(scan.hasNext())
            {
                // declare variables for student number / subject codes & results that will reset on every iteration
                int studentNumber = scan.nextInt();
                int [] subjectCodeResults = new int[maxSubjects];
                int [] subjectResults = new int[maxSubjects];

                // initialise the counter
                int i = 0;
                while (i < maxSubjects)
                {
                    // add int value to subjectCodeResults
                    int subjectCode = scan.nextInt();
                    subjectCodeResults[i] = subjectCode;

                    // add int value to subjectResults
                    int result = scan.nextInt();
                    subjectResults[i] = result;

                    i++;
                }

                // call the method selectFiveGrades & store the values in an array
                int [] top5Grades = selectFiveGrades(subjectCodeResults,subjectResults);

                // call the method calculateAverage & store the value in a variable
                double averageGrade = calculateAverage(top5Grades);

                // call the void method for printing the student number & average grade
                printStudentResult(studentNumber,averageGrade);
            }
            // close the stream
            scan.close();
        }
        catch (IOException e)
        {
            // print out the error message if the file wasn't found
            System.out.println("Error - File not found, " + e.getMessage());
        }
    }

    /** selectFiveGrades method selects the top five grades from a set of student results
     * based on conditions that 3 of the subjects are irish / english / maths & also that
     * the subject C.S.P.E is not to be included in the final give grades
     * @param codes is taken from the readTxtFile method
     * @param allGrades is taken from the readTxtFile method
     * @return returns the top 5 grades for the student **/

    public static int[] selectFiveGrades(int[] codes, int[] allGrades)
    {
        // declare arrays
        int [] top5grades = new int[5];
        int [] temp = new int[8];

        // initialise a counter to control the index of the top5Grades
        int top5index = 0;

        for (int i = 0; i < codes.length; i++)
        {
            // irish / english / maths
            if (codes[i] == 1 || codes[i] == 2 || codes[i] == 3)
            {
                // add values from allGrades to top5Grades
                top5grades[top5index] = allGrades[i];

                // increment the counter
                top5index++;
            }
            else {
                // NOT Equal to CSPE
                if(codes[i] != 218)
                {
                    // add to temporary array
                    temp[i] = allGrades[i];
                }
            }
        }

        // sort the temporary array and take the last 2 values and add them to the top5Grades array
        Arrays.sort(temp);
        top5grades[top5grades.length - 1] = temp[temp.length - 1];
        top5grades[top5grades.length - 2] = temp[temp.length - 2];

        // return the finished array
        return top5grades;
    }

    /** calculateAverage method calculates the average grade for the student
     * @param selectedGrades is generated from the selectFiveGrades method
     * @return returns the average grade for the student **/

    public static double calculateAverage(int[] selectedGrades)
    {
        // initialise the sum variable
        int sum = 0;

        // loop through the selectedGrades array and calculate the sum of the 5 subjects using an enhanced for loop
        for (int selectedGrade : selectedGrades)
        {
            sum += selectedGrade;
        }

        // cast to a double, calculate the average and return the value
        return (double) sum / selectedGrades.length;
    }

    /** printStudentResult - prints out the student number and the average
     * result to two decimal places
     * @param studentNumber is taken from the readTxtFile method
     * @param averageResult is generated from the calculateAverage method **/

    public static void printStudentResult(int studentNumber, double averageResult)
    {
        // print out the student number and the average grade to two decimal places
        System.out.printf("StudentNumber: %d - Average Grade: %.2f\n",studentNumber,averageResult);
    }
}
