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
        Scanner scan = new Scanner(jcResults);

        int [] subjectCodes = {1,2,3,4,5,6,7,8,9,10,11,12,13,27,40,41,42,46,47,48,52,54,57,65,81,82,83,100,106,125,
                126,137,200,217,218,220,221,224,565,569};

        String [] subjectNames = {
                "Irish","English","Mathematics","History","Geography","Classical Studies",
                "AncientGreek","Classical Studies","Hebrew Studies","French","German",
                "Spanish","Italian","Engineering","Typewriting","Art, Craft, Design",
                "Business Studies","Music (JC)","Materials Technology (Wood)","Technical Graphics",
                "Home Economics (JC)","Metalwork","Science (JC - Revised Syllabus)","Technology",
                "Environmental & Social Studies","Irish 2","Irish 1 ","Keyboarding","Classics ",
                "Applied Technology","Wood Technology","Graphics","Project Mathematics",
                "Religious Education (non-exam) ","Civic, Social & Political Education (CSPE)",
                "Religious Education (JC Exam) ","Social, Personal and Health Education (SPHE)",
                "Physical Education (JC)","Jewish Studies","Visual Art "};

        int maxSubjects = 8;

        // TODO: 21/10/2020 - add try / catch 
        // TODO: 21/10/2020 - make a method for the file 
        // TODO: 21/10/2020 - add more records to the results file 

        while(scan.hasNext())
        {
            String [] splitInput = scan.next().split(",");
            String studentNumber = splitInput[0];
            String [] subjectCodeResult = new String[maxSubjects];
            String [] results = new String[maxSubjects];

            int i = 0;
            int j = i + 1;
            int k = 1;

            // 891234,1,65,2,58,3,45,4,60,5,50,12,48,42,42,46,60
            // 783461,3,65,1,58,2,45,125,60,137,68,126,100,57,77,4,60

            while (i < subjectCodeResult.length)
            {
                results[i] = splitInput[j * 2];
                subjectCodeResult[i] = splitInput[k++];
                i++;
                j++;
                k++;
            }

            System.out.println(Arrays.toString(subjectCodeResult));

            System.out.println("Student Number: " + studentNumber + ", Student Results: " + Arrays.toString(results));

        }
    }

    public int[] selectFiveGrades(int[] codes, int[] grades)
    {
        int [] selectedGradeCodes = new int[5];

        for (int i = 0; i < selectedGradeCodes.length; i++)
        {
            for (int j = 0; j < grades.length; j++)
            {

            }
        }

        return selectedGradeCodes;
    }


//    private double calculateAverage( int[] selectedGrades)
//    {
//
//    }

}
