package org.example;

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

}