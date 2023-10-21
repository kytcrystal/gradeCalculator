package org.example;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GradeCalculatorTest {

    @Test
    void fullGradeTest() {
        Grade grade = GradeCalculator.computeGrade(50,10.0F);
        assertTrue(grade.getApproved());
        assertEquals(30,grade.getNumericGrade());
        assertFalse(grade.getCumLaude());
    }

    @Test
    void minimumPassGradeTest() {
        Grade grade = GradeCalculator.computeGrade(50,2.0F);
        assertTrue(grade.getApproved());
        assertEquals(18,grade.getNumericGrade());
        assertFalse(grade.getCumLaude());
    }

    @Test
    void zeroGradeTest() {
        Grade grade = GradeCalculator.computeGrade(0,0.0F);
        assertFalse(grade.getApproved());
        assertNull(grade.getNumericGrade());
        assertFalse(grade.getCumLaude());
    }

    @Test
    void cumLaudeGradeTest() {
        Grade grade = GradeCalculator.computeGrade(60,10.0F);
        assertTrue(grade.getApproved());
        assertEquals(30,grade.getNumericGrade());
        assertTrue(grade.getCumLaude());
    }

    @Test
    void exceedingLabPointsWithoutCumLaudeTest() {
        Grade grade = GradeCalculator.computeGrade(60,8.0F);
        assertTrue(grade.getApproved());
        assertEquals(29,grade.getNumericGrade());
        assertFalse(grade.getCumLaude());
    }

    @Test
    void exceedingLabPointsAboveMaximumTest() {
        Grade grade = GradeCalculator.computeGrade(70,6.0F);
        assertTrue(grade.getApproved());
        assertEquals(27,grade.getNumericGrade());
        assertFalse(grade.getCumLaude());
    }

    @Test
    void exceedingLabPointWithCumLaudeTest() {
        Grade grade = GradeCalculator.computeGrade(51,10.0F);
        assertTrue(grade.getApproved());
        assertEquals(30,grade.getNumericGrade());
        assertTrue(grade.getCumLaude());
    }

    @Test
    @Disabled
    void exceedingLabPointWithoutCumLaudeTest() {
        Grade grade = GradeCalculator.computeGrade(51,8.0F);
        assertTrue(grade.getApproved());
        assertEquals(27,grade.getNumericGrade());
        assertFalse(grade.getCumLaude());
    }


}