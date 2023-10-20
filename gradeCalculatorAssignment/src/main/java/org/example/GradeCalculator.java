package org.example;

public class GradeCalculator {

    public static Grade computeGrade(int labPoints, float examGrade) {
        Grade grade = new Grade();
        float finalLabPoints = (float) (labPoints * 15) / 50;
        float finalExamGrade = examGrade * 15 / 10;
        float finalGrade = finalLabPoints + finalExamGrade;
        determineApprovedAndNumericGrade(finalGrade, grade);
        return grade;
    }

    private static void determineApprovedAndNumericGrade(float finalGrade, Grade grade) {
        if (finalGrade<18) {
            grade.setApproved(false);
            grade.setNumericGrade(null);
        } else if (finalGrade>30) {
            grade.setApproved(true);
            grade.setNumericGrade(30);
        } else {
            grade.setApproved(true);
            grade.setNumericGrade((int) finalGrade);
        }
    }
}