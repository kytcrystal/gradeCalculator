package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GradeCalculatorTest {

    @Test
    void fullGradeTest() {
        Grade grade = GradeCalculator.calculateGrade(50,10.0F);
        assertTrue(grade.getApproved());
        assertEquals(30,grade.getNumericGrade());
        assertFalse(grade.getCumLaude());
    }

    @Test
    void minimumPassGradeTest() {
        Grade grade = GradeCalculator.calculateGrade(50,2.0F);
        assertTrue(grade.getApproved());
        assertEquals(18,grade.getNumericGrade());
        assertFalse(grade.getCumLaude());
    }

    

}