package com.dkit.sd2b.BrianMcKenna;

/* Brian McKenna - SD2B - D00197352 */

/* GitHub Repository Link - https://github.com/Brian-McK/JuniorCertGradeProject */

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
    public void calculateAverageTest1()
    {
        System.out.println("Test 1 calculateAverage");
        int [] top5Grades = {50,100,90,75,40};
        double expectedResult = 71;
        double actualResult = JuniorCertResults.calculateAverage(top5Grades);
        assertEquals(expectedResult,actualResult,0.01);
    }

    @Test
    public void calculateAverageTest2()
    {
        System.out.println("Test 2 calculateAverage");
        int [] top5Grades = {20,30,0,39,20};
        double expectedResult = 21.8;
        double actualResult = JuniorCertResults.calculateAverage(top5Grades);
        assertEquals(expectedResult,actualResult,0.01);
    }

    @Test
    public void calculateAverageTest3()
    {
        System.out.println("Test 3 calculateAverage");
        int [] top5Grades = {0,0,0,0,100};
        double expectedResult = 20;
        double actualResult = JuniorCertResults.calculateAverage(top5Grades);
        assertEquals(expectedResult,actualResult,0.01);
    }

    @Test
    public void calculateAverageTest4()
    {
        System.out.println("Test 4 calculateAverage");
        int [] top5Grades = {99,99,99,99,100};
        double expectedResult = 99.2;
        double actualResult = JuniorCertResults.calculateAverage(top5Grades);
        assertEquals(expectedResult,actualResult,0.01);
    }
}
