package org.example;

public class GradeCalculator {

    public static Grade calculateGrade(int labPoints, float examGrade) {
        Grade grade = new Grade();
        float finalLabPoints = (float) (labPoints * 15) / 50;
        float finalExamGrade = examGrade * 15 / 10;
        float finalGrade = finalLabPoints + finalExamGrade;
        grade.setNumericGrade((int) finalGrade);
        return grade;
    }
}