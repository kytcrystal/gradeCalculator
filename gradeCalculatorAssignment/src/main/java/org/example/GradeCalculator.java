package org.example;

public class GradeCalculator {

    public static Grade computeGrade(int labPoints, float examGrade) {
        Grade grade = new Grade();
        float finalLabPoints = (float) (labPoints * 15) / 50;
        float finalExamGrade = examGrade * 15 / 10;
        float finalGrade = finalLabPoints + finalExamGrade;
        determineApprovedGrade(finalGrade, grade);
        determineNumericGrade(finalGrade,grade);
        determineCumLaude(finalGrade,grade);
        return grade;
    }

    private static void determineApprovedGrade(float finalGrade, Grade grade) {
        grade.setApproved(finalGrade>=18);
    }
    private static void determineNumericGrade(float finalGrade, Grade grade) {
        if (finalGrade<18) {
            grade.setNumericGrade(null);
        } else if (finalGrade>30) {
            grade.setNumericGrade(30);
        } else {
            grade.setNumericGrade((int) finalGrade);
        }
    }
    private static void determineCumLaude(float finalGrade, Grade grade) {
        grade.setCumLaude(finalGrade > 30);
    }


}