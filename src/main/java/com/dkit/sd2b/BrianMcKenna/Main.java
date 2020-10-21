package com.dkit.sd2b.BrianMcKenna;

/* Brian McKenna - SD2B - D00197352 */

/*
 The program should output a list of student numbers and their corresponding calculated average value. e.g. 891234 56.54
 Each line represents one student record.

 Each student will have exactly eight “Code,Mark” pairs. (To reduce complexity)
 Subject Codes may appear in any order for a student record.
 You may assume that the structure of the data in the file is correct (so no need to validate)
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main
{
    public static void main( String[] args ) throws FileNotFoundException
    {
        File jcResults = new File("JC_Results.txt");
        Scanner scan = new Scanner(jcResults).useDelimiter("[,\r\n]+");

        int [] subjectCodes = {1,2,3,4,5,6,7,8,9,10,11,12,13,27,40,41,42,46,47,48,52,54,57,65,81,82,83,100,106,125,
                126,137,200,217,218,220,221,224,565,569};

        int maxSubjects = 8;

        // TODO: 21/10/2020 - add try / catch 
        // TODO: 21/10/2020 - make a method for the file 
        // TODO: 21/10/2020 - add more records to the results file

        while(scan.hasNext())
        {
            int i = 0;
            int studentNumber = scan.nextInt();
            int [] subjectCodeResults = new int[maxSubjects];
            int [] subjectResults = new int[maxSubjects];

            while (i < maxSubjects)
            {
                int subjectCode = scan.nextInt();
                System.out.println("Subject code: " + subjectCode);
                subjectCodeResults[i] = subjectCode;

                int result = scan.nextInt();
                System.out.println("Result: " + result);
                subjectResults[i] = result;

                System.out.println("i: " + i);

                i++;
            }

            System.out.println("studentNumber: " + studentNumber + ", subjectCodeResults: " +
                    Arrays.toString(subjectCodeResults) + ", " + "subjectResults: " + Arrays.toString(subjectResults));

            // 891234,1,65,2,58,3,45,4,60,5,50,12,48,42,42,46,60
            // 783461,3,65,1,58,2,45,125,60,137,68,126,100,57,77,4,60
        }
        scan.close();
    }

    // subject code - 218 - (CSPE) not to be included
    // subject code - 1 - Irish
    // subject code - 2 - English
    // subject code - 3 - Maths

    public int[] selectFiveGrades(int[] codes, int[] allGrades)
    {
        int [] selectedGrades = new int[5];

        for (int i = 0; i < selectedGrades.length; i++)
        {
            for (int j = 0; j < allGrades.length; j++)
            {

            }
        }

        return selectedGrades;
    }

//    private double calculateAverage( int[] selectedGrades)
//    {
//
//    }

}
