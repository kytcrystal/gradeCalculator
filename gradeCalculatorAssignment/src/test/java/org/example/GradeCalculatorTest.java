package org.example;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GradeCalculatorTest {

    @Test
    void fullGradeTest() throws Exception {
        Grade grade = GradeCalculator.computeGrade(50,10.0F);
        assertTrue(grade.getApproved());
        assertEquals(30,grade.getNumericGrade());
        assertFalse(grade.getCumLaude());
    }

    @Test
    void minimumPassGradeTest() throws Exception {
        Grade grade = GradeCalculator.computeGrade(50,2.0F);
        assertTrue(grade.getApproved());
        assertEquals(18,grade.getNumericGrade());
        assertFalse(grade.getCumLaude());
    }

    @Test
    void zeroGradeTest() throws Exception {
        Grade grade = GradeCalculator.computeGrade(0,0.0F);
        assertFalse(grade.getApproved());
        assertNull(grade.getNumericGrade());
        assertFalse(grade.getCumLaude());
    }

    @Test
    void cumLaudeGradeTest() throws Exception {
        Grade grade = GradeCalculator.computeGrade(60,10.0F);
        assertTrue(grade.getApproved());
        assertEquals(30,grade.getNumericGrade());
        assertTrue(grade.getCumLaude());
    }

    @Test
    void exceedingLabPointsWithoutCumLaudeTest() throws Exception {
        Grade grade = GradeCalculator.computeGrade(60,8.0F);
        assertTrue(grade.getApproved());
        assertEquals(29,grade.getNumericGrade());
        assertFalse(grade.getCumLaude());
    }

    @Test
    void exceedingLabPointsAboveMaximumTest() throws Exception {
        Grade grade = GradeCalculator.computeGrade(70,6.0F);
        assertTrue(grade.getApproved());
        assertEquals(27,grade.getNumericGrade());
        assertFalse(grade.getCumLaude());
    }

    @Test
    void exceedingLabPointWithCumLaudeTest() throws Exception {
        Grade grade = GradeCalculator.computeGrade(51,10.0F);
        assertTrue(grade.getApproved());
        assertEquals(30,grade.getNumericGrade());
        assertTrue(grade.getCumLaude());
    }

    @Test
    void gradeRoundedDownTest() throws Exception {
        Grade grade = GradeCalculator.computeGrade(23,10.0F);
        //finalLabPoints = 6.9, finalGrade = 21.9
        assertTrue(grade.getApproved());
        assertEquals(21,grade.getNumericGrade());
        assertFalse(grade.getCumLaude());
    }

    @Test
    void gradeRoundedNormallyUpTest() throws Exception {
        Grade grade = GradeCalculator.computeGrade(26,10.0F);
        //finalLabPoints = 7.8, finalGrade = 22.8
        assertTrue(grade.getApproved());
        assertEquals(23,grade.getNumericGrade());
        assertFalse(grade.getCumLaude());
    }

    @Test
    void gradeRoundedNormallyDownTest() throws Exception {
        Grade grade = GradeCalculator.computeGrade(27,10.0F);
        //finalLabPoints = 8.1, finalGrade = 23.1
        assertTrue(grade.getApproved());
        assertEquals(23,grade.getNumericGrade());
        assertFalse(grade.getCumLaude());
    }

    @Test
    void gradeRoundedUpTest() throws Exception {
        Grade grade = GradeCalculator.computeGrade(41,10.0F);
        //finalLabPoints = 12.3, finalGrade = 27.3
        assertTrue(grade.getApproved());
        assertEquals(28,grade.getNumericGrade());
        assertFalse(grade.getCumLaude());
    }

    @Test
    @Disabled
    void exceedingLabPointsAboveMaximumWithCumLaudeTest() throws Exception {
        Grade grade = GradeCalculator.computeGrade(66,8.0F);
        assertTrue(grade.getApproved());
        assertEquals(30,grade.getNumericGrade());
        assertTrue(grade.getCumLaude());
    }

    @Test
    @Disabled
    void exceedingLabPointWithoutCumLaudeTest() throws Exception {
        Grade grade = GradeCalculator.computeGrade(51,8.0F);
        assertTrue(grade.getApproved());
        assertEquals(27,grade.getNumericGrade());
        assertFalse(grade.getCumLaude());
    }

    @Test
    void negativeLabPointsTest() {
        assertThrows(Exception.class, () -> {
            GradeCalculator.computeGrade(-1,8.0F);
        });
    }

    @Test
    void negativeExamGradeTest() {
        assertThrows(Exception.class, () -> {
            GradeCalculator.computeGrade(50,-1.0F);
        });

    }

    @Test
    void aboveLimitExamGradeTest() {
        assertThrows(Exception.class, () -> {
            GradeCalculator.computeGrade(10,20.0F);
        });
    }


}