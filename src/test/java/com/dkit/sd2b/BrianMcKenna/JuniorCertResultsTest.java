package com.dkit.sd2b.BrianMcKenna;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class JuniorCertResultsTest
{
    @Test
    public void selectFiveGradesTest1()
    {
        System.out.println("Test 1 selectFiveGrades");
        int [] subjectCodes = {1,2,3,4,5,6,7,8};
        int [] results = {0,20,40,50,60,70,80,100};
        int [] expectedResult = {0,20,40,80,100};
        int [] actualResult = JuniorCertResults.selectFiveGrades(subjectCodes,results);
        assertArrayEquals(expectedResult,actualResult);
    }

    @Test
    public void selectFiveGradesTest2()
    {
        System.out.println("Test 2 selectFiveGrades");
        int [] subjectCodes = {218,8,1,3,2,8,7,6};
        int [] results = {100,90,15,50,35,70,95,25};
        int [] expectedResult = {15,50,35,90,95};
        int [] actualResult = JuniorCertResults.selectFiveGrades(subjectCodes,results);
        assertArrayEquals(expectedResult,actualResult);
    }

    @Test
    public void selectFiveGradesTest3()
    {
        System.out.println("Test 3 selectFiveGrades");
        int [] subjectCodes = {10,218,3,5,4,1,27,2};
        int [] results = {20,90,80,30,50,100,99,95};
        int [] expectedResult = {80,100,95,50,99};
        int [] actualResult = JuniorCertResults.selectFiveGrades(subjectCodes,results);
        assertArrayEquals(expectedResult,actualResult);
    }

    @Test
    public void calculateAverage()
    {
    }

    @Test
    public void printStudentResult()
    {
    }


}
