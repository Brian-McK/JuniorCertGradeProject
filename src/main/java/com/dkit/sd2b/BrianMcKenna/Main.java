package com.dkit.sd2b.BrianMcKenna;

/* Brian McKenna - SD2B - D00197352 */

/* GitHub Repository Link - https://github.com/Brian-McK/JuniorCertGradeProject */

/*
 The program should output a list of student numbers and their corresponding calculated average value. e.g. 891234 56.54
 Each line represents one student record.

 Each student will have exactly eight “Code,Mark” pairs. (To reduce complexity)
 Subject Codes may appear in any order for a student record.
 You may assume that the structure of the data in the file is correct (so no need to validate)
*/

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main
{
    public static void main( String[] args )
    {
        readTxtFile("JC_Results.txt");
    }

    public static void readTxtFile(String pathname)
    {
        try {
            File jcResults = new File(pathname);
            Scanner scan = new Scanner(jcResults).useDelimiter("[,\r\n]+");
            int maxSubjects = 8;

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

                printStudentResult(studentNumber,averageGrade);
            }
            scan.close();
        }
        catch (IOException e)
        {
            System.out.println("Error - File not found, " + e.getMessage());
        }
    }

    // TODO: 24/10/2020 - fix logic below - not working properly - last record in txt file throwing an error

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

    public static void printStudentResult(int studentNumber, double averageResult)
    {
        System.out.printf("StudentNumber: %d - Average Grade: %.2f\n",studentNumber,averageResult);
    }
}
