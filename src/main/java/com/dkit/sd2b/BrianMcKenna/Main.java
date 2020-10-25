package com.dkit.sd2b.BrianMcKenna;

/* Brian McKenna - SD2B - D00197352 */

/* GitHub Repository Link - https://github.com/Brian-McK/JuniorCertGradeProject */

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

    public static int[] selectFiveGrades(int[] codes, int[] allGrades)
    {
        int [] top5grades = new int[5];
        int [] temp = new int[8];

        int top5index = 0;

        for (int i = 0; i < codes.length; i++)
        {
            if (codes[i] == 1 || codes[i] == 2 || codes[i] == 3)
            {
                top5grades[top5index] = allGrades[i];
                top5index++;
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
