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
            int studentNumber = scan.nextInt();
            int [] subjectCodeResults = new int[maxSubjects];
            int [] subjectResults = new int[maxSubjects];

            int i = 0;
            while (i < maxSubjects)
            {
                int subjectCode = scan.nextInt();
                subjectCodeResults[i] = subjectCode;

                int result = scan.nextInt();
                subjectResults[i] = result;

                i++;
            }

            int [] top5Grades = selectFiveGrades(subjectCodeResults,subjectResults);
            double averageGrade = calculateAverage(top5Grades);

            System.out.printf("StudentNumber: %d, Average Grade: %.2f\n",studentNumber,averageGrade);
        }
        scan.close();
    }

    public static int[] selectFiveGrades(int[] codes, int[] allGrades)
    {
        int [] top5grades = new int[5];
        int [] temp = new int[8];

        for (int i = 0; i < codes.length; i++)
        {
            // irish
            if (codes[i] == 1)
            {
                top5grades[i] = allGrades[i];
            }
            //english
            else if(codes[i] == 2)
            {
                top5grades[i] = allGrades[i];
            }
            // maths
            else if(codes[i] == 3)
            {
                top5grades[i] = allGrades[i];
            }
            else {
                if(codes[i] != 218)
                {
                    temp[i] = allGrades[i];
                }
            }
        }

        Arrays.sort(temp);

        top5grades[top5grades.length - 1] = temp[temp.length - 1];
        top5grades[top5grades.length - 2] = temp[temp.length - 2];

        return top5grades;
    }

    private static double calculateAverage(int[] selectedGrades)
    {
        int sum = 0;

        for (int selectedGrade : selectedGrades)
        {
            sum += selectedGrade;
        }

        return (double) sum / selectedGrades.length;
    }
}
